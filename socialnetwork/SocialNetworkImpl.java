package socialnetwork;

import socialnetwork.exception.UserRegistrationException;
import socialnetwork.post.Post;
import socialnetwork.post.SocialFeedPost;
import socialnetwork.profile.Interest;
import socialnetwork.profile.UserProfile;

import java.util.*;

public class SocialNetworkImpl implements SocialNetwork{
    private Set<UserProfile> _users;
    private Collection<Post> _posts;
    public SocialNetworkImpl() {
        _users = new HashSet<UserProfile>();
        _posts = new ArrayList<Post>();
    }
    @Override
    public void registerUser(UserProfile userProfile) throws UserRegistrationException{
        if(userProfile == null)throw new IllegalArgumentException("Null!");
        if(_users.contains(userProfile))throw new UserRegistrationException("Already registered!");
        _users.add(userProfile);
    }
    @Override
    public Set<UserProfile> getAllUsers(){
        return Collections.unmodifiableSet(_users);
    }
    @Override
    public Post post(UserProfile userProfile, String content) throws UserRegistrationException{
        if(userProfile == null)throw new IllegalArgumentException("Null profile!");
        if(!_users.contains(userProfile)){
            throw new UserRegistrationException("User not registered!");
        }
        if(content == null || content.length()==0){
            throw new IllegalArgumentException("Content is empty!");
        }
        Post toAdd = new SocialFeedPost(userProfile, content);
        _posts.add(toAdd);
        return toAdd;
    }
    @Override
    public Collection<Post> getPosts(){
        return Collections.unmodifiableCollection(_posts);
    }
    private boolean checkForNetworkOfFriends(UserProfile user, UserProfile searched, Set<UserProfile> visited){
        if(user==searched)return true;
        visited.add(user);
        for(UserProfile u:user.getFriends()){
            if(!visited.contains(u)){
                if(checkForNetworkOfFriends(u, searched, visited))return true;
            }
        }
        return false;
    }
    @Override
    public Set<UserProfile> getReachedUsers(Post post){
        if(post == null)throw new IllegalArgumentException("Post is null!");
        Set<UserProfile> result = new HashSet<>();
        UserProfile author = post.getAuthor();
        for(UserProfile u:this._users){
            if(checkForNetworkOfFriends(u, author, new HashSet<UserProfile>())){
                result.add(u);
            }
            else{
                for(Interest i:u.getInterests()) {
                    if (author.getInterests().contains(i)) {
                        result.add(u);
                    }
                }
            }
        }
        return result;
    }
    @Override
    public Set<UserProfile> getMutualFriends(UserProfile userProfile1, UserProfile userProfile2)
            throws UserRegistrationException{
        if(userProfile1 == null || userProfile2 == null)throw new IllegalArgumentException("Null detected!");
        if(!_users.contains(userProfile1) || !_users.contains(userProfile2))throw new UserRegistrationException("not registered!");
        Set<UserProfile> mutualFriends= new HashSet<UserProfile>();
        for(UserProfile u:userProfile1.getFriends()){
            if(userProfile2.getFriends().contains(u)){
                mutualFriends.add(u);
            }
        }
        return mutualFriends;
    }
    @Override
    public SortedSet<UserProfile> getAllProfilesSortedByFriendsCount(){
        return new TreeSet<UserProfile>(this._users);
    }
}

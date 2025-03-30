package socialnetwork.post;

import socialnetwork.profile.UserProfile;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SocialFeedPost implements Post{
    private UserProfile _author;
    private String _content;
    private static int id_count = 1;
    private int _id;
    private LocalDateTime _publishedTime;
    private Map<ReactionType, Set<UserProfile>> _reactions;
    public SocialFeedPost(UserProfile author, String content){
        _author=author;
        _content=content;
        _id = id_count++;
        _publishedTime = LocalDateTime.now();
        _reactions = new HashMap<ReactionType, Set<UserProfile>>();
        for(ReactionType r:ReactionType.values()){
            _reactions.put(r, new HashSet<UserProfile>());
        }
    }
    @Override
    public String getUniqueId(){
        return Integer.toString(_id);
    }
    @Override
    public UserProfile getAuthor(){
        return _author;
    }
    @Override
    public LocalDateTime getPublishedOn(){
        return _publishedTime;
    }
    @Override
    public String getContent(){
        return _content;
    }
    @Override
    public boolean addReaction(UserProfile userProfile, ReactionType reactionType){
        if(userProfile == null || reactionType == null){
            throw new IllegalArgumentException("Null detected!");
        }
        for(Set<UserProfile> s:_reactions.values()){
            if(s.contains(userProfile)){
                _reactions.get(reactionType).add(userProfile);
                s.remove(userProfile);
                return false;
            }
        }
        _reactions.get(reactionType).add(userProfile);
        return true;
    }
    @Override
    public boolean removeReaction(UserProfile userProfile){
        if(userProfile == null)throw new IllegalArgumentException("Null!");
        for(Set<UserProfile> s:_reactions.values()){
            if(s.contains(userProfile)){
                s.remove(userProfile);
                return true;
            }
        }
        return false;
    }
    @Override
    public Map<ReactionType, Set<UserProfile>> getAllReactions(){
        return _reactions;
    }
    @Override
    public int getReactionCount(ReactionType reactionType){
        if(reactionType == null)throw new IllegalArgumentException("null!");
        return _reactions.get(reactionType).size();
    }
    @Override
    public int totalReactionsCount(){
        int result = 0;
        for(Set<UserProfile> s:_reactions.values()){
            result += s.size();
        }
        return result;
    }
    @Override
    public int hashCode(){
        return _id;
    }
    @Override
    public String toString(){
        return _content;
    }
    private void copyFrom(SocialFeedPost other){
        this._content = other._content;
        this._author = other._author;
        this._id = id_count++;
        this._publishedTime = other._publishedTime;
        this._reactions = new HashMap<ReactionType, Set<UserProfile>>();
        for(ReactionType r:ReactionType.values()){
            this._reactions.put(r, new HashSet<UserProfile>());
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        SocialFeedPost result = (SocialFeedPost)super.clone();
        result.copyFrom(this);
        return result;
    }
    @Override
    public boolean equals(Object other){
        if(this==other)return true;
        if(other==null || other.getClass() != this.getClass())return false;
        SocialFeedPost helper = (SocialFeedPost) other;
        return this._author.equals(helper._author) && this._content.equals(helper._content) && this._publishedTime.equals(helper._publishedTime);
    }
}

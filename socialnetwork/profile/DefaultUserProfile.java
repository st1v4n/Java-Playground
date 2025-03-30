package socialnetwork.profile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class DefaultUserProfile implements UserProfile, Comparable<UserProfile>{
    private String _username;
    private Collection<Interest> _interests;
    private Collection<UserProfile> _friends;
    public DefaultUserProfile(String username){
        _username=username;
        _interests = new ArrayList<Interest>();
        _friends = new ArrayList<UserProfile>();
    }
    @Override
    public String getUsername(){
        return _username;
    }
    @Override
    public Collection<Interest> getInterests(){
        return Collections.unmodifiableCollection(_interests);
    }
    @Override
    public boolean addInterest(Interest interest){
        if(interest == null){
            throw new IllegalArgumentException("Null!");
        }
        for(Interest i:_interests){
            if(i==interest){
                return false;
            }
        }
        _interests.add(interest);
        return true;
    }
    @Override
    public boolean removeInterest(Interest interest){
        if(interest == null){
            throw new IllegalArgumentException("Null!");
        }
        for(Interest i:_interests){
            if(i==interest){
                _interests.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public Collection<UserProfile> getFriends(){
        return Collections.unmodifiableCollection(_friends);
    }
    @Override
    public boolean addFriend(UserProfile userProfile){
        if(userProfile == null || userProfile == this){
            throw new IllegalArgumentException("Invalid argument!");
        }
        for(UserProfile u:_friends){
            if(u.equals(userProfile)){
                return false;
            }
        }
        _friends.add(userProfile);
        userProfile.addFriend(this);
        return true;
    }
    @Override
    public boolean unfriend(UserProfile userProfile){
        if(userProfile == null){
            throw new IllegalArgumentException("invalid argument!");
        }
        for(UserProfile u:_friends){
            if(u.equals(userProfile)){
                _friends.remove(u);
                userProfile.unfriend(this);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isFriend(UserProfile userProfile){
        if(userProfile == null){
            throw new IllegalArgumentException("invalid argument!");
        }
        for(UserProfile u:_friends){
            if(u.equals(userProfile))return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return _username;
    }
    @Override
    public boolean equals(Object other){
        if(other==this)return true;
        if(other==null || other.getClass() != this.getClass())return false;
        DefaultUserProfile helper = (DefaultUserProfile) other;
        return this._username.equals(helper._username);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        DefaultUserProfile result = (DefaultUserProfile)super.clone();
        result._username = this._username;
        result._friends = this._friends;
        result._interests = this._interests;
        return result;
    }
    @Override
    public int hashCode(){
        return Objects.hash(this._username);
    }
    @Override
    public int compareTo(UserProfile other){
        if(other==null)return -1;
        if(this.getFriends().size() == other.getFriends().size()){
            return this._username.compareTo(other.getUsername());
        }
        else if(this.getFriends().size() < other.getFriends().size())return -1;
        else return 1;
    }
}

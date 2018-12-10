package structure;

import java.util.ArrayList;
import java.util.HashSet;

public class
UserInformations {
    private long userId;
    private ArrayList<TimeBasedInformation> userActivites = new ArrayList<TimeBasedInformation>();
    private HashSet<Long> allOnlineFriends = new HashSet<>();

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public ArrayList<TimeBasedInformation> getUserActivites() {
        return userActivites;
    }

    public void setUserActivites(ArrayList<TimeBasedInformation> userActivites) {
        this.userActivites = userActivites;
    }

    public HashSet<Long> getAllOnlineFriends() {
        return allOnlineFriends;
    }

    public void setAllOnlineFriends(HashSet<Long> allOnlineFriends) {
        this.allOnlineFriends = allOnlineFriends;
    }
}

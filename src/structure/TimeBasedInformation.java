package structure;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class TimeBasedInformation {
    private Date currentTimestamp;
//    private String timestamp;
//    private ArrayList<OnlineFriendsAndStatus> onlineFriendsList = new ArrayList<OnlineFriendsAndStatus>();
//    private ArrayList<Long> onlineFriendsList2 = new ArrayList<>();
    private HashSet<Long> onlineFriendsHashSet;
    private String fileName;

    public HashSet<Long> getOnlineFriendsHashSet() {
        return onlineFriendsHashSet;
    }

    public void setOnlineFriendsHashSet(HashSet<Long> onlineFriendsHashSet) {
        this.onlineFriendsHashSet = onlineFriendsHashSet;
    }

//    public ArrayList<Long> getOnlineFriendsList2() {
//        return onlineFriendsList2;
//    }
//
//    public void setOnlineFriendsList2(ArrayList<Long> onlineFriendsList2) {
//        this.onlineFriendsList2 = onlineFriendsList2;
//    }

    public String getFileName() {
        return fileName;
    }

//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(String timestamp) {
//        this.timestamp = timestamp;
//    }

    public Date getCurrentTimestamp() {
        return currentTimestamp;
    }

    public void setCurrentTimestamp(Date currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }

//    public ArrayList<OnlineFriendsAndStatus> getOnlineFriendsList() {
//        return onlineFriendsList;
//    }
//
//    public void setOnlineFriendsList(ArrayList<OnlineFriendsAndStatus> onlineFriendsList) {
//        this.onlineFriendsList = onlineFriendsList;
//    }

}

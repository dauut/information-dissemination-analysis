package structure;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class TimeBasedInformation {
    //    private int onlineFriendsCount;
    private Date currentTimestamp;
    private String timestamp;
    private ArrayList<OnlineFriendsAndStatus> onlineFriendsList = new ArrayList<OnlineFriendsAndStatus>();
    private ArrayList<Long> onlineFriendsList2 = new ArrayList<>();

    public ArrayList<Long> getOnlineFriendsList2() {
        return onlineFriendsList2;
    }

    public void setOnlineFriendsList2(ArrayList<Long> onlineFriendsList2) {
        this.onlineFriendsList2 = onlineFriendsList2;
    }

    //    private int idleFriendsCount;
//    private int activeFriendsCount;
//    private int mobileUsersCount;
//    private int webUsersCount;
//    private int mobileActiveCount;
//    private int mobileIdleCount;
    private HashSet<Long> onlineFriendsHashSet;
    private String fileName;

    public HashSet<Long> getOnlineFriendsHashSet() {
        return onlineFriendsHashSet;
    }

    public void setOnlineFriendsHashSet(HashSet<Long> onlineFriendsHashSet) {
        this.onlineFriendsHashSet = onlineFriendsHashSet;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//    public int getOnlineFriendsCount() {
//        return onlineFriendsCount;
//    }
//
//    public void setOnlineFriendsCount(int onlineFriendsCount) {
//        this.onlineFriendsCount = onlineFriendsCount;
//    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Date getCurrentTimestamp() {
        return currentTimestamp;
    }

    public void setCurrentTimestamp(Date currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }

    public ArrayList<OnlineFriendsAndStatus> getOnlineFriendsList() {
        return onlineFriendsList;
    }

    public void setOnlineFriendsList(ArrayList<OnlineFriendsAndStatus> onlineFriendsList) {
        this.onlineFriendsList = onlineFriendsList;
    }

//    public int getIdleFriendsCount() {
//        return idleFriendsCount;
//    }
//
//    public void setIdleFriendsCount(int idleFriendsCount) {
//        this.idleFriendsCount = idleFriendsCount;
//    }
//
//    public int getActiveFriendsCount() {
//        return activeFriendsCount;
//    }
//
//    public void setActiveFriendsCount(int activeFriendsCount) {
//        this.activeFriendsCount = activeFriendsCount;
//    }
//
//    public int getMobileUsersCount() {
//        return mobileUsersCount;
//    }
//
//    public void setMobileUsersCount(int mobileUsersCount) {
//        this.mobileUsersCount = mobileUsersCount;
//    }
//
//    public int getWebUsersCount() {
//        return webUsersCount;
//    }
//
//    public void setWebUsersCount(int webUsersCount) {
//        this.webUsersCount = webUsersCount;
//    }
//
//    public int getMobileActiveCount() {
//        return mobileActiveCount;
//    }
//
//    public void setMobileActiveCount(int mobileActiveCount) {
//        this.mobileActiveCount = mobileActiveCount;
//    }
//
//    public int getMobileIdleCount() {
//        return mobileIdleCount;
//    }
//
//    public void setMobileIdleCount(int mobileIdleCount) {
//        this.mobileIdleCount = mobileIdleCount;
//    }

}

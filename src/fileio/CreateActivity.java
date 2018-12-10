package fileio;

import constants.Constants;
import constants.GenerationConstants;
import jdk.nashorn.api.tree.WhileLoopTree;
import structure.OnlineFriendsAndStatus;
import structure.TimeBasedInformation;
import structure.UserInformations;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class CreateActivity {

    public static void main(String[] args) {
        ArrayList<UserInformations> usersList;  // all exist users
        ReadData getUserFromData = new ReadData();
        CreateActivity ca = new CreateActivity();
        ArrayList<Long> generatedUserIDList;    //new user ID's
        ArrayList<Long> userAllFriends;     //all users of current users
        HashSet<Long> mainUserIDList = new HashSet<>(); // original user list
        HashSet<Long> newFriendsSet;
        UserInformations brandNewUserAndActivities;
        WriteNewActivities writeNewActivities = new WriteNewActivities();
        long longestUserID;

        // collect current users
        File mainUsersFolder = new File(GenerationConstants.getMainDataPath());
        File[] mainUsers = mainUsersFolder.listFiles();

        if (mainUsers != null) {
            for (int i = 0; i < mainUsers.length; i++) {
                mainUserIDList.add(Long.parseLong(mainUsers[i].getName()));
            }
        }
        try {
            usersList = getUserFromData.getUserList();
            longestUserID = ca.getLargestUserID(usersList); // we will start from this number to generate new user IDs
            generatedUserIDList = ca.userIdGenerator(longestUserID); // brand new IDs

            for (UserInformations user : usersList) {
                System.out.println("Total Friends count will be create = " + user.getAllOnlineFriends().size());
                userAllFriends = new ArrayList<>(user.getAllOnlineFriends());   // all friends of current user
                for (Long newID : userAllFriends) {
                    brandNewUserAndActivities = new UserInformations();
                    if (!ca.isUserExist(newID, mainUserIDList)) {   // some of users have original userID as friend
                        ca.createDir(String.valueOf(newID));
                        newFriendsSet = ca.collectNewFriends(generatedUserIDList);  // randomly assigned friends
                        brandNewUserAndActivities = ca.createTimeLine(newID, user, newFriendsSet);
                        writeNewActivities.writeFiles(brandNewUserAndActivities);
                    } else {
                        System.out.println("User = " + newID + " already exist!");
                    }
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while reading users!");
        }


    }

    private long getLargestUserID(ArrayList<UserInformations> usersList) {
        long longestUserID = 0;

        for (UserInformations u : usersList) {
            ArrayList<Long> userAllFriends;
            userAllFriends = new ArrayList<>(u.getAllOnlineFriends());

            for (int i = 0; i < userAllFriends.size(); i++) {
                if (userAllFriends.get(i) > longestUserID) {
                    longestUserID = userAllFriends.get(i);
                }
            }
        }

        return longestUserID;
    }

    private ArrayList<Long> userIdGenerator(long startId) {
        ArrayList<Long> newUserIds = new ArrayList<>();

        for (long i = startId + 1; i < startId + GenerationConstants.getAmountOfNewUserId(); i++) {
            newUserIds.add(i);
        }

        return newUserIds;

    }

    private HashSet<Long> collectNewFriends(ArrayList<Long> generatedUserIDList) {
        HashSet<Long> newFriends = new HashSet<>();
        Random rand = new Random();
        int newFriendCount = rand.nextInt(GenerationConstants.getMaximumNewFriendsNumer());
        for (int i = 0; i < newFriendCount; i++) {
            newFriends.add(generatedUserIDList.get(rand.nextInt(generatedUserIDList.size())));
        }

        return newFriends;
    }

    private boolean isUserExist(long newID, HashSet<Long> existUserList) {
        boolean isExist = false;
        int index = 0;
        while (!isExist && index < existUserList.size()) {
            if (existUserList.contains(newID)) {
                isExist = true;
            }
            index++;
        }
        return isExist;
    }

    private UserInformations createTimeLine(long newUserId, UserInformations user, HashSet<Long> newFriendsSet) {
        UserInformations newUser = new UserInformations();
        newUser.setUserId(newUserId);
        TimeBasedInformation timeBasedInformation;
        ArrayList<Long> momentList;
        ArrayList<TimeBasedInformation> timeBasedInformationArrayList = new ArrayList<>();
        for (int i = 0; i < user.getUserActivites().size(); i++) {
            timeBasedInformation = new TimeBasedInformation();
            timeBasedInformation.setCurrentTimestamp(user.getUserActivites().get(i).getCurrentTimestamp());
            momentList = momentFriends(newFriendsSet);
            timeBasedInformation.setOnlineFriendsList2(momentList);
            timeBasedInformationArrayList.add(timeBasedInformation);
        }
        newUser.setUserActivites(timeBasedInformationArrayList);

        return newUser;
    }

    private ArrayList<Long> momentFriends(HashSet<Long> newFriendsSet) {
        ArrayList<Long> newFriendsList = new ArrayList<>(newFriendsSet);
        ArrayList<Long> momentFriendsList;
        Random rand = new Random();

        int newFriendCount = rand.nextInt(newFriendsSet.size());
        HashSet<Long> momentSet = new HashSet<>();
        for (int i = 0; i < newFriendCount; i++) {
            momentSet.add(newFriendsList.get(rand.nextInt(newFriendsList.size())));
        }
        momentFriendsList = new ArrayList<>(momentSet);
        return momentFriendsList;
    }


    private ArrayList<int[]> createOnlineOfflineTimes(UserInformations user) {
        ArrayList<int[]> statusList = new ArrayList<>();
        Random random = new Random();
        int maximumMinutesCount = user.getUserActivites().size();
        int onlineOfflineCount = random.nextInt(200);
        int num1, num2, min, max;
        num1 = random.nextInt();
        num2 = random.nextInt();

        if (num1 > num2) {
            max = num1;
            min = num2;
        } else {
            max = num2;
            min = num1;
        }
        return statusList;
    }


    private void createDir(String dirPath) {
        String fullPath = GenerationConstants.getDataOutputPath() + dirPath;
        File dir = new File(fullPath);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Directory is created! " + dirPath);
            } else {
                System.out.println("Failed to create directory! " + "summary");
            }
        }else{
            System.out.println("Dir Exist = " + dir.toString());
        }
    }

}

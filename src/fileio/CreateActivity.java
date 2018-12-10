package fileio;

import constants.Constants;
import constants.GenerationConstants;
import structure.TimeBasedInformation;
import structure.UserInformations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class CreateActivity {

    public static void main(String[] args) {
        ArrayList<UserInformations> usersList;
        ReadData getUserFromData = new ReadData();
        CreateActivity ca = new CreateActivity();
        ArrayList<Long> generatedUserIDList = new ArrayList<>();
        ArrayList<Long> userAllFriends;
        HashSet<Long> mainUserIDList = new HashSet<>();
        HashSet<Long> newFriendsSet;
        long longestUserID;

        Random random;

        File mainUsersFolder = new File(GenerationConstants.getMainDataPath());
        File[] mainUsers = mainUsersFolder.listFiles();

        if (mainUsers != null) {
            for (int i = 0; i < mainUsers.length; i++) {
                mainUserIDList.add(Long.parseLong(mainUsers[i].getName()));
            }
        }
        try {
            usersList = getUserFromData.getUserList();
            longestUserID = ca.getLargestUserID(usersList);
            generatedUserIDList = ca.userIdGenerator(longestUserID);

            int friendsCount = 0;
            for (UserInformations u : usersList) {
                userAllFriends = new ArrayList<>(u.getAllOnlineFriends());
                long mainUserID;
                int newFriendCount;
                for (Long newID : userAllFriends) {
                    ca.createDir(String.valueOf(newID));
                    random = new Random();
                    newFriendCount = random.nextInt(GenerationConstants.getMaximumNewFriendsNumer());
                    newFriendsSet = ca.collectNewFriends(newFriendCount, generatedUserIDList);


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

        System.out.println("Longest User ID in Dataset = " + longestUserID);
        return longestUserID;
    }

    private ArrayList<Long> userIdGenerator(long startId) {
        ArrayList<Long> newUserIds = new ArrayList<>();

        for (long i = startId; i < startId + GenerationConstants.getAmountOfNewUserId(); i++) {
            newUserIds.add(i);
        }

        return newUserIds;

    }

    private HashSet<Long> collectNewFriends(int friendsCount, ArrayList<Long> generatedUserIDList) {
        HashSet<Long> newFriends = new HashSet<>();
        Random rand = new Random();

        for (int i = 0; i < friendsCount; i++) {
            newFriends.add(generatedUserIDList.get(rand.nextInt(generatedUserIDList.size())));
        }

        return newFriends;
    }

    private void createDir(String dirPath) {
        String fullPath = Constants.getNewDataPath() + dirPath;
        File dir = new File(fullPath);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Directory is created! " + dirPath);
            } else {
                System.out.println("Failed to create directory! " + "summary");
            }
        }
    }

}

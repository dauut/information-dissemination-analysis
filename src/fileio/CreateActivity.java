package fileio;

import constants.GenerationConstants;
import structure.UserInformations;

import java.io.IOException;
import java.util.ArrayList;

public class CreateActivity {

    public static void main(String[] args) {
        ArrayList<UserInformations> usersList;
        ReadData getUserFromData = new ReadData();
        CreateActivity ca = new CreateActivity();
        ArrayList<Long> generatedUserIDs = new ArrayList<>();
        long longestUserID;

        try {
            usersList = getUserFromData.getUserList();
            longestUserID = ca.getLargestUserID(usersList);
            generatedUserIDs = ca.userIdGenerator(longestUserID);

            int friendsCount = 0;
            for (UserInformations u : usersList) {
                friendsCount = u.getAllOnlineFriends().size();

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

}

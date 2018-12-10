package fileio;

import structure.UserInformations;

import java.io.IOException;
import java.util.ArrayList;

public class CreateActivity {

    public static void main(String[] args) {
        ArrayList<UserInformations> usersList;
        ReadData getUserFromData = new ReadData();


        try {
            usersList = getUserFromData.getUserList();
            int friendsCount = 0;
            for (UserInformations u : usersList) {
                friendsCount = u.getAllOnlineFriends().size();


            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while reading users!");
        }


    }

    public long getLargestUserID(ArrayList<UserInformations> usersList) {
        long longestUserID = 0;

        for (UserInformations u : usersList){
            for (int i = 0; i < u.getAllOnlineFriends().size(); i++){

            }
        }


        return longestUserID;
    }

}

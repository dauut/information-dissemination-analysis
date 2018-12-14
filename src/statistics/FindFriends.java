package statistics;

import constants.Constants;
import fileio.ReadData;
import structure.UserInformations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FindFriends {
    public static void main(String[] args) throws IOException {
        ArrayList<UserInformations> usersList;
        ReadData getUserFromData = new ReadData();
        usersList = getUserFromData.getUserList();

        for (UserInformations user : usersList) {

        }
    }

}

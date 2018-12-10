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
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while reading users!");
        }

        
    }

}

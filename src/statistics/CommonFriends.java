package statistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CommonFriends {
    public static void main(String[] args) {

        File fbUsersFolder = new File("C:\\Users\\dauut\\Desktop\\stats_output");
        File[] listOfFiles = fbUsersFolder.listFiles();
        File file;
        HashSet<Long> friends;
        ArrayList<HashSet<Long>> allUsers = new ArrayList<>();
        for (File listOfFile : listOfFiles) {
            friends = new HashSet<>();
            file = new File(listOfFile.toString());
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    friends.add(Long.parseLong(scanner.nextLine()));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            allUsers.add(friends);
        }
    }
}

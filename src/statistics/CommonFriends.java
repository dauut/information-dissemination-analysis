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
        HashSet<Long> friends = new HashSet<>();
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


        System.out.println("");
    }

    public HashMap<Long,Integer> findCommonFriendsCounts(ArrayList<HashSet<Long>> theList){
        HashMap<Long,Integer> friendsInCommonCounts = new HashMap<>();

        for (int i= 0; i < theList.size(); i++){
            for (int j = 1; j < theList.get(i).size(); j++){

            }
        }

        return friendsInCommonCounts;

    }
}

package fileio;

import constants.Constants;
import structure.TimeBasedInformation;
import structure.UserInformations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class ReadData {

    /*
     * Read data files line by line
     * This method calls Parseline class and collect useful data in data structures
     * */
    public ArrayList<UserInformations> getUserList() throws IOException {
        System.out.println("Collect all users information for once! ");
        String mainFolderPath = Constants.getDataPath();
        File fbUsersFolder = new File(mainFolderPath);
        File[] listOfUsers = fbUsersFolder.listFiles(); // we get all users path in a File lists
        File file;
        File folder;
        File[] listOfFiles;

        ArrayList<UserInformations> usersList = new ArrayList<>();

        for (int i = 0; i < listOfUsers.length; i++) {
            UserInformations user = new UserInformations();
            HashSet<Long> allFriends;

            user.setUserId(Long.parseLong(listOfUsers[i].getName()));
            System.out.println("Current user ID: " + user.getUserId() + " Index = " + i);
            folder = new File(listOfUsers[i].toString()); //all files names
            listOfFiles = folder.listFiles();
            ArrayList<TimeBasedInformation> timeBasedInformationArrayList = new ArrayList<>();


            Path dir = FileSystems.getDefault().getPath(listOfUsers[i].toString());
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir);

//            for (Path path: stream){
//                TimeBasedInformation timeBasedInformation = new TimeBasedInformation();
//                ParseLines parseLines = new ParseLines();
//                ArrayList<String> lines = new ArrayList<>();
//                lines.clear();
//                try {
//                    Scanner scanner = new Scanner(path);
//
//                    while (scanner.hasNext()) {
//                        lines.add(scanner.nextLine());
//                    }
//
//                    if (lines.size() > 1) {
//                        timeBasedInformation = parseLines.parseLines(lines);
//                        timeBasedInformation.setFileName(path.toString());
//                        //add only between two
////                        if (parsedStartDate != null && parsedEndDate != null &&
////                                timeBasedInformation.getCurrentTimestamp().after(parsedStartDate) &&
////                                timeBasedInformation.getCurrentTimestamp().before(parsedEndDate)) {
//                        timeBasedInformationArrayList.add(timeBasedInformation);
////                        }
//                    }
//                    scanner.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//            stream.close();


            //in every folder
            allFriends = new HashSet<>();
            for (int j = 0; j < listOfFiles.length; j++) {

                TimeBasedInformation timeBasedInformation = new TimeBasedInformation();
                ParseLines parseLines = new ParseLines();
                ArrayList<String> lines = new ArrayList<>();

                lines.clear();

                //pick iterated file in current folder
                //read all lines
                //pass these list to parser
                file = new File(listOfFiles[j].toString());
                try {
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNext()) {
                        lines.add(scanner.nextLine());
                    }
                    //control start date and end date -- START
                    // we need these dates for check simulation interval ie: 15 days
                    String startDate = Constants.getSimulationStartDate();
                    String endDate = Constants.getSimulationEndDate();
                    SimpleDateFormat simpleStartFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                    Date parsedStartDate = null;
                    Date parsedEndDate = null;
                    try {
                        parsedStartDate = simpleStartFormat.parse(startDate);
                        parsedEndDate = simpleStartFormat.parse(endDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //control start date and end date -- END

                    if (lines.size() > 1) {
                        timeBasedInformation = parseLines.parseLines(lines);
//                        timeBasedInformation.setFileName(listOfFiles[j].toString());
                        //add only between two
                        if (parsedStartDate != null && parsedEndDate != null &&
                                timeBasedInformation.getCurrentTimestamp().after(parsedStartDate) &&
                                timeBasedInformation.getCurrentTimestamp().before(parsedEndDate)) {
                        allFriends.addAll(timeBasedInformation.getOnlineFriendsHashSet());
                        timeBasedInformationArrayList.add(timeBasedInformation);
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }


            user.setUserActivites(timeBasedInformationArrayList);
            user.setAllOnlineFriends(allFriends);
            usersList.add(user);
        }
        return usersList;
    }

}

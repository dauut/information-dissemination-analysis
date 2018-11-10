package statistics;

import constants.Constants;
import constants.DayDistConstant;
import fileio.WriteFiles;
import structure.UserInformations;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class OnlineTimeDistribution {
    public void partOfDays(ArrayList<UserInformations> userList) {
        HashMap<Integer, Integer> proportionsOfHours = new HashMap<>();
        HashMap<Integer, Integer> proportionsOfUsers = new HashMap<>();
        for (int i = 0; i < DayDistConstant.getHours(); i++) {
            proportionsOfHours.put(i, 0);
            proportionsOfUsers.put(i, 0);
        }
        int activitiesSize;
        int newTotal;
        int hours;
        int currentlyOnlineFriendsCount;
        int average;
        String[] avgUserCounts;
        File file;
        WriteFiles wf = new WriteFiles();

        for (UserInformations anUser : userList) {
            System.out.println("User = " + anUser.getUserId() + " hourly statistics calculating...");
            avgUserCounts = new String[24];
            activitiesSize = anUser.getUserActivites().size();
            for (int j = 0; j < activitiesSize; j++) {
                hours = anUser.getUserActivites().get(j).getCurrentTimestamp().getHours();
                currentlyOnlineFriendsCount = anUser.getUserActivites().get(j).getOnlineFriendsList().size();

                proportionsOfHours.put(hours, proportionsOfHours.get(hours) + 1);
                newTotal = proportionsOfUsers.get(hours) + currentlyOnlineFriendsCount;
                proportionsOfUsers.replace(hours, newTotal);
            }

            for (int i = 0; i < proportionsOfHours.size(); i++) {
                average = proportionsOfUsers.get(i) / proportionsOfHours.get(i);
                System.out.println("In hours of = " + i + " Avarage Users = " + average);
                avgUserCounts[i] = Integer.toString(average);
            }
            file = new File(Constants.getStatsOutputPath() + "Hourly_average_" + anUser.getUserId() + ".txt");
            wf.writeFile(file, avgUserCounts);
        }

    }

    public void findDailyActivities(ArrayList<UserInformations> userList) {

        HashMap<String, Integer> proportionsOfDays = new HashMap<>();
        HashMap<String, Integer> proportionsOfUsers = new HashMap<>();
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        for (String d: days){
            proportionsOfDays.put(d,0);
            proportionsOfUsers.put(d,0);
        }

        File file;
        WriteFiles wf = new WriteFiles();
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        int activitiesSize;
        int currentlyOnlineFriendsCount;
        int newTotal;
        String theDay;
        int average;
        String[] avgUserCounts;

        for (UserInformations anUser : userList) {
            System.out.println("User = " + anUser.getUserId() + " daily statistics calculating...");
            avgUserCounts = new String[7];
            activitiesSize = anUser.getUserActivites().size();
            for (int j = 0; j < activitiesSize; j++) {
                theDay = format.format(anUser.getUserActivites().get(j).getCurrentTimestamp());
                currentlyOnlineFriendsCount = anUser.getUserActivites().get(j).getOnlineFriendsList().size();

                proportionsOfDays.put(theDay, proportionsOfDays.get(theDay) + 1);
                newTotal = proportionsOfUsers.get(theDay) + currentlyOnlineFriendsCount;
                proportionsOfUsers.replace(theDay, newTotal);
            }

            int index = 0;
            for (String d: days){
                average = proportionsOfUsers.get(d) / proportionsOfDays.get(d);
                System.out.println("In day of = " + d + " Avarage Users = " + average);
                avgUserCounts[index] = Integer.toString(average);
                index++;
            }
            file = new File(Constants.getStatsOutputPath() + "Daily_average_" +anUser.getUserId() + ".txt");
            wf.writeFile(file, avgUserCounts);
        }

    }
}

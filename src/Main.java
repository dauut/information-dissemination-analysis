import fileio.ReadData;
import fileio.WriteFiles;
import statistics.OnlineTimeDistribution;
import structure.UserInformations;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Started at " + dateFormat.format(date));
        Main main = new Main();
        WriteFiles wf = new WriteFiles();
        OnlineTimeDistribution timeDist = new OnlineTimeDistribution();

        ArrayList<UserInformations> usersList;
        ReadData getUserFromData = new ReadData();
        usersList = getUserFromData.getUserList();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double seconds = (double) totalTime / 1000000000.0;

        System.out.println("In memory all files time passed in minutes: " + seconds / 60 );

        wf.writePreProcessedData(usersList);
//        timeDist.partOfDays(usersList);
//        timeDist.findDailyActivities(usersList);
//        wf.writeAllFriends(usersList);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double) totalTime / 1000000000.0;
        System.out.println("seconds = " + seconds);
        System.out.println("minutes = " + seconds / 60);
        System.out.println("hours = " + seconds / 3600);
        date = new Date();
        System.out.println("Finished at "  + dateFormat.format(date));
    }
}

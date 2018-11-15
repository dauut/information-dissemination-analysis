package fileio;

import constants.Constants;
import structure.UserInformations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SuppressWarnings("Duplicates")
public class WriteFiles {

    public void writeAllFriends(ArrayList<UserInformations> userList) {
        for (UserInformations aUser : userList) {
            long main_user = aUser.getUserId();
            String fileName = Long.toString(main_user);

            File file = new File(Constants.getStatsOutputPath() + "\\" + fileName + ".txt");
            List<Long> list = new ArrayList<>(aUser.getAllOnlineFriends());
            String[] lines = new String[list.size()];

            for (int j = 0; j < list.size(); j++) {
                lines[j] = Long.toString(list.get(j));
            }
            writeFile(file, lines);
        }
    }

    public void writeFile(File file, String[] line) {
        System.out.println("Write File = " + file.toString());
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            // true = append file
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String line1 : line) {
                bufferedWriter.write(line1 + "\n");
            }

            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    //write processed data
    private void writeFiles(File file, ArrayList<String> s) {
        System.out.println("Write File = " + file.toString());
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            // true = append file
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String line1 : s) {
                bufferedWriter.write(line1 + "\n");
            }

            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    // Reshape data as smaller
    public void writePreProcessedData(ArrayList<UserInformations> userList) {
        File dir;
        File file = null;
        ArrayList<String> allInformation = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String delims = "\\\\";
        for (UserInformations in : userList) {
            String dirPath = Constants.getNewDataPath() + "\\" + Long.toString(in.getUserId()) + "\\";
            dir = new File(dirPath);
            if (!dir.exists()) {
                if (dir.mkdir()) {
                    System.out.println("Directory is created! " + "summary");
                } else {
                    System.out.println("Failed to create directory! " + "summary");
                }
            }
            for (int i = 0; i < in.getUserActivites().size(); i++) {
                allInformation = new ArrayList<>();
                String[] firstLineToken = in.getUserActivites().get(i).getFileName().split(delims);
                file = new File(dirPath + firstLineToken[6]);

                allInformation.add("id: " + in.getUserId() + " ct: " + df.format(in.getUserActivites().get(i).getCurrentTimestamp()));
                allInformation.add("");
                allInformation.add("OF: " + in.getUserActivites().get(i).getOnlineFriendsList().size());
                for (int j = 0; j < in.getUserActivites().get(i).getOnlineFriendsList().size(); j++) {
                    allInformation.add(Long.toString(in.getUserActivites().get(i).getOnlineFriendsList().get(j).getFriendUserID()));
                }
                allInformation.add("");
                writeFiles(file, allInformation);
            }
            //handle this later
        }


    }
}

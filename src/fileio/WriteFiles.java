package fileio;

import constants.Constants;
import structure.UserInformations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            for (String line1: line){
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
}

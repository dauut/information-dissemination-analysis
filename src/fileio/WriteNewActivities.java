package fileio;

import constants.GenerationConstants;
import structure.UserInformations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteNewActivities {

    public void writeFiles(UserInformations user) {
        String outputPath = GenerationConstants.getDataOutputPath();
        outputPath = outputPath + user.getUserId() + "\\";
        File file;
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        String fileName;
        for (int i = 0; i < user.getUserActivites().size(); i++) {
            fileName = String.valueOf(i) + "." + String.valueOf(user.getUserId() + ".txt");
            file = new File(outputPath + fileName);
            try {
                fileWriter = new FileWriter(file.getAbsoluteFile(), true);
                bufferedWriter = new BufferedWriter(fileWriter);

//                bufferedWriter.write("id: " + user.getUserId() + " current time: " + user.getUserActivites().get(i).getCurrentTimestamp()+ "\n\n");
                bufferedWriter.write("id: " + user.getUserId() + " current time: " + user.getUserActivites().get(i).getTimestamp()+ "\n\n");
                bufferedWriter.write("online friends: " + String.valueOf(user.getAllOnlineFriends().size()));
                for (int j = 0; j < user.getUserActivites().get(i).getOnlineFriendsList2().size(); j++){
                    bufferedWriter.write(String.valueOf(user.getUserActivites().get(i).getOnlineFriendsList2().get(j)) + "\n");
                }
                bufferedWriter.write("idle: null");
//                bufferedWriter.newLine();
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
}

package src.main.java;

import java.io.File;

public class SystemFilesHandler {
    public static void createOutputDirectory(String directory){
        File file = new File(directory);

        //check if directory exists or not
        if (!file.exists()) {
            //if not, try to create the folders
            boolean success = file.mkdirs();

            // verify is it was successful
            if (success) {
                System.out.println("Directory : " + directory
                        + " created successfully");
            } else {
                System.out.println("Directory : " + directory + " creation failed");
            }
        }
    }

}

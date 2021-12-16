package src.main.java;

import org.bytedeco.javacv.*;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

import src.main.java.PathHandler;
import src.main.java.VideoHandler;

public class Challenge {
    public static void main(String[] args) throws Exception {

        //verify if the number of arguments are correct
        if (args.length < 2) {
            System.err.println("Two parameters are required to run this program .)" +
                    "\n -The first parameter is a file name for a video clip (starting from the current directory) " +
                    "\n -The Second parameter is a directory path and saves the first 10 frames (also starting from the current directory)");
            System.exit(1);
        }

        //Retrieve the Filename for the video and the output folder for the frames
        //I could not test using the terminal and I believe the maven Window was not working properly
        //when trying to:
        //mvn compile exec:java -Dexec.mainClass=src.main.java.Challenge -Dexec.args="arg1 arg2"
        //It would assume arg1 and arg2 as only one argument
        //I tested with predefined strings and inputs
        //Nevertheless, the code should be the below one

        String videoFileName2 = args[0];
        String directory = args[1];
        //String videoFileName2 = "test.webm"; // Read user input
        //String directory = "outputs";  // Read user input

        //if needed be, create a directory for the output frames
        SystemFilesHandler SH = new SystemFilesHandler();
        SH.createOutputDirectory(directory);

        PathHandler PH = new PathHandler();
        String paths[] = PH.getFullPaths(videoFileName2, directory);


        VideoHandler VH = new VideoHandler();
        VH.retrieveFrames(paths[0], videoFileName2, paths[1]);
    }
}
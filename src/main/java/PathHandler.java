package src.main.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathHandler {
    public static String[] getFullPaths(String videoFileName2, String directory){
        //get current path
        Path currentPath = Paths.get(System.getProperty("user.dir"));


        //create the full paths for both the video and the output folder
        String videoFileNamePath = Paths.get(currentPath.toString(), videoFileName2).toString();
        String directoryPath     = Paths.get(currentPath.toString(),        directory).toString();
        String[] paths = new String[2];
        paths[0]=videoFileNamePath;
        paths[1]=directoryPath;
        return paths;
    }

}

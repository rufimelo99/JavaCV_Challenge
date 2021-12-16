package src.test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.main.java.PathHandler;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPathHandler {
    //just some quick examples of tests -> no need to expand these for now
    @Test
    void shouldShowEqualPaths() {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        PathHandler PH = new PathHandler();
        String paths[] = PH.getFullPaths("video.mp4", "out");

        Assertions.assertEquals(paths[0], Paths.get(currentPath.toString(), "video.mp4").toString());
    }
    void shouldShowEqualPathsBetweenOutputFolderAndFile() {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        PathHandler PH = new PathHandler();
        String paths[] = PH.getFullPaths("video.mp4", "video.mp4");

        Assertions.assertEquals(paths[0], paths[1]);
    }
}
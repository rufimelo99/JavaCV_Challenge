package src.main.java;

import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

public class VideoHandler {
    public static void retrieveFrames(String videoFileNamePath, String videoFileName, String directoryPath) throws FrameGrabber.Exception {

        //open converter to later convert frame into a  matrix
        OpenCVFrameConverter.ToMat converterToMat = new OpenCVFrameConverter.ToMat();
        //Open video and grabber
        File f = new File(videoFileNamePath);
        OpenCVFrameGrabber grabber = null;
        try {
            grabber = OpenCVFrameGrabber.createDefault(f);
            grabber.start();
            System.out.println("Starting grabber.");
        } catch (Exception e) {
            System.err.println("Failed start the grabber.");
        }

        Frame videoFrame = null;
        Mat videoMat = new Mat();
        int numberFrames = 10;
        int framesSaved = 0;

        //Capture frames according to numberFrames var
        while (framesSaved<numberFrames) {
            videoFrame = grabber.grab();
            videoMat = converterToMat.convert(videoFrame);

            Path outputPath = Paths.get(directoryPath.toString(),  videoFileName+"-"+framesSaved+".jpeg");
            //Proceed to write those images (Matrixes) on the outputFolder
            imwrite(outputPath.toString(), videoMat);

            framesSaved++;
        }
        System.out.println("Frames Saved at "+directoryPath.toString());
    }

}

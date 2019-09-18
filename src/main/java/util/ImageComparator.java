package util;

import java.io.File;

import javax.imageio.ImageIO;

import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;
import org.im4java.process.StandardStream;

import com.google.common.io.Files;

import ru.yandex.qatools.ashot.Screenshot;

public class ImageComparator {
	File baselineImageFile;
	
	public ImageComparator(String basefile) {
		baselineImageFile=new File(basefile);
	}
	
	
	
	

    //ImageMagick Compare Method
    public void compareImagesWithImageMagick (String expected, String actual, String difference) throws Exception {
        // This class implements the processing of os-commands using a ProcessBuilder.
        // This is the core class of the im4java-library where all the magic takes place.
        ProcessStarter.setGlobalSearchPath("C:\\Program Files\\ImageMagick-7.0.8-Q16");
 
        // This instance wraps the compare command
        CompareCmd compare = new CompareCmd();
 
        // Set the ErrorConsumer for the stderr of the ProcessStarter.
        compare.setErrorConsumer(StandardStream.STDERR);
 
        // Create ImageMagick Operation Object
        IMOperation cmpOp = new IMOperation();
 
        //Add option -fuzz to the ImageMagick commandline
        //With Fuzz we can ignore small changes
        cmpOp.fuzz(10.0);
 
        //The special "-metric" setting of 'AE' (short for "Absolute Error" count), will report (to standard error),
        //a count of the actual number of pixels that were masked, at the current fuzz factor.
        cmpOp.metric("AE");
 
        // Add the expected image
        cmpOp.addImage(expected);
 
        // Add the actual image
        cmpOp.addImage(actual);
 
        // This stores the difference
        System.out.println(difference);
        cmpOp.addImage(difference);
 
        try {
            //Do the compare
            System.out.println ("Comparison Started!");
            compare.run(cmpOp);
            System.out.println ("Comparison Finished!");
        }
        catch (Exception ex) {
            System.out.print(ex);
            System.out.println ("Comparison Failed!");
            //Put the difference image to the global differences folder
            Files.copy(new File(difference),new File("./Differences/diff.png"));
            
            
            throw ex;
        }
    }
 
    //Compare Operation
    public void doComparison (Screenshot elementScreenShot) throws Exception {
        //Did we capture baseline image before?
        if (baselineImageFile.exists()){
            //Compare screenshot with baseline
            System.out.println("Comparison method will be called!\n");
 
           /* System.out.println("Baseline: " + baselineScreenShotPath + "\n" +
                    "Actual: " + actualScreenShotPath + "\n" +
                    "Diff: " + differenceScreenShotPath);
 */
            //Try to use IM4Java for comparison
            compareImagesWithImageMagick(baselineImageFile.getAbsolutePath(),"./ScreenShots","./Differences/diff.png" );
        } else {
            System.out.println("BaselineScreenshot is not exist! We put it into test screenshot folder.\n");
            //Put the screenshot to the specified folder
            ImageIO.write(elementScreenShot.getImage(), "PNG", baselineImageFile);
        }
    }
 
}

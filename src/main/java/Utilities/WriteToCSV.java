package Utilities;
import Configurations.FilePaths;
import org.testng.asserts.SoftAssert;

import java.io.FileWriter;
import java.io.IOException;


public class WriteToCSV{

public static void feedDataToCSVFile(String data, boolean passTrueForAppendModeOrPassFalseForOverwriteMode, String path) throws IOException {
        FileWriter writer = new FileWriter(path, passTrueForAppendModeOrPassFalseForOverwriteMode);
        data=data+"\r\n";
        writer.write(data);
        writer.close();
}

}

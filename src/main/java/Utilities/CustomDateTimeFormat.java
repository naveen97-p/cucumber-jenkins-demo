package Utilities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class CustomDateTimeFormat {

    static LocalDateTime myDateObj = LocalDateTime.now();
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");

    static String formattedDate = myDateObj.format(myFormatObj);

    public static String customDateTime = new String(formattedDate);



}




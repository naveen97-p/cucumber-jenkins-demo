package Utilities;

import Configurations.FilePaths;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadAndWriteTextFiles extends BrowserInstance{


    public void updateTextFile(String data, String filePath){
        try{
            File file = new File(filePath);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            int actualIndex= Integer.parseInt(data);
            actualIndex=actualIndex+1;
            String mainData=""+actualIndex;
            bufferedWriter.write(mainData);
            bufferedWriter.close();
            System.out.println("INDEX DATA IS UPDATED");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("ERROR: INDEX DATA ISN'T UPDATED");
        }
    }

    public String readTextFile(String path) throws IOException {
            String data="";
            try {
                 data = new String(Files.readAllBytes(Paths.get(path)));
                System.out.println("INDEX DATA IS READABLE");
                }
            catch(IOException ex){
                    ex.printStackTrace();
                    System.out.println("ERROR: INDEX DATA ISN'T READABLE");
                }
    return data;
    }

    public String createAnUniqueEmailEntry(String email, String index){

        int index_of_domain=email.indexOf("@mailinator.com");
        return email.substring(0,index_of_domain)+index+"@mailinator.com";
    }
    public String getFirstnameFromIndexLogic(String firstname, String index){
        return firstname+index;
    }

    public String  getPreviouslyCreatedEmail(String prevEmail, String index){
        int pervIndex=Integer.parseInt(index)-1;
        int index_of_domain=prevEmail.indexOf("@mailinator.com");
        return prevEmail.substring(0,index_of_domain)+pervIndex+"@mailinator.com";
    }
    public String  getPreviouslyCreatedUsername(String prevUsername, String index){
        int pervIndex=Integer.parseInt(index)-1;
        return prevUsername+pervIndex;
    }

    public String  getPreviouslyCreatedFirstname(String firstname, String index){
        int pervIndex=Integer.parseInt(index)-1;
        return firstname+pervIndex;
    }
    public String getUsernameFromEmail(String email){
        int index_of_domain=email.indexOf("@mailinator.com");
        return email.substring(0,index_of_domain);
    }

    public String getUsernameFromEmailAndIndex(String email, String index){
        int index_of_domain=email.indexOf("@mailinator.com");
        return (email.substring(0,index_of_domain)+index);
    }

    public String combineUsernameAndIndexValue(String username, String index){
        return username+index;
    }
/*

    public static void main(String args[]) throws IOException {
        ReadAndWriteTextFiles ob = new ReadAndWriteTextFiles();

        //Get the Index and Create Email and Username
        String myEmail = ob.getUsernameFromEmail("naveenautomation9090@mailinator.com");
        System.out.println(myEmail);
    }
*/

}

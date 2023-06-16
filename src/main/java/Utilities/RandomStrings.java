package Utilities;

public class RandomStrings extends BrowserInstance {

    public String getRandomStringOfLowerCase(int sizeOfString){
        String alphaNumericStr = "abcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(sizeOfString);
        int i;
        for ( i=0; i<sizeOfString; i++) {
            int ch = (int)(alphaNumericStr.length() * Math.random());
            s.append(alphaNumericStr.charAt(ch));
        }
        return s.toString();
    }
    public String getRandomStringOfUpperCase(int sizeOfString){
        String alphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder s = new StringBuilder(sizeOfString);
        int i;
        for ( i=0; i<sizeOfString; i++) {
            int ch = (int)(alphaNumericStr.length() * Math.random());
            s.append(alphaNumericStr.charAt(ch));
        }
        return s.toString();
    }
    public String getRandomStringOfNumbers(int sizeOfString){
        String alphaNumericStr = "123456789";
        StringBuilder s = new StringBuilder(sizeOfString);
        int i;
        for ( i=0; i<sizeOfString; i++) {
            int ch = (int)(alphaNumericStr.length() * Math.random());
            s.append(alphaNumericStr.charAt(ch));
        }
        return s.toString();
    }
    public String getRandomFormatOfPasscode(int sizeOfUpperCase, int sizeOfLowerCase, int sizeOfNumbers){
        String requiredPasscode= getRandomStringOfUpperCase(sizeOfUpperCase);
        requiredPasscode+= getRandomStringOfLowerCase(sizeOfLowerCase);
        requiredPasscode+= "@";
        requiredPasscode+= getRandomStringOfNumbers(sizeOfNumbers);
        return requiredPasscode;
    }



}

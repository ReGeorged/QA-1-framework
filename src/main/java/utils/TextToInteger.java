package utils;

public class TextToInteger {

    public static int filteredToInteger(String S) {
        //this removes any text from string and leaves only numbers
        String FilteredToNUmber = S.replaceAll("[^0-9]", "");
        //this converts filtered Strings to integers
        int filteredInt = Integer.parseInt(FilteredToNUmber);
        return filteredInt;
    }
}

package utils;

public class TextToInteger {

    public  int filteredToInteger(String S){
        //this removes text from string and leaves only integers
        String FilteredToNUmber = S.replaceAll("[^0-9]", "");
        //this converts filtered Strings to integers
        int filteredInt = Integer.parseInt(FilteredToNUmber);
        return filteredInt;




    }
}

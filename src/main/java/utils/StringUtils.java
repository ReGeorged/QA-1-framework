package utils;

import data.JsonReader;

public class StringUtils {

    public static int filteredToInteger(String S) {
        //this removes any text from string and leaves only numbers
        String FilteredToNUmber = S.replaceAll("[^0-9]", "");
        //this converts filtered Strings to integers
        int filteredInt = Integer.parseInt(FilteredToNUmber);
        return filteredInt;
    }

    public static String getAlphaNumericString() {


        int n = StringUtils.filteredToInteger(JsonReader.returnFromTestDataJson("randomStringLength"));
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}

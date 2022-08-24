package romannumbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Onur Baskirt
 * Examples:
 * 14 = XIV
 * 79 = LXXIX
 * 225 = CCXXV
 * 845 = DCCCXLV
 * 2022 = MMXXII
 */

public class RomanNumbers {
    public static void main(String[] args) {
        String romanNumber = "MMXXII";

        System.out.println("Roman Number: " + romanNumber + " is equal to: " + romanNumberToInt(romanNumber));
    }

    public static int romanNumberToInt(String s) {
        int total = 0;
        char[] arr = s.toCharArray();

        //Roman numbers hashmap
        Map<Character, Integer> romanMap = new HashMap<Character, Integer>();

        //Populating the roman number map
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        //Algorithm
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                total = total + romanMap.get(arr[i]);
            } else if (romanMap.get(arr[i]) >= romanMap.get(arr[i + 1])) {
                total = total + romanMap.get(arr[i]);
            } else {
                total = total + (romanMap.get(arr[i + 1]) - romanMap.get(arr[i]));
                i++;
            }
        }

        //Return the total
        return total;
    }

}

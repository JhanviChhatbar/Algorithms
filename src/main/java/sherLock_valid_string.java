import java.io.*;
import java.util.*;

public class sherLock_valid_string {

    public static String isValid(String s) {

        int[] occurrences = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 97;
            occurrences[ascii] = occurrences[ascii] + 1;
        }

        Map<Integer, Integer> quantities = new TreeMap<>();

        for (int occurrence : occurrences) {
            if (occurrence > 0) {
                quantities.put(occurrence, quantities.getOrDefault(occurrence, 0) + 1);
            }
        }

        if (quantities.size() > 2) return "NO";
        if (quantities.size() == 1) return "YES";


        Integer minKey = Collections.min(quantities.keySet());
        Integer maxKey = Collections.max(quantities.keySet());


        if (quantities.get(minKey) == 1) {
            if (minKey == 1) {
                return "YES";
            } else {
                return "NO";
            }
        } else {
            if (quantities.get(maxKey) == 1 && maxKey - 1 == minKey) {
                return "YES";
            } else {
                return "NO";
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = isValid(s);

        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }

    /*
    Sherlock considers a string to be valid if all characters of the string appear the same number of times.
     It is also valid if he can remove just  character at  index in the string, and the remaining characters
      will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

Example

This is a valid string because frequencies are .


This is a valid string because we can remove one  and have  of each character in the remaining string.


This string is not valid as we can only remove  occurrence of . That leaves character frequencies of .

Function Description

Complete the isValid function in the editor below.

isValid has the following parameter(s):

string s: a string
Returns string: either YES or NO
Input Format

A single string .

Sample Input 0

aabbcd
Sample Output 0

NO

     */
}

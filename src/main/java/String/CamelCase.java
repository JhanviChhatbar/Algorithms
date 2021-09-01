package String;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

/*Find how many words are available
input : jhanviChhatbar
output : 2*/

public class CamelCase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int camelcase(String s) {
        int count = 0;

        for(int i =0;i<s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <=91){
                count++;
            }
        }
        return count + 1;

    }
}

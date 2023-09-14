import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class biggerIsGreater {

    public static String biggerIsGreater(String w) {
        // Write your code here
        int l = w.length();

        //get longest non increasing suffix
        // get pivot
        for(int i=l-1; i>0; i--){
            if(w.charAt(i-1) < w.charAt(i)){
                String s = getBiggerString(w.substring(i-1, l));
                System.out.println("s " + s);
                return w.substring(0, i-1).concat(s);
            }
        }
        return "no answer";

    }

    public static String getBiggerString(String s){
        // get bigger charcter from right most side of suffix

        char[] chars = s.toCharArray();
        int l = s.length();
        for(int i=l-1; i >=1; i--){
            if(chars[i] > chars[0]){
                // swap both character

                char c = chars[i];
                chars[i] = chars[0];
                chars[0] = c;
                break;
            }
        }
        System.out.println("chars " + new StringBuilder(Arrays.toString( Arrays.copyOfRange(chars, 1, l))));
        // reverse suffix
        char[] reversechar = Arrays.copyOfRange(chars, 1, l);
        StringBuilder stringBuilder = new StringBuilder(new String(reversechar));
        stringBuilder.reverse();
        stringBuilder.insert(0, chars[0]);
        System.out.println("string Builder" + stringBuilder);
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = biggerIsGreater(w);

//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }
/*
Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

It must be greater than the original word
It must be the smallest word that meets the first condition
Example
w = abcd
The next largest word is abdc.

Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.

Function Description

Complete the biggerIsGreater function in the editor below.

biggerIsGreater has the following parameter(s):

string w: a word
Returns
- string: the smallest lexicographically higher string possible or no answer
 */


}

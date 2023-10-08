import java.io.*;

public class highest_value_palindrome {

    public static String highestValuePalindrome(String s, int n, int k) {
        int left =0;
        int right = n-1;
        int changes =0;
        char[] arr = s.toCharArray();

        while(left<right){
            if(arr[left] != arr[right]){
                char maxChar = (char)Math.max(arr[left], arr[right]);
                arr[left] = maxChar;
                arr[right] = maxChar;
                changes++;
            }
            left++;
            right--;
        }
        if(changes > k)
            return "-1";

        if(k <= 0 && changes ==0)
            return s;

        left =0;
        right = n-1;
        while(left<=right){
            if(left==right){
                arr[left] = '9';
            }else{
                if(k-changes >= 2 && s.charAt(left) == arr[left]
                        && s.charAt(right) == arr[right]){
                    arr[left] = '9';
                    arr[right] = '9';
                    changes +=2;
                }else if(k-changes >= 1 && s.charAt(left) != s.charAt(right)){
                    arr[left] = '9';
                    arr[right] = '9';
                    changes ++;
                }
            }
            left++;
            right--;
        }
        return new String(arr);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = highestValuePalindrome(s, n, k);

        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
       // bufferedWriter.close();
    }
}
/*
Palindromes are strings that read the same from the left or right, for example madam or 0110.

You will be given a string representation of a number and a maximum number of changes you can make. Alter the string, one digit at a time, to create the string representation of the largest number possible given the limit to the number of changes. The length of the string may not be altered, so you must consider 's left of all higher digits in your tests. For example  is valid,  is not.

Given a string representing the starting number, and a maximum number of changes allowed, create the largest palindromic string of digits possible or the string '-1' if it is not possible to create a palindrome under the contstraints.

Example


Make  replacements to get .



Make  replacement to get .

Function Description

Complete the highestValuePalindrome function in the editor below.

highestValuePalindrome has the following parameter(s):

string s: a string representation of an integer
int n: the length of the integer string
int k: the maximum number of changes allowed
Returns

string: a string representation of the highest value achievable or -1
Input Format

The first line contains two space-separated integers,  and , the number of digits in the number and the maximum number of changes allowed.
The second line contains an -digit string of numbers.

Constraints

Each character  in the number is an integer where .
Output Format

Sample Input 0

STDIN   Function
-----   --------
4 1     n = 4, k = 1
3943    s = '3943'
Sample Output 0

3993
Sample Input 1

6 3
092282
Sample Output 1

992299
Sample Input 2

4 1
0011
Sample Output 2

-1
Explanation

Sample 0

There are two ways to make 3943 a palindrome by changing no more than k=1 digits:

1. 3943 -> 3993
2. 3943 -> 3443
3993 > 3443



 */
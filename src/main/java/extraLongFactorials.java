import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class extraLongFactorials {

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger output = BigInteger.ONE;
        for(int i=2; i<=n; i++){
            output = output.multiply(BigInteger.valueOf(i));

        }
        System.out.println(output);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        extraLongFactorials(n);

        bufferedReader.close();
    }
}

/*
The factorial of the integer , written , is defined as:

Calculate and print the factorial of a given integer.

For example, if , we calculate  and get .

Function Description

Complete the extraLongFactorials function in the editor below. It should print the result and return.

extraLongFactorials has the following parameter(s):

n: an integer
Note: Factorials of  can't be stored even in a  long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.

We recommend solving this challenge using BigIntegers.

 */

package Sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountSorting {

    // Get max value from array
    // Create array with max value size
    // iterate through input array and increment new array value for element value of input
    // create output array and put value from counted array

    public static int[] countingSort(int[] input){
        int max = Arrays.stream(input).max().getAsInt();

        int[] count = new int[max+1];

        for (int num : input) {
            count[num]++;
        }
        //below using stream
        //IntStream.of(input).forEach(num -> count[num]++);

        int j = 0;
        int[] output = new int[input.length];
        int i=0;
        while ( i<= max){
            while (count[i] > 0){
                output[j] = i;
                count[i]--;
                j++;
            }
            i++;
        }
        return output;

    }

    public static void main(String[] args) {
        int[] input = {2,5,1,4,7,3};
        int[] output = countingSort(input);
        Arrays.stream(output).boxed().forEach(System.out::println);
    }
}

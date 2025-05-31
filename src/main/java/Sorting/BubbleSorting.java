package Sorting;

import java.util.Arrays;

public class BubbleSorting {

    public static void bubbleSort(int[] input){
        // start from index 0 to 1
        // comparing adjacent pairs : if a[i] > a[i+1], if so then swap it
        //repeat for n passes, ignoring last sorted element

        int temp;

        for(int last = input.length-1; last>0;last--){
            for(int i=0; i<last;i++){
                if(input[i]> input[i+1]){
                    temp = input[i+1];
                    input[i+1] = input[i];
                    input[i] = temp;
                }
            }
        }
        //return input;
    }

    public static void main(String[] args) {
        int[] input = {2,5,1,4,7,3};
        bubbleSort(input);
        Arrays.stream(input).boxed().forEach(System.out::println);
    }
}

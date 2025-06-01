package Sorting;

import java.util.Arrays;

public class SelectionSorting {

    public static void selectionSort(int[] input){

        //from index i =0 to n-1
        //find index of min value from input[i to n-1]
        //swap with a[i]

        for(int i=0; i< input.length-1; i++){
            int min_index =i;

            for(int j=i+1; j<input.length;j++){
                if(input[j] < input[min_index]){
                    min_index = j;
                }
            }
            int temp = input[min_index];
            input[min_index] = input[i];
            input[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] input = {2,5,1,4,7,3};
        selectionSort(input);
        Arrays.stream(input).boxed().forEach(System.out::println);
    }
}

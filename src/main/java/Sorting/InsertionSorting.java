package Sorting;

import java.util.Arrays;

public class InsertionSorting {

    public static void insertionSort(int[] input){

        for(int i=1; i<input.length;i++){

            int key = input[i];
            int j = i-1;

            while(j >= 0 && input[j] > key){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = key;

        }

    }

    public static void main(String[] args) {
        int[] input = {2,5,1,4,7,3};
        insertionSort(input);
        Arrays.stream(input).boxed().forEach(System.out::println);
    }

    /*
    for (int i = 1; i < arr.length; i++)
Starts from index 1 (since a single element at index 0 is already "sorted").

This loop runs from second element to last.

int key = arr[i];
The key is the current element we want to place in its correct sorted position.

Think of this as the "card" you’re holding in your hand to insert into a sorted hand of cards.

int j = i - 1;
j starts from the element just before the current one.

We'll compare key with elements to its left (which are already sorted).

while (j >= 0 && arr[j] > key)
While we haven’t reached the start and the current element arr[j] is greater than key:

Keep shifting elements to the right.

arr[j + 1] = arr[j];
Move the larger element one index to the right to make space for the key.

j--;
Move the comparison index to the left (previous element).

arr[j + 1] = key;
We’ve found the correct position for the key (all larger elements have been moved right).

Insert the key just after the last smaller (or equal) element.
     */
}

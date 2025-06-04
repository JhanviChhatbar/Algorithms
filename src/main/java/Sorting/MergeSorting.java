package Sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSorting {

    //Divide array  into two halves recursively until each half has one element
    //merge two sorted halves into a single sorted array
    // repeat until fully merged

    public static void mergeSort(int[] arr, int left, int right){
        if (left < right){
            int mid = left + (right - left)/2;

            mergeSort(arr, left, mid);

            mergeSort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        IntStream.range(0, n1).forEach(i -> L[i] = arr[left+i]);
        IntStream.range(0, n2).forEach(i-> R[i] = arr[mid+i+1]);

        int i=0;
        int j=0;
        int k=left;

        while (i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] input = {2,5,1,4,7,3};
        mergeSort(input, 0, input.length - 1);
        Arrays.stream(input).boxed().forEach(System.out::println);
    }
}

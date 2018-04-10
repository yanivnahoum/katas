package com.att.training.katas.karatechop;

public class BinarySearch {
    
    private BinarySearch() {
        // No instances allowed
    }

    public static int chop(int element, int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) >>> 1;
            if (element > arr[midIndex]) {
                leftIndex = midIndex + 1;
            }
            else if (element < arr[midIndex]) {
                rightIndex = midIndex - 1;
            }
            else {
                return midIndex;
            }
        }
        return -1;
    }
}

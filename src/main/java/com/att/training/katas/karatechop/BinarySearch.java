package com.att.training.katas.karatechop;

class BinarySearch {

    private static final int NOT_FOUND = -1;

    private BinarySearch() {
        // No instances allowed
    }

    static int chop(int element, int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        
        while (leftIndex <= rightIndex) {
            int midIndex = getMiddleIndex(leftIndex, rightIndex);
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
        return NOT_FOUND;
    }

    private static int getMiddleIndex(int leftIndex, int rightIndex) {
        return (leftIndex + rightIndex) >>> 1;
    }
}

package com.coding.binarySearch.basic;

public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        int left = -1, right = letters.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return letters[right];
    }
}

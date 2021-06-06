/**
 * Define the n-based integer rounding of an integer k to be the nearest multiple of n to k. If two multiples of n are equidistant use the greater one.
 *
 * For example
 * the 4-based rounding of 5 is 4 because 5 is closer to 4 than it is to 8,
 * the 5-based rounding of 5 is 5 because 5 is closer to 5 that it is to 10,
 * the 4-based rounding of 6 is 8 because 6 is equidistant from 4 and 8, so the greater one is used,
 * the 13-based rounding of 9 is 13, because 9 is closer to 13 than it is to 0,
 * Write a function named doIntegerBasedRounding that takes an integer array and rounds all its positive elements using n-based
 * integer rounding.
 * A negative element of the array is not modified and if n <=0, no elements of the array are modified. Finally you may assume that the
 * array has at least two elements.
 * Hint: In integer arithmetic, (6/4) * 4 = 4
 *
 *
 * if a is                   and n is       then a becomes                        reason
 * {1, 2, 3, 4, 5}               2          {2, 2, 4, 4, 6}                       because the 2-based rounding of 1 is 2, the 2-based rounding of 2 is 2, the 2-based rounding of 3 is 4, then  2-based rounding of 4 is 4, and the 2-based rounding of 5 is 6.
 * {1, 2, 3, 4, 5}               3          {0, 3, 3, 3, 6}                       because the 3-based rounding of 1 is 0, the 3-based roundings of 2, 3, 4 are all 3, and the 3-based rounding of 5 is 6.
 * {1, 2, 3, 4, 5}              -3          {1, 2, 3, 4, 5}                       because the array is not changed if n <= 0.
 * {-1, -2, -3, -4, -5}          3          {-1, -2, -3, -4, -5}                  because negative numbers are not rounded
 * {-18, 1, 2, 3, 4, 5}          4          {-18, 0, 4, 4, 4, 4}                  because -18 is negative and hence is not modified, the 4-based rounding of 1 is 0, and the 4-based roundings of 2, 3, 4, 5 are all 4.
 * {1, 2, 3, 4, 5}               5          {0, 0, 5, 5, 5}
 * {1, 2, 3, 4, 5}               100        {0, 0, 0, 0, 0}
 *
 */

package com.hawa.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerBasedRounding {
        public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        int n = 2;

//        int[] arr = {1, 2, 3, 4, 5};

//        int[] arr = {1, 2, 3, 4, 5};
//        int n = -3;

//        int[] arr = {-1, -2, -3, -4, -5};
//        int n = 2;

//        int[] arr = {-18, 1, 2, 3, 4, 5};
//        int n = 4;

//        int[] arr = {1, 2, 3, 4, 5};
//        int n = 5;

        int[] arr = {1, 2, 3, 4, 5};
        int n = 100;

        log.info("The resultant Rounded array of {} with n={}, is: {}", arr, n, getRoundedArray(arr, n));

    }

    static int[] getRoundedArray(int[] arr, int n) {
        int x = 0;
        int[] newArr = new int[arr.length];

        if (n <= 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++, x++) {
            if (arr[i] < 0) {
                newArr[x] = arr[i];
                continue;
            }
            int val = arr[i] / n;
            int baseValue = n * val;
            newArr[x] = Math.abs(arr[i] - baseValue) < Math.abs(arr[i] - baseValue - n) ? baseValue : baseValue + n;
        }
        return newArr;

    }

}

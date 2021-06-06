/**
 * Define an array to be a Martian array if the number of 1s is greater than the number of 2s and no two adjacent elements are equal.
 *
 * Write a function named isMartian that returns 1 if its argument is a Martian array; otherwise it returns 0.
 *
 * If you are programming in Java or C#, the function signature is
 * int isMartian(int[ ] a)
 *
 * There are two additional requirements.
 *
 * 1. You should return 0 as soon as it is known that the array is not a Martian array; continuing to analyze the array would be a waste of
 * CPU cycles.
 * 2. There should be exactly one loop in your solution.
 *
 * Examples
 *
 * a is						then function returns		reason
 * {1, 3} 						1 							There is one 1 and zero 2s, hence the number of 1s is greater than the number of 2s. Also, no adjacent elements have the same value (1 does not equal 3)
 * {1, 2, 1, 2, 1, 2, 1, 2,1} 	1 							There are five 1s and four 2s, hence the number of 1s is greater than the number of 2s. Also, no two adjacent elements have the same value.
 * {1, 3, 2} 					0 							There is one 1 and one 2, hence the number of 1s is not greater than the number of 2s.
 * {1, 3, 2, 2, 1, 5, 1, 5} 	0 							There are two 2s adjacent to each other.
 * {1, 2, -18, -18, 1, 2} 		0 							The two -18s are adjacent to one another. Note that the number of 1s is not greater than than the number of 2s but your method should return 0 before determining that! (See the additional requirements above.)
 */

package com.hawa.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MartianArray {

    public static void main(String[] args) {
        int[] arrayOfNumbers = {1, 3};
//        int[] arrayOfNumbers = {1, 2, 1, 2, 1, 2, 1, 2, 1};
//        int[] arrayOfNumbers = {1, 3, 2};
//        int[] arrayOfNumbers = {1, 3, 2, 2, 1, 5, 1, 5};
//        int[] arrayOfNumbers = {1, 2, -18, -18, 1, 2};
//        int[] arrayOfNumbers = {};
//        int[] arrayOfNumbers ={1};
//        int[] arrayOfNumbers ={2};
        log.info("Checking if array {} is a Martian array. Return 1 for Yes and 0 for No.", arrayOfNumbers);
        log.info("Actual result: {}", isMartian(arrayOfNumbers));
    }

    static int isMartian(int[] a) {

        int countOne = 0;
        int countTwo = 0;
        int len = a.length;

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return a[0] == 1 ? 1 : 0;
        }

        for (int i = 0; i < len; i++) {
            if (i != len - 1) {
                if (a[i] == a[i + 1]) {
                    return 0;
                }
            }

            if (i == len - 2) {
                if (a[i] == a[len - 1]) {
                    return 0;
                }
            }
            if (a[i] == 1) {
                countOne++;
            }

            if (a[i] == 2) {
                countTwo++;
            }
        }

        log.info("Number of One's {}, Number of Two's: {}", countOne, countTwo);

        if (countOne > countTwo) {
            return 1;
        }
        return 0;
    }

}

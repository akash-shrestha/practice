/**
 * An array is defined to be paired-N if it contains two distinct elements that sum to N for some specified value of N and the indexes
 * of those elements also sum to N. Write a function named isPairedN that returns 1 if its array parameter is a paired-N array, otherwise
 * it returns 0.
 *
 * The value of N is passed as the second parameter.
 * If you are writing in Java or C#, the function signature is
 * int isPairedN(int[ ] a, int n)
 *
 * There are two additional requirements.
 * 1. Once you know the array is paired-N, you should return 1. No wasted loop iterations please.
 * 2. Do not enter the loop unless you have to. You should test the length of the array and the value of n to determine whether the array
 * could possibly be a paired-N array. If the tests indicate no, return 0 before entering the loop.
 *
 *
 * if a is                         and n is   	return     	reason
 * {1, 4, 1, 4, 5, 6} 				5 			1 			because a[2] + a[3] == 5 and 2+3==5. In other words,
 * 														    the sum of the values is equal to the sum of the corresponding indexes
 * 														    and both are equal to n (5 in this case).
 * {1, 4, 1, 4, 5, 6} 				6 			1 			because a[2] + a[4] == 6 and 2+4==6
 * {0, 1, 2, 3, 4, 5, 6, 7, 8} 	    6 			1 			because a[1]+a[5]==6 and 1+5==6
 * {1, 4, 1} 						5 			0 			because although a[0] + a[1] == 5, 0+1 != 5; and although a[1]+a[2]==5, 1+2 != 5
 * {8, 8, 8, 8, 7, 7, 7} 			15 			0 			because there are several ways to get the values to sum to 15 but there is no way to get the corresponding indexes to sum to 15.
 * {8, -8, 8, 8, 7, 7, -7} 		    -15 		0 			because although a[1]+a[6]==-15, 1+6!=-15
 * {3} 							    3 			0 			because the array has only one element
 * {} 								0 			0 			because the array has no elements
 *
 */

package com.basic.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PairedN {

    public static void main(String[] args) {
//        int[] arrayOfNumbers = {1, 4, 1, 4, 5, 6};
//        int num = 5;

//        int[] arrayOfNumbers = {1, 4, 1, 4, 5, 6};
//        int num = 6;

//        int[] arrayOfNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8};
//        int num = 6;

//        int[] arrayOfNumbers = {1, 4, 1};
//        int num = 5;

//        int[] arrayOfNumbers = {8, 8, 8, 8, 7, 7, 7};
//        int num = 15;

//        int[] arrayOfNumbers = {8, -8, 8, 8, 7, 7, -7};
//        int num = -15;

//        int[] arrayOfNumbers = {3};
//        int num = 3;

        int[] arrayOfNumbers = {};
        int num = 0;

        log.info("Checking it see if array {} is paired with N={}. Return 1 for Yes and 0 for No.", arrayOfNumbers, num);
        log.info("Acutal Result: {}", isParnedN(arrayOfNumbers, num));
    }

    static int isParnedN(int[] a, int n) {

        int len = a.length;
        if (len <= 1) {
            return 0;
        }

        for (int i = 0; i < len; i++) {
            int num = a[i];
            for (int j = i; j < len; j++) {
                if (a[j] + num == n && i + j == n) {
                    log.info("Matched. Because: a[{}] + a[{}] == {} and {} + {} == {}", i, j, n, i, j, n);
                    return 1;
                }
            }
        }

        return 0;
    }
}

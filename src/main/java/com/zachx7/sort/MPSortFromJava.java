package com.zachx7.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zach - 吸柒
 */
public class MPSortFromJava {

    public static void main(String[] args) {

        int[] arr = new int[10];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(80000);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}

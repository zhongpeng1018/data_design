package com.zachx7.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zach - 吸柒
 */
public class SelectSortFromJava {

    public static void main(String[] args) {

        int[] arr = new int[10];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(80000);
        }

        /*
         * 选择排序思路，先找出最小的值与第一个数进行替换，一次类推
         */

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i]; // 定义最小值
            int minIndex = i; // 定义最小值的索引

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}

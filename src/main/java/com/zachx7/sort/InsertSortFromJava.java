package com.zachx7.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zach - 吸柒
 */
public class InsertSortFromJava {

    public static void main(String[] args) {

        int[] arr = new int[10];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(80000);
        }

        // 插入排序思路：

        for (int i = 0; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            // 如果要插入的索引小于0
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }

        System.out.println(Arrays.toString(arr));

    }


}

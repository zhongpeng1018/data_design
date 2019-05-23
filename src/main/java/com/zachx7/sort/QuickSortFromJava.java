package com.zachx7.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zach - 吸柒
 * 快速排序
 */
public class QuickSortFromJava {

    public static void main(String[] args) {

        int[] arr = new int[1000];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(80000);
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //定义左指针
        int r = right; // 定义右指针
        int midValue = arr[(l + r) / 2]; // 给定一个中间值
        int temp = 0; //定义一个临时值用于交换位置

        while (l < r) {
            //循环遍历左边值，如果值大于中间值跳出循环
            while (arr[l] < midValue) {
                l++;
            }
            //循环遍历右边值，如果值小于中间值跳出循环
            while (arr[r] > midValue) {
                r--;
            }
            if (l >= r) { // 说明本次交换结束,退出本次 while
                break;
            }
            //将两边的值进行交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //提高效率
            if (arr[l] == midValue) {
                r -= 1;
            }
            if (arr[r] == midValue) {
                l += 1;
            }
        }

        if (l == r) { // 提高效率,不判断左右是否相等有可能会出现栈溢出的情况
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }


}

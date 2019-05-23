package com.zachx7.binarySearch;

/**
 * @author zach - 吸柒
 * 二分查找
 */
public class BinarySearchFromJava {

    public static void main(String[] args) throws Exception {

        int[] arr = {1,8,9,100,298,342,500};

        int i = binarySearch(arr, 0, arr.length - 1, 123124);
        System.out.println(i);

    }

    public static int binarySearch(int[] arr,int left , int right , int findVal) {
        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];

        if(left > right){
            return -1;
        }

        if(findVal > midValue){
            midIndex =  binarySearch(arr,midIndex+1,right,findVal);
        }else if (findVal < midValue) {
            midIndex =  binarySearch(arr,left,midIndex - 1,findVal);
        }else {
            return midIndex;
        }
        return midIndex;
    }

}

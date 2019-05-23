package com.zachx7;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zach - 吸柒
 */
public class test {

    @Test
    public void getSecondNum() {

        int[] arr = {2, 2, 1, 3, 7, 9};

        Arrays.sort(arr);

        System.out.println(arr[1]);

    }

    @Test
    public void fristNum() {
        int[] arr = {2, 2, 1, 3, 7, 9};

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                System.out.println(arr[i - 1]);
                break;
            }
        }
    }

    public void pay(int pay , int ten , int five , int two){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(10,ten);
        map.put(5,five);
        map.put(2,two);



    }




}

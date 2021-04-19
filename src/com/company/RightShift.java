package com.company;

import java.util.Arrays;

/**
  @author   Volodymyr Lakusta
  @project   JavaTest
  @class  RightShift
  @version  1.0.0 
  @since 19.04.2021 - 18.16
**/

public class RightShift {
    public static int[] rightShift(int[] array, int step){
        for (int i = 0; i < step; i++) {
            int lastElement = array[array.length-1];
            for (int j = array.length-1; j > 0; j--){
                array[j] = array[j-1];
            }
            array[0] = lastElement;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        System.out.println(Arrays.toString(rightShift(array, 1))); // [30, 10, 20]

        int[] array2 = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(rightShift(array2, 2))); // [40, 50, 10, 20, 30]

        System.out.println(Arrays.toString(rightShift(array2, 21))); // [50, 10, 20, 30, 40]
    }
}

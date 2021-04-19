package com.company;

import java.util.Arrays;

/**
  @author   Volodymyr Lakusta
  @project   JavaTest
  @class  Duplicates
  @version  1.0.0 
  @since 19.04.2021 - 18.28
**/

public class Duplicates {
    public  static  boolean hasDuplicates(int[] array){
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i]==array[i+1])return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        int[] array = {1,5,3,6,2,9,33,21};
        System.out.println(hasDuplicates(array));  // false
        array[5] = 1;
        System.out.println(hasDuplicates(array)); // true
    }
}

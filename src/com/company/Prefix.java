package com.company;
/**
  @author   Volodymyr Lakusta
  @project   JavaTest
  @class  Prefix
  @version  1.0.0 
  @since 19.04.2021 - 18.31
**/

public class Prefix {

    public static String prefix(String[] array) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < array[0].length(); i++) {
            prefix.append(array[0].charAt(i));
            for (int j = 1; j < array.length; j++) {
                if(array[j].length()==i || array[j].charAt(i)!=prefix.charAt(i)){
                    return prefix.substring(0,i);
                }
            }

        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] array = {"abc", "abcd", "abfce", "abcac"} ;

        System.out.println(prefix(array));  // ab

        String[] array2 = {"abc", "abcd", "abce", "abcac"} ;

        System.out.println(prefix(array2)); // abc


    }

}

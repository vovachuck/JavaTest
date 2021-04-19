package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
  @author   Volodymyr Lakusta
  @project   JavaTest
  @class  Harry
  @version  1.0.0 
  @since 19.04.2021 - 19.29
**/

public class Harry {

    public static void main(String[] args) throws IOException {

        String text1 = new String(Files.readAllBytes(Paths.get("src/com/company/harry.txt")));

        String text = text1.toLowerCase().replaceAll("[^A-Za-z ]","");
        String[] array = text.split(" +");

        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        Map<String, Integer> distinctWords = new HashMap<>();

        for (String word: list) {
            if(!distinctWords.containsKey(word)){
                distinctWords.put(word, 1);
            }else {
                distinctWords.put(word, distinctWords.get(word) + 1);
            }
        }

        //distinctWords.entrySet().stream().limit(20).forEach(System.out::println);

        Map<String, Integer> descMap = new LinkedHashMap<>();

        distinctWords.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> descMap.put(entry.getKey(), entry.getValue()));

        descMap.entrySet().stream().limit(20).forEach(System.out::println);

        // First 20 pairs
        descMap.entrySet().stream().limit(20).forEach(System.out::println);

        // Find all the proper names
        String[] array1 = text1.split(" +");
        List<String> names = new ArrayList<>();

        for (int i = 1; i < array1.length; i++) {
            if(array1[i-1].charAt(array1[i-1].length()-1)!='.' && !Character.isLowerCase(array1[i].charAt(0))){
                names.add(array1[i]);
            }
        }

        List<String> namesDistinct = new ArrayList<String>(new HashSet<String>(names));


        System.out.println(namesDistinct.size());

        // Sort name list
        List<String> sortedList = namesDistinct.stream().sorted().collect(Collectors.toList());
        sortedList.stream().limit(20).forEach(System.out::println);

        String listString = "";

        for (String s : sortedList)
        {
            listString += s + "\t";
        }

        String fileOutput = "src/com/company/names.txt";
        Files.write(Paths.get(fileOutput), listString.getBytes());

    }
}

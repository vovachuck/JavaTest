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
    /* Output:
    the=3628
    and=1919
    to=1856
    a=1688
    he=1528
    of=1259
    harry=1214
    was=1186
    it=1026
    in=964
    his=937
    you=863
    said=794
    had=702
    i=652
    on=636
    at=625
    that=601
    they=597
    as=526
    the=3628
    and=1919
    to=1856
    a=1688
    he=1528
    of=1259
    harry=1214
    was=1186
    it=1026
    in=964
    his=937
    you=863
    said=794
    had=702
    i=652
    on=636
    at=625
    that=601
    they=597
    as=526
    2161




    "A


    "Absolutely,"


    "Ah


    "Ah,


    "Aha!"


    "All


    "Always


    "An'


    "And


    "Anyway,


    "Are


    "Asked


    "B-b-but


    "B-but


    "Barking,"


    "Be


    "Bet


    "Blimey,


    "Blown

    Process finished with exit code 0

     */
}

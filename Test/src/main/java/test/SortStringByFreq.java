package test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class SortStringByFreq {
/*    aaabbccdefghiabchdes
    cond 1: sort on freq count in descing order
    cond 2: if freq is same then sort on character in ascending order


    bbbaaccccddd
            ccccbbbdddaa*/
    public static void main(String[] args) {
        String A = "bbbaaccccddd";
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<A.length();i++) {
            if(hm.containsKey(A.charAt(i))) {
                hm.put(A.charAt(i), hm.get(A.charAt(i)) +1);
            } else {
                hm.put(A.charAt(i), 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        hm.entrySet().stream().sorted((o1, o2) -> {
            if(o1.getValue() > o2.getValue()) {
                return -1;
            }else if(o1.getValue() < o2.getValue()) {
                return 1;
            } else {
               return (o1.getKey()-'0') - (o2.getKey()-'0');
            }
        }).forEach(entry -> sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue()))));
/*
                .forEach(characterIntegerEntry -> {

            for(int i=0;i<characterIntegerEntry.getValue();i++) {
                sb.append(characterIntegerEntry.getKey());
            }
        });*/
        System.out.println(sb.toString());
/*
        for(Map.Entry<Character,Integer> s : hm.entrySet()) {
            System.out.print(s.getKey() + " ");
        }*/



    }
}

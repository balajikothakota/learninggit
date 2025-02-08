package com.redis_cache.project;

import javax.swing.*;
import java.util.*;

public class Sample {
    public static void test(){
        System.out.println("testing.... ");
    }
    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1,1,3,5,4,4);
//        ArrayList<Integer> withoutDuplicates = new ArrayList<>(new LinkedHashSet<>(numbers));
//        System.out.println(withoutDuplicates);
//        HashSet<String> tree = new HashSet<>();
//        tree.add(null);
//        tree.add("abc");
//        System.out.println(tree);
//        String name = "balu";
//        char[] ch =name.toCharArray();
//        for(int i=ch.length-1;i>=0;i--){
//            System.out.print(ch[i]);
//        }
        int a = 10;
        int b=20;
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a+" "+b);

        String name ="I love you";
        HashMap<String, Integer> map = new HashMap<>();
        String[] split= name.split("\\s+");
        for(String s: split){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(Map.Entry<String,Integer> mapEntry : map.entrySet()){
            mapEntry.getValue();
            mapEntry.getKey();
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println("test");
        }
        System.out.println(map);


    }
    public static void print(){
        System.out.println("hi");
    }
}


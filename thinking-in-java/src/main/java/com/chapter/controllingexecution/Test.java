package com.chapter.controllingexecution;

import org.w3c.dom.ranges.RangeException;

import java.awt.print.Pageable;
import java.util.*;

public class Test {


    public static void main(String[] args) {
        /*        for (char c = 128; c >0; c--) {
         *//* if (Character.isLowerCase(c))
                System.out.println("value:" + (int) c + "character:" + c);*//*
            System.out.println("value:" + (int) c + "character:" + c);
        }*/
        Character c = 0;

        System.out.println("value:" + (int) --c + "character:" + --c);
    }


    @org.junit.jupiter.api.Test
    public void testCommaOperator() {
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i is " + i + ",j is " + j);
        }
    }

    @org.junit.jupiter.api.Test
    public void testForEach() {
        for (char c : "Hello World".toCharArray()) {
            System.out.println(c);
        }
    }

    @org.junit.jupiter.api.Test
    public void testContinueAndBreak() {

        /*   label:*/
        for (char c : "Hello World".toCharArray()) {
            if (c == new Character('r')) {
                /*     break label;*/
                break;
            }
            System.out.print(c);
            for (char b : "Hello World".toCharArray()) {
                if (b == new Character('r')) {
                    /*        continue label;*/
                    continue;
                }
                System.out.print(b);
            }
        }

    }

    @org.junit.jupiter.api.Test
    public void testGenerateFibonacci(){
        long[] list = generateFibonacci(20);
        for(long i :list){
            System.out.println(i);
        }
    }

    public long[] generateFibonacci(int num){
        long[] list = new long[num];
        for(int i = 0 ; i<num;i++){
            if(i==0){
                list[i]=1;
                continue;
            }
            if(i==1){
                list[i]=2;
                continue;
            }
            list[i] = list[i-1]+list[i-2];
        }
        return list;
    }

    @org.junit.jupiter.api.Test
    public void testFindAllVampireNumber(){
        List<Integer> list = findAllVampireNumber();
        for(int n:list){
            System.out.println(n);
        }
        System.out.println(list.size());
    }

    public List<Integer> findAllVampireNumber(){
        List<Integer> vampireNumbers = new ArrayList<Integer>();

        label:
        for(int i = 1000;i<=9999;i++){
            char[] chars = (i+"").toCharArray();
            List<Integer> nums = new ArrayList<Integer>();
            for(char c1 : chars){
                for(char c2: chars){
                    String numString = String.valueOf(c1)+String.valueOf(c2);
/*                    if (nums.contains(numString)){
                        continue;
                    }*/
                    nums.add(Integer.parseInt(numString));
                }
            }

            for(Integer integer1 : nums){
                for (Integer integer2 : nums){
                    if(integer1 == integer2){
                        continue;
                    }else if((integer1*integer2)==i){
                        vampireNumbers.add(i);
                        continue label;
                    }
                }
            }

        }
        return vampireNumbers;
    }
}

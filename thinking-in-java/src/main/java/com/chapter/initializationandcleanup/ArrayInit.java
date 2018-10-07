package com.chapter.initializationandcleanup;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayInit {

    int[] a = new int[5];
    int[] a1 = new int[]{1,2,3,4};
    int[] a2 ;
    // 存放引用，并非存放实际的对象
    Integer[] arr = {1,2,3,4,5 };
    Integer[] arr1 ;
    Integer[] arr2 = new Integer[5];
    {
        a2 = new int[]{1,2,3,4,5};
        arr1 = new Integer[]{1,2,3,4,5};
    }

    public static void main(String[] args) {
        ArrayInit arrayInit = new ArrayInit();
        System.out.println(Arrays.toString(arrayInit.a2));
    }
}

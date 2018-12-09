package com.chapter.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayTest{
    @Test
    public void testMultiArray() {
        String[][] strings = {{"212","211"},{}};
        String[][][] strings1 = {{{"1","2"},{"123","12312"}},{}};
        String[][][][] strings2 = {{{{"0000","0001"},{"0010","0011"}},{{},{}}},{}};
        String[] st = new String[3];
        System.out.println(strings2[0][0][0][0]);

    }

    @Test
    public void testMethod(){
        String[][] strings = {{"212","211"},{}};
        String[][] strings1 = new String[2][];
        System.arraycopy(strings,0,strings1,0,strings.length); // 复制
        System.out.println(strings1[0][0]); // 212

        System.out.println(Arrays.equals(strings,strings1)); // 比较 true

        Arrays.sort(strings, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1.length - o2.length;
            }
        });



        Integer[] ints = {1,2,4,5,3,6,8,7};

        Arrays.sort(ints, (o1, o2) -> -(o1 - o2));
        Arrays.sort(ints,Integer::compareTo);
        System.out.println(Arrays.binarySearch(ints,5));


    }

}

package algorithm.datastruct;

import algorithm.datastruct.map.HashMap;
import algorithm.datastruct.map.MapEntry;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            map.put(i, "value" + i);
        }
        Iterator<MapEntry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getValue());
        }
  /*      map.remove(0);
        System.out.println(map.get(0));*/
        System.out.println(16 >> 1);


        for(Integer i : map.krySet()){
            System.out.println("args = [" + i + "]");
        }
        Set<String> stringSet = new HashSet<>(); //

        java.util.HashMap map1;
/*        array.remove(9);
        array.forEach((v) -> System.out.println("args = [" + v + "]"));*/
    }
}

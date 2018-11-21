package com.chapter.collection;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

class Snow implements Comparable<Snow>{

    private int size;
    public Snow(int size){
        this.size = size;
    }

    public int compareTo(Snow o) {
        if(this.size>o.size){
            return 1;
        }
        if(this.size<o.size){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Snow{" +
                "size=" + size +
                '}';
    }
}

class Powder extends Snow {

    public Powder(int size) {
        super(size);
    }
}

class Light extends Snow {

    public Light(int size) {
        super(size);
    }
}

class MyArray <E> implements Iterable<E>{

    private class Itr implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }



    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
public class CollectionTest {

    public static void main(String... args) throws Exception {

        List<Integer> list = new ArrayList();

        list.add(1);
        list.add(3);
        list.add(2);

        List<Integer> list2 = new ArrayList<Integer>(list);
        Iterator<Integer> it = list2.iterator();

        Iterator<Snow> iterator = new Iterator<Snow>() {
            public boolean hasNext() {
                return false;
            }

            public Snow next() {
                return null;
            }

            public void remove() {

            }

            public void forEachRemaining(Consumer<? super Snow> action) {

            }
        };

        System.out.println(list.toString());

        Collections.sort(list, new Comparator<Integer>() {
            /**
             *当返回负值，a,b顺序不变，当返回正值，a，b顺序交换
             * @param o1
             * @param o2
             * @return
             */
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)
                    return 1;
                if (o1 > o2)
                    return -1;
                return 0;
            }
        });

        System.out.println(list.toString());


        List<Snow> snows = new ArrayList<Snow>();

        Collections.addAll(snows,new Light(1),new Powder(3),new Light(2));

        Collections.sort(snows);

        System.out.println(snows.toString());

        Collections.reverse(snows);
        System.out.println(snows.toString());
    }


}

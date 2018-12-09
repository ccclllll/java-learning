package com.chapter.generics.erasure;

import com.chapter.generics.GenerisTest;

public class GenericsArray<E> {
    Object[] elementDate;
    E[] es;

    public GenericsArray(int size) {
        this.elementDate = new Object[size];
        es = (E[]) elementDate;
    }

    public E get(int index) {
        //return (E)elementDate[index];
        return es[index];
    }

    public void insert(E e, int index) {
        //this.elementDate[index] = e;
        this.es[index] = e;
    }

    E[] getEs(){
        return es;
    }

    public static void main(String[] args) throws Exception {
        GenericsArray<Number> array = new GenericsArray(10);
        array.insert(1, 0);
        array.getClass().getDeclaredMethod("insert", new Class[]{Object.class, int.class}).invoke(array, new Object[]{1, 1});
        Number s = array.get(0);
        array.get(1);

        Object[] es = array.getEs();
        Number[] es1 = array.getEs();
        int l = es1.length;
        System.out.println(array.get(1)); // 相当于(Number)array.get(1); int 可以向上转型为Number
    }
}

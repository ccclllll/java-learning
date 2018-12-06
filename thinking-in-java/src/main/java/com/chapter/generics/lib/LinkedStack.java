package com.chapter.generics.lib;

public class LinkedStack<T> extends LinkedList<T> {
    public void push(T t){
        this.appendFront(t);
    }

    public T pop(){
        return this.removeFront();
    }
}

package com.chapter.generics.lib;

import java.util.Iterator;
import java.util.function.Consumer;

public abstract class LinkedList<T> extends List<T> implements Iterable<T> {

    /**
     * 迭代器
     **/
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < LinkedList.this.size;
            }

            @Override
            public T next() {
                return LinkedList.this.get(index++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < this.size; i++) {
            action.accept(this.get(i));
        }
    }

    @Override
    protected T get(int index) {

        if (index == this.size - 1) return getLast();
        int i = -1;
        Node node = this.first;
        while (node.next != null && i < index) {
            node = node.next;
            i++;
        }
        if (i == index) return node.item;
        throw new IndexOutBoundException();
    }

    @Override
    protected T getFirst() {
        return get(0);
    }

    @Override
    protected T getLast() {
        return this.last.item;
    }

    @Override
    protected void insert(int index, T t) {
        int i = 0;
        Node node = this.first;

        if (index == this.size) {
            appendEnd(t);
            return;
        }
        while (node.next != null && i < index) {
            node = node.next;
            i++;
        }
        if (i == index) {
            Node newNode = new Node(node.next, node, t);
            node.next = newNode;
            this.size++;
        } else {
            throw new IndexOutBoundException();
        }
    }

    @Override
    protected void appendFront(T o) {
        insert(0, o);
    }

    @Override
    protected void appendEnd(T o) {
        Node node = new Node(null, null, o);
        if (this.last == null) {
            this.first.next = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.pre = this.last;
            this.last = node;
        }
        this.size++;
    }


    @Override
    protected T remove(int index) {
        if (index >= this.size) {
            throw new IndexOutBoundException();
        }
        if (index == this.size - 1) return removeEnd();
        Node node = this.first;
        int i = 0;
        while (node.next != null && i < index) {
            node = node.next;
            i++;
        }
        if (i == index) {
            if (this.size == 1) return removeEnd();
            T t = node.next.item;
            node.next = node.next.next;
            node.next.pre = node;
            this.size--;
            return t;
        } else {
            throw new IndexOutBoundException();
        }
    }

    @Override
    protected T removeEnd() {
        if (this.size <= 0) {
            throw new IndexOutBoundException();
        } else {
            T t = this.last.item;
            this.size--;
            this.last = this.last.pre;
            if (this.last != null)
                this.last.next = null;
            return t;
        }
    }

    @Override
    protected T removeFront() {
        if (this.size <= 0) {
            throw new IndexOutBoundException();
        } else {
            if (this.size == 1) return removeEnd();
            return remove(0);
        }
    }

}

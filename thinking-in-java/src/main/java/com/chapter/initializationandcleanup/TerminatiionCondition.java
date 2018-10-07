package com.chapter.initializationandcleanup;

import org.junit.jupiter.api.Test;

public class TerminatiionCondition {
    class Book {
        boolean checkOut = false;

        Book(boolean checkOut) {
            this.checkOut = checkOut;
        }

        public void checkIn() {
            checkOut = false;
        }

        @Override
        protected void finalize() {
            if (checkOut)
                System.out.println("error: not check in");
            //super.finalize();

        }

        @Override
        public String toString() {
            return "Book{" +
                    "checkOut=" + checkOut +
                    '}';
        }
    }

    @Test
    public void testTerminationCondition() {
        Book book = new Book(true);
        book.checkIn();
        new Book(true);
        System.gc();
        int a=10;
        int b=a; // b的数据区实际上是变量a所表示的存储单元的数据
        a=5; // a的数值发生改变并不会影响到b

        System.out.println(b);
        Book book1 = new Book(true);
        Book book2 = book1; // book2的这个变量的数据区变成了book1所表示的存储单元的地址
        // book1这个变量的数据区变成了book所表示的存储单元的地址 book1的数据区改变并不会影响到book2，
        // 但是如果通过bool1改变了他所引用的地址的数据，那么就会影响到book2
        book1 = book;
        System.out.println(book2.toString());
        System.out.println(book1.toString());
    }
}

package com.chapter.exception;

class MyE extends Exception{

}
interface In{
    default void fun(){
        System.out.println("123");
    }

    void ex() throws Exception;
}


class Imp implements In{

    @Override
    public void ex() throws Exception{

    }
}
public class OutException extends Exception {
}

class TestOutException {
    public void initTestOutException(Integer i) throws Exception {
        Long l = i.longValue();
        if (i == null) {
            OutException exception = new OutException();
            exception.initCause(new NullPointerException());
            throw exception;

        }
    }

    public static void main(String[] args) throws Exception {

/*        TestOutException t = new TestOutException();
        t.initTestOutException(null);*/
/*        try {
            throw new RuntimeException();
        }finally {
            return;
        }*/
        try {
            try {
                throw new Exception("exception1");
            } catch (Exception e){
                System.out.println(e);
            } finally {
                throw new Exception("exception2");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
package com.chapter.exception;

public class BasicException {
    class MyExceprion extends Exception {
        public MyExceprion() {
            super("MyException occurred");
        }
    }

    public void testException(int i) throws Exception {
        if (i > 10)
            throw new Exception("exception occurred"){
            };
    }

    public int useException(){
        try {
            testException(11);
        } catch (Exception e) {
            for(StackTraceElement ele : e.getStackTrace()){
                System.out.println(ele.getMethodName());
            }
            return 1;
        }finally {
            return 2;
        }
    }


    class Exception1 extends Exception{
        Exception1(String message){
            super(message);
        }
    }
    class Exception2 extends Exception{
        Exception2(String message){
            super(message);
        }
    }
    class Exception3 extends RuntimeException{

    }
    class A{
        void fun(int i) throws Exception1,Exception2{ // 以这种方式告知调用者会出现的异常
            if(i==1)throw new Exception1("a exception");
            if(i==2)throw new Exception2("a exception");
            if(i==3)throw new Exception3();
        }
    }

    public static void main(String[] args) {
        BasicException basicException = new BasicException();

        System.out.println(basicException.useException());
    }


}

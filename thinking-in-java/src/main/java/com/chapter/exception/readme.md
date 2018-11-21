异常
1 finally子句是一定会执行的，所以下面代码无论如何都是返回2

```java
class A{
    public int useException(){
            try {
                testException(101);
            } catch (Exception e) {
                e.printStackTrace();
                return 1;
            }finally {
                return 2;
            }
        }
}
```
2 exception specification 
```java
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
        void fun(int i) throws Exception1,Exception2{ // throws keyword followed by a list of the potential exceptions would be thrown form the method
            if(i==1)throw new Exception1("a exception");
            if(i==2)throw new Exception2("a exception");
            if(i==3)throw new Exception3(); // the exception inherit from RuntimeException can be thrown anywhere without exception specification
        }
    }
```

3 .stack trace 栈轨迹
```java
e.getStackTrace() //返回 StackTraceElement[] 数组最后一个元素是第一个调用
```

4. rethrow exception
```java
class A{
    void f() throws Exception{
        
    }
}
```


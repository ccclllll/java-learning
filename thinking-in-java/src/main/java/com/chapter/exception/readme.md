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
        throw new Exception(); // mark1
    }
    
    void ff() {
        try{
            f();
        }catch (Exception e
        ){
            //throw e; // 抛出异常，当上一层环境捕捉到异常时，异常地址依旧是之前的地址，即mark1,抛出的依旧是之前的异常
            throw (Exception)e.fillInStackTrace(); // 当上一层环境捕捉到异常时，此处是异常发生地址
        }
    }
}
```

5 异常链
```java
public class OutException extends Exception{
}
class TestOutException{
    public void initTestOutException(Integer i) throws Exception{
        if(i == null){
            OutException exception = new OutException();
            exception.initCause(new NullPointerException()); // 使用initCause链接异常
            throw exception;

        }
    }
    public static void main(String[] args) throws Exception{

        TestOutException t = new TestOutException();
        t.initTestOutException(null);
    }
}
```
6 RuntimeException
运行时异常不用被捕获，当发生运行时异常时，会在程序退出前调用printStackTrace()。

7 方法异常限制
子类覆盖父类方法时，异常说明应该和父类方法一致，而且异常说明中的异常也不支持向上转型。

6. 在创建一个需要被清理的对象之后，立即进入try-catch语句块
```java
class A{
    public static void main(String[] args){
      try{
          BufferedReader reader = new BufferedReader(new FileReader("c://tex.txt"));
          try{
                     
          }finally{
              reader.close(); 
          }
      }catch (Exception e){ // 在BufferedReader创建时发生异常，则不需要对其清理，应为并没有创建成功
          e.printStackTrace();
      }
    }
}
```

7. 异常会被匹配的第一个catch子句捕获，如果将基类异常放到最前面，则其派生类异常会被屏蔽
```java
class MyException extends Exception{}
class MyE1 extends MyException{}

class A{
    public static void main(String[] args){
      try{
          throw new MyException();
      }catch (MyException e){
          
      }catch (MyE1 e){ // can not reachable
          
      }
    }
}
```
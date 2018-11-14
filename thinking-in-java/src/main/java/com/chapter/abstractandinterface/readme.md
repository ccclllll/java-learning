1. abstract class
抽象类不允许创建其实例
抽象类可以没有抽象方法
2. interface
interface like a protocol between classes
the methods in interface is public 
3. 适配器模式和策略模式
将某个类进行适配，让它能应用与某个方法
```java
interface Processor{
    void process();
}

class A{
    public static void apply(Processor p){ // 这里p相当于策略
        p.process();
    }
}

class B{
    void doSomething(){
    }
}

/** 此时可应用与apply**/
class BAdapter implements Processor{
    B b; // 这里b相当于代理
    BAdapter(B b){
        this.b = b;
    }
    
    public void process(){
        b.doSomething();
    }
}

public class Client{
    public static void main(String[] args){
      A.apply(new BAdapter());
    }
}
```

4. 多重继承
java可以多重继承，但是继承的基类中，只能有一个类有具体实现，其余必须为接口
接口允许被另一个接口继承
5. 接口中的域
默认修饰 public static final
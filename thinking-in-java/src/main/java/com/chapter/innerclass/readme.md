# inner class
1. 内部类对象可以访问外部类对象的所有成员，内部类也可访问外部类的所有成员, 内部类对象会持有一个外围类的引用,
所以，在创建非静态内部类对象时，必须提供外围类对象的引用 
```java
   A.C c = new A.C(); // c is static inner class
   A.B bb = a.new B(); // 在创建非静态内部类对象时，必须提供外围类对象的引用 
```
2. 内部类的this
```java
this指向内部类对象
A.this.fun(); // 内部类访问外围类对象成员变量
class A{

    void say(){
        System.out.println("A fun");
    }
    class B{
        void Say(){
        }
        void t(){
            this.Say();
            A.this.say(); // 类名.this
        }
    }
}
```
当静态内部类访问外围类的实例成员变量时，会出现错误

3. 外围类可以访问内部类的私有成员
4. 通过内部类实现接口，并向上转型为接口，可以方便的隐藏实现细节，对于客户端程序员来说完全无法知道类型信息，只能面向接口编程。
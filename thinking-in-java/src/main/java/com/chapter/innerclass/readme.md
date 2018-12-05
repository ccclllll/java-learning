# inner class

Each inner class can independently inherit from an implementation. Thus, the inner
class is not limited by whether the outer class is already inheriting from an
implementation. 

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

5. 内部类可以在任何作用域定义

6. 匿名内部类不能有构造器

7.匿名内部类创建
```java
void Contents contents(){
    
    return new Contens(){
        private int i;
    }
}
```
that means "Create an object of an anonymous class that’s inherited from Contents."

8. 匿名内部类中使用到外部的对象时，那么这个引用这个对象的变量必须被定义final

9. 匿名内部类可以通过构造代码块来进行初始化，不能通过构造函数来初始化，所以无法实现构造重载
```java
class A{
    
}

interface In{
    void ff();
}
class B{
    public A buildA(final int b){ // the variable be used in anonymous inner class directly, so it must be defined as final.otherwise, the compiler will show you a error message.
        return new A(){
            private int i;
            {
                this.i = b;
            }
        };
    }
}

```

匿名内部类相当于是对基类的一个扩展，或者说继承。但是和普通类不同，它们只能继承或者实现一个类或者接口,只能一个

10. nested classes 嵌套类
通过static关键字声明的内部类又叫做嵌套类，这样的内部类对象与外围类对象没有联系，所以在创建时，不需要外围类对象，这样的话，就无法访问外围类的实例变量，
这是很好理解的，因为static内部类对象不知道外围类对象，他们没有联系。
普通内部类与嵌套类的区别：
1 普通内部类对象与外围类对象有联系，而嵌套类没有，对象创建语法分别为：
```java
   A.C c = new A.C(); // c is static inner class
   A.B bb = a.new B(); // 在创建非静态内部类对象时，必须提供外围类对象的引用 
```
2 普通内部类不能有类成员变量，而嵌套类可以有
3 嵌套类只能当作成员变量进行声明，不能在方法体类进行声明，它类似于一个static方法
4 普通内部类更像多重继承。
```java

class A{
    
}

class B{
    class C extends A{ //C 继承了A，但是也能访问B，类似继承了B
        
    }
}
```
11. 接口中可以声明内部类，并且为public static，和字段不同，没有final修饰，说明可以被继承

12. 闭包和回调
闭包：闭包就是能够读取其他函数内部变量的函数。例如在javascript中，只有函数内部的子函数才能读取局部变量，
所以闭包可以理解成“定义在一个函数内部的函数“。在本质上，闭包是将函数内部和函数外部连接起来的桥梁。 
```javascript
var add = (function () {
    var counter = 0;
    return function () {return counter += 1;}
})();
 
add();
add();
add();
 
```
这里的add就是一个闭包，它可以访问counter。
内部类类似于一个闭包，可以访问外围类的所有成员变量以及外围类的实例变量。
回调：A让B做一件事情，B做完了，然后告知A。告知A这个动作叫做回调
```java
interface Callback{
    void doSomething();
}

class A implements Callback{
    void doSomething(){
        
    }
}

class B{
    void doSomething(Callback callback){
        callback.doSomething();
    }
    
    public static void main(String[] args){
      A a = new A();
      B b = new B();
      b.doSomething(new Callback() {
          @Override
          public void doSomething() {
              
          }
      });
    }
}
```
13. 内部类的继承
```java
class WithInner{
    class Inner{
        
    }
}
class InheritInner extends WithInner.Inner{
    public InheritInner(WithInner withInner){
        withInner.super();
    }
}
```
必须提供外围类的引用。在构造器内执行enclosingClassReference.super();

14. 内部类并不能被覆盖

15. 局部内部类也可以访问外围类的所有成员。
polymorphism 多态
向上转型：
一个对象的引用可以被当成父类对象的引用
前期绑定：在运行前由绑定
后期绑定：在运行时根据对象的类型进行绑定，在java中，除了static，final，private方法之外，都是属于后期绑定,这些方法是不可覆盖的。
多态： 对象的行为与类型无关，只于实例相关
```java
class A{
    public static void fun(){
        System.out.println("A fun");
    }
}
class B extends A{
    public static void fun(){
        System.out.println("B fun");
    }
}
public class MyTest {
    void fun(A a){
        a.fun();
    }

    @Test
    public void testA(){
        A b = new B();
        fun(b); 
    }
}
output: A fun
```
当本类和父类都含有同一变量时，会优先寻找本类，就近原则.

构造器中的多态：

```java
class Father{

    public void fun2(){
        System.out.println("father fun2 called");
    }
    
    public Father(){

        fun2();
    }
}
class Son extends Father{

    public Son(){
    }
    @Override
    public void fun2(){
        System.out.println("son fun2 called");
    }

}

Father ob = new Son(); // son fun2 called
```
这里会调用实际对象的（被覆盖的）fun2。这里有个问题：在调用父类构造器调用fun2时，子类还未被构造，所以，如果此时fun2使用了子类的成员变量或引用，则会出现一些
问题

```java
class Father{

    public void fun2(){
        System.out.println("father fun2 called");
    }
    
    public Father(){

        fun2();
    }
}
class Son extends Father{

    int i = 1;
    public Son(){
    }
    @Override
    public void fun2(){
        System.out.println("son fun2 called ; i = "+ i);
    }

}

// Father ob = new Son(); // son fun2 called i = 0
```

可见，在未被初始化之前就使用了成员变量，会给出一个默认值.可根据初始化顺序得出。

1 先将分配给对象的空间以0初始化
2 查找是有继承
3 有继承，转第二步，否则进入4
4 初始化基类实例变量，调用基类构造代码块，调用基类器
5 初始化本类实例变量，调用构造代码块，构造器
注意（类变量和类引用，静态代码块在类加载时已经执行）



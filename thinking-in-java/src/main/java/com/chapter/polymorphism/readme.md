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

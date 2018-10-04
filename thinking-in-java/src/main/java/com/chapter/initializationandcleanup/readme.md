### 初始化和清除对象
#### 1. 构造函数
构造函数是对象被创建后自动调用的一个方法，并且构造函数会自动对类的成员变量进行初始化。
例如：
```java
    class A{
        String s;
    }
    A a= new A();
    String s;
    System.out.println(s); // error 没有被初始化 使用一个引用前必须对其赋值或者初始化
    System.out.println(a.s); // 会被构造器自动初始化为null*/
```
#### 2. method overload  方法重载
allow the same method to be used with different arguments type 
对于方法重载 ， 返回类型可以不同，但是不能有相同序列的参数列表，举个例子  void f(int i,String s),void f(String s,int i)是允许的，但是不推荐。
#### 3. 基本类型的重载Overload With Primitive
当方法参数包含基本类型时，如果传入的参数精度小于方法要求的参数的精度，则传入的参数会被自动提升精度。
```java
    /**
     * 基本类型重载 类似类型提升
     */
    class OverloadWithPrimitive{
        void f1(byte b){
            System.out.println("b = [" + b + "]");
        }
        void f1(short shortNum){
            System.out.println("shortNum = [" + shortNum + "]");
        }
        void f1(float f){
            System.out.println("f = [" + f + "]");
        }
    }
    @Test
    public void testA(){

        OverloadWithPrimitive overload = new OverloadWithPrimitive();
        char c = 5; 
        overload.f1(c); // if there are no method with char argument, but a method with large type , the char type will be automatically promoted to large type.
        int i = 5;
        overload.f1(i);
        float f= 5;
        overload.f1(f);

        byte b = 5;
        overload.f1(b);
    }
    output:
    f = [5.0]
    f = [5.0]
    f = [5.0]
    b = [5]

```
#### 4. this 关键字
有两个A 类型的对象，一个peel方法，两个对象都调用peel方法，编译器如何知道是哪个实例调用了类的peel()方法？实际上，在调用peel方法时，编译器会自动的把对象的引用当成一个
参数传入到方法。
```java
A a = new A();
A b = new A();
a.peel(); // => A.peel(a)
b.peel(); => A.peel(b);
```
那么如何在方法内部获取到这个被编译器自动传入的参数（也就是对象的引用，方法的实际调用者）呢，可以通过this关键字获取。  
The this keyword—which can be used only inside a non-static method—produces the reference to the object that the method has been called
for.  
this一般用返回值或者将引用作为参数传递给其他类的方法,也用作在构造器里调用另一个构造函数。this(Object ...arg)
```java
public class Exercise3 {
    class A{
        public A(){

        }
        public A(String a){
            this();
        }
        
        public A operate(B b){
            b.doWithA(this);
            return this;
        }
        
    }
    
    class B{
        A doWithA(A a){
            System.out.println("a = [" + a + "]");
        }
    }
}
```
#### 5. static 关键字
    1. 用static关键字修饰的属性或方法，在类被加载时会被创建在内存中，当我们要使用这些属性或方法时，类必须要被加载到虚拟机。
    2. 非静态内部类不能拥有static关键字修饰的成员变量，因为非静态内部类不会随着外部类一起加载。
    3. 使用static关键字修饰的内部类，会随着外部类加载时而被加载，然后对内部类的静态成员及静态代码块进行初始化。
ps: 其实很容易理解，在给静态成员变量分配内存空间时，类必须要先被加载，而内部类并不会随着外部类被加载时而被加载，所以无法给静态成员1变量
分配内存空间。

类加载机制初步理解：
 类装载器就是寻找类的字节码文件，并构造出类在JVM内部表示的对象组件。在Java中，类装载器把一个类装入JVM中，要经过以下步骤：

     (1) 装载：查找和导入Class文件；

     (2) 链接：把类的二进制数据合并到JRE中；

        (a)校验：检查载入Class文件数据的正确性；

        (b)准备：给类的静态变量分配存储空间；

        (c)解析：将符号引用转成直接引用；

     (3) 初始化：对类的静态变量，静态代码块执行初始化操作
 jvm的类动态加载机制
 
 不管使用什么样的类加载器，类，都是在第一次被用到时，动态加载到JVM的。这句话有两层含义：
 
 Java程序在运行时并不一定被完整加载，只有当发现该类还没有加载时，才去本地或远程查找类的.class文件并验证和加载；
 当程序创建了第一个对类的静态成员的引用（如类的静态变量、静态方法、构造方法——构造方法也是静态的）时，才会加载该类。
 Java的这个特性叫做：动态加载。   
#### 6. 不定个数的参数
f1(String ...s) 写法，可以传入任意多个String 类型的参数，可以通过foreach对s进行遍历。
#### 7. cleanup:garbage collection
当垃圾回收器准备释放某块内存空间，回收某个对象的内存时，会首先执行finalize() （任何类都可以覆盖这个方法）方法，然后在下一轮的回收过程中对内存进行释放。
java对象的内存不一定总是会被回收。当程序不接近于耗尽内存的界限，垃圾回收器不会起作用（垃圾回收器本身会耗费资源，所以如果
没有必要回收内存空间，垃圾回收器无需工作）。
finalize()和garbage collection都不一定会执行。
finalize() 方法一般用作对终止条件的判断，当对象被释放时，要保证他已经可以释放了。
```java

public class TerminatiionCondition {
    class Book{
        boolean checkOut = false;
        Book(boolean checkOut){
            this.checkOut = checkOut;
        }
        public void checkIn(){
            checkOut = false;
        }
        @Override
        protected void finalize(){
            if(checkOut)
                System.out.println("error: not check in");
        }
    }

    @Test
    public void testTerminationCondition(){
        Book book  = new Book(true);
        book.checkIn();
        new Book(true);  // error: not check in  被回收时报出错误，因为图书没有被登记（所以finalize方法可以用来检查是否满足终止条件
        System.gc(); // 通知垃圾回收器进行回收 
    }
}

```
#### 8. java垃圾回收器的运行机制  
垃圾回收器的实现，一般需要一个引用计数器，用来统计对象被引用的次数。垃圾回收器通过判断引用的个数来决定是否要释放空间。

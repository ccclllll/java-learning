## Generics (泛型)
1 parameterized types(参数化类型)
2 泛型类不可使用Throwable
3 泛型方法
```java
class A{
        public <T> T getParameterType(T... t){
            return t;
        }
}
```
```java
class A{
        public static void main(String[] args) throws Exception{
            GenerisTest test = new GenerisTest();
            test.getParameterType("String");
            List<String> strings = new ArrayList<>();
            List<?> list = strings; // ?只提供可读功能
            List<? extends Base> bases = new ArrayList<>();
            bases.add(new Child()); // error
            bases.add(new Base());// error
            List<? super Child> objects = new ArrayList<>();
            objects.add(new Child());
            objects.add(new Base());//error
            
            System.out.println(objects.getClass().equals(bases.getClass()));//true
        }
}
```
将类型参数置于返回类型之前
 \<? extends T> 被称作有上限的通配符。T 以及T的子类
\<? super T> 被称作有下限的通配符。 T 以及T的超类  ? 通配符
这是用于告知泛型边界的
```java
interface A{
    void f();
}

class AG<T extends A>{
    T t;
    A(T t){
        this.t = t;
    }
    void f(){
        t.f(); // 如果没有告知边界，这个是无法执行的
    }
}
```

5 类型擦除  
A<String> a 和A<Integer> b 的class对象是等级的，在运行时都会被转换为A类型。
通过反射可以绕过编译器，向泛型容器添加任意元素。
```java
class A{
  @Test
    public void testRemoveType() throws Exception{
        List<String> strings = new ArrayList<>();
        strings.getClass().getDeclaredMethod("add",Object.class).invoke(strings,new Double(10));
        Object o = strings.getClass().getDeclaredMethod("get",int.class).invoke(strings,0);
        System.out.println(o); // 10.0
    }
    
    void tt(){
       Child<String>[] s = new Child[]{new Child<Double>(),new Child<Integer>()}; //right 都转成了Child
    }
}


public class GenericsArray <E extends Number> {
    E[] elementDate;

    public GenericsArray(int size) {
        //elementDate = new E[size]; // error，因为在运行时类型信息会丢失
        this.elementDate = (E[]) new Number[size]; // 编译器认可，但是会产生异常，因为无法把Object[] 转换为具体类型的数组
    }
    public E get(int index){
        return elementDate[index];
    }
}
```
java的泛型是在编译期进行类型检测，当进入运行期时，类型将会被擦除，所以在运行期间无法获取具体类型的信息。  
```java
public class GenericsArray <E> {
    Object[] elementDate;

    public GenericsArray(int size) {
        this.elementDate = new Object[size];
    }
    public E get(int index){
        return (E)elementDate[index]; // 加上强制类型转换只是让编译通过，返回时的类型在运行时会变成Object
    }
}

```

java泛型，在编译期会自动加上强制类型转换。
```java


public class GenericsArray <E> {
    E element;
    public E get(){ return element; }
    public void insert(E e){ this.element= e; }
    public static void main(String[] args) throws Exception{
      GenericsArray<String> s = new GenericsArray();
	s.insert("qqweq");
	String ss = s.get();
    }
}
Compiled from "GenericsArray.java"
public class c.cl.GenericsArray<E> {
  java.lang.object element;

  public c.cl.GenericsArray();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public java.lang.object get();
    Code:
       0: aload_0
       1: getfield      #2                  // Field element:Ljava/lang/Object;
       4: areturn

  public void insert(java.lang.object);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #2                  // Field element:Ljava/lang/Object;
       5: return

  public static void main(java.lang.String[]) throws java.lang.Exception;
    Code:
       0: new           #3                  // class c/cl/GenericsArray
       3: dup
       4: invokespecial #4                  // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: ldc           #5                  // String qqweq
      11: invokevirtual #6                  // Method insert:(Ljava/lang/Object;)V
      14: aload_1
      15: invokevirtual #7                  // Method get:()Ljava/lang/Object;
      
      
      
      18: checkcast     #8                  // class java/lang/String 自动加上强制类型转换,泛型节省了强制转换的代码
      21: astore_2
      22: return
}
```
Class.isInstance();
obj instanceOf Class
```java
class A{
    void ff(){
        System.out.println(ss instanceof String); // t 对象是否为这个类型或它的派生类
        System.out.println(String.class.isInstance(new String())); // t 对像是否可以转换成这个类型，可在泛型中使用
    }
}
```
6 create generics array
```java
public class GenericsArray <E> {
    Object[] elementDate;
   // E[] elementDate;
    public GenericsArray(int size) {
        this.elementDate = new Object[size];
    }
    public E get(int index){
        return (E)elementDate[index];
    }

    public void insert(E e,int index){
        this.elementDate[index] = e;
    }
    public static void main(String[] args) throws Exception{
        GenericsArray<Number> array = new GenericsArray(10);
        array.insert(1,0);
        array.getClass().getDeclaredMethod("insert",new Class[]{Object.class,int.class}).invoke(array,new Object[]{1,1});
        Number s = array.get(0);
        array.get(1);
        System.out.println(array.get(1)); // 相当于(Number)array.get(1); int 可以向上转型为Number
    }
}

```
<? extends T>
```java
public class Common {
    @Test
    public  void m() {
        Object[] objects = new String[10];
        Common common = new Common();
        objects[0] = new String();
        //编译通过，但是运行时产生java.lang.ArrayStoreException: java.lang.Object 异常，
        // 运行时，数组里存放的引用的实际类型为String，无法将一个Object向下转型为String
        objects[0] = new Object();
        List<? extends Number> list = new LinkedArray<Integer>(); // 编译器不知道list到底持有什么类型，所以不会接受任何类型的Number,禁止了使用了泛型作为参数类型的方法
        

    }
}
```
T 是上界，如果向容器里存放对象（T 以及 T的子类），
<? super T>
相比extends，编译器允许边界类型的对象作为参数传递给使用泛型作为参数类型的方法
## summary:
1. 泛型只是编译期的类型监测，在运行期都会变成Object或者边界。
2. 无法创建泛型数组，创建的数组其实是Object[];
3. 泛型擦除其实就是运行时泛型参数丢失，变成普通的类，未指定边界的泛型类，泛型参数将被擦除为Object
4. 当获取一个泛型的引用时，编译期在编译期间，会加入checkcast指令将其转型，也就是说不用手动编写强制类型转换的代码
5. 泛型不适应于原生类型（int,double..)


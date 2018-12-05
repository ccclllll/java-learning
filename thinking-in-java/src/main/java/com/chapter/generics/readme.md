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
A<String> a 和A<Integer> b 的class对象是等级的，都会被转换为A类型。
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

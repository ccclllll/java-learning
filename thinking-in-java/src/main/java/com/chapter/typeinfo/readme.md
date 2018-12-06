1. class object
    1. class load : class load into java virtual machine upon first use of the class.that happens 
    when the program make the first reference to a static member of  the class.
2. 泛化的Class引用
```java
class A{
    Class<? extends Number> aClass = double.class;
    Class<Number> numberClass = double.class; // error because Class<Double> not the subclass of Class<Number>
    Class<?> numberClass1 = double.class;
}
```
3. cast
```java
class A{
       public void testCast(){
           A a = new B();
           Class<B> bType = B.class; // 使用Class对象的cast方法
           B b = bType.cast(a); 
           B bb = new B();
           A aa = A.class.cast(bb);
       } 
}
```
向下转型时，不允许转型到实际不是待转类型的子类的类型上，即：
```java
class Father{
    
}
class Son extends Father{
    
}
class A{
    public void cast(){
        Number integer = new Integer(10);
        
        Double d = (Double)integer; // error
        
        Father father = new Father();
        Son son = (Son) father;//error
        
    }
}
```
4. 反射可以访问私有成员变量
5. 动态代理
```java
public interface Buyer {
    void talk(String word);
}

public class DynamicProxyDemo {
    public static void main(String[] args) {

        Buyer buyerProxy = (Buyer) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Buyer.class}, new InvocationHandler() {
            Object proxied = (Buyer) word -> System.out.println("buyer says:"+word);
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(proxied,args);
            }
        });
        buyerProxy.talk("hhhhhhh");
    }

}
```

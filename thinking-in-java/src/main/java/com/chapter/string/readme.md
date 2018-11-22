## String 字符串
1. 字符串是常量
```java
String s = "123";
s = "234"; // s = new String("234");
```
```java
public class StringTest {
    public static void main(String[] args) {
        String s = "123";
        String s1 = "123"; // 当"123"存在时，则s1指向已存在的String对象，不存在时，则会new一个对象
        String s2 = new String("123");  // 之间new 一个String对象
        System.out.println(s==s1); // true  s和s1所引用的对象是一样的
        System.out.println(s.equals(s1)); // true
        System.out.println(s==s2); // false
        System.out.println(s.endsWith(s2)); // true
    }
}
```
an argument usually looks like a piece of information provided to the method, not
something to be modified. 
2. + and StringBuilder
String的+操作符是通过StringBuilder实现的，但是每使用一次+，就会生成一个新的StringBuilder对象，可以自己使用一个StringBuilder对象完成+的功能。

2. 可能会出现递归的情况
```java
class A{
    
    public String toString(){
        return this; // 会发生递归
        return super.toString(); // 返回地址，明确调用父类的toString()
    }
}
```
3. 

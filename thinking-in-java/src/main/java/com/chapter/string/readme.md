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
3. Regular Expressions  正则表达式

    1.边界匹配符：^(一行的开始) $(一行的结束) \b \B \G

    2. 量词 X?(一个或者零个) X*(零个或者多个) X+(一个或者多个) X{n}(恰好) X{n,}(至少n) X{n,m}(n到m个)
    
    3. \s(空白符) \S \d(数字) \D \w(字符) \W(非字符) \[abc](即a|b|c) \[^abc](除abc之外) [a-Z[hij]] (求交集，任意hij)
    4. \n \t \r(回车) \f(换页) \e(转义)
4. String < StringBuffer(线程安全，使用了同步) <StringBuilder (线程不安全，执行速度最快)
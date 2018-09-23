controlling execution(流程控制)
1. java not allow use a number as a boolean type.

2. 知识点
```java
    public static void main(String[] args) {
/*        for (char c = 128; c >0; c--) {
           *//* if (Character.isLowerCase(c))
                System.out.println("value:" + (int) c + "character:" + c);*//*
            System.out.println("value:" + (int) c + "character:" + c);
        }*/
        Character c = 0;

        System.out.println("value:" + (int) --c + "character:" + --c); // value:65535character:￾
    }
}
```
计算机中是按照补码存储数值的。  char 不支持负数，当 c = -1 时， -1源码 为 1000 0000 0000 00001  最高位表示符号， 转为 反码 1111 1111 1111 1110   
(除符号位之外按位取反)，补码为 1111 1111 1111 1111 (在补码基础上+1)。c实际值为-1的补码，输出转化为int之后输出结果为65535。
正数符号位以0表示，正数的反码补码与其原码值相同。

3. comma operator (for 的逗号操作符) ,可以在初始化和一次迭代完成之后的语句部分用逗号分隔多个语句，这些语句会被顺序执行。
```java
    public void testCommaOperator(){
        for(int i=0, j=10;i<j;i++,j--){
            System.out.println("i is "+ i+",j is "+j);
        }
    }
```
You cannot use this approach with any of the otherselection or iteration statements.
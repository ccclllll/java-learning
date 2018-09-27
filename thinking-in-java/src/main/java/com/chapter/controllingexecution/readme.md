### controlling execution(流程控制)
#### 1. java not allow use a number as a boolean type.

#### 2. 数据的存储
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

### 3. comma operator (for 的逗号操作符) 
可以在初始化和一次迭代完成之后的语句部分用逗号分隔多个语句，这些语句会被顺序执行。
```java
    public void testCommaOperator(){
        for(int i=0, j=10;i<j;i++,j--){
            System.out.println("i is "+ i+",j is "+j);
        }
    }
```
You cannot use this approach with any of the otherselection or iteration statements.
#### 4. 关于continue和break
```java
    public void testContinueAndBreak(){

        for(char c: "Hello World".toCharArray()){
            if(c == new Character('r')){
                break;
            }
            System.out.print(c); // Hellowo
        }

        for(char c: "Hello World".toCharArray()){
            if(c == new Character('r')){
                continue;
            }
            System.out.print(c);// hello wold
        }
    }
```
break 会直接结束循环，而continue则是结束当前迭代，进入下一次迭代

#### 5. label 的用法
```java

label:
        for (char c : "Hello World".toCharArray()) {
            if (c == new Character('r')) {
                break label;
            }
            System.out.print(c);
            for (char b : "Hello World".toCharArray()) {
                if (b == new Character('r')) {
                    continue label;
                }
                System.out.print(b);
            }
        }
```
 //  
 continue label 相当于结束当前迭代，并从label出开始进入下一侧迭代。结果是：HHello WoeHello WolHello WolHello WooHello Wo Hello WoWHello WooHello Wo
 如果没有label，则是结束内层循环的当前迭代，进入内层循环的下一层迭代 执行结果会是：HHello WoldeHello WoldlHello WoldlHello WoldoHello Wold Hello WoldWHello WoldoHello Wold
 
 
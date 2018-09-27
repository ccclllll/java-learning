### 操作符
1. 自动递增和递减
    * 前缀递增 先运算 后生成值
    * 后缀递增 先生成值 后运算
    ```java
            int i = 1;
            int j= 1;
            System.out.println("i++ is  " + i++); // 先拿到值 输出1
            System.out.println("++j is " + ++j); // 先执行运算 后拿到值 输出2
    ```
    
2. 直接常量
    ```java
        float f1 = 1F;
        long l1 = 1L;
        int c = 0xffff; // 0x表示十六进制
        System.out.println(f1+":"+l1+":"+c);
        输出：1.0:1:65535
   ```
3. 按位操作符
    ```java
        int i1 = 1;
        int i2 = 0;
        System.out.println(1&0); // 按位与 0
        System.out.println(1^0);// 按为或 1
        System.out.println(1|0);// 异或 1
        i1&=i2; // i1=i1&i2
        System.out.println(i1); // 0
    ```
4. 类型转换
    ```java
        double d2 = 12.53433453536; // 有效数字16位
        float f2 = (float) d2; // 有效数字7位 包括小数点在内
        int i3 = (int) d2;
        System.out.println(i3); // 12 精度流失
        System.out.println(f2); // 12.534334
    ```
5. 类型提升
    运算时以数据大的类型为准。
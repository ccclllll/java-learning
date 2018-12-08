### 数组
1. 数组标识符是一个引用，指向一个数组对象，除基本类型的数组以外，数组对象保存的是指向其它对象的引用，数组的length表示数组的长度，而不是实际保存  
元素的个数，当数组被创建时，其保存的引用被自动初始化为null。如果时基本类型，数值型-》0，char -》 char(o),boolean -》 false。
2. 多维数组
其实就是一维数组，而一维数组的每个元素又指向一个数组。
```java
public class ArrayTest {
    @Test
    public void testMultiArray() {
        String[] ss = new String[10]; // 初始化方式1
        String[] sss = {"1213","2323"}; // 初始化方式2
        
        String[][] strings = {{"212","211"},{}};
        String[][][] strings1 = {{{"1","2"},{"123","12312"}},{}};
        String[][][][] strings2 = {{{{"0000","0001"},{"0010","0011"}},{{},{}}},{}};
        System.out.println(strings2[0][0][0][0]); // 0000  
    }
}
```
3. 排序
Arrays.sort(Array array) // 需要素组中的元素实现了Comparable接口

4. 查找 Arrays.binarySearch(ints,5) (要先对数组排序)

 5. 复制 System.arraycopy(strings,0,strings1,0,strings.length); // 复制 源数组，源数组复制偏移，目标数组，目标数组偏移，复制的个数
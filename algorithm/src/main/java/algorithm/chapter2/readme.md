### chapter2
1. 插入排序算法
```java
class A{
        public static int[] insertSort(int[] nums){
            if(nums.length<=1)
                return nums;
            for(int i =1;i<nums.length;i++){ // 每一次循环，都将i以及i之前的数按照从小到大的顺序排列
                int key = nums[i];
                int j = i-1;
                while(i>=0&&nums[j]>key){
                    nums[j+1] = nums[j];
                    j= j-1;
                }
    
                nums[j+1] = key;
            }
            return nums;
        }
}

```
2.斐波那契数列  
求第n项
```java
public class FeiBoNaQie {
    public static int  getN(int n){ // 递归法
        if(n == 1 || n==2)
            return 1;
        return getN(n-1)+getN(n-2);
    }
    
    public static int getN2(int n){ // 非递归
        if(n == 1 || n==2)
            return 1;
        int pre = 1;
        int next = 1;
        int index = 3;
        while(index++<=n){
            int mid = next;
            next = next+pre;
            pre= mid;
            
        }
        return next;
    }
}
```
    
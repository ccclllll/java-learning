package algorithm.chapter2;

public class Chapter2 {
    public static int[] insertSort(int[] nums){
        if(nums.length<=1)
            return nums;
        for(int i =1;i<nums.length;i++){
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

    public static void main(String[] args) {
        int[] nums = {1,5,2,4,6,10,7,8};
        int[] ret =insertSort(nums);
        for(int i = 0;i<ret.length;i++){
            System.out.println(ret[i]);
        }
    }
}

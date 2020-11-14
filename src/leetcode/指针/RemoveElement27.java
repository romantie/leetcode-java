package leetcode.指针;

/**
 * 原地移除数组中的元素
 */
public class RemoveElement27 {
    public static int removeElement(int[] nums, int val){
        int i=0;
        int j = nums.length;
        while (i<j){
            if (nums[i] == val){
                nums[i] = nums[j-1];
                j--;
            }else{
                i++;
            }

        }

        return j;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println();
        System.out.println(i);

    }
}

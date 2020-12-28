package leetcode.贪心;

/**
 * 寻找最下的下一个排列，贪心法
 *两遍扫描，从后面往前面扫描，先找出一个比升序时减小的数字，之后在从后面扫描，
 * 找出一个比自己小的最大数，然后将其交换，最后将此数字后面的呃数字交换
 */
public class 下一个排列31 {
    public void nextPermutation(int[] nums){
        int i = nums.length - 2;
        //第一遍扫描找出一个升序时下降的数字，
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        //在从后往前扫描找出一个比自己小的最大数，将其交换
        if (i >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        //将此数字之后的序列反转，即变为降序序列
        revrese(nums,i+1);
    }

    private void revrese(int[] nums, int start) {
        int left = start,right = nums.length - 1;
        while (left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

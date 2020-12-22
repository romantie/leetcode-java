package leetcode.Array;

public class 旋转升序数组中查找目标值33 {
    public static int search(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if (nums[mid] == target){
                return mid;
            }
            //根据nums[0]和target的关系判断目标值在做半段还是右半端
            if (target >= nums[0]){
                if (nums[mid] < nums[0]){
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                if (nums[mid] >= nums[0]){
                  nums[mid] = Integer.MIN_VALUE;
              }
            }
            if (nums[mid] < target){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;
        int search = search(nums, target);
        System.out.println(search);
    }
}

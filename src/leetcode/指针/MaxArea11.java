package leetcode.指针;

/**
 * 水容器的的最大空间，使用双指针解法，
 */
public class MaxArea11 {
    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while(left < right){
            int area = Math.min(height[left],height[right])*(right-left);
            ans = Math.max(ans,area);
            if (height[left]<height[right]){
                ++left;
            }else{
                --right;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7,};
        int i = maxArea(height);
        System.out.println(i);
    }

}

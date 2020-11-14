package leetcode.二分;

/**
 * 对应74题
 * 给定一个二维数组，给出一个目标值，判断是否在二维数组中
 */
public class SearchMatrix74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

    public static boolean search(int [][] matrix,int target){
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;

        //将二维数组转化为一维数组惊进行计算，
        int left=0;
        int right = m*n-1;
        int pivotIdx ,pivotElement;
        while(left<=right){
            pivotIdx = (left+right)/2;
            pivotElement = matrix[pivotIdx/n][pivotIdx%n];
            if (pivotElement==target){
                return true;
            }
            if ((pivotElement<target)){
                left = pivotIdx+1;
            }else{
                right = pivotIdx-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int r = matrix.length;
        int target = 3;
        boolean result = search(matrix,target);
        System.out.println(result);

    }
}

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

    /**
     * 这是另一种二维，行和列都是升序，与第一种不同之处是第一种的下面一行第一个大于上一行的最后一个数字
     * 采用对角线的方法，从右上遍历至左下
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {
        int rows = array.length;
        if(rows==0) return false;
        int cols = array[0].length;
        if(cols==0) return false;
        //从右上找
        int row = 0;
        int col = cols-1;
        while(row<rows && col>=0){
            if(array[row][col] <target){
                row++;
            }else if(array[row][col]>target){
                col--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int r = matrix.length;
        int target = 7;
        //boolean result = search(matrix,target);
        boolean res2 = Find(target,matrix);
        //System.out.println(result);
       System.out.println(res2);

    }
}

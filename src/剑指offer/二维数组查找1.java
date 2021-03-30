package 剑指offer;

import java.lang.reflect.Array;

/**
 * 给定一个二维数组，
 *   [1,2,8,9],
 *   [2,4,9,12],
 *   [4,7,10,13],
 *   [6,8,11,15]，在其中进行查找，
 *   采用二分的方法，斜对角查询
 */
public class 二维数组查找1 {
    public static int Find(int target, int[][] array){
        int rows = array.length;
        if (rows == 0) return 0;
        int cols = array[0].length;
        if (cols == 0) return 0;

        //从右上往下开始找
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0){
            if (array[row][col] < target) {
                row++;
            }else if (array[row][col] > target){
                col--;
            }else {
                return array[row][col];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        int target = 9;
        int find = Find(target, array);
        System.out.println(find);

    }

}

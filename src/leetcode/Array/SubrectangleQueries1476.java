package leetcode.Array;

/**
 * 2020/11/23
 * 子矩形查询
 */
public class SubrectangleQueries1476 {
    private int [][] list = null;
    public SubrectangleQueries1476(int[][] rectangle) {
        //int [][] list = {{2,5,2,3,1},{2,5,2,3,1},{2,5,2,3,1},{2,5,2,3,1},{2,5,2,3,1}};
        this.list = rectangle;

    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        //int [][] list = new SubrectangleQueries1476;
        if (list != null){
            for (int i=row1;i<=row2;i++){
                for (int j =col1;j<=col2;j++){
                    list[i][j] = newValue;
                }
            }
        }


    }

    public int getValue(int row, int col) {
        //int[][] list = new SubrectangleQueries1476;
        if (list!=null){
            return list[row][col];
        }
        return -1;
    }
}

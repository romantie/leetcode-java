package 剑指offer;


//需要考虑大数越界的问题,使用全排列的放啊
public class 打印从1到n位的数字 {
    StringBuilder res;
    int count = 0,n;
    char[] num ,loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumber(int n){
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    void dfs(int x){
        if (x == n) {
            res.append(String.valueOf(num) + ",");
            return ;
        }
        for (char i : loop){
            //固定第x位位i
            num[x] = i;
            //开启固定第x+1位
            dfs(x + 1);
        }
    }

}

package 剑指offer;

/**
 * 使用位运算，与运算定义，
 * 若 n & 1 = 0 ，则 nn 二进制 最右一位 为 00 ；
 * 若 n & 1 = 1 ，则 nn 二进制 最右一位 为 11 。
 */
public class 二进制中1的个数 {

    public static int hammingWeight(int n){
        int res = 0;
        while(n != 0){
            res += n & 1;
            //将二进制数字n无符号右移一位 ，java中右移符号位>>>
            n >>>= 1;
        }
        return res;
    }
}

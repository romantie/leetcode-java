package leetcode.排序;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Insertion {
    public static void sort(Comparable[] a){
        for (int i=1;i<a.length;i++){
            for (int j=i;j>0;j--){
                //比较j处和索引处的值
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }
                else{
                    break;
                }
            }
        }
    }

    public static void sorted(Comparable[] a){
        for (int i=1; i < a.length; i++){
            for (int j = i; j > 0; j--){
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else{
                    break;
                }
            }
        }
    }

    //比较大小
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //交换
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        Integer[] a = {5,1,3,45,6,8,1,26,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

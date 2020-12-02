package leetcode.排序;

import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;

/**
 * 2020/11/30
 * 快速排序
 */
public class Quick {
    public static void sort(Comparable[] a){
        int lo =0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }

    public static void sort(Comparable[] a,int lo,int hi){
        //校验
        if (hi <= lo){
            return ;
        }
        //需要对数组lo到hi的元素进行分组,
        //partation 返回的是分组后分界值所在的索引
        int partation= partation(a,lo,hi);
        //让左子组有序
        sort(a,lo,partation-1);
        //让右自组有序
        sort(a,partation+1,hi);

    }

    public static int partation(Comparable[] a,int lo,int hi){
        //确定分界值，一般定为第一个元素
        Comparable key = a[lo];
        //定义两个指针指向最小的下表和最大索引的下一个位置'
        int left =lo;
        int right = hi+1;
        //切分
        while (true){
            //先从右往左扫描，然后从右往左扫描
            while (less(key,a[--right])){
                if (right==lo)
                    break;
            }

            while (less(a[++left],key)){
                if (left==hi)
                    break;
            }
            //判断left>=right，如果是则扫描完毕，不是则交换元素
            if (left>=right){
                break;
            }else{
                exch(a,left,right);
            }
        }
        //最后交换分界值
        exch(a,lo,right);
        return right;
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] a= {22,5,4,52,5,1,2,54,26,64} ;
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

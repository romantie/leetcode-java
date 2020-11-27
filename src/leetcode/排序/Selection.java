package leetcode.排序;

import javax.swing.event.InternalFrameEvent;
import java.util.Arrays;

/**
 * 2020/11/27
 * 选择排序
 */
public class Selection {
    //排序
    public static void sort(Comparable[] a){
        for (int i=0;i<a.length-2;i++){
            //定义一个变量记录最小值
            int minIndex = i;
            for (int j =i+1;j<a.length;j++){
                //比较最小索引出和j处的值
                if (greater(a[minIndex],a[j]))
                    minIndex = j;
            }
            //交换
            exch(a,i,minIndex);
        }

    }

    //比较元素大小
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //交换元素
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] a = {58,3,4,9,25,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

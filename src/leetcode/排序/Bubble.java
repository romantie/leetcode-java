package leetcode.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 冒泡排序
 */
public class Bubble {
    //排序
    public static void sort(Comparable[] a){
        for (int i=a.length-1;i>0;i--)
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1]))
                    exch(a, j, j + 1);
            }
    }

    //比较元素大小
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }
    //交换元素的位置
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] a={5,3,4,2,6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

package leetcode.排序;

import java.util.Arrays;

/**
 * 希尔排序，对插入排序的优化
 */
public class Shell {
    public static void sort(Comparable[] a){
        //根据a的长度，确定h增长量的初始值
        int h=1;
        while (h<a.length){
            h=2*h+1;
        }
        //希尔排序
        while (h>=1){
            //排序
            //找到待插入的数据
            for (int i=h;i<a.length;i++){
                //将待插入的数据插入到有序数列中
                //j为待插入的值，j-h的值为每次和待插数据比较的值，j-h和待插入的数据的值间隔为h
                for (int j=i;j>=h;j-=h){
                    if (greater(a[j-h],a[j]))
                        exch(a,j-h,j);
                    else
                        break;
                }
            }
            //减小h值
            h=h/2;
        }
    }

    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] a={3,5,4,1,2,8,4,9,5};
        sort(a);
        System.out.println(Arrays.toString(a));

    }
}

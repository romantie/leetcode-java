package leetcode.排序;

import java.util.Arrays;

/**
 * 2020/11/30
 * 归并排序，
 */
public class Merge {
    private static Comparable[] assist;
    public  static void sort(Comparable[] a){
        //初始化一个辅助数组，assist
        //定义lo和hi变量，分别记录数组中的最大和最小的索引
        //调用sort重载方法完成排序
        assist = new Comparable[a.length];
        int lo=0;
        int hi = a.length - 1;
        sort(a,lo,hi);
    }

    private static void sort(Comparable[] a,int lo ,int hi){
        if (hi <= lo) return;
        //对lo和hi中间的数据进行分组
        int mid = lo + (hi-lo)/2;
        //分别递归排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //将两个组中的数据归并
        merge(a,lo,mid,hi);
    }

    private static void merge(Comparable[] a,int lo,int mid,int hi){
        //定义三个指针，
        int i = lo;
        int p1 = lo;
        int p2 = mid+1;
        //遍历指针，最后没有走完的全部合并到后面
        while (p1 <= mid && p2<=hi){
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }
        while (p1<=mid) assist[i++]=a[p1++];
        while (p2<=hi) assist[i++]=a[p2++];
        //将辅助数组中的元素放到原数组中
        for (int index=lo;index<=hi;index++){
            a[index] = assist[index];
        }

    }
    //返回v元素比w元素小
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    //交换两个元素
    private static  void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a={21,3,8,5,5,45,8,5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

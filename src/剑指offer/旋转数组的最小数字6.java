package 剑指offer;

public class 旋转数组的最小数字6 {
    public int minNum(int [] array){
        int low = 0,high = array.length - 1;
        while(low < high){
            if (array[low] < array[high]){
                return array[low];
            }

            int mid = (low + high)/2;
            if (array[mid] > array[low]) {
                low = mid + 1;
            }else if (array[mid] < array[high]){
                high = mid;
            }else{
                low++;
            }
        }
        return array[low];
    }
}

package leetcode.字符串;

/**
 * 2020/11/30
 * 重构字符串，每日一题767
 * 基于计数的贪心算法，第一次写贪心算法的题
 */
public class ReorganizeString767 {
    public static String reorganizeString(String S){
        if (S.length() < 2) return S;
        int [] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        //统计字符的个数
        for (int i = 0 ; i < length ; i++){
            char c = S.charAt(i);
            counts[c-'a']++;
            maxCount = Math.max(maxCount,counts[c-'a']);
        }
        if (maxCount > (length+1 )/ 2)
            return "";
//        char[] reorangizeArray = new char[length];
//        int evenIndex = 0,oddIndex = 1;
//        int halfLength = length / 2;
//        for (int i = 0; i<26; i++){
//            char c = (char)('a'+i);
//            //数量小于字符串长度一般的字符存到奇数下标的数组中
//            while (counts[i] > 0 && counts[i] < halfLength && oddIndex < length){
//                reorangizeArray[oddIndex] = c;
//                counts[i]--;
//                oddIndex += 2;
//            }
//            //将剩余的，字符数量超过啦字符串长度一半的存放到数组的偶数下标
//            while (counts[i] > 0){
//                reorangizeArray[evenIndex] = c;
//                counts[i]--;
//                evenIndex += 2;
//            }
//
//        }
//        return new String(reorangizeArray);
        StringBuffer array = new StringBuffer();
        while (array.length() < length){
            for (int i = 0 ; i<26;i++){
                if (counts[i]>0){
                    array.append((char)('a'+i));
                    counts[i]--;
                }
            }
        }
        return array.toString();



    }
}

package 剑指offer;

/**
 * 将字符串的前面几个字符转移到字符串的尾部
 */
public class 左旋转字符串 {
    //字符串切片
    public static String reverWord(String s,int n){
        return s.substring(n,s.length() )+ s.substring(0,n);
    }

    //列表遍历切片
    public static String reWord(String s, int n ){
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++){
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    //字符串遍历拼接
    public static String resWord(String s, int n){
        String res = "";
        for (int i = n; i< s.length(); i++){
            res += s.charAt(i);
        }
        for (int i = 0; i < n; i++){
            res+=s.charAt(i);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "asdfdg";
        int n = 3;
        String s1 = resWord(s, n);
        System.out.println(s1);
    }
}

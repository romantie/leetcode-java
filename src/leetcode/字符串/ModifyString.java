package leetcode.字符串;

import java.util.Arrays;

/**
 * 2020/11/27
 * 替换所有的问号，字符串操作
 */
public class ModifyString {
    public static String modifyString(String s) {
        char [] ch = s.toCharArray();
        for (int i=0;i<ch.length;i++){
            if (ch[i] == '?'){
                char ahead = i ==0 ? ' ':ch[i-1];
                char hehind = i==s.length()-1? ' ': ch[i+1];
                //从a开始比较，如果等于前面或者后面的话就加1
                char temp='a';
                while(temp==ahead || temp==hehind){
                    temp++;
                }
                //String newString =s.replace(ch,temp);
                // 经过测试不能用replace方法，因为此方法不是在原数组上修改，而是返回一个新得字符串
                ch[i] = temp;
            }
        }

        return new String(ch);
    }
    public static void main(String[] args) {
        String string = "?zs";
        String s = modifyString(string);
        System.out.println(s);

    }
}

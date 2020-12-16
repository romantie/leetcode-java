package leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020/12/10括号的生成，给点一个数字n，代表括号的数量,生成所有非合法括号
 * 使用回溯的方法，并且将结果保存数组
 */
public class 括号生成22 {


    ArrayList[] cache = new ArrayList[100];
    public List<String> generate(int n){
        if (cache[n] != null){
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0){
            ans.add("");
        }else{
            for (int c=0;c<n;++c){
                for (String left:generate(c)){
                    for (String right:generate(n-1-c)){
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
    public List<String> generateParenthesis(int n){
        return generate(n);
    }
}

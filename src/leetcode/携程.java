package leetcode;

import javax.swing.*;

public class 携程 {
    static String uncompress(String cmpStr) {
        int len = cmpStr.length();
        int i =0,n =0;
        StringBuilder res = new StringBuilder();
        while(i < len){
            char c = cmpStr.charAt(i);
            if (c >= '0' && c <= '9'){
                n = n*10 + cmpStr.charAt(i) - '0';
            }else if (c >= 'a' && c <= 'z'){

                while (n > 1){
                    res.append(cmpStr.charAt(i));
                    n--;
                }
                res.append(c);
                n = 0;
            }
            i++;
        }
        return res.toString();
    }
    static String un(String cmpStr){
        int cnt = 0;
        char cur_char = ' ';
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < cmpStr.length(); i++){
            char t = cmpStr.charAt(i);
            if (t >= '0' && t <= '9'){
                cnt =10 * cnt + t - '0';
            }else{
                for (int j = 0; j<cnt; j++){
                    sb.append(cur_char);
                }
            }
            cnt = 0;
            cur_char = t;
        }

        for (int j = 0; j < cnt; j++){
            sb.append(cur_char);
        }
        return sb.toString();
    }

    public static void main(String[] args){

        String res = "a5b1c3";
        String uncompress = uncompress(res);
        System.out.println(uncompress);
        System.out.println();
    }
}

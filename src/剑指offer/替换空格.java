package 剑指offer;

public class 替换空格 {

    public static String replaceSpace(String s){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0;i < s.length(); i++){
            if (s.charAt(i) == ' '){
                stringBuffer.append("%20");
            }else{
                stringBuffer.append(s.charAt(i));
            }
        }

        return stringBuffer.toString();
    }

    public static String replaceSpa(String s){
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length ; i++){
            char c = s.charAt(i);
            if (c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public static void main(String[] args) {
        String s = "wo hapdp de";
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }
}

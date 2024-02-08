package ch10BackTracking.Segment;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {

    public static void main(String[] args) {


    }
    /*
    * 传不传start呢  关键是每个数字都要用到啊
    * 1 不行 10   数字要小于三位 第一位为0 后面不能有其他数字
    * */
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtrack(sb,0,0);
        return res;
    }

    private void backtrack(StringBuilder s,int start,int dotNum) {
        if(dotNum == 3){
            if(isValidPart(s,start,s.length())){
                res.add(s.toString());
            }
            return;
        }

        for (int i = start;i < s.length();i++){
            if(isValidPart(s,start,i + 1)){
                s.insert(i + 1,'.');
                backtrack(s,i + 2,dotNum + 1);
                s.deleteCharAt(i + 1);
            }else {
                break;
            }
        }
    }

    public boolean isValidPart(StringBuilder s, int start, int end){
        if(start > end) return false;
        if(s.charAt(start) == '0' && end - start > 1) return false;
        int num = 0;
        for (int i = start; i <end ; i++) {
            int digit = s.charAt(i) - '0';
            num = num * 10 +digit;
            if(num > 255) return false;
        }
        return true;
    }

    private boolean isValidIP(String string) {
        String[] s = string.split("\\.");
        if(s.length != 4){
            return false;
        }
        for (String s1:s){
            if(s1.isEmpty() || s1.length() > 3){
                return false;
            }
            if(Integer.parseInt(s1) > 255) return false;
            if(s1.charAt(0) == '0' && s1.length() != 1){
                return false;
            }
        }
        return true;
    }
}

package ch0Review.ch1Array;

public class P367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int left = 1,right = num;
        int mid;
        while (left <= right){
            mid = (right - left) / 2 + left;
            long res = (long) mid * mid;
            if(res == num){
                return true;
            }else if(num < res){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}

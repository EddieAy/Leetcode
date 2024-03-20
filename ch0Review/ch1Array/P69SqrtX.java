package ch0Review.ch1Array;

public class P69SqrtX {


    public int mySqrt(int x) {
        /*
        * 解决方法之一是将 num 的类型改为 long，以便能够存储更大的数值，避免溢出。同时，为了进一步保证算法的正确性和鲁棒性，
        * 最后返回的时候需要返回 right 而不是 left，
        * 因为在循环结束时，left 可能指向的是大于 x 的平方根的最小整数，而 right 指向的是小于或等于 x 的平方根的最大整数。
        * */
        if(x <= 1) return x;
        int left = 0,right = x;
        int mid;
        while (left <= right){
            mid = (right - left) / 2 + left;
            long num = (long)mid * mid;
            if(num == x){
                return mid;
            }else if(num < x){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }
}

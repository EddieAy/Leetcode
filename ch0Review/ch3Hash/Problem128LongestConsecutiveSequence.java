package ch0Review.ch3Hash;

import java.util.HashSet;
import java.util.Set;

public class Problem128LongestConsecutiveSequence {

    /*
    * 题目分析
对于数组中存在的连续序列，为了统计每个连续序列的长度，我们希望直接定位到每个连续序列的起点，从起点开始遍历每个连续序列，从而获得长度。



那么如何获取到每个连续序列的起点呢，或者说什么样的数才是一个连续序列的起点？
答案是这个数的前一个数不存在于数组中，因为我们需要能够快速判断当前数num的前一个数num - 1是否存在于数组中。

同时当我们定位到起点后，我们就要遍历这个连续序列，什么时候是终点呢？
答案是当前数num的后一个数nunm + 1不存在于数组中，因此我们需要能够快速判断当前数num的后一个数num + 1是否存在于数组中。

为了实现上述需求，我们使用哈希表来记录数组中的所有数，以实现对数值的快速查找
    * */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;

                while (set.contains(curNum + 1)) {
                    curLength++;
                    curNum++;
                }
                res = Math.max(res, curLength);
            }
        }
        return res;
    }
}

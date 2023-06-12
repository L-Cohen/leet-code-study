package org.example.day2;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 多数元素
 * @date 2023/6/11
 */
public class MajorityElement {


    public static int majorityElementByFor(int[] nums) {
        // count计数相同++，不同--
        // 投票法
        int result = nums[0];
        int count = 0;
        for (int num : nums) {
            if (result == num) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                count = 1;
                result = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,9,9,10};
        System.out.println(majorityElementByFor(nums));
    }
}

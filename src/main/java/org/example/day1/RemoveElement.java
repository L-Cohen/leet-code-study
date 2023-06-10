package org.example.day1;

import java.util.Arrays;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 移除元素
 * @date 2023/6/9-21:26
 */
public class RemoveElement {

    /**
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     */
    public static int removeElement(int[] nums, int val) {
        // 双指针：p1指针指向数组头，p2指针指向数组尾部
        int p1 = 0;
        int p2 = nums.length - 1;
        int count = 0;
        while (p1 <= p2) {
            if (nums[p2] == val) {
                p2--;
                count++;
                continue;
            }
            if (nums[p1] == val) {
                nums[p1] = nums[p2];
                nums[p2] = val;
                p2--;
                count++;
            }
            p1++;
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2};
        int i = removeElement(nums, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}

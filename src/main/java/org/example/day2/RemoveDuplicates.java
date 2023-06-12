package org.example.day2;

import java.util.Arrays;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @date 2023/6/11
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        // 慢指针-2和fast指针指向元素是否相等
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = removeDuplicates(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }
}

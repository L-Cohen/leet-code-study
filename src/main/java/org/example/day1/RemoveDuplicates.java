package org.example.day1;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 移除重复元素
 * @date 2023/6/9
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        // 移除重复元素，即将不重复元素移动到左边
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 1;
        while (p2 < nums.length) {
            if (nums[p1] != nums[p2]) {
                nums[p1 + 1] = nums[p2];
                p1++;
            }
            p2++;
        }
        return p1 + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }
}

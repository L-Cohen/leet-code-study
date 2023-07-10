package org.example.day3;

import java.util.Arrays;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @date 2023/6/13
 */
public class Rotate {
    public static void rotate1(int[] nums, int k) {
        // 解题关键：新建数组存放，因为移动k个位置可以，可以通过i+k(i+k - length < 0) 或者通过(i+k)%length,取余得到该元素下标
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            if (i + k - n >= 0) {
                res[(i + k) % n] = nums[i];
            } else {
                res[i + k] = nums[i];
            }
        }
        System.arraycopy(res, 0, nums, 0, n);
    }

    public static void rotate2(int[] nums, int k) {
        // 翻转法：1.将数组翻转，2.将0 -> k-1之间元素翻转，3.剩余元素翻转
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 环状替换 ?
     */
    public static void rotate3(int[] nums, int k) {

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}

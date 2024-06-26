package org.example.day1;

import java.util.Arrays;

/**
 * @author ryf
 * @version 1.0
 * @project leeCode-study
 * @description 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */

public class Merge {

    /**
     * 将数组nums2 放入尾部并进行排序
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //
        if (n <= 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 正向双指针
     */

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        int[] result = new int[m + n];
        while (p1 < m || p2 < n) {
            // nums1 指针达到边界插nums2
            if (p1 == m) {
                result[cur] = nums2[p2++];
            } else if (p2 == n) {
                // nums2 指针达到边界插nums1
                result[cur] = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                result[cur] = nums1[p1++];
            } else {
                result[cur] = nums2[p2++];
            }
            cur++;
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }


    /**
     * 逆向指针
     * 通过指针指向数组尾部可以不创建额外的数组空间
     * 谁大谁到尾部，需要注意数组下标越界的情况
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        // 两个指针任一到0后即可结束
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        merge2(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 双指针
     */
    public static void mergeReview1(int[] nums1, int m, int[] nums2, int n) {
    }
}

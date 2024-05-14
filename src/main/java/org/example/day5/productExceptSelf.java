package org.example.day5;

import java.util.Arrays;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 除自身以外数组的乘积
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @date 2024/5/14
 */
public class productExceptSelf {

    /**
     * 通过初始化两个数组得到结果，下标i的值等于左边的乘积乘的右边的乘积
     * left数组即下标为原数组某个下标左边的乘积
     * right数组即下标为原数组某个下标左边的乘积
     *
     * @param nums 给定数组
     * @return 结果数组
     */
    public static int[] solution(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }


    /**
     * 左侧乘积正向遍历得到原数组下标左侧部分的乘积，通过一个局部变量存储右侧部分乘积，因为右侧反向遍历，只需要在左侧数组部分相乘后，将对应下标重新相乘赋值
     *
     * @param nums 给定数组
     * @return 结果数组
     */
    public static int[] solution2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        int tmp = 1; // 临时存储右侧乘积

        for (int i = 1; i < length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        // 通过tmp存储右侧乘积反向遍历
        for (int i = length - 2; i >= 0; i--) {
            // 左侧部分乘积与右侧乘积临时变量相乘
            result[i] = result[i] * tmp;
            // 重新赋值右侧乘积
            tmp *= result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(solution));
    }
}

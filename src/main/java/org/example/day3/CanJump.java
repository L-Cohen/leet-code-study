package org.example.day3;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description <a href="https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * @date 2024/4/22
 */
public class CanJump {

    public static boolean solutionReachMax(int[] nums) {
        // 初始位置开始遍历，当下标值大于我的数组对应值说明我无法到达终点
        int reach = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solutionReachMax(new int[]{3,2,1,0,4}));
    }
}

package org.example.day4;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 跳跃游戏 II <a href="https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @date 2024/4/24
 */
public class Jump2 {

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * 每一步尽可能多走，整体就少走
     * 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！
     */
    public static int solution(int[] nums) {
        // 记录当前能跳跃到的位置的边界下标
        int border = 0;
        // 记录在边界范围内，能跳跃的最远位置的下标
        int maxPosition = 0;
        // 记录所用步数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 继续往下遍历，统计边界范围内，哪一格能跳得更远，每走一步就更新一次能跳跃的最远位置下标
            // 其实就是在统计下一步的最优情况
            maxPosition = Math.max(maxPosition, nums[i] + i);
            // 如果到达了边界，那么一定要跳了，下一跳的边界下标就是之前统计的最优情况maxPosition，并且步数加1
            if (i == border) {
                border = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,1,2,2,0,2};
        System.out.println(solution(nums));
    }
}

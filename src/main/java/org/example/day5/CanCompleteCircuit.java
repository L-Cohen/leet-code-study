package org.example.day5;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 134. 加油站 <a href="https://leetcode.cn/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @date 2024/5/17
 */
public class CanCompleteCircuit {

    /**
     * 首先只要gas数组和大于cost数组和必定有解
     * 然后从0开始遍历，如果当前gas大于等于cost，则可以作为起点，否则从下一个开始
     *
     * @param gas  油量数组
     * @param cost 耗费数组
     * @return 下标
     */
    public static int solutionByGreedy(int[] gas, int[] cost) {
        int start = -1;
        int gasSum = 0;
        int costSum = 0;
        int suffixSum = 0;

        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            suffixSum += gas[i] - cost[i];

            if (suffixSum < 0) {
                start = -1;
                suffixSum = 0;
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }

        return gasSum >= costSum ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println(solutionByGreedy(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}

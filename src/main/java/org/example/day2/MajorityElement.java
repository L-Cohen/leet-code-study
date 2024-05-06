package org.example.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
            if (count == 0) {
                count = 1;
                result = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElementByFor(nums));
    }

    /**
     *
     */
    public static int majorityElementByForVote(int[] nums) {
        int result = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                result = num;
            }
            vote += (result == num ? 1 : -1);
        }
        return result;
    }

    /**
     * 使用hash表
     */
    public static int majorityElementByForByHashTable(int[] nums) {
        HashMap<Integer, Integer> hashMap = getCountMap(nums);

        int result = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    private static HashMap<Integer, Integer> getCountMap(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.computeIfPresent(num, (key, value) -> value + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        return hashMap;
    }

    public static int majorityElementByForBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

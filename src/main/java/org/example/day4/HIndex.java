package org.example.day4;

import java.util.Arrays;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description <a href="https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @date 2024/4/25
 */
public class HIndex {

    public static int solutionBySort(int[] citations) {
        Arrays.sort(citations);
        int h = 0; // 初始引用次数为0
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) { // h系数可以理解为至少有h篇论文被引用h次，尾指针指向尾部，头指针指向数组头部，当尾部大于头部时，存在一篇引用次数大于等于h的论文h++
            h++;
            i--;
        }
        return h;
    }

    public static int solutionByBinarySearch(int[] citations) {
        int left = 0, right = citations.length;
        int mid = 0, cnt = 0;
        while (left < right) {
            // 右移一位等同于 mid = (left + right) / 2
            mid = (left + right + 1) >> 1;
            // 满足高引用的特点是：引用次数 >= 论文篇数
            // count 的含义是：大于等于 mid 的论文篇数
            int count = 0;
            for (int citation : citations) {
                if (citation >= mid) {
                    count++;
                }
            }
            if (count >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] citations = {1,3,1};
        System.out.println(solutionByBinarySearch(citations));
    }
}

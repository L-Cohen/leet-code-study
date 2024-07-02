package org.example.day6;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 最长公共前缀 <a href="https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @date 2024/7/2
 */
public class LongestCommonPrefix {

    public String solution(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = longestCommonPrefix(result, strs[i]);
        }
        return result;
    }

    private String longestCommonPrefix(String result, String str) {
        int minLength = Math.min(result.length(), str.length());
        int index = 0;
        for (int i = 0; i < minLength; i++) {
            if (result.charAt(i) == str.charAt(i)) {
                index++;
            } else {
                break;
            }
        }
        return result.substring(0, index);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] array = new String[]{"a"};
        System.out.println(longestCommonPrefix.solution(array));
    }
}

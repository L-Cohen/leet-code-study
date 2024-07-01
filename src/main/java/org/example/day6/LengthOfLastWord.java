package org.example.day6;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 最后一个单词的长度 <a href="https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * 给你一个字符串 s，由若干个单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * @date 2024/7/1
 */
public class LengthOfLastWord {

    public int solution(String s) {
        if (s.length() == 1 && s.charAt(0) == ' ') {
            return 0;
        }
        int result = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                count++;
                if (count > 0) {
                    result = count;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }

    /**
     * 倒序遍历，取出第一个非空串的下标进行遍历计数
     * @param s
     * @return
     */
    public int reverseForeach(String s) {
        if (s.length() == 1 && s.charAt(0) == ' ') {
            return 0;
        }
        // 从非空格字符的下标开始遍历
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        // 计算最后一个单词的长度
        int result = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            result++;
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.solution("s"));
    }
}

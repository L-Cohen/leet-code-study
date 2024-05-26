package org.example.day5;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 罗马数字转整数 <a href="https://leetcode.cn/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @date 2024/5/26
 */
public class RomanToInt {

    public static int solution(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = getRomanInt(s.charAt(i));
            if (i < s.length() - 1 && value < getRomanInt(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

    private static int getRomanInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("MCMXCIV"));
    }
}

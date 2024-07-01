package org.example.day6;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 整数转罗马数字 <a href="https://leetcode.cn/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @date 2024/6/4
 */
public class IntToRoman {

    /**
     * 数字转为罗马字符
     * 1 ~ 3999
     *
     * @param num 数值
     * @return 罗马字符
     */
    public String solution(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }


    public String solution2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                sb.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToRoman roman = new IntToRoman();
        System.out.println(roman.solution(3911));
        System.out.println(roman.solution2(3911));
    }
}

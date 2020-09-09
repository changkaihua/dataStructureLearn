package com.joe.beginzero.strings.highprecisioncalculation;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * 43. Multiply Strings
 *
 * @author ckh
 * @create 9/9/20 8:56 AM
 */
public class MultiplyStrings {

    /**
     * 简化竖式计算
     * https://leetcode-cn.com/problems/multiply-strings/solution/gao-pin-mian-shi-xi-lie-zi-fu-chuan-cheng-fa-by-la/
     */
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        // 结果最多为 m + n 位数
        int[] res = new int[m + n];
        // 从个位数开始逐位相乘
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 乘积在 res 对应的索引位置
                int p1 = i + j, p2 = i + j + 1;
                // 叠加到 res 上
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        // 结果前缀可能存的 0（未使用的位）
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        // 将计算结果转化成字符串
        StringBuilder str = new StringBuilder();
        for (; i < res.length; i++) {
            str.append(res[i]);
        }

        return str.length() == 0 ? "0" : str.toString();
    }

    public static void main(String[] args) {

        System.out.println(multiply("101", "100"));
    }
}

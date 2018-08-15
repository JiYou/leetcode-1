package com.leetcode.String;

public class StringCommon {
    private static String countAndSay(String string) {
        char[] str = string.toCharArray();
        String s = "";
        int p = 1;
        int count = 1;
        char last = str[0];
        for (; p < str.length; p++) {
            if (str[p] == last)
                count++;
            else {
                s += "" + count + last;
                count = 1;
                last = str[p];
            }
        }
        s += count + last;
        return s;
    }

    public static String countAndSay(int n) {
        String init = "1";
        for (int i = 1; i < n; i++)
            init = countAndSay(init);
        return init;
    }


}

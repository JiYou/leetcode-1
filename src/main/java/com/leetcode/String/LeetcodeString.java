package com.leetcode.String;

import java.util.HashMap;
import java.util.Stack;

public class LeetcodeString {
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

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (map.keySet().contains(c))
                stack.push(c);
            else if (map.values().contains(c)) {
                if (!stack.empty() && map.get(stack.peek()) == c)
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.empty();
    }

    public static boolean isPalindrome(String s) {
        
    }


}

package com.leetcode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
        if (s.length() <= 1)
            return true;
        char[] chars = s.toLowerCase().toCharArray();
        for (int st = 0, ed = chars.length - 1; st <= ed; st++, ed--) {
            while(st < ed && !isValidChar(s, st))
                st++;
            while (st < ed && !isValidChar(s, ed))
                ed--;
            if(chars[st] != chars[ed])
                return false;
        }
        return true;
    }

    private static boolean isValidChar(String s,int i) {
        char c = s.charAt(i);
        return (c >= '0' && c <= '9') ||(c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static String simplifyPath(String path) {
        if (path == null)
            return null;
        String[] list = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.length; i++) {
            String token = list[i];
            if (list[i].equals(".") || list[i].length() == 0)
                continue;
            else if (!list[i].equals(".."))
                stack.push(list[i]);
            else {
                if (!stack.isEmpty())
                    stack.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        Stack<String> tmp = new Stack<>();
        while (!stack.isEmpty())
            tmp.push(stack.pop());
        while (!tmp.isEmpty())
            sb.append("/" + tmp.pop());
        if (sb.length() == 0)
            sb.append("/");
        return sb.toString();
    }

    public String reverseWords(String s) {
        return null;
    }

    private void reverseWord(char[] arr) {
        int i = 0, j = 0, n = arr.length;
        while (j < n) {
            while (i < n && arr[i] == ' ')
                i++;


        }
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public int longestSubStringWithoutRepeatingCharacters(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int max = -1;
        int begin = 0, end = 0;
        while(end < s.length()) {
            if (set.contains(s.charAt(end))) {
                max = (end - begin) < max ?  max:(end - begin);
                while (s.charAt(begin) != s.charAt(end)) {
                    set.remove(s.charAt(begin));
                    begin++;
                }
                begin++;
            } else {
                set.add(s.charAt(end));
            }
            end++;
        }
        max = Math.max(max, end - begin);
        return max;
    }

    public int longestSubStringWithAtMostTwoDistinctCharacters(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int max = -1;
        int begin = 0, end = 0;
        int occur = 0;
        while(end < s.length()) {
            if (set.contains(s.charAt(end))) {
                max = (end - begin) < max ?  max:(end - begin);
                while (s.charAt(begin) != s.charAt(end)) {
                    set.remove(s.charAt(begin));
                    begin++;
                }
                begin++;
            } else {
                set.add(s.charAt(end));
            }
            end++;
        }
        max = Math.max(max, end - begin);
        return max;
    }

    public String miniWindowSubString(String s, String t) {
        if(s == null || t == null || s.length() < t.length())
            return "";
        int[] cnt = new int[128];
        for (char c : t.toCharArray())
            cnt[c]++;
        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--;
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) total++;
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }





}

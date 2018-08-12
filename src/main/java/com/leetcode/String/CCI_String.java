package com.leetcode.String;

import java.util.Arrays;

public class CCI_String {
    public static boolean isUnique(String s) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);
            if (char_set[value])
                return false;
            char_set[value] = true;
        }
        return true;
    }

    public String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public boolean permutation1(String s, String t) {
        if (s.length() != t.length())
            return false;
        return sort(s).equals(sort(t));
    }

    public boolean permutation(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] letters = new int[256];
        for (int i = 0; i < s.length(); i++)
            letters[s.charAt(i)]++;
        for (int i = 0; i < t.length(); i++) {
           if (--letters[t.charAt(i)] < 0)
               return false;
        }
        return true;
    }

    public void replaceSpace(char[] str, int length) {
        int space = 0;
        for (int i = 0; i < str.length; i++)
            if (str[i] == ' ')
                space++;
        int size = str.length + 2 * space;
        str[size] = '\0';
        for (int i = length - 1; i > 0; i--) {
            if (str[i] == ' ') {
                str[size - 1] = '0';
                str[size - 2] = '2';
                str[size - 3] = '%';
                size -=3;
            }
            str[size - 1] = str[i];
            size--;
        }
    }

    public static String compressString1(String str) {
        StringBuffer sb = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last)
                count++;
            else {
                sb.append(last).append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        sb.append(last).append(count);
        return sb.toString();
    }






}

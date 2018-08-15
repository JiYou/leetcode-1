package com.leetcode.arrays;

public class ArrayCommon {
    public long Fibonacci(long n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long fn1 = 1;
        long fn2 = 0;
        long fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
        }
        return fn;
    }
}

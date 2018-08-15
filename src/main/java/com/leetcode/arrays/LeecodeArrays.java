package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeecodeArrays {
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        int[][] dp = new int[m][n];
        for (int y = 0; y < n; y++)
            dp[0][y] = 1;
        for (int x = 0; x < m; x++)
            dp[x][0] = 1;
        for (int x = 1; x < m; x++)
            for (int y = 1; y < n; y++) {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
            }
        return dp[m - 1][n - 1];
    }

    public static int uniquePath2(int[][] arr) {
        if (arr == null || arr[0] == null)
            return 0;
        if (arr[0][0] == 1)
            return 0;
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        for (int y = 1; y < n; y++) {
            if (arr[0][y] == 0)
                dp[0][y] = 1;
            else
                break;
        }

        for(int x = 0; x < m; x++) {
            if (arr[x][0] == 0)
                dp[x][0] = 1;
            else
                break;
        }

        for (int y = 1; y < n; y++)
            for (int x = 1; x < m; x++)
                if (arr[x][y] == 1)
                    dp[x][y] = 0;
                else
                    dp[x][y] = dp[x - 1][y] +dp[x][y - 1];
        return dp[m - 1][n - 1];
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        for (int i = 0; i < nums.length; i++) {
            int st = nums[i];
            int ed = st;
            while (i + 1 < nums.length && nums[i + 1] - ed == 1){
                i++;
                ed++;
            }

            if (st == ed)
                result.add(st + "");
            else
                result.add(st + "->" + ed);
        }
        return result;
    }

    public static int[][] SpiralMatrix(int n) {
        if (n <= 0)
            return new int[0][0];
        int[][] matrix = new int[n][n];
        int num = 1;
        int startx = 0, endx = n - 1;
        int starty = 0, endy = n - 1;

        while(startx <= endx && starty <= endy) {
            for (int y = starty; y <= endy; y++)
                matrix[startx][y] = num++;
            for (int x = startx + 1; x <= endx; x++)
                matrix[x][endy] = num++;
            if (startx == endx || starty == endy)
                break;
            for (int y = endy - 1; y >= starty; y--)
                matrix[endx][y] = num++;
            for (int x = endx - 1; x >= startx; x--)
                matrix[x][starty] = num++;
            startx++;
            starty++;
            endx--;
            endy--;
        }
        return matrix;
    }

    public static void sortColors(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                red++;
            else if (arr[i] == 1)
                white++;
            else
                blue++;
        }
        int i = 0;
        while(red-- > 0)
            arr[i++] = 0;
        while(white-- > 0)
            arr[i++] = 1;
        while(blue-- > 0)
            arr[i++] = 2;
    }

    public static int searchInRotatedSortedArray(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (k < nums[mid]) {
                if (nums[mid] < nums[high])
                    high = mid -1;
                else
                    if (k < nums[low])
                        low = mid + 1;
                    else
                        high = mid - 1;
            } else if ( k > nums[mid]) {
                if(nums[low] < nums[mid])
                    low = mid + 1;
                else
                    if (k > nums[high])
                        high = mid - 1;
                    else
                        low = mid + 1;
            } else
                return mid;
        }
        return -1;
    }

    public static int searchInRoatatedSortedArray2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (k < nums[mid]) {
                if (nums[mid] < nums[high])
                    high = mid - 1;
                else if(nums[mid] == nums[high])
                    high--;
                else
                    if (k > nums[low])
                        high = mid - 1;
                    else
                        low = mid + 1;
            } else if(k > nums[mid]) {
                if (nums[mid] > nums[low])
                    low = mid + 1;
                else if (nums[mid] == nums[low])
                    low++;
                else
                    if (k < nums[high])
                        low = mid + 1;
                    else
                        high = mid - 1;
            }else
                return mid;
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1};
        int begin = 0, end = nums.length - 1;

        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > k)
                end = mid - 1;
            else if (nums[mid] < k)
                begin = mid + 1;
            else {
                int i = mid, j = mid;
                while(i - 1 >= 0 && nums[i - 1] == k)
                    i--;
                while (j + 1 <= end && nums[ j + 1] == k)
                    j++;
                return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }

    public static boolean searchMatrix(int[][]matrix, int k) {
        if(matrix == null || matrix[0] == null)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int begin = 0, end = m * n;
        while (begin < end) {
            int mid = (begin + end - 1) / 2;
            int x = mid / m, y = mid % n;
            if (matrix[x][y] == k)
                return true;
            else if (matrix[x][y] > k)
                end = mid - 1;
            else
                begin = mid + 1;
        }
         return false;
    }

    public static void reverse()




}

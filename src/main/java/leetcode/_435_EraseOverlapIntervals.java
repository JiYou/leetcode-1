package leetcode;

import com.leetcode.utils.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class _435_EraseOverlapIntervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null)
			return 0;

		Arrays.sort(intervals, (a, b) -> (a.start - b.start));

		int end = intervals[0].end;
		int count = 1;

		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i].start >= end) {
				end = intervals[i].end;
				count++;
			}
		}

		return intervals.length - count;
	}
}

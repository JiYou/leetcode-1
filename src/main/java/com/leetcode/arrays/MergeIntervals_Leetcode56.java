package com.leetcode.arrays;

import com.leetcode.utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals_Leetcode56 {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		List<Interval> res = new ArrayList<>();
		for (Interval interval : intervals) {
			if (interval.start <= end)
				end = Math.max(end, interval.end);
			else {
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		res.add(new Interval(start, end));
		return res;
	}
}

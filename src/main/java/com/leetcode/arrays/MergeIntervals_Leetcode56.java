package com.leetcode.arrays;

import com.leetcode.utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals_Leetcode56 {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, (x, y) -> (x.start - y.start));
		List<Interval> res = new ArrayList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval it: intervals) {
			if (it.start <= end) {
				end = Math.max(end, it.end);
			} else {
				res.add(new Interval(start, end));
				start = it.start;
				end = it.end;
			}
		}
		res.add(new Interval(start, end));
		return res;
	}
}

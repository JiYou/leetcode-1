package com.leetcode.arrays;

import com.leetcode.utils.Interval;

import java.util.Arrays;

public class Meetingroom_252 {
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, (x, y) -> (x.start - y.start));
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1].end > intervals[i].start)
				return false;
		}
		return true;
	}
}

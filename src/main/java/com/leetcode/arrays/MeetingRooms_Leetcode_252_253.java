package com.leetcode.arrays;

import com.leetcode.utils.Interval;

import java.util.Arrays;
import java.util.Collections;

public class MeetingRooms_Leetcode_252_253 {
	public boolean canAttendMeeting(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;
		Arrays.sort(intervals, (a, b) -> a.start - b.start);

		int end = intervals[0].end;
		for (Interval interval : intervals) {
			if (interval.start < end)
				return false;
			end = Math.max(end, interval.end);
		}
		return true;
	}

	public boolean canAttendMeetings2(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1].start > intervals[i].end)
				return false;
		}
		return true;
	}

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i <= intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int res = 0;
		int end = 0;
		for (int i = 0; i <= intervals.length; i++) {
			if (intervals[i].start < end)
				res++;
			else
				end++;
		}
		return res;
	}
}

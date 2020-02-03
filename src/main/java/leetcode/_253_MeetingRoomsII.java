package leetcode;

import com.leetcode.utils.Interval;

import java.util.Arrays;

public class _253_MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (a, b) -> (a.start - b.start));

		int res = 1, end = intervals[0].end;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start > end)
				end = intervals[i].end;
			else
				res++;
		}
		return res;
	}


}

package leetcode;

import com.leetcode.utils.Interval;

import java.util.ArrayList;
import java.util.List;

public class _731_MyCalendar2 {
	public boolean book(int start, int end) {
		List<Interval> intervalList = new ArrayList<>();
		List<Interval> overlapList = new ArrayList<>();

		for (Interval interval : overlapList) {
			if (end <= interval.start || start >= interval.end)
				continue;
			return false;
		}

		for (Interval interval : intervalList) {
			if (end <= interval.start || start >= interval.end)
				continue;
			overlapList.add(new Interval(Math.max(start, interval.start), Math.min(end, interval.end)));
		}
		intervalList.add(new Interval(start, end));
		return true;
	}
}

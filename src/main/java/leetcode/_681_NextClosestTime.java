package leetcode;

public class _681_NextClosestTime {
	public String nextClosestTime(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int min = Integer.parseInt(time.substring(3, 5));

		while (true) {
			if (++min == 60) {
				min = 0;
				++hour;
				hour %= 24;
			}
			String cur = String.format("%02d:%02d", hour,min);
			boolean valid = true;
			for (int i = 0; i < cur.length(); i++)
				if (time.indexOf(cur.charAt(i)) < 0) {
					valid = false;
					break;
				}
			if (valid)
				return cur;
		}
	}
}

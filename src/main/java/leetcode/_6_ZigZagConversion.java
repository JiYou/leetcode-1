package leetcode;

public class _6_ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows <= 1) return s;

		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuffer("");
		}

		for (int i = 0; i < numRows; i++) {
			int index = i % (2 * numRows - 2);
			index = index < numRows ? index : (2 * numRows - 2 - index);
			sb[index].append(s.charAt(i));
		}
		for (int i = 1; i < sb.length; i++)
			sb[0].append(sb[i]);

		return sb[0].toString();
	}
}

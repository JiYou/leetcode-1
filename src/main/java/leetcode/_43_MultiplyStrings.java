package leetcode;

public class _43_MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null)
			return "0";
		int[] digits = new int[num1.length() + num2 .length()];
		int sum = 0;
		for (int i = num1.length() - 1; i >= 0; i--)
			for (int j = num2.length() - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				digits[p2] += product % 10;
				digits[p1] += product / 10;
			}

		StringBuffer sb = new StringBuffer();
		for (int digit : digits){
			if (!(digit == 0 && sb.length() == 0))
				sb.append(digit);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}

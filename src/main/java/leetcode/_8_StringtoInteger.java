package leetcode;

public class _8_StringtoInteger {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		str = str.trim();
		int sign = 1;
		char first = str.charAt(0);
		int start = 0;
		int res = 0;
		if (first == '+') {
			sign = 1;
			start++;
		} else if (first == '-'){
			sign = -1;
			start++;
		}
		for (int i = start; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return (int) sign * res;
			}
			res = res * 10 + str.charAt(i) - '0';
			if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
		}
		return (int) sign * res;
	}

	public String itoa(int num, int base) {
		if (num == 0)
			return "0";
		String ret = "";
		int flag = 0;
		int reminder = 0;

		if (num < 0) {
			flag = -1;
			num *= -1;
		}

		while (num > 0) {
			reminder = num % base;
			num /= base;
			ret = (char)(reminder + '0') + ret;
		}

		return flag == 0 ? ret : ( '-' + ret);
	}
}

package leetcode;

public class _468_ValidIPAddress {
	public String validIPAddress(String ip) {
		String INVALID = "Neither";
		if (ip.startsWith(":") || ip.startsWith(".") ||
		ip.endsWith(":") || ip.endsWith("."))
			return INVALID;
		String[] splitted = ip.split("\\.");
		if (splitted.length == 4) {
			int num = -1;
			for (int i = 0; i < 4; i++) {
				try {
					num = Integer.parseInt(splitted[i]);
				} catch (NumberFormatException e) {
					return INVALID;
				}
				if (num < 0 || num > 255)
					return INVALID;
				if (splitted[i].length() > 1 && splitted[i].startsWith("0") || splitted[i].startsWith("-"))
					return INVALID;
				return "IPv4";
			}
		} else {
			splitted = ip.split(":");
			if (splitted.length == 8) {
				int num = -1;
				for (int i = 0; i < 8; i++) {
					int len = splitted[i].length();
					if (splitted[i] == null || len > 4 || len == 0) return INVALID;
					for (int j = 0; j < len; j++) {
						char c = splitted[i].charAt(j);
						if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')))
							return INVALID;
					}
				}
				return "IPv6";
			} else return INVALID;
		}
		return INVALID;
	}
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _722_RemoveComments {
	public List<String> removeComments(String[] source) {
		List<String> res = new ArrayList<>();
		boolean isBlock = false;

		StringBuffer sb = new StringBuffer();

		for (String str: source) {
			char[] line = str.toCharArray();
			int pt = 0;
			int len = line.length;
			while (pt < len) {
				if (isBlock) {
					if (pt < len - 1 && line[pt] == '*' && line[pt + 1] == '/') {
						isBlock = false;
						pt += 2;
					} else
						pt++;
				} else {
					if (pt < len - 1 && line[pt] == '/' && line[pt + 1] == '/')
						break;
					else if (pt < len - 1 && line[pt] == '/' && line[pt + 1] == '*') {
						isBlock = true;
						pt += 2;
					} else
						sb.append(line[pt++]);
				}
				if (!isBlock && sb.length() > 0) {
					res.add(sb.toString());
					sb = new StringBuffer();
				}
			}
		}
		return res;
	}
}

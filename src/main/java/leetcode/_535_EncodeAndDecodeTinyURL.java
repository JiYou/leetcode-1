package leetcode;

import java.util.HashMap;
import java.util.Random;

public class _535_EncodeAndDecodeTinyURL {
	HashMap<String, String> map = new HashMap<>();
	String mapping = "abcdedewwfffe1234e3e3";

	public String encode(String longUrl) {
		Random random = new Random(mapping.length());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			int index = random.nextInt();
			sb.append(mapping.charAt(index));
		}
		String url = "http://tinyURL/" + sb.toString();
		map.put(url, longUrl);
		return url;
	}

	public String decode(String shortUrl) {
		return map.get(shortUrl);
	}
}

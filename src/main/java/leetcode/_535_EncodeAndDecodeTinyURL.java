package leetcode;

import java.util.HashMap;
import java.util.Random;

public class _535_EncodeAndDecodeTinyURL {
	HashMap<String, String> map = new HashMap<>();
	String mapping = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public String encode(String longUrl) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(62);
			sb.append(mapping.charAt(index));
		}
		String url = "http://tinyURL/" + sb.toString();
		map.put(url, longUrl);
		return url;
	}

	public String encode2(String longUrl) {
		String url = "http://tinyURL/" + longUrl.hashCode();
		map.put(url, longUrl);
		return url;
	}

	public String decode(String shortUrl) {
		return map.get(shortUrl);
	}
}

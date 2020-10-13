package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _635_LogSystem {
	class Record {
		static final String YEAR_STRING = "Year";
		static final String MONTH_STRING = "Month";
		static final String DAY_STRING = "Day";
		static final String HOUR_STRING = "Hour";
		static final String MINUTE_STRING = "Minute";
		static final String SECOND_STRING = "Second";

		int id;
		String timestamp;
		public Record(int id, String timestamp) {
			this.id = id;
			this.timestamp = timestamp;
		}

		public int compare(String timestamp, String string) {
			if (string.equals(YEAR_STRING))
				return this.timestamp.substring(0,4).compareToIgnoreCase(timestamp.substring(0,4));
			else if (string.equals(MONTH_STRING))
				return this.timestamp.substring(0,7).compareToIgnoreCase(timestamp.substring(0,7));
			else if (string.equals(DAY_STRING))
				return this.timestamp.substring(0, 10).compareToIgnoreCase(timestamp.substring(0, 10));
			else if (string.equals(HOUR_STRING))
				return this.timestamp.substring(0, 13).compareToIgnoreCase(timestamp.substring(0, 13));
			else if (string.equals(MINUTE_STRING))
				return this.timestamp.substring(0, 16).compareToIgnoreCase(timestamp.substring(0, 16));
			else if (string.equals(SECOND_STRING))
				return this.timestamp.compareToIgnoreCase(timestamp);
			return 0;
		}
	}

	List<Record> logs;
	public _635_LogSystem() {
		logs = new ArrayList<Record>();
	}

	public void put(int id, String timestamp) {
		logs.add(new Record(id, timestamp));
	}

	public List<Integer> retrieve(String start, String end, String granularity) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < logs.size(); i++)
			if (logs.get(i).compare(start, granularity) >= 0 && logs.get(i).compare(end, granularity) <= 0)
				res.add(logs.get(i).id);
		return res;
	}
}

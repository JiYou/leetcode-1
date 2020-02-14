package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _679_JudgePoint24 {
	public boolean judgePoint24(int[] nums) {
		List<Double> nowNums = new ArrayList<>();
		for (int num : nums)
			nowNums.add((double) num);
		return dfs(nowNums);
	}

	private boolean dfs(List<Double> nowNums) {
		if (nowNums.size() == 1)
			return Math.abs(nowNums.get(0) - 24) < 1e-6;
		for (int i = 0; i < nowNums.size(); i++)
			for (int j = 0; j < nowNums.size(); j++) {
				if (i == j)
					continue;
				List<Double> newNums = new ArrayList<>();
				for (int k = 0; k < nowNums.size(); k++)
					if (k != i && k != j)
						newNums.add(nowNums.get(k));
				for (int times = 0; times < 4; times++) {
					if (times < 2 && j > i)
						continue;
					if (times == 0) newNums.add(nowNums.get(i) + nowNums.get(j));
					if (times == 1) newNums.add(nowNums.get(i) * nowNums.get(j));
					if (times == 2) newNums.add(nowNums.get(i) - nowNums.get(j));
					if (times == 3)
						if (nowNums.get(j) != 0)
							newNums.add(nowNums.get(i) / nowNums.get(j));
						else
							continue;
					if (dfs(newNums))
						return true;
				}
			}
		return false;
	}
}

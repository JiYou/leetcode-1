package leetcode;

public class _547_FriendCircles {
	public int findCircleNum(int[][] nums) {
		int [] visited = new int[nums.length];
		int res = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				dfs(nums, visited, i);
				res++;
			}
		}
		return res;
	}

	private void dfs(int[][] nums, int[] visited, int i) {
		for (int j = 0; j < nums.length; j++) {
			if (nums[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				dfs(nums, visited, j);
			}
		}
	}


	public int findCircleNum2(int[][] nums) {
		int res = nums.length;
		int[] roots = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			roots[i] = i;

		for (int i = 0; i < nums.length; i++)
			for (int j = 0; j < nums[0].length; j++) {
				if (nums[i][j] == 1) {
					int x = find(roots, i);
					int y = find(roots, j);
					if (x != y) {
						roots[x] = y;
						res--;
					}
				}
			}
		return res;
	}

	private int find(int[] roots, int i) {
		return i == roots[i] ? i : find(roots, roots[i]);
	}

}

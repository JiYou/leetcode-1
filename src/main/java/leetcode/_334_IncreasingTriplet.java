package leetcode;

public class _334_IncreasingTriplet {
	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length < 3)
			return false;
		int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
		for(int n : nums) {
			if(n <= one)
				one = n;
			else if(n <= two) {
				two = n;
			} else
				return true;
		}
		return false;
	}
}

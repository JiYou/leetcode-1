package offer;

public class maxSubArray {
	public int maxSubArray(int[] nums) {
		int res = 0, sum = 0;
	  for (int n : nums) {
	  	if (sum > 0)
	  		sum += n;
	  	else
	  		sum = n;
	  	res = Math.max(res, sum);
		}
	  return res;
	}
}

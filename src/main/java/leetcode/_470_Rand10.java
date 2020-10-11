package leetcode;

public class _470_Rand10 {
	public int rand10() {
		int num = (rand7() - 1) * 7 + rand7();
		// 只要它还大于40，那你就给我不断生成吧
		while (num > 40)
			num = (rand7() - 1) * 7 + rand7();
		// 返回结果，+1是为了解决 40%10为0的情况
		return 1 + num % 10;
	}

	private int rand7() {
		return 1;
	}
}

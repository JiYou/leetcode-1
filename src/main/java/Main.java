import com.leetcode.arrays.RemoveDuplicatesFromSortedArray;
import com.leetcode.backtracing.LeetcodeBackTracing;
import com.leetcode.sort.HeapSort;
import com.leetcode.sort.MergeSort;
import com.leetcode.sort.QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
	public static void main(String[] agrs) {
		Vector<Integer> test = new Vector<>();
		test.add(2);
		test.add(7);
		test.add(11);
		test.add(15);
		test.add(29);
	//	int a[] = TwoSum.twoSumWithHashMap(test, 22);
		int b[] = {3, 4, 1, 10, 8, 1, 15, 1, 12};
		int c[] = {3, 4, 1, 10, 8, 2, 15, 9, 12};
		/*QuickSort.sort(b);
		RemoveDuplicatesFromSortedArray.removeDuplicates(b);
		for (int i = 0; i < b.length; i++)
			System.out.println(b[i]);*/

		int a[] = {1,2,3};
		List<List<Integer>> res = new ArrayList<>();
		res = LeetcodeBackTracing.subsets(a);
		for (int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
	}
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _251_Flatten2DVector {

	int indexList, indexElement;
	List<List<Integer>> list;

	public _251_Flatten2DVector(List<List<Integer>> vec2d) {
		indexElement = 0;
		 indexList = 0;
		 list = vec2d;
	}

	public Integer next() {
		return list.get(indexList).get(indexElement);
	}

	public boolean hasNext() {
		while (indexList < list.size()) {
			if (indexElement < list.get(indexList).size()) {
				return true;
			} else {
				indexElement = 0;
				indexList++;
			}
		}
		return false;
	}
}

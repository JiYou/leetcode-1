package com.leetcode.design;

import com.leetcode.common.Point;

import java.util.HashMap;

public class MaxPointsonALine_149 {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		if (points.length < 2)
			return points.length;
		int res = 0;
	  for (int i = 0; i < points.length; i++) {
		  HashMap<String, Integer> map = new HashMap<>();
		  int samePoint = 0;
		  int sameXAxis = 0;
		  for (int j = 0; j < points.length; j++) {
		  	if (i != j) {
		  		if (points[i].x == points[j].x && points[i].y == points[j].y)
		  			samePoint++;
		  		if (points[i].x == points[j].x){
					  sameXAxis++;
					  continue;
				  }
				  int numerator = points[i].y - points[j].y;
		  		int denominator = points[i].x - points[j].x;
		  		int gcd = gcd(numerator, denominator);
		  		String tmp = (numerator/gcd) + "/" + (denominator/gcd);
		  		map.put(tmp, map.getOrDefault(tmp, 1) + 1);
		  		res = Math.max(res, map.get(tmp) + samePoint);
			  }
		  }
		  res = Math.max(res, sameXAxis);
	  }
	  return res;
	}

	private int gcd(int a, int b) {
		if (a == 0) return b;
		return gcd(b % a, a);
	}
}

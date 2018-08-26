package com.leetcode.backtracing;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetcodeBackTracing {

	  public static List<List<Integer>> subsets(int[] nums) {
	  	if (nums == null || nums.length == 0)
	  		return null;
	  	List<List<Integer>> res = new ArrayList<>();
	  	subsetHelper(nums,res,0,new ArrayList<>());
	  	return res;
	  }

	  private static void subsetHelper(int[] nums, List<List<Integer>>res, int index, List<Integer> tmp) {
	  	res.add(new ArrayList<>(tmp));
	  	for (int i = index; i < nums.length; i++){
	  		tmp.add(nums[i]);
	  		subsetHelper(nums, res, i + 1, tmp);
	  		tmp.remove(tmp.size() - 1);
		  }
	  }

	  public static List<List<Integer>> combinationSum(int[]nums, int k) {
	  	List<List<Integer>> res = new ArrayList<>();
	  	if (nums == null || nums.length == 0)
	  		return res;
	  	combinationSumHelper(res, new ArrayList<>(), nums, 0, k);
	  	return res;
	  }

	  private static void combinationSumHelper(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index, int k) {
	  	if (k < 0) return;
	  	if (k == 0) {
			  res.add(new ArrayList<>(tmp));
			  return;
		  }
		  for (int i = 0; i < nums.length; i++){
		  	tmp.add(nums[i]);
		  	combinationSumHelper(res,tmp,nums,i, k - nums[i]);
		  	tmp.remove(tmp.size() - 1);
		  }
	  }

	  public static List<List<Integer>> permute(int[] nums) {
	  	List<List<Integer>> res = new ArrayList<>();
	  	if (nums == null || nums.length == 0)
	  		return res;
	  	permuteHelper(res, new ArrayList<>(), nums);
	  	return res;
	  }

	  private static void permuteHelper(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
	  	if (tmp.size() == nums.length) {
	  		res.add(new ArrayList<>(tmp));
	  		return;
		  }
		  for (int i = 0; i < nums.length; i++) {
		  	if (tmp.contains(nums[i]))
		  		continue;
		  	tmp.add(nums[i]);
		  	permuteHelper(res, tmp, nums);
		  	tmp.remove(tmp.size() - 1);
		  }
	  }

	  public static List<List<Integer>> pathSum(TreeNode root, int k) {
	  	List<List<Integer>> res = new ArrayList<>();
	  	if (root == null)
	  		return res;
	  	pathSumHelper(res, new ArrayList<>(), root, k);
	  	return res;
	  }

	  private static void pathSumHelper(List<List<Integer>> res, List<Integer> tmp, TreeNode root, int k) {
	  	if (root == null)
	  		return;
	  	tmp.add(root.getValue());
	  	k = k - root.getValue();
	  	if (root.getLeft() == null && root.getRight() == null) {
	  		if (k == 0)
	  			res.add(new ArrayList<>(tmp));
		  } else {
	  		if (root.getLeft() != null)
	  			pathSumHelper(res, tmp, root.getLeft(), k);
	  		if (root.getRight() != null)
	  			pathSumHelper(res, tmp, root.getRight(), k);
		  }
		  tmp.remove(tmp.size() - 1);
	  }
}

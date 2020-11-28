package Sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/solution/
 * @author lakec
 *
 */
public class ThreeSum {
	
	int target=0;
	public List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for(int i=0;i<nums.length && nums[i]<=target;i++) {
			if(i==0 || nums[i-1]!=nums[i])
				twoSum(nums,res,i);
		}
		return res;
	}
	
	public void twoSum(int[] nums, List<List<Integer>> res, int i) {
		int lo=i+1; int hi=nums.length-1;
		while(lo<hi) {
			int sum = nums[i]+nums[lo]+nums[hi];
			if(sum>target)
				hi--;
			else if(sum<target)
				lo++;
			else {
				res.add(Arrays.asList(nums[i],nums[lo++],nums[hi--]));
				while(lo<hi && nums[lo-1]==nums[lo])
					lo++;
			}
		}
	}

}

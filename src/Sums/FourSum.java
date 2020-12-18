package Sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	List<List<Integer>> fourSum(int[] nums, int target){
		
		Arrays.sort(nums);
		return kSum(nums,target,0,4);
		
	}
	
	List<List<Integer>> kSum(int[] nums, int target, int start, int k){
		List<List<Integer>> res = new ArrayList<>();
		if(start==nums.length || nums[start]*k>target || target<nums[nums.length-1]*k)
			return res;
		if(k==2)
			return twoSum(nums,target,start);
		for (int i=start;i<nums.length;i++) {
			if(i==start || nums[i]!=nums[i-1]) {
				for(List<Integer> list : kSum(nums,target-nums[i],i+1,k-1)) {
					res.add(new ArrayList<>(Arrays.asList(nums[i])));
					res.get(res.size()-1).addAll(list);
					
				}
			}
		}
		return res;
	}
	
	List<List<Integer>> twoSum(int[] nums, int target, int i){
		
		List<List<Integer>> res = new ArrayList<>();
		int lo=i+1;
		int hi=nums.length-1;
		
		while(lo<hi) {
			int sum = nums[lo]+nums[hi];
			if(sum<target)
				lo++;
			else if (sum<target)
				hi--;
			else {
				res.add(Arrays.asList(nums[lo],nums[hi]));
				while(lo<hi && nums[lo]==nums[lo-1]) lo++;
				while(lo<hi && nums[hi]==nums[hi+1]) hi--;
			}
		}
		return res;
	}
<<<<<<< HEAD
	
	public List<List<Integer>> fourSum2(int[] nums, int target){
		
	}
=======
>>>>>>> commit changes

}

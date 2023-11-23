Q Link : https://leetcode.com/problems/non-decreasing-array/description/

// Approach 1 : Brute Force
// TC : O(N^2)
// SC : O(1)

class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length==1 || nums.length==0) return true;
        for(int i=1;i<nums.length;i++){
             if(nums[i]<nums[i-1]){
                 int temp = nums[i-1];
                 nums[i-1]=nums[i];
                 if(isNonDecreasing(nums)) return true;
                 nums[i-1]=temp;
                 nums[i]=nums[i-1];
                 if(isNonDecreasing(nums)) return true;
                 else return false;
             } 
        }
        return true;
    }

    public boolean isNonDecreasing(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]) return false;
        }
        return true;
    }
}


// Approach 2 : Greedy Approach
// TC : O(N)
// SC : O(1)

// Modifying The Input

public boolean checkPossibility(int[] nums) {
	for (int i=1, modified=0; i<nums.length; i++) {
		if (nums[i-1] > nums[i]) {
			if (modified++ == 1) return false;
			if (i<2 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
			else nums[i] = nums[i-1];
		}
	}
	return true;
}

// Without Modifying The Input

public boolean checkPossibility(int[] nums) {
	for (int i=1, modified=0, prev = nums[0]; i<nums.length; i++) {
		if (nums[i] < prev) {
			if (modified++ == 1) return false;
			if (i>=2 && nums[i-2] > nums[i]) continue;
		}
		prev = nums[i];
	}
	return true;
}


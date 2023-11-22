Q Link : https://leetcode.com/problems/rotate-array/description/

// Approach 1 : Using Another Array
// TC = O(N)
// SC = O(N)

class Solution {
    public void rotate(int[] nums, int k) {

        k%=nums.length; // nums=[1,2] & k=3

        int[] temp = new int[nums.length];

        for(int i=nums.length-k,j=0;i<nums.length;i++,j++){
            temp[j]=nums[i];
        }

        for(int i=0;i<nums.length-k;i++){
            temp[i+k]=nums[i];
        }

        nums = Arrays.copyOfRange(temp,0,temp.length);

    }
}

// Approach 2 : Reversing The Array
// TC = O(N)
// SC = O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void reverse(int[] nums, int l, int r){
        int i=l;
        int j=r;

        while(i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}



Q Link : https://leetcode.com/problems/kth-largest-element-in-an-array/description/

// Approach-1 : Sorting 
// TC : O(nlogn)
// SC : O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums); // Use TimSort -> mix of Insertion & Merge Sort
        return nums[nums.length-k];
    }
}

// Approach-2 : Min-Heap
// TC : O(n*log(k))
// SC : O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k) pq.poll();
        }

        return pq.peek();
    }
}

// Approach-3 : Quick Select or Hoare's Algorithm
// TC : O(n^2) -> (Worst) & O(n) -> (Average)
// SC : O(1)

/*

 Algo : 
- Assume the pivot element
- Make sure the left ones from pivot must be larger & right ones must be smaller
- Swap the jth element with pivot
- Check the jth element 
- If smaller than k -> l = pivot idx + 1 else r = pivot idx - 1

*/
  

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int l = 0;
        int r = nums.length-1;
        int pivot_idx = 0;
        while(l<=r){
             pivot_idx = partition(nums,k,l,r);
             if(pivot_idx==k-1) break;
             else if(pivot_idx<k) l=pivot_idx+1;
             else r=pivot_idx-1;
        }
        return nums[pivot_idx];
    }

    public static int partition(int[] nums, int k , int l , int r){
        int n = nums.length;
        int p = nums[l];
        int i = l+1; // for edge case like nums=[1] & k=1 else we can also take, i=l
        int j = r;
        while(i<=j){
            if(nums[i]<p && nums[j]>p) {
                swap(nums,i,j);
                i++;
                j--;
            }
            if(nums[i]>=p) i++;
            if(nums[j]<=p) j--;

        }
        swap(nums,l,j);
        return j;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


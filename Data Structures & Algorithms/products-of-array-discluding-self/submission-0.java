class Solution {
    public int[] productExceptSelf(int[] nums) {
          // using prefix && suffix
        int n=nums.length;
        int pref[]=new int[n]; // to calculate the product of element to the left of i
        int suff[]=new int[n]; // to calculate the product of element to the right of i
        int res[]=new int[n];

        pref[0]=1; //since there will be nothing to the left of index 0
        suff[n-1]=1; // since there will be nothing to the right of last index
        for(int i=1;i<n;i++)
        {
            pref[i]=nums[i-1]*pref[i-1];
        }
        for(int i=n-2;i>=0;i--)
        {
            suff[i]=nums[i+1]*suff[i+1];
        }
        for(int i=0;i<n;i++)
        {
            res[i]=pref[i]*suff[i];
        }
        return res;
    }
}  

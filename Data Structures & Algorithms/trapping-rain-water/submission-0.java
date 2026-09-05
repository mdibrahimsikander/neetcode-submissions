class Solution {
    public int trap(int[] height) {
        if(height.length==0)
        {
            return 0;
        }
        int l=0;
        int r=height.length-1;
        int prefMax=height[l];
        int suffMax=height[r];
        int res=0;
        while(l<r)
        {
            if(prefMax<suffMax)
            {
                l++;
                prefMax=Math.max(prefMax,height[l]);
                res+=prefMax-height[l];
            }
            else
            {
                r--;
                suffMax=Math.max(suffMax,height[r]);
                res+=suffMax-height[r];
            }

        }
        return res;
    }
}

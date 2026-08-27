class Solution {
    public int maxArea(int[] heights) {
        int maxWater=0;
        int i=0;
        int j=heights.length-1;
        while(i<j)
        {
            int water=(j-i)*Math.min(heights[i],heights[j]);
            maxWater=Math.max(water,maxWater);
            if(heights[i]<heights[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return maxWater;
    }
}

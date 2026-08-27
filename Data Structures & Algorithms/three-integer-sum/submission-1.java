class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List <List<Integer>> ans = new ArrayList <> ();
        for(int i=0;i<nums.length-2;i++)
        {
            int target=-(nums[i]);
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                int sum=nums[j]+nums[k];
                if(j<k && sum==target)
                {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j+1]==nums[j])    j++;
                    while(k>j && nums[k-1]==nums[k])    k--;
                    j++;
                    k--;
                }
                else if(j<k && sum>target)
                {
                    k--;
                }
                else if(j<k && sum<target)
                {
                    j++;
                }
            }
            while(i<nums.length-1 && nums[i]==nums[i+1])
            {
                i++;
            }
        }
        return ans;
    }
}

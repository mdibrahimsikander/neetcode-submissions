class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // HashMap <Integer,Integer> mp =new HashMap<>();
        // for(int i=0;i<numbers.length;i++)
        // {
        //     int tmp=target-numbers[i];
        //     if(mp.containsKey(tmp))
        //     {
        //         return new int[]{mp.get(tmp),i+1};
        //     }
        //     else
        //     {
        //         mp.put(numbers[i],i+1);
        //     }
        // }
        // return new int[]{};

        //using binary search
        int n=numbers.length;
        for(int i=0;i<n;i++)
        {
            int tmp=target-numbers[i];
            int start=0;
            int end=n-1;
            int mid=(start+end)/2;
            while(start<=end)
            {
                if(numbers[mid]==tmp && mid!=i)
                {
                    return new int[]{i+1,mid+1};
                }
                else if(tmp<numbers[mid])
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
                mid=(start+end)/2;
            }
        }
        return new int[0];
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         HashMap <Integer,Integer> count =new HashMap<>();
         for(int n: nums)
         {
            count.put(n,count.getOrDefault(n,0)+1);
         }
         ArrayList <int[]> list=new ArrayList<>();
         for(Map.Entry<Integer,Integer> entry : count.entrySet())
         {
            list.add(new int[]{entry.getValue(),entry.getKey()});
         }
         list.sort((a,b)->b[0]-a[0]);
         int [] a=new int[k];
         for(int i=0;i<k;i++)
         {
            a[i]=list.get(i)[1];
         }
         return a;
    }
}

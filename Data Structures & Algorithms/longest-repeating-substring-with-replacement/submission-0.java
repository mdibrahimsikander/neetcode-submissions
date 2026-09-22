class Solution {
    public int characterReplacement(String s, int k) {
        HashMap <Character, Integer> store=new HashMap<>();
        int l=0,maxf=0 ,res=0; 
        for(int r=0;r<s.length();r++)
        {
            store.put(s.charAt(r),store.getOrDefault(s.charAt(r),0)+1);
            maxf=Math.max(maxf,store.get(s.charAt(r)));
            while((r-l+1)-maxf>k)
            {
                store.put(s.charAt(l),store.get(s.charAt(l))-1);
                l++;
            }
            res=Math.max(res,r-l+1);
            
        }
        return res;
    }
}

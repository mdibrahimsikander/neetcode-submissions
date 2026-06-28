class Solution {
    public boolean isAnagram(String s, String t) {
         if (s.length() != t.length()) //Check For Same Length
        {
            return false;
        }
        HashMap <Character, Integer> map1= new HashMap<>(); //store the string to HashMap and keep a count of characters
        for(char i : s.toCharArray())
        {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        HashMap <Character, Integer> map2=new HashMap<>(); //store the 2nd string to HashMap and keep a count of characters
        for(char i : t.toCharArray())
        {
            map2.put(i,map2.getOrDefault(i,0)+1);
        }
        return map1.equals(map2); // check if both the hashmaps are equal or not
    }
}

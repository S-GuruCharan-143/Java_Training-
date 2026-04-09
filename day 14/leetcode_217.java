import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c=nums[i];
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)>1) return true;
        }
        return false;
    }
}
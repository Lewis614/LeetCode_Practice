package medium001.twoSum;
import java.util.*;


public class Solution {
	public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length < 2) return res;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i<numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                // output is index+1
                res[0] = map.get(target - numbers[i])+1;
                res[1] = i+1; 
                
                return res;
            }
            else map.put(numbers[i],i);
        }
        return res;
    }
}

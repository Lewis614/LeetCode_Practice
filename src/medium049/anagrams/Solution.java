package medium049.anagrams;

import java.util.*;
import java.util.Map.Entry;

/**
 * make sure the sequence of this string can be anything.
 * @author liuyisi
 *
 */

public class Solution {
	public List<String> anagrams(String[] strs){
		ArrayList<String> res = new ArrayList<String>();
		if(strs == null || strs.length == 0) return res;
		
		HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for(String elem : strs){
			char[] cStr = elem.toCharArray();
			Arrays.sort(cStr);
			String key = new String(cStr);
			if(map.containsKey(key)){
				map.get(key).add(elem);
			} else {
				map.put(key,new ArrayList<String>());
				map.get(key).add(elem);
			}
		}
		for(ArrayList<String> elem : map.values()){
			if(elem.size()>1) {
				// remember we can a collection at one time by addAll when using List.
				res.addAll(elem);
			}
		}
		return res;
		
		/* another way to iterate the map is using while loop. but you need to create the iterator.
		 * 
		 * Iterator iter = map.values().iterator();
		 * while(iter.hasNext()){
		 * 		ArrayList<String> item = (ArrayList<String>)iter.next();
		 * 		if(item.size>1) res.addAll(item);
		 * }
		 * return res;
		 */
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		String[] strs = {"asddsa","qwertrewq","qwetre","o","opop","asdffgfds"};
		System.out.println(s.anagrams(strs));
		
	}
}

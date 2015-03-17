package medium049.anagrams;

import java.util.*;

public class Solution2 {
	public List<String> anagrams(String[] strs){
		ArrayList<String> res = new ArrayList<String>();
		if(strs == null || strs.length == 0) return res;
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String elem :strs){
			char[] strArray = elem.toCharArray();
			Arrays.sort(strArray);
			String keyStr = new String(strArray);
			if(map.containsKey(keyStr)){
				map.get(keyStr).add(elem);
			}
			else{
				ArrayList<String> item = new ArrayList<String>();
				item.add(elem);
				map.put(keyStr, item);
			}
		}
		
		for(String key : map.keySet()){
			if(map.get(key).size()>1) res.addAll(map.get(key));
		}
		return res;
	}
}

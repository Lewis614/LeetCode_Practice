/**
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

package medium046.permutations;

import java.util.*;


// solution with exponential time.  
public class Solution {
	
	//Iterative Solution
	public List<List<Integer>> permute(int[] num) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num == null || num.length == 0) return res;
		//initialization for this iteration.
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(num[0]);
		res.add(first);
		
		for(int i = 1; i < num.length; i++) {
			ArrayList<List<Integer>> tempRes = new ArrayList<List<Integer>>();
			for(int j = 0; j<res.size(); j++) {
				List<Integer> cur= res.get(j);
				
				// "< cur.size()+1" add a new element at the end of index.(index+1 is legal) 
				for(int k = 0; k < cur.size()+1; k++) {
					ArrayList<Integer> item = new ArrayList<Integer>(cur);
					/* add to specific index. Review the API of ArrayList Please!
					   =>
					   add(int index, E element)
					   Inserts the specified element at the specified position in this list.
					*/
					item.add(k,num[i]);
					tempRes.add(item);
				}
			}
			res = tempRes;
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	//Recursive Solution
	public List<List<Integer>> permute2(int[] num) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num == null || num.length == 0) return res;
		
		boolean[] isChosen = new boolean[num.length];
		ArrayList<Integer> item = new ArrayList<Integer>();
		helper(num,isChosen,item,res);
		return res;
	}
	
	public void helper(int[] num, boolean[] isChosen, 
			ArrayList<Integer> item, ArrayList<List<Integer>> res){
		if(item.size()==num.length){
			//Why there should have a new object when doing the add method
			//add只是把对应元素的pointer指了上去，但是后面紧接着现场还原以后，item就都remove清零了，
			//那对应这个res里面pointer指向的item也会是空的，所以在加入最终结果的时候，一定要不断的新建全新的list
			//即便不清零，你就这一个list，来回的变化，每次add都是pointer指向同一个list，你觉得能对么？
			//Remember such a constructor to copy all List.
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i = 0 ; i < num.length; i++) {
			if(!isChosen[i]){
				isChosen[i]=true;
				item.add(num[i]);
				helper(num,isChosen, item, res);
				
				//Protect the original situation
				item.remove(item.size()-1);
				isChosen[i]=false;
			}
		}
	}
	
}

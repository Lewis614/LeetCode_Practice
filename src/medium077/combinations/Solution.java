package medium077.combinations;
/**
 * It is a NP problem, http://blog.csdn.net/linhuanmars/article/details/21260217
 */

import java.util.*;


public class Solution {
	
	//perfect solution online: (Chinese Note may refer to LeetCode Note 12)
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //注意这里的n<k的boundary状态清理。
        if(n<=0 || n<k) return res;  
        // 直接在这里new ArrayList<Integer>() 写在参数里面节省了一行，但是若无把握还是先出一个local variable之后再填入method当中。
        helper(n,k,1,new ArrayList<Integer>(), res);  
        return res;  
    }  
    private void helper(int n, int k, int start, ArrayList<Integer> item, ArrayList<List<Integer>> res){  
        if(item.size()==k) {  
        	// 千万注意item还要为后面的list所用，加入到最终结果时候一定要单独在拷贝一份item才能使后面的操作不影响已有的结果，如果只传递指针，最后已修改前面的也会变化，且多个指针指向一个东西也不是正常的。
            res.add(new ArrayList<Integer>(item));  
            // you need to stop this helper, because it is end and have added the item to res.
            return;  
        }  
        for(int i=start;i<=n;i++) {  
        // 这里相比于permutation唯一缺少的就是boolean[i]判断是不是来过了，但是因为我们有传参数start确定循环时是一直向前扫描的，也就不必担心之前的是否还需要，boolean数组可以省略。
            item.add(i);  
            helper(n,k,i+1,item,res);  
            //恢复现场还是要记得做好。
            item.remove(item.size()-1);  
        }  
    }  
	
	
	//my solution
	public List<List<Integer>> combine1(int n, int k) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		// there is not necessary to add the constraint here, but better to add it .
		if(n<=0 || n<k) return res;
		boolean[] isChosen = new boolean[n];
		
		ArrayList<Integer> listNode = new ArrayList<Integer>();
		helper(n, k, isChosen, 0, listNode,res);
		return res;
	}
	
	public void helper(int n, int k, boolean[] isChosen, int start,
			ArrayList<Integer> listNode, ArrayList<List<Integer>> res) {
		
		if(listNode.size() == k) {
			res.add(new ArrayList<Integer>(listNode));
			return;
		}
		for(int i = start ; i < n; i++) {
			if(!isChosen[i]){
				isChosen[i] = true;
				listNode.add(i+1);
				
				// the only different between permutation and combination is:
				// add the starting point of the for loop in combination to stop it track the past element again.
				
				// must be i+1 not start+1, since the i will be changing all the time.
				helper(n, k, isChosen, i+1, listNode, res);
				
				listNode.remove(listNode.size()-1);
				isChosen[i] = false;
				
			}
			
		}
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		// fu lei yin yong zhi xiang zi lei dui xiang. so you need to use the same data type as declare in static data type.
		List<List<Integer>> res = s.combine(4,2);
	}
}

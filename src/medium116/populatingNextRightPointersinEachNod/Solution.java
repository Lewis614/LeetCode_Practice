/**https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
*/



package medium116.populatingNextRightPointersinEachNod;

import java.util.*;

public class Solution {
	
	// constant space: since only use some pointer to keep track of the linklist in same level.
	public void connect (TreeLinkNode root) {
		if(root == null) return;
		TreeLinkNode lastHead = root;
		TreeLinkNode pre = null;
		TreeLinkNode curHead = null;
		
		while(lastHead != null) {
			// lastCur means the cur node in last level.
			TreeLinkNode lastCur = lastHead;
			while(lastCur!= null) {
				if(lastCur.left != null){
					if(curHead == null) {
						curHead = lastCur.left;
						pre = curHead;
					}
					else {
						pre.next = lastCur.left;
						pre = pre.next;
					}
				} 
				
				// dont use else, it can go into both.
				if(lastCur.right != null) {
					if(curHead ==null) {
						curHead = lastCur.right;
						pre = curHead;
					}
					else {
						pre.next = lastCur.right;
						pre =pre.next;
					}
				}
				lastCur = lastCur.next;
			}
			
			// prepare for the next 
			lastHead = curHead;
			curHead = null;
		}
	}
	
	
	
	// this solution is not in constant space, ****the space should be n?
	public void connect1(TreeLinkNode root) {
		if(root == null) return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		TreeLinkNode tail = root;
		
		while(!queue.isEmpty()){
			TreeLinkNode cur = queue.remove();
			cur.next = queue.peek();
			// add a pointer to record the tail.
			if(cur == tail){
				tail.next = null;
				tail = tail.right;
			}
			// since perfect binary tree.
			if(cur.left != null && cur.right != null){
				queue.add(cur.left);
				queue.add(cur.right);
			}
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
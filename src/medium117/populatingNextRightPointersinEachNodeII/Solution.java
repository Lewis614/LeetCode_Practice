package medium117.populatingNextRightPointersinEachNodeII;
/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? 
 * 
 * Would your previous solution still work? --- YES!!!!
 * @author liuyisi
 *
 */

public class Solution {
	public void connect(TreeLinkNode root) {
		if(root == null) return;

		TreeLinkNode lastHead = root;
		TreeLinkNode curHead = null;
		TreeLinkNode pre = null;

		while(lastHead != null) {
			TreeLinkNode lastCur = lastHead;
			while(lastCur != null) {
				if(lastCur.left != null) {
					if(curHead == null) {
						curHead = lastCur.left;
						pre = curHead;
					}
					else {
						pre.next = lastCur.left;
						pre = pre.next;
					}
				}

				if(lastCur.right != null) {
					if(curHead == null) {
						curHead = lastCur.right;
						pre =curHead;
					}
					else {
						pre.next = lastCur.right;
						pre = pre.next;
					}

				}
				lastCur = lastCur.next;
			}
			lastHead = curHead;
			curHead = null;
		}
	}
}


class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
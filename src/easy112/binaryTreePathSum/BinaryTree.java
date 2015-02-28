/* BinaryTree.java */

package easy112.binaryTreePathSum;

import java.util.*;

import javax.swing.tree.TreeNode;





/**
 *  BinaryTree implements a Dictionary as a binary tree (unbalanced).  Multiple
 *  entries with the same key are permitted.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 *
 *  @author Jonathan Shewchuk
 **/
public class BinaryTree implements Dictionary {

	/** 
	 *  size is the number of items stored in the dictionary.
	 *  root is the BinaryTreeNode that serves as root of the tree.
	 *  If there are no items, size is zero and root is null.
	 **/
	protected int size;
	protected BinaryTreeNode root;

	/**
	 *  Construct an empty binary tree.
	 **/
	public BinaryTree() {
		makeEmpty();
	}

	/**
	 *  makeEmpty() removes all the entries from the dictionary.
	 */
	public void makeEmpty() {
		size = 0;
		root = null;
	}

	/** 
	 *  size() returns the number of entries stored in the dictionary.
	 *
	 *  @return the number of entries stored in the dictionary.
	 **/
	public int size() {
		return size;
	}

	/** 
	 *  isEmpty() tests if the dictionary is empty.
	 *
	 *  @return true if the dictionary has no entries; false otherwise.
	 **/
	public boolean isEmpty() {
		return size == 0;
	}

	/** 
	 *  insert() constructs and inserts a new Entry object, consisting of
	 *  a (key, value) pair, into the dictionary, and returns a reference to the
	 *  new Entry.  Multiple entries with the same key (or even the same key and
	 *  value) can coexist in the dictionary.
	 *
	 *  @param key the key by which the entry can be retrieved.  Must be of
	 *  a class that implements java.lang.Comparable.
	 *  @param value an arbitrary object associated with the key.
	 *  @return an Entry object referencing the key and value.
	 **/
	public Entry insert(Object key, Object value) {
		Entry entry = new Entry(key, value);
		if (root == null) {
			root = new BinaryTreeNode(entry);
		} else {
			insertHelper(entry, (Comparable) key, root);
		}

		size++;
		return entry;
	}

	/**
	 *  insertHelper() recursively does the work of inserting a new Entry object
	 *  into the dictionary.
	 *
	 *  @param entry the Entry object to insert into the tree.
	 *  @param key the key by which the entry can be retrieved.
	 *  @param node the root of a subtree in which the new entry will be
	 *         inserted.
	 **/
	private void insertHelper(Entry entry, Comparable key, BinaryTreeNode node) {
		if (key.compareTo(node.entry.key()) <= 0) {
			if (node.leftChild == null) {
				node.leftChild = new BinaryTreeNode(entry, node);
			} else {
				insertHelper(entry, key, node.leftChild);
			}
		} else {
			if (node.rightChild == null) {
				node.rightChild = new BinaryTreeNode(entry, node);
			} else {
				insertHelper(entry, key, node.rightChild);
			}
		}
	}

	/** 
	 *  find() searches for an entry with the specified key.  If such an entry is
	 *  found, it returns the Entry object; otherwise, it returns null.  If more
	 *  than one entry has the key, one of them is chosen arbitrarily and
	 *  returned.
	 *
	 *  @param key the search key.  Must be of a class that implements
	 *         java.lang.Comparable.
	 *  @return an Entry referencing the key and an associated value, or null if
	 *          no entry contains the specified key.
	 **/
	public Entry find(Object key) {
		BinaryTreeNode node = findHelper((Comparable) key, root);

		//take care of the null exception.
		if (node == null) {
			return null;
		} else {
			return node.entry;
		}
	}

	/**
	 *  Search for a node with the specified key, starting from "node".  If
	 *  a matching key is found (meaning that key1.compareTo(key2) == 0), return
	 *  a node containing that key.  Otherwise, return null.
	 *
	 *  Be sure this method returns null if node == null.
	 **/

	private BinaryTreeNode findHelper(Comparable key, BinaryTreeNode node) {
		// Replace the following line with your solution.
		if(key.compareTo(node.entry.key) < 0) {
			if(node.leftChild == null) return null;

			//recursive calling REMEMBER THIS STUPID MISTAKE I MADE. ADD THE RETURN WHEN YOU CALL IT!
			else return findHelper(key, node.leftChild);
		}
		else if (key.compareTo(node.entry.key) == 0) return node;
		else {
			if(node.rightChild == null) return null;
			else return findHelper(key, node.rightChild);
		}

		// this is the error I made more than one time!!!! recursively calling you need to 
		// return same method, or the it will give you error, saying the incompleted logic. return null;
	}

	/** 
	 *  remove() searches for an entry with the specified key.  If such an entry
	 *  is found, it removes the Entry object from the Dictionary and returns it;
	 *  otherwise, it returns null.  If more than one entry has the key, one of
	 *  them is chosen arbitrarily, removed, and returned.
	 *
	 *  @param key the search key.  Must be of a class that implements
	 *         java.lang.Comparable.
	 *  @return an Entry referencing the key and an associated value, or null if
	 *          no entry contains the specified key.
	 **/
	public Entry remove(Object key) {
		// Replace the following line with your solution.
		// Please remind that the parameter is Object, cast it to Comparable

		// *****Do take care of the Null and root situation.
		BinaryTreeNode node = findHelper((Comparable)key, root); 

		if(node == null) return null;


		//if the node is root everything should be considered seperately:if (node == root) {}
		//root.entry:this is not make sense, root is null, must trigger the NoPointerException. if you return root.entry;

		else if(node.leftChild == null && node.rightChild == null) {
			//if the node is root everything should be considered seperately:if (node == root) {}
			if(node == root) {
				root = null;
			} 
			else if(node == node.parent.leftChild) node.parent.leftChild = null;
			else if(node == node.parent.rightChild) node.parent.rightChild = null;
			// clean the pointer
			//node.parent = null;
		}
		else if (node.leftChild == null && node.rightChild != null ) {
			if(node == root) {
				root = node.rightChild;
				node.rightChild.parent = null;
			}

			else if(node == node.parent.leftChild) {
				// two side link should be added at the same time. OR next time --> execute node.parent() will have error
				node.parent.leftChild = node.rightChild;
				node.rightChild.parent = node.parent;
				// Clean memory may not necessary.
				//node.parent = null;
				//node.rightChild =null;
			}
			else if (node == node.parent.rightChild) {
				node.parent.rightChild = node.rightChild;
				node.rightChild.parent = node.parent;
				//node.parent = null;
				//node.rightChild =null;
			}
		}
		else if (node.leftChild != null && node.rightChild == null) {
			if (node == root) {
				root = node.leftChild;
				node.leftChild.parent = null;
			}

			else if(node == node.parent.leftChild) {
				node.parent.leftChild = node.leftChild;
				node.leftChild.parent = node.parent;
			}
			else if (node == node.parent.rightChild) {
				//contain a bug, but because never execute this part, it is almost ignored. 
				//node.parent.rightChild = node.leftChild  NOT node.rightChild
				node.parent.rightChild = node.leftChild;
				node.leftChild.parent = node.parent;
			}
		}
		else if (node.leftChild != null && node.rightChild != null) {
			BinaryTreeNode minMaxNode = node.rightChild;
			while(minMaxNode.leftChild != null) {
				minMaxNode = minMaxNode.leftChild;
			}
			node.entry = minMaxNode.entry;
			//it doesnt have leftnode now, but now clear on rightChlid
			//determined if it contains rightChild. 
			if(minMaxNode.rightChild == null) {
				//***********!!!!!!!!Still have two possibilities, if the while loop never executed, 
				// it is still have the chance to be the right child. You still need distinguish.
				if(minMaxNode == minMaxNode.parent.rightChild) minMaxNode.parent.rightChild = null;
				if(minMaxNode == minMaxNode.parent.leftChild) minMaxNode.parent.leftChild = null;
				//the rightChild is null, dont need to right that.parent = XX.
			}
			else if(minMaxNode.rightChild != null){
				if(minMaxNode == minMaxNode.parent.rightChild) {
					minMaxNode.parent.rightChild = minMaxNode.rightChild;
					// so complicated !! BUT I MAKE IT!!!!
					minMaxNode.rightChild.parent = minMaxNode.parent;

				}
				else if (minMaxNode == minMaxNode.parent.leftChild) {
					minMaxNode.parent.leftChild = minMaxNode.rightChild;
					//dont forget it is a double sided link, dont ignore the new node`s parent.
					minMaxNode.rightChild.parent = minMaxNode.parent;
				}

			}
		}


		// if they can arrive there that means they do find a match.
		// Dont forget the return Node should be activated at last
		// AS WELL AS size control!
		size--;
		return node.entry;
	}

	/**
	 *  Convert the tree into a string.
	 **/

	public String toString() {
		if (root == null) {
			return "";
		} else {
			return root.toString();
		}
	}

	//TestCode for Path Sum
	//http://www.cnblogs.com/springfor/p/3879825.html

	//*************************************************
	public boolean hasPathSum(BinaryTreeNode root, int sum) {

		if(root == null) return false;

		sum -=(Integer)root.entry.key;
		if(root.leftChild ==null && root.rightChild == null) return sum == 0;
		else return hasPathSum(root.leftChild, sum) || hasPathSum(root.rightChild, sum);
	}


	//-------------------------------------------------
	public int minDepth (BinaryTreeNode root) {

		if (root == null) return 0;

		// the constraints should from harder to easier.
		if (root.leftChild == null && root.rightChild == null) return 1;
		if (root.leftChild == null) return minDepth(root.rightChild)+1;
		else if (root.rightChild == null) return minDepth(root.leftChild)+1;
		else {
			return Math.min(minDepth(root.rightChild), minDepth(root.rightChild))+1;
		} 
	}

	//-------------------------------------------------
	public boolean isBalanced(BinaryTreeNode root) {
		//ask the interviewee whether the null is true or false.
		//if(root == null) return false;
		if(root == null) return true;
		if(root.leftChild != null && root.rightChild != null) {
			if (Math.abs(depth(root.leftChild) - depth(root.rightChild))> 1) return false;
			else return isBalanced(root.leftChild) && isBalanced(root.rightChild);
		}

		//different thinking style. be careful.
		else if (root.leftChild != null) {
			if (root.leftChild.leftChild== null && root.leftChild.rightChild == null) return true;
			else return false;
		}
		else if (root.rightChild != null) {
			if(root.rightChild.leftChild == null && root.rightChild.rightChild == null) return true;
			else return false;
		}
		else return true;

	}

	public int depth(BinaryTreeNode root) {
		if(root == null) return 0;
		if (root.leftChild != null && root.rightChild != null) return Math.max(depth(root.leftChild), depth(root.rightChild))+1;
		else if (root.leftChild != null) return depth(root.leftChild)+1;
		else if (root.rightChild != null) return depth(root.rightChild)+1;
		else return 1;
	}

	//-------------------------------------------------

	public List<List<Integer>> levelOrderBottom (BinaryTreeNode root) {
		List<List<Integer>> reservedList= new ArrayList<List<Integer>>();
		if(root == null) return reservedList;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		queue.add(root);

		while (!queue.isEmpty()) {
			ArrayList<BinaryTreeNode> innerList = new ArrayList<BinaryTreeNode>();
			ArrayList<Integer> innerValue = new ArrayList<Integer>();
			while(!queue.isEmpty()) {
				BinaryTreeNode node = queue.remove();
				innerList.add(node);
				innerValue.add((Integer)node.entry.key);
			}
			list.add(innerValue);

			for (int i = 0; i < innerList.size(); i++) {
				BinaryTreeNode node = innerList.get(i);
				if (node.leftChild != null) {
					queue.add(node.leftChild);
				}
				if (node.rightChild != null) {
					queue.add(node.rightChild);
				}
			}
		}

		//reverse the list
		for (int i = 0 ; i < list.size() ; i++){
			reservedList.add(list.get(list.size()-1-i));
		}

		return reservedList;

	}




	//-------------------------------------------------

	public boolean isSymmetric (BinaryTreeNode root) {
		if(root == null) return true;
		else return isSymmetric(root.leftChild, root.leftChild);
	}

	public boolean isSymmetric (BinaryTreeNode a, BinaryTreeNode b) {

		if (a == null) return b == null;
		if (b == null) return false;
		if (!a.entry.key.equals(b.entry.key)) return false;

		if(!isSymmetric(a.leftChild, b.rightChild)) return false;
		if(!isSymmetric(a.rightChild,b.leftChild)) return false;

		return true;
	}

	//-------------------------------------------------

	public boolean isSymmetric2 (BinaryTreeNode root) {
		if (root == null) return true;
		
		// remember to specify the generic type you want to use, or you have to cast the type later. 
		LinkedList<BinaryTreeNode> l = new LinkedList<BinaryTreeNode>();
		LinkedList<BinaryTreeNode> r = new LinkedList<BinaryTreeNode>();
		
		l.add(root.leftChild);
		r.add(root.rightChild);
		
		while (!l.isEmpty() && !r.isEmpty()) {
			BinaryTreeNode temp1 = l.remove();
			BinaryTreeNode temp2 = r.remove();
			
			if (temp1 != null && temp2 == null) return false;
			if (temp1 == null && temp2 != null) return false;
			if (temp1 != null && temp2 != null) {
				if(temp1.entry.key != temp2.entry.key) return false; 
				l.add(temp1.leftChild);
				l.add(temp1.rightChild);
				r.add(temp2.rightChild);
				r.add(temp2.leftChild);
			} 
		}
		return true;
	}

	//-------------------------------------------------
	//pick up every possible false and the left is true.
	
	public static boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
		if (p == null && q == null)  return true;
		else if((p == null && q != null) || (p != null && q == null)) return false;

//		key is an object!!!!!  don't use the != , use .equals() instead! if (p.entry.key != q.entry.key) return false;
		if (!p.entry.key.equals(q.entry.key)) return false;
		else {
			if (p.leftChild != null && p.rightChild != null && q.leftChild != null && q.rightChild != null){
				return isSameTree(p.leftChild, q.leftChild) && isSameTree(p.rightChild, q.rightChild);
			}

			if (p.leftChild != null && p.rightChild ==null && q.leftChild != null && q.rightChild == null){
				return isSameTree(p.leftChild, q.leftChild);
			}
				
			if (p.leftChild == null && p.rightChild !=null && q.leftChild == null && q.rightChild != null){
				return isSameTree(p.rightChild, q.rightChild);
			}
			
			if (p.leftChild == null && p.rightChild ==null && q.leftChild == null && q.rightChild == null) return true;
				
			
			return false;
		}
	
	}


/*
 * 		if (p.entry.key != q.entry.key) return false;
		else {
			if (p.leftChild != null && p.rightChild != null && q.leftChild != null && q.rightChild != null){
				if (p.leftChild.entry.key != q.leftChild.entry.key || p.rightChild.entry.key != q.rightChild.entry.key) return false;
				else return isSameTree(p.leftChild, q.leftChild) && isSameTree(p.rightChild, q.rightChild);
			}

			if (p.leftChild != null && p.rightChild ==null && q.leftChild != null && q.rightChild == null){
				if(p.leftChild.entry.key != q.leftChild.entry.key) return false;
				else return isSameTree(p.leftChild, q.leftChild);
			}
				
			if (p.leftChild == null && p.rightChild !=null && q.leftChild == null && q.rightChild != null){
				if(p.rightChild.entry.key != q.rightChild.entry.key) return false;
				else return isSameTree(p.rightChild, q.rightChild);
			}
			
			if (p.leftChild == null && p.rightChild ==null && q.leftChild == null && q.rightChild == null) return true;
				
			
			return false;
 */
	
	
	//*************************************************

	/* Tests the binary search tree. */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();

		System.out.println("Inserting 1A, 6V, 3K, 2Z, 5L, 9L:");
		
		tree.insert(new Integer(9), "L");
		tree.insert(new Integer(3), "A");
		tree.insert(new Integer(4), "V");
		tree.insert(new Integer(5), "K");
//		
		tree2.insert(new Integer(9), "L");
		tree2.insert(new Integer(3), "A");
		tree2.insert(new Integer(4), "V");
		tree2.insert(new Integer(5), "K");
		
		
//		tree.insert(new Integer(2), "Z");
		//		tree.insert(new Integer(1), "Z");
		//		tree.insert(new Integer(5), "L");
		//		tree.insert(new Integer(9), "L");
		//		tree.insert(new Integer(4), "L");
		//		tree.insert(new Integer(10), "L");
		//		tree.insert(new Integer(8), "L");
		//if the root is static type there, no metter how many trees instance you generate, the root has only one piece,
		//it will always change based on your code, so will double the result,
		/**
		 * execute these two lines:
		 * System.out.println("The tree is:  " + tree);
		 * System.out.println("The tree2 is:  " + tree2);
		 * 
		 * ---when the root is nonstatic:
		 * The tree is:  3A(4V(5K))
		 * The tree2 is:  3A(4V(5K))
		 * 
		 * ---when the root is static, "protected static BinaryTreeNode root;"
		 * The tree is:  (3A)3A((4V)4V((5K)5K))
		 * The tree2 is:  (3A)3A((4V)4V((5K)5K))

		 */
		
		System.out.println("The tree is:  " + tree);
		System.out.println("The tree2 is:  " + tree2);
		
		// static method call.
		System.out.println(BinaryTree.isSameTree(tree.root, tree2.root));
//		System.out.println(tree.isSymmetric(root));
//		System.out.println(tree.isSymmetric2(root));
//		System.out.println("Size:  " + tree.size());

		//		System.out.println(tree.minDepth(root));
//		System.out.println(tree.isBalanced(root));
//		System.out.println(tree.levelOrderBottom(root));
		//		System.out.println("\nTesting find() ...");
		//		tree.testFind(1, "A");
		//		tree.testFind(9, "L");
		//		tree.testFind(5, "L");
		//		tree.testFind(4, null);
		//		tree.testFind(6, "V");
		//		tree.testFind(3, "K");

		//		System.out.println("\nTesting remove() (for nodes with < 2 children) ...");
		//		tree.testRemove(5, "1A(((2Z)3K)6V(9L))");
		//		tree.testRemove(3, "1A((2Z)6V(9L))");
		//		tree.testRemove(1, "(2Z)6V(9L)");
		//		tree.insert(new Integer(7), "S");
		//		tree.insert(new Integer(8), "X");
		//		tree.insert(new Integer(10), "B");
		//		System.out.println("After inserting 7S, 8X, 10B:  " + tree);
		//		System.out.println("Size:  " + tree.size());
		//		if (tree.size() != 6) {
		//			System.out.println("  SHOULD BE 6.");
		//		}
		//
		//		System.out.println("\nTesting remove() (for nodes with 2 children) ...");
		//		tree.testRemove(6, "(2Z)7S((8X)9L(10B))");
		//		tree.testRemove(9, "(2Z)7S((8X)10B)");
		//		System.out.println("Size:  " + tree.size());
		//		if (tree.size() != 4) {
		//			System.out.println("  SHOULD BE 4.");
		//		}
	}

	private void testRemove(int n, String shouldBe) {
		Integer key = new Integer(n);
		System.out.print("After remove(" + n + "):  ");
		remove(key);
		System.out.println(this);
		if (!toString().equals(shouldBe)) {
			System.out.println("  SHOULD BE " + shouldBe);
		}
	}

	private void testFind(int n, Object truth) {
		Integer key = new Integer(n);
		Entry entry = find(key);
		System.out.println("Calling find() on " + n);
		if (entry == null) {
			System.out.println("  returned null.");
			if (truth != null) {
				System.out.println("  SHOULD BE " + truth + ".");
			}
		} else {
			System.out.println("  returned " + entry.value() + ".");
			if (!entry.value().equals(truth)) {
				if (truth == null) {
					System.out.println("  SHOULD BE null.");
				} else {
					System.out.println("  SHOULD BE " + truth + ".");
				}
			}
		}
	}

}

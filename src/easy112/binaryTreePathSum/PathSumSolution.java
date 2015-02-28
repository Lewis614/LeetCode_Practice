//20141113 1755-

package easy112.binaryTreePathSum;

public class PathSumSolution {

	public boolean hasPathSum(BinaryTreeNode root, int sum) {
		if (root == null) return false;
		sum -= (Integer)root.entry.value;
		if(root.leftChild != null) {
			return hasPathSum(root.leftChild, sum);
		}
		else if(root.rightChild != null) {
			return hasPathSum(root.rightChild, sum);
		}
		else {
			if(sum == 0) return true;
		}

		return false;

	}
}


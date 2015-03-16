package medium096.uniqueBinarySearchTrees;

public class Solution {
	// DP solution, 
	public int numTrees(int n) {
		// my fault to set if(n<0) only, distinguish here with the meaning of res[0]=1;
		if(n<=0) return 0;
		int[] res = new int[n+1];
		
		// if a branch without anything. 
		res[0]=1;
		
		res[1]=1;
		for( int i = 2 ; i<=n; i++) {
			for(int j = 0 ; j<i ; j++) {
				res[i] +=res[j]*res[i-j-1];
			}
		}
		return res[n];
	}
	
	public int numTrees2(int n) {
		if(n<=0) return 0;
		int[] res= new int[n+1];
		res[0]=1;
		
		for(int i = 1 ; i<=n; i++){
//OR		res[i] = 2*(2*i-1)*res[i-1]/(i+1);
			res[i+1] = 2*(2*i+1)*res[i]/(i+2);
		}
		return res[n];
	}
	
	public static void main(String[] args) {
		
	}
	
}

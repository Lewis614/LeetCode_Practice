package medium050.powFunction;

public class Solution {
	public double pow(double x, int n) {
		// base case, each case will go like 4->2->1->0 if they have the chance to multiply x 
		//to them self when go to n == 1. So if n == 0; just go unit 1.
		 if(n == 0) return 1.0;
		 double half = pow(x, n/2);
		 if(n%2 == 0) return half*half;
		 else{
			 if(n>0) return half*half*x;
			 else return half*half/x;
		 }
	}

	public static void main(String[] args){
		Solution s  =new Solution();

		System.out.println(s.pow(-3.0, -3));
		
	}
}	

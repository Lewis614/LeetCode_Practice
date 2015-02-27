/**
 * 20141121 16:15
 */
		

package easy070.climbingStairs;



public class ClimbingStairs {

	public int climbStairs(int n){
		if(n <= 0) return 0;
		if(n== 0) return 1;
		// for earlier understanding, level the dp[0] make the index consistent with stair number. so the total length should be n+1
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		// for earlier understanding, level the dp[0] make the index consistent with stair number.
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2]; 
		}
		return dp[n];
	}

	
/**
 * 
 * @param n
 * @return

	public long climbStairs(int n) {
		if (n <= 0) return 0;
		long total= 0;
		for(int twoNum = 0 ; twoNum <= n/2 ; twoNum++){
			int oneNum = n - twoNum*2;
			
		total += (factorial(twoNum+oneNum)/(factorial(oneNum)*factorial(twoNum)));
//		System.out.println(total);
		}
		
		return total;
	}
	
	//The Factorial method is famous for recursive implementation 
	
	//DO watch out the factorial should return long type!
	public long factorial (int n) {
		
		if (n <= 1) return 1;
		else {
			return factorial(n-1)*n;	
		}
	}
	*/
	
	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs(34));
		
	}
}

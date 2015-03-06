package medium062.uniquePaths;

public class Solution {
	//standard dynamic programming solution.
	
	//MY CODING CAPACITY IS SO WEAK THAT I CAN NOT SIMPLY CODE WITHOUT ECLIPSE?!
	//I NEED CHANGE AND PRACTISE!
	public int uniquePaths(int m, int n){
		if(m<=0 || n<=0) return 0;
		int[][] res = new int[m][n];
		
		for(int i = 0; i<m ; i++){
			for(int j = 0; j<n; j++){
				if(i==0 || j==0) res[i][j]=1;
				else{
					res[i][j]=res[i-1][j]+res[i][j-1];	
				}
				
			}
		}
		return res[m-1][n-1];
	}
	
	//optimal solution.
	public int uniquePaths2(int m, int n) {
		if(m<=0||n<=0) return 0;
		int[] res = new int[n];
		res[0]=1;
		for(int i = 0 ; i<m ; i++){
			for(int j = 1;j<n;j++){
				res[j] += res[j-1];
			}
		}
		return res[n-1];
	}
	
	
	//online solution based on math:
	public int uniquePaths3(int m, int n)
	{
	    double dom = 1;  
	    double dedom = 1;  
	    int small = m<n? m-1:n-1;  
	    int big = m<n? n-1:m-1;  
	    for(int i=1;i<=small;i++)  
	    {  
	        dedom *= i;  
	        dom *= small+big+1-i;  
	    }  
	    return (int)(dom/dedom);  
	}
}

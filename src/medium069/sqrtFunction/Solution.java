package medium069.sqrtFunction;

public class Solution {
	
	public int sqrt1(int x){
		if(x<0) return -1;
		
		if(x==0) return 0;
		
		int l = 1;
		//x must be >=1
		//
		int r = x/2+1;
		
		while(l<=r){
			// must => 1-1;
			int mid = (l+r)/2;
			if(mid*mid<= x && (mid+1)*(mid+1)>x) return mid;
			else if(x< mid*mid) r = mid-1;
			//watch out the mid*mid=x, even if it succeed, let l exceed to the right answer, 
			//and "if((mid-1)*(mid-1)<= x && mid*mid>x) return mid-1;" in next turn will handle it.
			else l = mid+1;
		}
		// can not access logically, you can name it any number.
		return r;
	}
	
	//My solution: Time Exceeded:2147483647 --- dont know why: 估计是int太大相乘以后越界了。
	//Because the mid*mid>x could be exceed to max Integer. you should use x/m >=m to replace.
	
	//implement binary search.
	public int sqrt(int x){
		if(x<=0) return 0;
		int l = 1;
		//x must be >=1
		//
		int r = x/2+1;
		
		while(l<=r){
			// must => 1-1;
			int mid = (l+r)/2;
			if((mid-1)*(mid-1)<= x && mid*mid>x) return mid-1;
			else if(x< (mid-1)*(mid-1)) r = mid-1;
			//watch out the mid*mid=x, even if it succeed, let l exceed to the right answer, 
			//and "if((mid-1)*(mid-1)<= x && mid*mid>x) return mid-1;" in next turn will handle it.
			else if(mid*mid<=x) l = mid+1;
		}
		
		// can not access logically, you can name it any number.
		return r;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.sqrt(2147483647));
	}
}


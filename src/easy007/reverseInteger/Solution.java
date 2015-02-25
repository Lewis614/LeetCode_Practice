package easy007.reverseInteger;


public class Solution {
	public int reserve(int x) {
		long reserveNum=0;
		int remainder = 0;
		boolean isNagetive = false;
		if(x<0){
			x=-x;
			isNagetive = true;
		}
		while(x>0) {
			remainder = x % 10;
			x = x/10;
			reserveNum = reserveNum*10+remainder;
			if(reserveNum>Integer.MAX_VALUE) return 0;
		}
		
		//casting for possible overflow.
		if(isNagetive) return -(int)reserveNum;
		else return (int)reserveNum;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.reserve(1222229991));
	}
}

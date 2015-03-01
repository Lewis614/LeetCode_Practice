package easy168.excelSheetColumnTitle;


//20150224 16:28-16:48. only one line code missing waste 30min to debug and fail in the end!!!!!!!!16:48-17:20
public class Solution {
	public String convertToTitle(int n){
		if(n<=0) return null;
		StringBuffer strBuffer  = new StringBuffer();
		while(n>0){
			int digit = n%26;
			n = n/26;
			if(digit == 0){
				strBuffer.append('Z');
				//very IMP point is here!!!! do update the n value!
				n--;
			} 
			else strBuffer.append((char)(digit+(int)('A')-1));
		}
		
		return strBuffer.reverse().toString();
		
		
	}
		
	public static void main(String[] args){
		Solution s = new Solution();
		
		System.out.println(s.convertToTitle(26));
	}
}

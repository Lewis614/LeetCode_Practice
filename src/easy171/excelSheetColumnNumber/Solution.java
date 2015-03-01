package easy171.excelSheetColumnNumber;

public class Solution {
	public int titleToNumber(String s) {
		
		if(s == null || s.length() == 0) return 0;
		char[] c = s.toCharArray();
		int sum = 0;
		for(int i = 0 ; i< c.length ; i++) {
			sum = sum*26+c[i]-64;
		}
		return sum;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.titleToNumber("AAA"));
	}

}

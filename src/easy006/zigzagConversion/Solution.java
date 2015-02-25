/**
 * Dec 5,2014, 12:55:42AM Done Easy Part! Congratulation!
 */

package easy006.zigzagConversion;


public class Solution {
	public String convert(String s, int nRows){
		
		//SpecialAction case1: distinguish the null and "" properly.
		if(s == null) return null;
		//SpecialAction case2
		if(nRows<=0) return null;
		
		if(nRows ==1) return s;
		
		char[] cArray = s.toCharArray();
		
		// String toString is writing the null, dont make the String array have null pointer
		//initial setting is very important, instead of the null
		String[] result= new String[nRows];
		for(int h = 0 ; h<result.length; h++) {
			result[h]="";
		}
		
		int i=0;
		int j=0;
		while(i<cArray.length){
			while(i<cArray.length) {
				result[j] = result[j]+cArray[i];
				i++;
				if(j==nRows-1) {
					j--;
					// break the loop and continue 
					break;
				}
				j++;
			}
			while(i<cArray.length){
				result[j] = result[j]+cArray[i];
				i++;
				if(j==0){
					j++;
					break;
				} 
				j--;
			}
		}
		String combinedString = "";
		for(int k = 0; k < result.length; k++) {
			combinedString +=result[k];
		}
		return combinedString;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
	    System.out.println(s.convert("", 1));
	}
}


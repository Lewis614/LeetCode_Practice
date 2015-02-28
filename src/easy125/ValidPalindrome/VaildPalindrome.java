package easy125.ValidPalindrome;

//public class VaildPalindrome {
//
//	public static void main (String[] args) {
//
//		VaildPalindrome vaildPalindrome = new VaildPalindrome();
//		vaildPalindrome.test();
//		String s = "Cnin C";
//		System.out.println(vaildPalindrome.isVP(vaildPalindrome.purifyStr(s)));
//	}
//
//	public String purifyStr(String s) {
//		return s.replaceAll("[\\pP|\\s]", "").toLowerCase();
//		
//	}
//	public boolean isVP(String s) {
//		if(s == "" || s.length() == 1) return true;
//		else if (s.charAt(0) != s.charAt(s.length()-1)) return false;
//			else return isVP(s.substring(1, s.length()-1));
//		}
//				
//	public void test() {
//		String s = "China";
//		System.out.println(s.charAt(0));
//		System.out.println(s.charAt(s.length()-1));
//		System.out.println(s.substring(1,s.length()-1));
//	}
//}

public class VaildPalindrome {
	public boolean isPalindrome(String s) {

		String testStr = s.replaceAll("[^A-Za-z0-9]|\\s", "").toLowerCase();
		String reverseStr = new StringBuffer(testStr).reverse().toString();
		if(testStr.length() == 0 ) return true;
		//please do mind the difference between == and .equals! 
//     	else if(testStr == reverseStr) return true;
		else if(testStr.equals(reverseStr))return true;
		else return false;
	}



	public static void main (String[] args) {
		VaildPalindrome v = new VaildPalindrome();
		System.out.println(v.isPalindrome("1a2"));
	}
}
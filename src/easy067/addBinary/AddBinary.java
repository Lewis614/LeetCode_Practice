package easy067.addBinary;


public class AddBinary {
	
	
	public String addBinary(String a , String b) {
		
		//Dont forget the null and empty string!
		if(a == null || a == "") return b;
		if(b == null || b == "") return a;
				
		int i = a.length()-1;
		int j = b.length()-1;
		int carry = 0;
		
		StringBuffer sBuffer = new StringBuffer();
		
		while(i >=0 && j>=0) {
			int digit = Integer.parseInt(a.charAt(i)+"")+Integer.parseInt(b.charAt(j)+"") + carry;
			carry = digit/2;
			digit = digit % 2;
			//translate from int back to string
			sBuffer.append(digit);
			i--;
			j--;
		}
		while(i>=0) {
			int digit = Integer.parseInt(a.charAt(i)+"") + carry;
			carry = digit / 2;
			digit =digit % 2;
			sBuffer.append(digit);
			i--;
		}
		while(j>=0) {
			int digit = Integer.parseInt(b.charAt(i)+"") + carry;
			carry = digit / 2;
			digit =digit % 2;
			sBuffer.append(digit);
			j--;
		}
		// last digit when i==0 and j==0; give them a digit.
		if(carry >0) sBuffer.append(carry);
		
		return sBuffer.reverse().toString();
		
		
	}
	public static void main(String[] args) {
		AddBinary add = new AddBinary();
		System.out.println(add.addBinary("11","1"));
		
		
		
	}
}

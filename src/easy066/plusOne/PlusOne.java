
package easy066.plusOne;

public class PlusOne {

	public int[] plusOne (int[] digits) {
		int i = digits.length -1;
		while (i>=0) {
			if(digits[i] != 9) {
				digits[i] +=1;
				return digits;
			}
			else digits[i] = 0;
			i--;
		}

		//this time the i < 0, new generate one digit.
		digits = new int[digits.length+1];
		digits[0] = 1;
		return digits;

	}

	/**
	 * 
	 * @param digits
	 * @return

	public int[] plusOne (int[] digits) {
		int i = digits.length-1;
		if(digits[i] != 9) digits[i] +=1;
		else {
			while (i>=0 && digits[i]==9) {
				digits[i] = 0;
				i -=1;
			}
			//new digit crated and give it a new object,with longer array length.
			if(i<=0) {
				digits = new int[digits.length+1];
				digits[0] = 1;
			}
		}
		return digits;
	}


	public int[] plusOne (int[] digits) {
		int i = digits.length -1;
		if(digits[i] == 0) {
			digits[i]=1;
		}
		else if(digits[i] == 1) {
			while (i>=0 && digits[i] ==1) {
				digits[i] = 0;
				i = i-1;
			}
			if (i >= 0) digits[i] = 1;
			//else do nothing:  else ;
		}
		return digits;
	}
	 */
	public static void main(String[] args) {

		int[] a = {8,9,9};
		PlusOne p = new PlusOne();
		int[] b = p.plusOne(a);
		System.out.println(b);
	}

}

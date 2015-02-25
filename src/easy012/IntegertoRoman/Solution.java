package easy012.IntegertoRoman;

//I 1  
//V 5  
//X 10  
//L 50  
//C 100  
//D 500  
//M 1,000  

public class Solution {
	public String intToRomanString (int num) {
		if(num<1 || num>3999) return "";
		int[] digits = new int[4];
		for(int i = 0 ; i<4 ; i++){
			digits[i] = num%10;
			num /=10;
		}
		StringBuffer allRes = new StringBuffer();
		allRes.append(convert(digits[3], 'M', ' ', ' '));
		allRes.append(convert(digits[2], 'C', 'D', 'M'));
		allRes.append(convert(digits[1], 'X', 'L', 'C'));
		allRes.append(convert(digits[0], 'I', 'V', 'X'));
		
		return allRes.toString();
		
	}
	public String convert(int digit, char one, char five, char ten){
		StringBuffer res = new StringBuffer();
		switch(digit) 
		{
		case 3:
			res.append(one);
		case 2: 
			res.append(one);
		case 1:
			res.append(one);
			break;
		case 4:
			res.append(one);
		case 5:
			res.append(five);
			break;
		case 6:
			res.append(five);
			res.append(one);
			break;
		case 7:
			res.append(five);
			res.append(one);
			res.append(one);
			break;
		case 8:
			res.append(five);
			res.append(one);
			res.append(one);
			res.append(one);
			break;
		case 9:
			res.append(one);
			res.append(ten);
			break;
		default:
			break;
		}
		return res.toString();
	}
}

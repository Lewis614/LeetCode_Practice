package easy038.countAndSay;

public class CountAndSay {


	public String countAndSay(int n) {
		String s = "";

		if (n == 1) return "1";
		else{
			String lastRun = countAndSay(n-1);
			char[] sArray = lastRun.toCharArray();
			int count;
			for(int i = 0; i <sArray.length ; i++) {
				count = 1;
				while(i< sArray.length-1 && sArray[i] == sArray[i+1]){
					count++;
					i++;
				}
				s += count +""+sArray[i];
			}
			return s;
		}



	}


	//************Answer by Forum *****************

	public String countAndSay1(int n) {
		String s = "";
		if (n==1) return "1";
		String prev = countAndSay1(n-1);
		int ct;
		char [] c = prev.toCharArray();
		for (int i = 0; i<c.length; ++i ){
			ct = 1;
			for (;i<c.length-1 && c[i]==c[i+1];) {
				ct++;
				i++;  
			}
			s+=ct+""+c[i];
		}
		return s;
	}

	//************Answer Doing it recursively: 
	// IF YOU PLAY WITH INTEGER, SOME NUMBER WILL CAUSE YOU OUT OF BOUND. SO YOU DO NEED TO PLAY WITH CHARARRAY*****************

	public String countAndSayString (int n) {
		if(n == 1) return "1";

		else {
			String s = countAndSayString(n-1);
			//			Remember parseInt will exceed the Integer boundary
			//			int totalNum = Integer.parseInt(s);
			long totalNum = Integer.parseInt(s);

			StringBuffer sBuffer = new StringBuffer();
			int lastdigit = (int) totalNum % 10;
			totalNum = totalNum/10;
			int count = 1;

			while(totalNum > 0) {
				int digit = (int) totalNum%10;
				totalNum = totalNum/10;
				if(digit != lastdigit) {
					sBuffer.insert(0, count +""+lastdigit);
					lastdigit = digit;
					count = 1;
				}
				else count ++;
			}
			sBuffer.insert(0,count+""+lastdigit);

			return sBuffer.toString();

		}
	}

	//************Answer One*****************
	// Wrong interpretation with the requirement. 
	public String countAndSay2 (int n) {


		if(n<0) return "";

		StringBuffer s = new StringBuffer();
		int lastDigit = n % 10;
		n = n/10;
		int count = 1;
		while (n>0) {
			int digit = n % 10;
			n = n/10;


			if(digit != lastDigit) {
				s.insert(0 , count + "" + lastDigit);
				lastDigit = digit;
				count = 1;
			}
			else {
				count++;
			}
		}

		// handle the last one
		s.insert(0,count + "" + lastDigit);

		return s.toString();
	}




	public static void main(String[] args) {
		//		StringBuffer s = new StringBuffer();
		//		s.append("111123ss");
		//		System.out.println(s.toString());
		//		System.out.println(s.reverse().toString());
		CountAndSay c= new CountAndSay();
		System.out.println(c.countAndSay(23));

	}

}

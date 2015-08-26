package LeetCode;
public class stringToLong {
	/**
	 * Converts input String to Long
	 * @param      s   the String to be converted
	 * @return     the Long value converted from s
	 * @throws     NumberFormatException  if the string does not contain a legal Long. 
	 * 			   NumberFormatException  if the string is larger than Long.MAX_VALUE or less than Long.MIN_VALUE.
	 * Limitation  Handles overflow and underflow as exceptions
	 */

	long stringToLong(String s)
	{
		// Use Regex to filter out illegal inputs
		if(!s.matches("-?\\d+")){ 
			throw new NumberFormatException("input String " + s + " is illegal number format");
		}
		// Convert a string to a long 
		long result = 0;
		boolean IsNegative = s.charAt(0)== '-';
		int start=IsNegative ? 1:0;
		for(int i=start;i<s.length();i++){
			/* Deal with overflow and underflow */
			
			if(((!IsNegative) && result > (Long.MAX_VALUE)/10 )|| ((!IsNegative) && result == (Long.MAX_VALUE)/10 && (s.charAt(i) - 48)>7)){
				
				throw new NumberFormatException("input String " + s + " out of bound (overflow)");
			}
			else if((IsNegative && (-1 * result) < (Long.MIN_VALUE)/10 ) || (IsNegative &&  (-1 * result) == (Long.MIN_VALUE)/10 ) && (s.charAt(i) - 48)>8 ){
				
				throw new NumberFormatException("input String " + s + " out of bound (underflow)");
			}
			else{
				result=result * 10 + (s.charAt(i) - 48);
			}
		}
		return IsNegative ? -result : result;
	}
	// test on correctness
	void test()
	{
		long a = stringToLong("9223372036854775807"), b = stringToLong("-9223372036854775808");
		long c = stringToLong("12342435436234"), d = stringToLong("-12342435436234");
		if (a == 9223372036854775807L && b==-9223372036854775808L && c==12342435436234L && d==-12342435436234L)
			// success
			System.out.println("correct\n");
		else
			// failure
			System.out.println("wrong\n");
	}
	// test on illegal inputs
	void test_exceptions(int type){
		switch(type){
		case 1: long x = stringToLong("1@#$1342134");
		case 2: long y = stringToLong("9223372036854775808");
		case 3: long z = stringToLong("-9223372036854775809");
		}
	}

	public static void main(String[] args) {
		stringToLong s=new stringToLong();

		s.test();
		//test on illegal inputs, change parameter from 1 to 3
		s.test_exceptions(2);
	}

}

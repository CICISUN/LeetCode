package LeetCode;

public class numberToWords {
	static String[] twodigits = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static String[] thousands = {"", "Thousand", "Million", "Billion"};
	
	public static String numberToWords(int num) {
		if(num==0) return "Zero";
		String result="";
		int i=0;
		while(num>0){
			if(num%1000>0){
				result += helper(num%1000) + thousands[i];
			}
			num/=1000;
			i++;
		}
		return result;
	}
	private static String helper(int num){
		if(num==0) return ""; //edge case
		if(num<20){
			return twodigits[num] + " ";//1-19
		}
		if(num<100){
			return tens[num/10] + " " + twodigits[num%10];//21-99
		}
		else{
			return twodigits[num/100] + " Hundred " + helper(num%100);//100-999
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

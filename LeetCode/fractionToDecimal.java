package LeetCode;

import java.util.HashMap;

public class fractionToDecimal {

	public String fractionToDecimal(int num, int den) {
		StringBuilder sb = new StringBuilder();
		if(num == 0 || den==0) return "0";
		//sign
		sb.append(((num > 0) ^ (den > 0)) ? "-" : "");
		//integer
		long numerator = Math.abs((long)num);
		long denominator = Math.abs((long)den);
		sb.append(numerator/denominator);
		long residual=numerator%denominator;
		if(residual==0) return sb.toString();
		//factorial
		sb.append(".");
		HashMap<Long, Integer> map=new HashMap<Long, Integer>();
		map.put(residual, sb.length());
		while(residual!=0){
			sb.append(residual*10 / denominator);
			residual=(residual*10) % denominator;
			if(map.containsKey(residual)){
				sb.insert(map.get(residual), "(");
				sb.append(")");
				break;
			}
			else{
				map.put(residual, sb.length());
			}
		}
		return sb.toString();  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fractionToDecimal(1,8);
	}

}

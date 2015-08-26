import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class largestNumber {
	
    private class StringComparator implements Comparator<String> {
        public int compare(String x, String y) {
            if (x.equals(y)) return 0;            
            return -(x+y).compareTo(y+x);
        }
    }


	public String largestNumber(int[] num){
		String[] nums = new String[num.length];
		for(int i =0 ;i<num.length;i++){
			nums[i]=String.valueOf(num[i]);
		}
		Comparator<String> comparator = new StringComparator();
		Arrays.sort(nums,comparator);

		StringBuilder str = new StringBuilder();
		for(String n:nums){
			str.append(n);
		}
		return str.charAt(0)=='0'?"0":str.toString();
	}
	
	public String largestNumber2(int[] num) {
        ArrayList snum=new ArrayList<String>();
        for(int i=0;i<num.length;i++){
            snum.add(String.valueOf(num[i]));
        }
        
        StringBuilder sb=new StringBuilder();
        
        Collections.sort(snum, new Comparator<String>(){
			public int compare(String a, String b) {
			    if (a.equals(b)) return 0;
				return -(a+b).compareTo(b+a);
			}
		});
       
        for(int i=0;i<snum.size();i++){
            sb.append(snum.get(i));
        }
        
        return sb.charAt(0)=='0'?"0":sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="433",b="343";
		System.out.println(s.compareTo(b));
	}

}

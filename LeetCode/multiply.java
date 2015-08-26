
public class multiply {
	public String multiply(String num1, String num2) {
		int[] tmp= new int[num1.length()+num2.length()];
		StringBuilder res=new StringBuilder();
		int j=0,i,num,carries=0;
		for( i = num1.length()-1; i>=0 ;i--){
			 carries=0; num=0;
			for( j = num2.length()-1; j>=0;j--){
			   
				num=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+tmp[i+j+1]+carries;
				tmp[i+j+1]=num%10;
				carries=num/10;
				System.out.println("num"+num+"carries"+carries+"tmp"+tmp[i+j+1]);
			}
			tmp[i+j+1]=carries;
		}
		i=0;
		while(i<tmp.length-1&&tmp[i]==0){i++;}
		while(i<tmp.length){res.append(tmp[i++]);}
		return res.toString();
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiply m=new multiply();
		System.out.println(m.multiply("9", "99"));
	}

}

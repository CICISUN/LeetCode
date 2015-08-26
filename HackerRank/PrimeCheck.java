package HackerRank;

import java.util.Scanner;

public class PrimeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int s = 0;
        s = in.nextInt();
        for(int i=2 ;i<s;i++){
        	if(s%i==0)
        		{for(int j=s-1; j>=i; j--){
        			if(s%j==0) {System.out.println("Not Prime");System.out.println(j);return;}}}
        }
        System.out.println("Prime");
	}

}

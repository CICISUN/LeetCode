package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Palindrome {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String s = "";
        s = in.nextLine();
        if(s==null||s.length()==0) {System.out.println("Palindrome"); return;}
	        s=s.toUpperCase();
	        int l=0, r=s.length()-1;
	        while(l<r){
	            Character tmpl=s.charAt(l), tmpr=s.charAt(r);
	            if(!(tmpl>='0'&& tmpl<='9'||tmpl>='A'&&tmpl<='Z')) {l++; continue;}
	            else if(!(tmpr>='0'&& tmpr<='9'||tmpr>='A'&&tmpr<='Z')) {r--;continue;}
	            else{
	            	if(tmpl.equals(tmpr)){l++;r--;}
	                else {System.out.println("Not Palindrome"); return;}
	            }
	           
	        }
	        System.out.println("Palindrome");
    }
}
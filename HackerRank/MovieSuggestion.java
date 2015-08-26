package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieSuggestion {
    public static void main(String args[] ) throws Exception {
    	String [] listofm = {"The Shawshank Redemption",
    			"The Godfather",
    			"The Godfather: Part II",
    			"The Dark Knight",
    			"Pulp Fiction",
    			"The Good, the Bad and the Ugly",
    			"Schindler's List",
    			"12 Angry Men",
    			"The Lord of the Rings: The Return of the King",
    			"Fight Club",
    			"The Lord of the Rings: The Fellowship of the Ring",
    			"Star Wars: Episode V - The Empire Strikes Back",
    			"Inception",
    			"Forrest Gump",
    			"One Flew Over the Cuckoo's Nest",
    			"The Lord of the Rings: The Two Towers",
    			"Goodfellas",
    			"The Matrix",
    			"Star Wars",
    			"Seven Samurai",};
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
        Scanner in = new Scanner(System.in);
        String input = "";
        ArrayList<String> res = new ArrayList<String>();

        input = in.nextLine().toLowerCase();
        input = input.replace("the", "");
        
        String[] copy = listofm.clone();
        
        for(int j=0; j<copy.length;j++){
//        for(String each: copy){
        	copy[j] = copy[j].toLowerCase();
        	copy[j] = copy[j].replace("the", "").trim();
//        	System.out.println(copy[j]);
        	for(int i=0;i<input.length();i++){
        				if(input.charAt(i) != copy[j].charAt(i)) break;
        				if(i==input.length() - 1) {
        					res.add(listofm[j]);
        					}
        	}
        }
        if(res.size() == 0){ System.out.println("No results");}
        for(String out: res){
        	System.out.println(out);
        }
        
    }
}



package LeetCode;

import java.util.LinkedList;

public class SurroundedRegions {
	
	  class Pair{
	        int x;
	        int y;
	        public Pair(int x, int y){this.x=x;this.y=y;}
	    }
	    
	    public void solve(char[][] board) {
	        if(board==null || board.length==0) return;
	        int rows=board.length;
	        int cols=board[0].length;
	        LinkedList<Pair> q = new LinkedList<Pair>();
	        for(int i=0; i<rows;i++){
	            if(board[i][0]=='O'){
	                q.offer(new Pair(i, 0));
	            }
	            if(board[i][cols-1]=='O'){
	                q.offer(new Pair(i, cols-1));
	            }
	        }
	        for(int i=0; i<cols;i++){
	            if(board[0][i]=='O'){
	                q.offer(new Pair(0, i));
	            }
	            
	            if(board[rows-1][i]=='O'){
	                q.offer(new Pair(rows-1, i));
	            }
	        }
	        while(!q.isEmpty()){
	  
	            Pair cur=q.poll();
	            int x=cur.x; int y=cur.y;
	            board[x][y]='#';
	            print(board);
	            if(x-1 >=0 && board[x-1][y]=='O'){q.offer(new Pair(x-1, y));}
	            if(x+1 <rows && board[x+1][y]=='O'){q.offer(new Pair(x+1, y));}
	            if(y-1 >=0 && board[x][y-1]=='O'){q.offer(new Pair(x, y-1));}
	            if(y+1 <cols && board[x][y+1]=='O'){q.offer(new Pair(x, y+1));}
	        }
	        
	        for(int i=0; i<rows; i++){
	            for(int j=0; j<cols; j++){
	                if(board[i][j]=='O') board[i][j]='X';
	                if(board[i][j]=='#') board[i][j]='O';
	            }
	        }
	    }
	    
	    public void print(char[][] c){
	    	System.out.println("-----------");
	    	for(int i=0; i<c.length; i++){
	    		String s ="";
	    		for(int j=0; j<c[0].length; j++){
	    			s = s + " " + c[i][j];
	    		}
	    		System.out.println(s);
	    	}
	    	System.out.println("-----------");
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] s ={
				{'X', 'O', 'X'},
				{'O', 'X', 'O'},
				{'X', 'O', 'X'}
		};
		
		SurroundedRegions ss = new SurroundedRegions();
		ss.solve(s);
		
	}

}

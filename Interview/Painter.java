package Interview;

public class Painter {
	
	class Color{
		int rgb;
	}

	void helper(Color[][] image, int x, int y, Color newColor) {
		//check input
		if(image==null || image.length==0) return;
		if(x<0 || x>image.length-1 || y<0 || y>image[0].length-1) return;
		helper(image, x, y, newColor, image[x][y]);
	}

	void helper(Color[][] image, int x, int y, Color newColor, Color orig){
		//check boundary
		if(x<0 || x>image.length-1 || y<0 || y>image[0].length-1 || image[x][y].equals(newColor) || !image[x][y].equals(orig)) return;
		//replace cur color
		image[x][y] = newColor;
		//move right
		helper(image, x, y+1, newColor, orig);
		//move down
		helper(image, x+1, y, newColor, orig);
		//move left
		helper(image, x, y-1, newColor, orig);
		//move up
		helper(image, x-1, y, newColor, orig);
	} 



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

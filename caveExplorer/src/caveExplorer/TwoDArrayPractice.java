package caveExplorer;

public class TwoDArrayPractice {
	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(String[] row: pic) {
			for(int col = 0; col < row.length; col++) {
				row[col] = "L";
			}
		}
	// 	drawHorizontalLine(pic,2);
	//	drawVerticalLine(pic,3);
	//	drawSlot(pic,0,9);
		drawBox(pic,2,4);
		print(pic);
		
	}
	private static void drawBox(String[][] pic, int i, int j) {
		drawSlot(pic,i,j);
		drawSlot(pic,i+1,j);
		drawAt("_",pic,i+1,j);
		for(int k=j-1;k<j+2;k++) {
			pic[i-1][k] = "_";
		}
	
	}
	private static void drawAt(String string, String[][] pic, int row, int col) {
		if(row >= 0 && row < pic.length && col >= 0 && col < pic[row].length) {
			pic[row][col] = string;
		}
		
	}
	private static void drawSlot(String[][] pic, int row, int col) {
		if(row >= 0 && row < pic.length) {
			if(col-1 >=0 ) {
				pic[row][col-1] = "|";
			}
			if(col+1 <= pic[row].length-1) {
				pic[row][col+1] = "|";
			}
		}
	}
	private static void drawVerticalLine(String[][] pic, int col) {
		for(int i=0;i<pic.length;i++) {
			pic[i][col] = "|";
		}
	}
	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int i=0;i<pic[row].length;i++) {
			pic[row][i] = "-";
		}
		
	}
	public static void print(String[][] pic) {
		for(String[] row:pic) {
			for(String col:row) {
				System.out.print(col);
			}
			System.out.println("");
		}
	}
}

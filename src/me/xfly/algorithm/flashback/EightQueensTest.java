package me.xfly.algorithm.flashback;

public class EightQueensTest {
	int[] result = new int[8];
	
	public static void main(String[] args) {
		new EightQueensTest().calEightQueens(0);
	}
	
	private void calEightQueens(int row) {
		if (row == 8) {
			printQueens();
			return;
		}
		
		for (int i = 0; i < 8; i++) {
			if (isOk(row, i)) {
				result[row] = i;
				calEightQueens(row+1);
			}
		}
	}
	
	private boolean isOk(int row,int column) {
		int leftUp = column -1,rightUp = column+1;
		
		for (int i = row - 1; i >=0; i--) {
			if (result[i] == column) {
				return false;
			}
			
			if (leftUp >= 0 && result[i] == leftUp) {
				return false;
			}
			if (rightUp <= 8 && result[i] == rightUp) {
				return false;
			}
			--leftUp;
			++rightUp;
		}
		
		return true;
	}
	
	private void printQueens() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (result[i] == j) {
					System.out.print(" Q ");
				}else {
					System.out.print(" * ");
				}
				
			}
			System.out.println();
		}
		System.out.println();
	}
}

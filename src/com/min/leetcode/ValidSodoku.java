
public class ValidSodoku {

	/** 
	 * @author Min
	 * @date Jun 5, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
		isValidSudoku(board);
	}	

	public static boolean isValidSudoku(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}
		for(int i = 0; i < 9; i++) {
			boolean[] check = new boolean[9];
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					if(check[board[i][j] - '1']) {
						return false;
					} else {
						check[board[i][j] - '1'] = true;
					}
				}
			}
		}

		for(int j = 0; j < 9; j++) {
			boolean[] check = new boolean[9];
			for(int i = 0; i < 9; i++) {
				if(board[i][j] != '.') {
					if(check[board[i][j] - '1']) {
						return false;
					} else {
						check[board[i][j] - '1'] = true;
					}
				}
			}
		}

		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					System.out.println("i = " + i + " j = " + j + " block = " + block);
					if (board[i][j] != '.') {
						if (m[(int) (board[i][j] - '1')]) {
							return false;
						}
						m[(int) (board[i][j] - '1')] = true;
					}
				}
			}
		}
		return true;
	}
	
}

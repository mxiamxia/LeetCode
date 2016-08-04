import java.util.LinkedList;
import java.util.Queue;


public class SurroundRegion {

	/** 
	 * @author Min
	 * @date Sep 16, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'O'}};
		new SurroundRegion().solve(board);
	}
	
	    Queue<Integer> queue = new LinkedList<Integer>();
	    public void solve(char[][] board) {
	        if(board == null || board.length == 0) {
	            return;
	        }
	        int rLen = board.length;
	        int cLen = board[0].length;
	        for(int i=0; i<rLen; i++) {
	            if(board[i][0] == 'O') {
	                bfs(board, i, 0);
	            }
	            if(board[i][cLen-1] == 'O') {
	                bfs(board, i, cLen-1);
	            }
	        }
	        for(int j=0; j<cLen; j++) {
	            if(board[0][j] == 'O') {
	                bfs(board, 0, j);
	            }
	            if(board[rLen-1][j] == 'O') {
	                bfs(board, rLen-1, j);
	            }
	        }
	        for(int i=0; i<rLen; i++) {
	            for(int j=0; j<cLen; j++) {
	                if(board[i][j] == '#') {
	                    board[i][j] = 'O';
	                }else if(board[i][j] == 'O') {
	                    board[i][j] = 'X';
	                }
	            }
	        }
	    }
	    public void bfs(char[][] board, int i, int j) {
	        int n = board[0].length;
	        fill(board, i, j);
	        while(!queue.isEmpty()) {
	            int cur = queue.poll();
				int x = cur / n;
				int y = cur % n;
	            fill(board, x-1, y);
	            fill(board, x+1, y);
	            fill(board, x, y-1);
	            fill(board, x, y+1);
	        }
	    }
	    
	    public void fill(char[][] board, int i, int j) {
	        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O') {
	            return;
	        }
	        queue.add(i*board[0].length + j);
	        board[i][j] = '#';
	    }

}

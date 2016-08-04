
public class Search2DMatrix {

	/** 
	 * @author Min
	 * @date Jul 22, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,3}};
		searchMatrix(input, 3);
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int l = 0;
        int h = matrix.length-1;
        while(l<=h) {
            int mid = (l+h)/2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int rowIdx = h; // rowindex is last high - 1 or last low
        if(rowIdx < 0) {
            return false;
        }
        int rl = 0;
        int rh = matrix[0].length-1;
        while(rl<=rh) {
            int mid = (rl+rh)/2;
            if(matrix[rowIdx][mid] == target) {
                return true;
            } else if(matrix[rowIdx][mid] > target) {
            	rh = mid - 1;
            } else {
                rl = mid + 1;
            }
        }
        return false;
    }

}

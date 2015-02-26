//20141123 14:25
package easy036.validSudoku;


public class Solution {

	//ANSWER FROM LinHuan ---if you use map and the value is the key, it will give you a very quick O(n^2) solution.
	//20150223 1215-
	public boolean isValidSudoku_map(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9) return false;
		
		//if column is valid.
		for(int i = 0; i <9; i++){
			boolean[] map = new boolean[9];
			for(int j = 0; j<9; j++){
				if(board[i][j] != '.'){
					if(map[board[i][j]-'1']) return false;
					
					map[board[i][j] -'1'] =true;
				}
			}
		}
		//if row is valid.
		for(int j = 0; j<9; j++) {
			boolean[] map = new boolean[9];
			for(int i = 0; i<9; i++){
				if(board[i][j] != '.'){
					if(map[board[i][j]-'1']) return false;
					
					map[board[i][j]-'1']= true;
				}
			}
		}
		
		//if block is valid.
		for(int block = 0; block<9; block++){
			boolean[] map = new boolean[9];
			for(int i = block/3*3; i<block/3*3+3; i++){
				for(int j = block%3*3; j<block%3*3+3; j++){
					if(board[i][j] != '.'){
						if(map[board[i][j]-'1']) return false;
						
						map[board[i][j] -'1'] = true;
					}
					
				}
			}
		}
		
		return true;
	}
	
	// my answer is much more complicated!
	public boolean isValidSudoku(char[][] board) {
		if (board == null) return false;
		if (board.length != 9) return false;
		if(board.length == 9) {
			// no need to do that loop.
			for(int i = 0; i<9 ; i++) {
				if(board[i].length != 9) return false;
			}
		}


		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9; j++){
				if(board[i][j] != '.') {
					for(int k = j+1; k<9; k++) {
						if(board[i][j] ==board[i][k]) return false;
					}
				}
			}
		}
		for(int j = 0 ; j < 9 ; j++) {
			for(int i = 0 ; i < 9; i++){
				if(board[i][j] != '.') {
					for(int k = i+1; k<9; k++) {
						if(board[i][j] ==board[k][j]) return false;
					}
				}
			}
		}
		for(int n = 0; n<3; n++){
			for(int m = 0; m<3 ; m++) {
				int charL = 0;
				char[] compare = new char[9];
				for(int i = 3*n; i< 3*n+3; i++) {
					for(int j = 3*m; j < 3*m+3; j++) {
						compare[charL] =board[i][j];
						charL++;
					}
				}
				for(int k= 0 ; k<9; k++) {
					if(compare[k] !='.') {
						for(int h = k+1; h<9;h++) {
							if(compare[k] ==compare[h]) return false;
						}
					}
				}
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] c= 
			{{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(s.isValidSudoku(c));
	}
}

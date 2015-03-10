package medium079.wordSearch;

public class Solution {
	public boolean exist(char[][] board, String word){
		if(word == null || word.length() == 0) return true;
		if(board == null || board.length == 0 || board[0].length == 0) return false;
		
		boolean[][] used = new boolean[board.length][board[0].length];
		int index = 0;
		for(int i = 0 ; i< board.length; i++){
			for(int j = 0; j< board[0].length; j++){
				
					if(search(board, word, used, index, i, j)) return true;
				}
		}
		return false;
		
	}
	
	public boolean search(char[][] board, String word, boolean[][] used, int index, int row, int col){
		if(index == word.length()) return true;
		if(row<0 || col<0 || row>=board.length || col>=board[0].length || used[row][col] || word.charAt(index) !=board[row][col])
			return false;
		used[row][col] =true;
		
		//rememeber the search result may help you to decide upper level recursion, so it must have return value. 
		boolean res = search(board, word, used, index+1, row-1, col) ||
				search(board, word, used, index+1, row, col+1) ||
				search(board, word, used, index+1, row+1, col) ||
				search(board, word, used, index+1, row, col-1);
		
		//reset the "used setting" back.
		used[row][col] = false;
		return res;
	}
}

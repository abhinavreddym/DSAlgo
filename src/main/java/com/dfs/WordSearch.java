package com.dfs;

public class WordSearch {
	public boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, int i, int j, String word, int index) {

		if (index >= word.length())
			return true;

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index))
			return false;

		char temp = board[i][j];
		board[i][j] = ' ';

		boolean res = (dfs(board, i + 1, j, word, index + 1) || dfs(board, i - 1, j, word, index + 1)
				|| dfs(board, i, j + 1, word, index + 1) || dfs(board, i, j - 1, word, index + 1));

		board[i][j] = temp;

		return res;

	}
	
	public static void main(String[] args) {
		WordSearch obj = new WordSearch();
		
		System.out.println(obj.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
	}
}

/**
 * 单词搜索
 * @author georgechou
 * @link https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {
	private int[][] opt = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		int wordIndex = 0;
		visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(wordIndex) == board[i][j]) {
					// 寻找相邻元素是否满足要求
					if (check(board, word, wordIndex + 1, i, j)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean check(char[][] board, String word, int wordIndex, int x, int y) {
		if (wordIndex == word.length()) {
			return true;
		}

		visited[x][y] = true;
		char letter = word.charAt(wordIndex);
		for (int optIndex = 0; optIndex < 4; optIndex++) {
			int i = x + opt[optIndex][0];
			int j = y + opt[optIndex][1];
			if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || letter != board[i][j] || visited[i][j]) {
				continue;
			}

			if (check(board, word, wordIndex + 1, i, j)) {
				return true;
			}
		}

		visited[x][y] = false;

		return false;
	}
}

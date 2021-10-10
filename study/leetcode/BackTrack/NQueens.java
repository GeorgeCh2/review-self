package life.codecook.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 * @author georgechou
 * @link https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {
	private final List<List<String>> res = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		// 初始化棋盘
		char[][] board = new char[n][n];
		for (char[] chars : board) {
			Arrays.fill(chars, '.');
		}

		backTrack(board, 0, n);
		return res;
	}

	/**
	 * 回溯算法穷举所有可能
	 * @param board
	 * @param row
	 * @param n
	 */
	private void backTrack(char[][] board, int row, int n) {
		// 列举到最后一行，说明存在满足情况的可能，加入到结果中
		if (row == n) {
			res.add(charToList(board));
			return;
		}

		for (int i = 0; i < n; i++) {
			// 判断能否在该位置放置皇后
			if (!isValid(board, row, i)) {
				continue;
			}

			// 做选择
			board[row][i] = 'Q';

			// 递归下一行
			backTrack(board, row+1, n);

			// 取消选择
			board[row][i] = '.';
		}
	}

	private boolean isValid(char[][] board, int row, int col) {
		int n = board.length;

		// 上方是否存在皇后
		for (char[] chars : board) {
			if ('Q' == chars[col]) {
				return false;
			}
		}

		// 右上方是否存在皇后
		for (int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
			if ('Q' == board[i][j]) {
				return false;
			}
		}

		// 左上方是否存在皇后
		for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
			if ('Q' == board[i][j]) {
				return false;
			}
		}

		return true;
	}

	private List<String> charToList(char[][] board) {
		List<String> list = new ArrayList<>();

		for (char[] chars : board) {
			list.add(String.copyValueOf(chars));
		}

		return list;
	}
}

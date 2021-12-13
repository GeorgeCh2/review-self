/**
 * 省份数量
 * @author georgechou
 * @link https://leetcode-cn.com/problems/number-of-provinces/
 */
public class ProvinceNumber {
	public int findCircleNum(int[][] isConnected) {
		int citizens = isConnected.length, provinces = 0;
		boolean[] visited = new boolean[citizens];
		for (int i = 0; i < citizens; i++) {
			if (!visited[i]) {
				dfs(isConnected, visited, i);
				provinces++;
			}
		}

		return provinces;
	}

	private void dfs(int[][] isConnected, boolean[] visited, int i) {
		for (int j = 0; j < isConnected.length; j++) {
			if (1 == isConnected[i][j] && !visited[j]) {
				visited[j] = true;
				// 深度遍历连接的所有城市
				dfs(isConnected, visited, j);
			}
		}
	}
}

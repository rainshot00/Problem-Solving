import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	static int n = 100;
	static int startY, startX;
	static int[][] arr = new int[n][n];
	static boolean[][] visited;

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static boolean bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { startY, startX });
		visited[startY][startX] = true;

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int step = 0; step < 4; step++) {
				int yy = pos[0] + dy[step];
				int xx = pos[1] + dx[step];

				if (arr[yy][xx] == 3) {
					return true;
				}

				if (yy < 0 || yy >= n || xx < 0 || xx >= n) {
					continue;
				}

				if (arr[yy][xx] == 1 || visited[yy][xx]) {
					continue;
				}

				q.add(new int[] { yy, xx });
				visited[yy][xx] = true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int testcase = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				String str = br.readLine().trim();

				for (int k = 0; k < n; k++) {
					arr[i][k] = str.charAt(k) - '0';

					if (arr[i][k] == 2) {
						startY = i;
						startX = k;
					}
				}
			}

			visited = new boolean[n][n];

			sb.append("#" + testcase + " " + (bfs() ? 1 : 0) + "\n");
		}

		System.out.println(sb.toString());
	}

}

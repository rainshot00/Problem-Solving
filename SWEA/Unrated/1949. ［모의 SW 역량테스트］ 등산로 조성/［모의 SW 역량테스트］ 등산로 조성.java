import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int n, k, ans;
	static int[][] arr;
	static List<int[]> l;
	static boolean[][] visited;

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void road(int y, int x, int len, boolean canDig) {
		for (int step = 0; step < 4; step++) {
			int yy = y + dy[step];
			int xx = x + dx[step];

			if (yy < 0 || yy >= n || xx < 0 || xx >= n)
				continue;

			if (visited[yy][xx])
				continue;

			if (canDig) {
				for (int i = 1; i <= k; i++) {
					arr[yy][xx] -= i;

					if (arr[y][x] > arr[yy][xx]) {
						visited[yy][xx] = true;
						road(yy, xx, len + 1, false);
						visited[yy][xx] = false;
					}

					arr[yy][xx] += i;
				}
			}

			if (arr[y][x] > arr[yy][xx]) {
				visited[yy][xx] = true;
				road(yy, xx, len + 1, canDig);
				visited[yy][xx] = false;
			}
		}

		ans = Math.max(ans, len);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			l = new ArrayList<int[]>();

			int maxHeight = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());

					maxHeight = Math.max(maxHeight, arr[i][k]);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					if (arr[i][k] == maxHeight) {
						l.add(new int[] { i, k });
					}
				}
			}

			ans = -1;
			for (int[] pos : l) {
				visited = new boolean[n][n];
				visited[pos[0]][pos[1]] = true;
				road(pos[0], pos[1], 1, true);
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}

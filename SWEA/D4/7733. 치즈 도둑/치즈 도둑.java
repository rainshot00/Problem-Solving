import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, ans;
	static int[][] arr;
	static boolean[][] visited;

	static void check() {
		int res = 0;

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (arr[i][k] != -1 && !visited[i][k]) {
					count(i, k);
					res++;
				}
			}
		}

		ans = Math.max(ans, res);
	}

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void count(int y, int x) {
		visited[y][x] = true;

		for (int step = 0; step < 4; step++) {
			int yy = y + dy[step];
			int xx = x + dx[step];

			if (yy < 0 || yy >= n || xx < 0 || xx >= n) {
				continue;
			}

			if (arr[yy][xx] == -1 || visited[yy][xx]) {
				continue;
			}

			count(yy, xx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			n = Integer.parseInt(br.readLine());
			ans = 1;
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}

			for (int day = 1; day <= 100; day++) {
				for (int i = 0; i < n; i++) {
					for (int k = 0; k < n; k++) {
						if (arr[i][k] <= day) {
							arr[i][k] = -1;
						}
					}
				}

				visited = new boolean[n][n];
				check();
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}

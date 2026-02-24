import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int n, w, h, ans;

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void marble(int cnt, int[][] board, boolean[][] checked) {
		if (cnt == n) {
			int res = 0;

			for (int i = 0; i < h; i++) {
				for (int k = 0; k < w; k++) {
					if (board[i][k] != 0) {
						res++;
					}
				}
			}

			ans = Math.min(ans, res);
			return;
		}

		for (int marblePos = 0; marblePos < w; marblePos++) {
			Queue<int[]> q = new ArrayDeque<>();
			int[][] arr = new int[h][w];
			boolean[][] visited = new boolean[h][w];

			// 2차원 배열을 copy method로 간단하게 복사하는 법?
			for (int i = 0; i < h; i++) {
				for (int k = 0; k < w; k++) {
					arr[i][k] = board[i][k];
					visited[i][k] = checked[i][k];
				}
			}

			for (int i = 0; i < h; i++) {
				if (arr[i][marblePos] != 0) {
					q.add(new int[] { i, marblePos });
					break;
				}
			}

			while (!q.isEmpty()) {
				int[] bomb = q.poll();
				int y = bomb[0];
				int x = bomb[1];
				int power = arr[y][x];
				arr[y][x] = 0;

				for (int step = 0; step < 4; step++) {
					for (int range = 0; range < power; range++) {
						int yy = y + dy[step] * range;
						int xx = x + dx[step] * range;

						if (yy < 0 || yy >= h || xx < 0 || xx >= w)
							continue;

						if (arr[yy][xx] == 0 || visited[yy][xx])
							continue;

						visited[yy][xx] = true;
						q.add(new int[] { yy, xx });
					}
				}
			}

			for (int x = 0; x < w; x++) {
				for (int y = h - 2; y >= 0; y--) {
					if (arr[y][x] != 0) {
						int yy = y;

						while (yy + 1 < h && arr[yy + 1][x] == 0) {
							arr[yy + 1][x] = arr[yy][x];
							visited[yy + 1][x] = visited[yy][x];

							arr[yy][x] = 0;
							visited[yy][x] = false;

							yy++;
						}
					}
				}
			}

			marble(cnt + 1, arr, visited);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			ans = 987654321;

			int[][] arr = new int[h][w];
			boolean[][] visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < w; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}

			marble(0, arr, visited);

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}

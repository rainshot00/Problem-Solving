import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, maxHeight;
	static int[][] arr;
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };
	static int ans = 0;

	public static void check(int rain) {
		boolean[][] check = new boolean[n][n];
		int tmp = 0;

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (arr[i][k] <= rain) {
					check[i][k] = true;
				}
			}
		}

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (check[y][x])
					continue;

				Queue<int[]> q = new ArrayDeque<>();

				q.add(new int[] { y, x });
				check[y][x] = true;

				while (!q.isEmpty()) {
					int[] now = q.poll();

					for (int step = 0; step < 4; step++) {
						int yy = now[0] + dy[step];
						int xx = now[1] + dx[step];

						if (yy < 0 || yy >= n || xx < 0 || xx >= n)
							continue;

						if (arr[yy][xx] > rain && !check[yy][xx]) {
							check[yy][xx] = true;
							q.add(new int[] { yy, xx });
						}
					}
				}

				tmp++;
			}
		}

		ans = Math.max(ans, tmp);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		maxHeight = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, arr[i][k]);
			}
		}

		for (int i = 0; i <= maxHeight; i++) {
			check(i);
		}

		System.out.println(ans);
	}

}

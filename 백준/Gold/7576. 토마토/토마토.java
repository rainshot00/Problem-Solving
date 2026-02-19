import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans, tomatoCount;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q = new ArrayDeque<>();

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void tomato(int res, int cnt) {
		if (tomatoCount == cnt) {
			ans = res;
			return;
		}

		int size = q.size();
		boolean flag = false;

		for (int s = 0; s < size; s++) {
			int[] pos = q.poll();
			int y = pos[0];
			int x = pos[1];

			if (!visited[y][x]) {
				visited[y][x] = true;
				flag = true;
			}

			for (int step = 0; step < 4; step++) {
				int yy = y + dy[step];
				int xx = x + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= m) {
					continue;
				}

				if (arr[yy][xx] != 0 || visited[yy][xx]) {
					continue;
				}

				arr[yy][xx] = 1;
				cnt++;
				q.add(new int[] { yy, xx });
			}
		}

		if (!flag) {
			ans = -1;
			return;
		}

		tomato(res + 1, cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];
		tomatoCount = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < m; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());

				if (arr[i][k] == 1) {
					q.add(new int[] { i, k });
				}

				if (arr[i][k] == 0) {
					tomatoCount++;
				}
			}
		}

		tomato(0, 0);

		System.out.println(ans);
	}

}

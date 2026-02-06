import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans;
	static int[][] arr;
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];

		q.add(new int[] { 0, 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			int y = now[0];
			int x = now[1];
			int cnt = now[2];

			if (y == n - 1 && x == m - 1) {
				ans = cnt;
				break;
			}

			for (int step = 0; step < 4; step++) {
				int yy = y + dy[step];
				int xx = x + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= m)
					continue;

				if (visited[yy][xx] || arr[yy][xx] == 0)
					continue;

				visited[yy][xx] = true;
				q.add(new int[] { yy, xx, cnt + 1 });
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		ans = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < m; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		System.out.println(ans);
	}
}
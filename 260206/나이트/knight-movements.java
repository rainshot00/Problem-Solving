import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, y1, x1, y2, x2, ans;
	static int[] dy = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] dx = { 1, -1, 2, -2, 2, -2, 1, -1 };

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];

		q.add(new int[] { y1, x1, 0 });
		visited[y1][x1] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			int y = now[0];
			int x = now[1];
			int cnt = now[2];

			if (y == y2 && x == x2) {
				ans = cnt;
				break;
			}

			for (int step = 0; step < 8; step++) {
				int yy = y + dy[step];
				int xx = x + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					continue;

				if (visited[yy][xx])
					continue;

				visited[yy][xx] = true;
				q.add(new int[] { yy, xx, cnt + 1 });
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		y1 = Integer.parseInt(st.nextToken()) - 1;
		x1 = Integer.parseInt(st.nextToken()) - 1;
		y2 = Integer.parseInt(st.nextToken()) - 1;
		x2 = Integer.parseInt(st.nextToken()) - 1;

		ans = -1;
		bfs();

		System.out.println(ans);
	}
}
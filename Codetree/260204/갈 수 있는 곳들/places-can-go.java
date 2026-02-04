import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };
	static int n, k;

	public static void bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();

		q.add(new int[] { y, x });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int step = 0; step < 4; step++) {
				int yy = pos[0] + dy[step];
				int xx = pos[1] + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					continue;

				if (arr[yy][xx] == 1 || visited[yy][xx])
					continue;

				visited[yy][xx] = true;
				q.add(new int[] { yy, xx });
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visited = new boolean[n][n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			bfs(y - 1, x - 1);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					ans++;
			}
		}

		System.out.println(ans);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean[][] visited;
	static int n, m;
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	public static boolean bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			visited[pos[0]][pos[1]] = true;

			if (pos[0] == n - 1 && pos[1] == m - 1)
				return true;

			for (int step = 0; step < 4; step++) {
				int yy = pos[0] + dy[step];
				int xx = pos[1] + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= m)
					continue;

				if (arr[yy][xx] == 0 || visited[yy][xx])
					continue;

				q.add(new int[] { yy, xx });
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < m; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs(0, 0) ? 1 : 0);
	}
}
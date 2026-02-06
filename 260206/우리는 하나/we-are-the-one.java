import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, k, u, d, ans;
	static int[][] arr;
	static List<int[]> l = new ArrayList<>();

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];

		for (int[] pos : l) {
			q.add(pos);
			visited[pos[0]][pos[1]] = true;
		}

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int step = 0; step < 4; step++) {
				int yy = pos[0] + dy[step];
				int xx = pos[1] + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					continue;

				int diff = Math.abs(arr[yy][xx] - arr[pos[0]][pos[1]]);

				if (visited[yy][xx] || diff < u || diff > d)
					continue;

				visited[yy][xx] = true;
				q.add(new int[] { yy, xx });
			}
		}

		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (visited[i][k])
					tmp++;
			}
		}

		ans = Math.max(ans, tmp);
	}

	static void combi(int start, int len) {
		if (len == k) {
			bfs();
			return;
		}

		for (int i = start; i < n * n; i++) {
			int y = i / n;
			int x = i % n;

			l.add(new int[] { y, x });
			combi(i + 1, len + 1);
			l.remove(l.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		combi(0, 0);
		System.out.println(ans);
	}
}
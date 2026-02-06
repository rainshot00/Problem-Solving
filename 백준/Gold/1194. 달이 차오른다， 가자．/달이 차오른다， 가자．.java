import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans;
	static char[][] arr;
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void bfs(int startY, int startX) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[n][m][64];

		q.add(new int[] { startY, startX, 0, 0 });
		visited[startY][startX][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			int y = now[0];
			int x = now[1];
			int key = now[2];
			int cnt = now[3];

			if (arr[y][x] == '1') {
				ans = Math.min(ans, cnt);
				break;
			} else if (arr[y][x] >= 'a' && arr[y][x] <= 'f') {
				key = key | (1 << (arr[y][x] - 'a'));
			}

			for (int step = 0; step < 4; step++) {
				int yy = y + dy[step];
				int xx = x + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= m)
					continue;

				if (visited[yy][xx][key] || arr[yy][xx] == '#')
					continue;

				if (arr[yy][xx] >= 'A' && arr[yy][xx] <= 'F') {
					if ((key & (1 << (arr[yy][xx] - 'A'))) == 0) {
						continue;
					}
				}

				visited[yy][xx][key] = true;
				q.add(new int[] { yy, xx, key, cnt + 1 });
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];

		int startY = 0, startX = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int k = 0; k < m; k++) {
				arr[i][k] = str.charAt(k);

				if (arr[i][k] == '0') {
					startY = i;
					startX = k;
				}
			}
		}

		ans = Integer.MAX_VALUE;
		bfs(startY, startX);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

}

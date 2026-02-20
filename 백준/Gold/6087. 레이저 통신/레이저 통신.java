import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int w, h, startY, startX, ans;
	static char[][] arr;
	static int[][] visited;

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void bfs(int startY, int startX, int dir) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { startY, startX, dir, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			int direction = now[2];
			int res = now[3];

			if (arr[y][x] == 'C') {
				ans = Math.min(ans, res);
				continue;
			}

			for (int step = 0; step < 4; step++) {
				int yy = y + dy[step];
				int xx = x + dx[step];

				if (yy < 0 || yy >= h || xx < 0 || xx >= w)
					continue;

				if (arr[yy][xx] == '*')
					continue;

				int newRes = res + (step == direction ? 0 : 1);

				if (newRes < visited[yy][xx]) {
					visited[yy][xx] = newRes;
					q.add(new int[] { yy, xx, step, newRes });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		arr = new char[h][w];

		for (int i = 0; i < h; i++) {
			String str = br.readLine().trim();

			for (int k = 0; k < w; k++) {
				arr[i][k] = str.charAt(k);

				if (arr[i][k] == 'C') {
					startY = i;
					startX = k;
				}
			}
		}

		arr[startY][startX] = 'A';

		for (int direction = 0; direction < 4; direction++) {
			visited = new int[h][w];
			for (int i = 0; i < h; i++) {
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}
			bfs(startY, startX, direction);
		}

		System.out.println(ans);
	}

}

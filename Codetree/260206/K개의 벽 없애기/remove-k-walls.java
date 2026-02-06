import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, k, startY, startX, endY, endX, ans;
	static int[][] arr;
	static List<int[]> wall = new ArrayList<>();

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];

		q.add(new int[] { startY, startX, 0 });
		visited[startY][startX] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			int y = now[0];
			int x = now[1];
			int cnt = now[2];

			if (y == endY && x == endX) {
				ans = Math.min(ans, cnt);
				return;
			}

			for (int step = 0; step < 4; step++) {
				int yy = y + dy[step];
				int xx = x + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					continue;

				if (visited[yy][xx] || arr[yy][xx] == 1)
					continue;

				visited[yy][xx] = true;
				q.add(new int[] { yy, xx, cnt + 1 });
			}
		}
	}

	static void selectWall(int start, int len) {
		if (len == k) {
			bfs();
			return;
		}

		for (int i = start; i < wall.size(); i++) {
			int[] wallPos = wall.get(i);

			arr[wallPos[0]][wallPos[1]] = 0;
			selectWall(start + 1, len + 1);

			arr[wallPos[0]][wallPos[1]] = 1;
			selectWall(start + 1, len);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());

				if (arr[i][k] == 1) {
					wall.add(new int[] { i, k });
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		startY = Integer.parseInt(st.nextToken()) - 1;
		startX = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		endY = Integer.parseInt(st.nextToken()) - 1;
		endX = Integer.parseInt(st.nextToken()) - 1;

		ans = 987654321;
		selectWall(0, 0);

		System.out.println(ans == 987654321 ? -1 : ans);
	}
}
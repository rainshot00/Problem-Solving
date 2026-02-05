import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	public static int[] bfs(int y, int x) {
		visited = new boolean[n][n];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });

		int nowVal = arr[y][x];
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int step = 0; step < 4; step++) {
				int yy = pos[0] + dy[step];
				int xx = pos[1] + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n) {
					continue;
				}

				if (arr[yy][xx] >= nowVal || visited[yy][xx])
					continue;

				visited[yy][xx] = true;
				q.add(new int[] { yy, xx });
			}
		}

		int maxVal = -1;
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (visited[i][k] && (i != y || k != x))
					maxVal = Math.max(maxVal, arr[i][k]);
			}
		}

		int nowY = -1, nowX = -1;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (visited[i][k] && arr[i][k] == maxVal) {
					nowY = i;
					nowX = k;
					flag = true;
					break;
				}
			}

			if (flag)
				break;
		}

		if (maxVal == -1) {
			return new int[] { y, x };
		} else {
			return new int[] { nowY, nowX };
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
			}
		}

		st = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		startY--;
		startX--;

		for (int i = 0; i < k; i++) {
			int[] pos = bfs(startY, startX);
			startY = pos[0];
			startX = pos[1];
		}

		System.out.println((startY + 1) + " " + (startX + 1));
	}
}
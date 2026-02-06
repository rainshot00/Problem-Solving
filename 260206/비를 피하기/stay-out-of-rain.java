import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, h, m;
	static int[][] arr;
	static int[][] ans;
	static List<int[]> human = new ArrayList<>();
	static List<int[]> space = new ArrayList<>();

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void bfs(int startY, int startX) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];

		q.add(new int[] { startY, startX, 0 });
		visited[startY][startX] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			int y = now[0];
			int x = now[1];
			int cnt = now[2];

			if (arr[y][x] == 3) {
				ans[startY][startX] = cnt;
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

		ans[startY][startX] = -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		ans = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());

				if (arr[i][k] == 2) {
					human.add(new int[] { i, k });
				}

				else if (arr[i][k] == 3) {
					space.add(new int[] { i, k });
				}
			}
		}

		for (int[] pos : human) {
			bfs(pos[0], pos[1]);
		}

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(ans[i][k] + " ");
			}
			System.out.println();
		}
	}
}
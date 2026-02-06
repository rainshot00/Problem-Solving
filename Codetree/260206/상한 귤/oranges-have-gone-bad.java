import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[][] arr;
	static int[][] finalTomato;
	static List<int[]> l = new ArrayList<>();

	static void tomato() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];

		int[] dy = { 1, 0, 0, -1 };
		int[] dx = { 0, 1, -1, 0 };

		for (int[] tomato : l) {
			int y = tomato[0];
			int x = tomato[1];

			q.add(new int[] { y, x, 0 });
			visited[y][x] = true;
			finalTomato[y][x] = 0;
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			int y = tmp[0];
			int x = tmp[1];
			int cnt = tmp[2];

			for (int step = 0; step < 4; step++) {
				int yy = y + dy[step];
				int xx = x + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					continue;

				if (visited[yy][xx] || arr[yy][xx] == 0)
					continue;

				visited[yy][xx] = true;
				finalTomato[yy][xx] = cnt + 1;
				q.add(new int[] { yy, xx, cnt + 1 });
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		finalTomato = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(finalTomato[i], -2);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());

				if (arr[i][k] == 2) {
					l.add(new int[] { i, k });
				} else if (arr[i][k] == 0)
					finalTomato[i][k] = -1;
			}
		}

		tomato();

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(finalTomato[i][k] + " ");
			}
			System.out.println();
		}
	}
}

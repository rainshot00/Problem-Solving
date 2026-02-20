import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int n, normalArea, dyschromatopsiaArea;
	static char[][] arr;
	static boolean[][] visited;

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void normal(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });
		visited[y][x] = true;
		char color = arr[y][x];

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int step = 0; step < 4; step++) {
				int yy = pos[0] + dy[step];
				int xx = pos[1] + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n) {
					continue;
				}

				if (arr[yy][xx] != color || visited[yy][xx]) {
					continue;
				}

				q.add(new int[] { yy, xx });
				visited[yy][xx] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine().trim();

			for (int k = 0; k < n; k++) {
				arr[i][k] = str.charAt(k);
			}
		}

		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (!visited[i][k]) {
					normal(i, k);
					normalArea++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (arr[i][k] == 'G') {
					arr[i][k] = 'R';
				}
			}
		}

		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (!visited[i][k]) {
					normal(i, k);
					dyschromatopsiaArea++;
				}
			}
		}

		System.out.println(normalArea + " " + dyschromatopsiaArea);
	}

}

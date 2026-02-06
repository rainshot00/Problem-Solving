import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] arr;
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void melt() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];

		q.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int step = 0; step < 4; step++) {
				int yy = pos[0] + dy[step];
				int xx = pos[1] + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= m)
					continue;

				if (visited[yy][xx])
					continue;

				visited[yy][xx] = true;

				if (arr[yy][xx] == 0)
					q.add(new int[] { yy, xx });

				if (arr[yy][xx] > 0) {
					arr[yy][xx]--;
				}
			}
		}
	}

	static int size() {
		int size = 0;

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < m; k++) {
				if (arr[i][k] != 0)
					size++;
			}
		}

		return size;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < m; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		int size = size();

		while (true) {
			melt();
			time++;

			if (size() == 0)
				break;

			size = size();
		}

		System.out.println(time + " " + size);
	}
}
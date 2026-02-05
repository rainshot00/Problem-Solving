import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, k, m, ans;
	static int[][] arr;
	static List<int[]> start = new ArrayList<>();
	static List<int[]> stone = new ArrayList<>();
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };
	static int[] check;

	static void combi(int len, int start) {
		if (len == m) {
			bfs();
			return;
		}

		for (int i = start; i < stone.size(); i++) {
			check[len] = i;
			combi(len + 1, i + 1);
		}
	}

	static void bfs() {
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new ArrayDeque<>();
		int[][] copyArr = new int[n][n];
		int cnt = 0;

		for (int i = 0; i < n; i++)
			copyArr[i] = arr[i].clone();

		for (int i : check) {
			int[] pos = stone.get(i);
			copyArr[pos[0]][pos[1]] = 0;
		}

		for (int[] st : start) {
			q.add(st);
			visited[st[0]][st[1]] = true;
			cnt++;
		}

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int step = 0; step < 4; step++) {
				int yy = pos[0] + dy[step];
				int xx = pos[1] + dx[step];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					continue;

				if (visited[yy][xx] || copyArr[yy][xx] == 1)
					continue;

				visited[yy][xx] = true;
				q.add(new int[] { yy, xx });
				cnt++;
			}
		}

		ans = Math.max(ans, cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());

				if (arr[i][k] == 1)
					stone.add(new int[] { i, k });
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			start.add(new int[] { y - 1, x - 1 });
		}

		ans = 0;
		check = new int[m];
		combi(0, 0);

		System.out.println(ans);
	}
}
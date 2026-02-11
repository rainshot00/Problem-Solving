import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int n, m;
	static boolean[][] arr;
	static boolean[][] visited;

	static void bfs(int idx) {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(idx);
		visited[idx][idx] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int x = 0; x < n; x++) {
				if (arr[now][x] && !visited[idx][x]) {
					q.offer(x);
					visited[idx][x] = true;
				}
			}
		}
	}

	static boolean check(int idx) {
		for (int x = 0; x < n; x++) {
			if (visited[idx][x])
				continue;

			if (visited[x][idx])
				continue;

			return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			arr = new boolean[n][n];
			visited = new boolean[n][n];
			int ans = 0;

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				arr[a][b] = true;
			}

			for (int i = 0; i < n; i++) {
				bfs(i);
			}

			for (int i = 0; i < n; i++) {
				if (check(i))
					ans++;
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());

	}
}

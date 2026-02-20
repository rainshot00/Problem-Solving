import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int v, e;
	static boolean[][] arr;
	static boolean visited[];
	static Queue<Integer> q;

	static StringBuilder sb;

	static void check() {
		while (true) {
			addIndegreeZero();
			if (q.isEmpty()) {
				break;
			}
			removeEdge();
		}
	}

	static void addIndegreeZero() {
		for (int x = 0; x < v; x++) {
			if (visited[x])
				continue;

			boolean flag = true;
			for (int y = 0; y < v; y++) {
				if (arr[y][x]) {
					flag = false;
					break;
				}
			}

			if (flag) {
				q.add(x);
			}
		}
	}

	static void removeEdge() {
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append((now + 1) + " ");
			visited[now] = true;

			Arrays.fill(arr[now], false);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		for (int testcase = 1; testcase <= 10; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			arr = new boolean[v][v];
			visited = new boolean[v];
			q = new ArrayDeque<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				arr[start - 1][end - 1] = true;
			}

			sb.append("#" + testcase + " ");
			check();
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}

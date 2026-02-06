import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static void makeOne(int n) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[1_000_001];

		q.add(new int[] { n, 0 });
		visited[n] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			int now = tmp[0];
			int cnt = tmp[1];

			if (now == 1) {
				System.out.println(cnt);
				break;
			}

			if (now % 2 == 0 && now / 2 >= 1 && !visited[now / 2]) {
				visited[now / 2] = true;
				q.add(new int[] { now / 2, cnt + 1 });
			}

			if (now % 3 == 0 && now / 3 >= 1 && !visited[now / 3]) {
				visited[now / 3] = true;
				q.add(new int[] { now / 3, cnt + 1 });
			}

			if (now - 1 >= 1 && !visited[now - 1]) {
				visited[now - 1] = true;
				q.add(new int[] { now - 1, cnt + 1 });
			}

			if (now + 1 <= 1_000_000 && !visited[now + 1]) {
				visited[now + 1] = true;
				q.add(new int[] { now + 1, cnt + 1 });
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		makeOne(n);
	}
}
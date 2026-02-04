import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited = new boolean[6];
	static int[] sum = new int[3];
	static int[] arr = new int[5];
	static int ans = 987654321;

	public static void team(int cnt) {
		if (cnt == 3) {
			if (sum[0] == sum[1] || sum[0] == sum[2] || sum[1] == sum[2])
				return;

			int max = Math.max(sum[0], Math.max(sum[1], sum[2]));
			int min = Math.min(sum[0], Math.min(sum[1], sum[2]));

			ans = Math.min(ans, max - min);
			return;
		}

		if (cnt == 2) {
			for (int i = 0; i < 5; i++) {
				if (!visited[i]) {
					sum[cnt] = arr[i];
					team(cnt + 1);
					return;
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			if (visited[i])
				continue;

			for (int k = i + 1; k < 5; k++) {
				if (visited[k])
					continue;

				visited[i] = true;
				visited[k] = true;

				sum[cnt] = arr[i] + arr[k];
				team(cnt + 1);

				visited[i] = false;
				visited[k] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		team(0);

		System.out.println(ans);
	}

}

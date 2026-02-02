import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];
		int[][] sum = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 1; k <= n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		for (int x = 1; x <= n; x++) {
			sum[1][x] = sum[1][x - 1] + arr[1][x];
		}

		for (int y = 1; y <= n; y++) {
			sum[y][1] = sum[y - 1][1] + arr[y][1];
		}

		for (int i = 2; i <= n; i++) {
			for (int k = 2; k <= n; k++) {
				sum[i][k] = sum[i - 1][k] + sum[i][k - 1] - sum[i - 1][k - 1] + arr[i][k];
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			System.out.println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]);
		}
	}

}

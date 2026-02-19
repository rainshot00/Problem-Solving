import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int ans = -987654321;
		int[][] arr = new int[n + 1][n + 1];
		int[][] rowPsum = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 1; k <= n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				rowPsum[i][k] = rowPsum[i][k - 1] + arr[i][k];
			}
		}

		for (int x1 = 1; x1 <= n; x1++) {
			for (int x2 = x1; x2 <= n; x2++) {
				int currentMax = 0;

				for (int y = 1; y <= n; y++) {
					int rowSum = rowPsum[y][x2] - rowPsum[y][x1 - 1];

					// Kadane's Algorithm
					currentMax = Math.max(rowSum, currentMax + rowSum);
					ans = Math.max(ans, currentMax);
				}
			}
		}

		System.out.println(ans);
	}

}

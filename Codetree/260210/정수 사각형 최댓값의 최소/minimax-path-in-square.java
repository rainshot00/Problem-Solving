import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = arr[0][0];

		for (int y = 1; y < n; y++) {
			dp[y][0] = Math.max(dp[y - 1][0], arr[y][0]);
		}

		for (int x = 1; x < n; x++) {
			dp[0][x] = Math.max(dp[0][x - 1], arr[0][x]);
		}

		for (int y = 1; y < n; y++) {
			for (int x = 1; x < n; x++) {
				dp[y][x] = Math.max(Math.min(dp[y - 1][x], dp[y][x - 1]), arr[y][x]);
			}
		}

		System.out.println(dp[n - 1][n - 1]);
	}

}

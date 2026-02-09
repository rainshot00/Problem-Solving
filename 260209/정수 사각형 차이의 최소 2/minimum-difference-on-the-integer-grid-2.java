import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int[][][] dp;

	static int recursion(int y, int x) {
		if (y == 0 || x == 0) {
			return dp[y][x][2];
		}

		if (dp[y][x][2] != -1) {
			return dp[y][x][2];
		}

		dp[y][x][0] = Math.max(Math.max(dp[y - 1][x][0], dp[y][x - 1][0]), arr[y][x]);
		dp[y][x][1] = Math.min(Math.min(dp[y - 1][x][1], dp[y][x - 1][1]), arr[y][x]);
		return dp[y][x][2] = dp[y][x][0] - dp[y][x][1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n][3];

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				Arrays.fill(dp[i][k], -1);
			}
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0][0] = arr[0][0]; // max
		dp[0][0][1] = arr[0][0]; // min
		dp[0][0][2] = 0; // diff

		for (int y = 1; y < n; y++) {
			dp[y][0][0] = Math.max(dp[y - 1][0][0], arr[y][0]);
			dp[y][0][1] = Math.min(dp[y - 1][0][1], arr[y][0]);
			dp[y][0][2] = dp[y][0][0] - dp[y][0][1];
		}

		for (int x = 1; x < n; x++) {
			dp[0][x][0] = Math.max(dp[0][x - 1][0], arr[0][x]);
			dp[0][x][1] = Math.min(dp[0][x - 1][1], arr[0][x]);
			dp[0][x][2] = dp[0][x][0] - dp[0][x][1];
		}

		System.out.println(recursion(n - 1, n - 1));
	}

}

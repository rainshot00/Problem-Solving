import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int[][][] dp;

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

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (y == 0 && x == 0)
					continue;

				int max1 = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE, diff1 = Integer.MAX_VALUE;
				int max2 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, diff2 = Integer.MAX_VALUE;

				if (y > 0) {
					max1 = Math.max(dp[y - 1][x][0], arr[y][x]);
					min1 = Math.min(dp[y - 1][x][1], arr[y][x]);
					diff1 = max1 - min1;
				}

				if (x > 0) {
					max2 = Math.max(dp[y][x - 1][0], arr[y][x]);
					min2 = Math.min(dp[y][x - 1][1], arr[y][x]);
					diff2 = max2 - min2;
				}

				if (diff1 < diff2) {
					dp[y][x][0] = max1;
					dp[y][x][1] = min1;
					dp[y][x][2] = diff1;
				} else if (diff1 > diff2) {
					dp[y][x][0] = max2;
					dp[y][x][1] = min2;
					dp[y][x][2] = diff2;
				} else {
					if (max1 <= max2) {
						dp[y][x][0] = max1;
						dp[y][x][1] = min1;
						dp[y][x][2] = diff1;
					} else {
						dp[y][x][0] = max2;
						dp[y][x][1] = min2;
						dp[y][x][2] = diff2;
					}
				}
			}
		}

		System.out.println(dp[n - 1][n - 1][2]);
	}

}

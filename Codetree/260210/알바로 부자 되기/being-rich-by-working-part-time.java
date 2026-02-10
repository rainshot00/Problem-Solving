import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, ans = 0;
	static int[][] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < 3; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(arr, (a, b) -> {
			if (a[0] == b[0])
				return a[1] - b[1];

			return a[0] - b[0];
		});

		dp[0] = arr[0][2];

		for (int i = 1; i < n; i++) {
			dp[i] = arr[i][2];

			for (int k = 0; k < i; k++) {
				if (arr[i][0] > arr[k][1]) {
					dp[i] = Math.max(dp[i], dp[k] + arr[i][2]);
				}
			}
		}

		for (int res : dp) {
			ans = Math.max(ans, res);
		}

		System.out.println(ans);
	}

}

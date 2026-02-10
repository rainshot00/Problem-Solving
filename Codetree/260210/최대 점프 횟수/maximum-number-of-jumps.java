import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, ans = -1;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		Arrays.fill(dp, -1);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			for (int k = 0; k < i; k++) {
				if (dp[k] != -1 && k + arr[k] >= i) {
					dp[i] = Math.max(dp[i], dp[k] + 1);
				}
			}

			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}

}

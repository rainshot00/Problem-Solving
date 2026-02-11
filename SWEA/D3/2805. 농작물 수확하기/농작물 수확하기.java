import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int ans = 0;

			for (int i = 0; i < n; i++) {
				String str = br.readLine().trim();

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(String.valueOf(str.charAt(k)));
				}
			}

			for (int i = 0; i <= n / 2; i++) {
				for (int k = n / 2 - i; k < n / 2 + i + 1; k++) {
					ans += arr[i][k];
				}
			}

			for (int i = n / 2 + 1; i < n; i++) {
				for (int k = i - n / 2; k < n - (i - n / 2); k++) {
					ans += arr[i][k];
				}
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}

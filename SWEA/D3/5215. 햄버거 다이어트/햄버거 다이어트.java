import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, l, ans;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			arr = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				int T = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());

				arr[i][0] = T;
				arr[i][1] = K;
			}

			int ans = -1;
			for (int i = 0; i < (1 << n); i++) {
				int val = 0, cal = 0;

				for (int k = 0; k < n; k++) {
					if ((i & (1 << k)) != 0) {
						val += arr[k][0];
						cal += arr[k][1];
					}
				}

				if (cal <= l)
					ans = Math.max(ans, val);
			}

			System.out.println("#" + testcase + " " + ans);
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, l, ans;
	static int[][] arr;
	static boolean[] visited;

	public static void hamburger(int idx, int val, int cal) {
		if (cal > l)
			return;

		if (idx == n) {
			ans = Math.max(ans, val);
			return;
		}

		hamburger(idx + 1, val + arr[idx][0], cal + arr[idx][1]);
		hamburger(idx + 1, val, cal);
	}

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

			ans = 0;
			visited = new boolean[n];
			hamburger(0, 0, 0);

			System.out.println("#" + testcase + " " + ans);
		}
	}

}

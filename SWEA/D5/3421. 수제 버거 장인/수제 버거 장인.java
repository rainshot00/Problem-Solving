import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, m;
	static int[] notGood;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			notGood = new int[n];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				notGood[a] = notGood[a] | (1 << b);
				notGood[b] = notGood[b] | (1 << a);
			}

			int ans = 0;

			for (int i = 0; i < (1 << n); i++) {
				boolean flag = true;

				for (int k = 0; k < n; k++) {
					if ((i & (1 << k)) != 0) {
						if ((i & notGood[k]) != 0) {
							flag = false;
						}
					}
				}

				if (flag)
					ans++;
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}

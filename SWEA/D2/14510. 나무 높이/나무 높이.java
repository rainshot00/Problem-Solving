import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			int n = Integer.parseInt(br.readLine());
			int[] tree = new int[n];
			int maxHeight = -1;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < n; k++) {
				tree[k] = Integer.parseInt(st.nextToken());

				maxHeight = Math.max(maxHeight, tree[k]);
			}

			int one = 0, two = 0;
			for (int i = 0; i < n; i++) {
				one += ((maxHeight - tree[i]) % 2);
				two += ((maxHeight - tree[i]) / 2);
			}

			while (two - one > 1) {
				two--;
				one += 2;
			}

			sb.append("#" + testcase + " " + Math.max(2 * (one - 1) + 1, 2 * two) + "\n");
		}

		System.out.println(sb.toString());
	}

}

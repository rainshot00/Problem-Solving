import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, maxAns, minAns;
	static int[] operator;
	static int[] num;

	static void cal(int len, int result) {
		if (len == n) {
			maxAns = Math.max(maxAns, result);
			minAns = Math.min(minAns, result);

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0)
				continue;

			if (i == 0) {
				operator[i]--;
				cal(len + 1, result + num[len]);
				operator[i]++;
			}

			else if (i == 1) {
				operator[i]--;
				cal(len + 1, result - num[len]);
				operator[i]++;
			}

			else if (i == 2) {
				operator[i]--;
				cal(len + 1, result * num[len]);
				operator[i]++;
			}

			else {
				operator[i]--;
				cal(len + 1, result / num[len]);
				operator[i]++;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			n = Integer.parseInt(br.readLine());
			operator = new int[4];
			num = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			maxAns = Integer.MIN_VALUE;
			minAns = Integer.MAX_VALUE;
			cal(1, num[0]);

			sb.append("#" + testcase + " " + (maxAns - minAns) + "\n");
		}

		System.out.println(sb.toString());
	}

}

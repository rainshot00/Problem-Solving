import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int n, ans;
	static int[][] arr;
	static boolean[] visited;
	static List<Integer> l1;

	static void combination(int len, int start) {
		if (len == n / 2) {
			check();
			return;
		}

		for (int i = start; i < n; i++) {
			l1.add(i);
			combination(len + 1, i + 1);
			l1.remove(l1.size() - 1);
		}
	}

	static void check() {
		List<Integer> l2 = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			boolean flag = true;

			for (int k = 0; k < l1.size(); k++) {
				if (l1.get(k) == i) {
					flag = false;
					break;
				}
			}

			if (flag)
				l2.add(i);
		}

		int l1Val = 0;
		int l2Val = 0;

		for (int i = 0; i < l1.size(); i++) {
			for (int k = 0; k < l1.size(); k++) {
				l1Val += arr[l1.get(i)][l1.get(k)];
			}
		}

		for (int i = 0; i < l2.size(); i++) {
			for (int k = 0; k < l2.size(); k++) {
				l2Val += arr[l2.get(i)][l2.get(k)];
			}
		}

		ans = Math.min(ans, Math.abs(l1Val - l2Val));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}

			visited = new boolean[n];
			l1 = new ArrayList<>();
			l1.add(0);
			ans = Integer.MAX_VALUE;
			combination(1, 1);

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}

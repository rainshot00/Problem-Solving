import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static boolean isOperator(String str) {
		return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testcase = 1; testcase <= 10; testcase++) {
			int n = Integer.parseInt(br.readLine());

			String[] tree = new String[n + 1];
			boolean flag = true;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int num = Integer.parseInt(st.nextToken());
				String str = st.nextToken();
				int left = 0;
				int right = 0;

				if (st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					right = Integer.parseInt(st.nextToken());
				}

				tree[num] = str;
			}

			if (!isOperator(tree[1]))
				flag = false;

			for (int i = 1; i <= n; i++) {
				int num = i;
				String str = tree[num];

				if (isOperator(str)) {
					if (2 * num <= n) {
						if (tree[2 * num] == null) {
							flag = false;
							break;
						}
					}

					if (2 * num + 1 <= n) {
						if (tree[2 * num + 1] == null) {
							flag = false;
							break;
						}
					}
				} else {
					if (2 * num <= n) {
						if (tree[2 * num] != null) {
							flag = false;
							break;
						}
					}

					if (2 * num + 1 <= n) {
						if (tree[2 * num + 1] != null) {
							flag = false;
							break;
						}
					}
				}
			}

			System.out.println("#" + testcase + " " + (flag ? 1 : 0));
		}

		br.close();
	}

}

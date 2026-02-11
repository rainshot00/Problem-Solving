import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		StringBuilder sb = new StringBuilder();

		st.nextToken();
		int t = (int) st.nval;

		for (int testcase = 1; testcase <= t; testcase++) {
			st.nextToken();
			int n = (int) st.nval;
			long ans = 0;

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				st.nextToken();
				arr[i] = (int) st.nval;
			}

			int[] left = new int[n];
			int[] right = new int[n];

			for (int i = 1; i < n; i++) {
				if (arr[i - 1] < arr[i])
					left[i] = left[i - 1] + 1;
			}

			for (int i = n - 2; i >= 0; i--) {
				if (arr[i + 1] < arr[i])
					right[i] = right[i + 1] + 1;
			}

			for (int i = 0; i < n; i++)
				ans += (left[i] * right[i]);

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}

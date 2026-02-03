import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[101];
		int ans = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int candy = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());

			arr[pos] += candy;
		}

		int sum = 0;
		for (int i = 0 - k; i <= 0 + k; i++) {
			if (i >= 0 && i < 101)
				sum += arr[i];
		}

		ans = Math.max(ans, sum);

		for (int c = 1; c < 101; c++) {
			if (c + k < 101)
				sum += arr[c + k];
			if (c - k - 1 >= 0)
				sum -= arr[c - k - 1];

			ans = Math.max(ans, sum);
		}

		System.out.println(ans);
	}
}

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int ans = 987654321;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= n - t; i++) {
			int sum = 0;

			for (int k = 0; k < t; k++) {
				sum += Math.abs(arr[i + k] - h);
			}

			ans = Math.min(ans, sum);
		}

		System.out.println(ans);
	}
}

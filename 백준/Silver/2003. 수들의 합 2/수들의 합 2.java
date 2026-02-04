import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = arr[0];
		int ans = 0;
		int start = 0, end = 1;
		while (true) {
			if (sum == m) {
				sum -= arr[start];
				start++;
				ans++;
			} else if (sum > m) {
				sum -= arr[start];
				start++;
			} else {
				if (end < n) {
					sum += arr[end];
					end++;
				} else {
					break;
				}
			}
		}

		System.out.println(ans);
	}

}

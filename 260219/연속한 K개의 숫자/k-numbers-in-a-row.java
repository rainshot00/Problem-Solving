import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		int[] psum = new int[n + 1];
		int ans = 987654321;

		for (int i = 0; i < b; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num] = 1;
		}

		psum[1] = arr[1];
		for (int i = 2; i <= n; i++) {
			psum[i] = psum[i - 1] + arr[i];
		}

		for (int i = 1; i <= n - k; i++) {
			int res = psum[i + k - 1] - psum[i] + arr[i];
			ans = Math.min(ans, res);
		}

		System.out.println(ans);
	}

}

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
		int[] arr = new int[n];
		int[] psum = new int[n];
		int ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		psum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			psum[i] = psum[i - 1] + arr[i];
		}

		int left = 0, right = 0;
		while (left < n && right < n) {
			int sum = psum[right] - psum[left] + arr[left];
			if (sum == k) {
				ans++;
				right++;
			} else if (sum > k) {
				left++;
			} else {
				right++;
			}
		}

		System.out.println(ans);
	}

}

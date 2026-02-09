import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];

		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 7;

		for (int i = 3; i <= n; i++) {
			arr[i] = 2 * arr[i - 1] + 3 * arr[i - 2];
			arr[i] %= 1_000_000_007;

			for (int k = i - 3; k >= 0; k--) {
				arr[i] += 2 * arr[k];
				arr[i] %= 1_000_000_007;
			}
		}

		System.out.println(arr[n]);
	}

}

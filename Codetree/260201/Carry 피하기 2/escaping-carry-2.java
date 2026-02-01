import java.io.*;

public class Main {
	public static boolean check(int a, int b, int c) {
		while (a > 0 || b > 0 || c > 0) {
			int digitA = a % 10;
			int digitB = b % 10;
			int digitC = c % 10;

			if (digitA + digitB + digitC >= 10) {
				return false;
			}

			a /= 10;
			b /= 10;
			c /= 10;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int ans = -1;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (check(arr[i], arr[j], arr[k])) {
						ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
					}
				}
			}
		}

		System.out.println(ans);

		br.close();
	}
}

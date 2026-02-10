import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, ans = 1;
	static int[] arr;
	static int[] lis;
	static int[] lds;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		lis = new int[n];
		lds = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			lis[i] = 1;

			for (int k = 0; k < i; k++) {
				if (arr[i] > arr[k]) {
					lis[i] = Math.max(lis[i], lis[k] + 1);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			lds[i] = 1;

			for (int k = n - 1; k > i; k--) {
				if (arr[i] > arr[k]) {
					lds[i] = Math.max(lds[i], lds[k] + 1);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, lis[i] + lds[i] - 1);
		}

		System.out.println(ans);
	}

}

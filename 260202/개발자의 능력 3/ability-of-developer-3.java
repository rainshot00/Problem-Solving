import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[6];
		int ans = 987654321;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				for (int k = j + 1; k < 6; k++) {
					boolean[] check = new boolean[6];
					check[i] = true;
					check[j] = true;
					check[k] = true;

					int sum1 = arr[i] + arr[j] + arr[k];
					int sum2 = 0;
					for (int idx = 0; idx < 6; idx++) {
						if (!check[idx]) {
							sum2 += arr[idx];
						}
					}

					ans = Math.min(ans, Math.abs(sum1 - sum2));
				}
			}
		}

		System.out.println(ans);
	}
}

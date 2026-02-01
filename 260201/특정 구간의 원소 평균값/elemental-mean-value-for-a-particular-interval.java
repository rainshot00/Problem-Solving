import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int ans = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int size = 1; size <= n; size++) {
			for (int idx = 0; idx <= n - size; idx++) {
				int sum = 0;

				for (int cnt = 0; cnt < size; cnt++) {
					sum += arr[idx + cnt];
				}

				for (int cnt = 0; cnt < size; cnt++) {
					if (arr[idx + cnt] * size == sum) {
						ans++;
						break;
					}
				}
			}
		}

		System.out.println(ans);

		br.close();
	}
}

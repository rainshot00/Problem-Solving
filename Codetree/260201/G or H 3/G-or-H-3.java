import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[10_001];
		int ans = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);

			if (c == 'G')
				arr[idx] = 1;
			else
				arr[idx] = 2;
		}

		for (int i = 1; i <= 10_000 - k; i++) {
			int tmp = 0;

			for (int idx = 0; idx <= k; idx++) {
				tmp += arr[i + idx];
			}

			ans = Math.max(ans, tmp);
		}

		System.out.println(ans);

		br.close();
	}
}

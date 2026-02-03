import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] brr = new int[m];
		int ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(brr);
		for (int i = 0; i <= n - m; i++) {
			int[] check = new int[m];
			boolean flag = true;

			for (int k = 0; k < m; k++)
				check[k] = arr[i + k];

			Arrays.sort(check);

			for (int k = 0; k < m; k++) {
				if (brr[k] != check[k]) {
					flag = false;
					break;
				}
			}

			if (flag)
				ans++;
		}

		System.out.println(ans);

		br.close();
	}
}

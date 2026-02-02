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
		int ans = 0;

		String str = br.readLine().trim();

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[4];
		int[] cnt = new int[4];

		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			if (str.charAt(i) == 'A')
				cnt[0]++;
			else if (str.charAt(i) == 'C')
				cnt[1]++;
			else if (str.charAt(i) == 'G')
				cnt[2]++;
			else if (str.charAt(i) == 'T')
				cnt[3]++;
		}

		if (cnt[0] >= arr[0] && cnt[1] >= arr[1] && cnt[2] >= arr[2] && cnt[3] >= arr[3])
			ans++;

		for (int i = 1; i <= n - m; i++) {
			if (str.charAt(i - 1) == 'A')
				cnt[0]--;
			else if (str.charAt(i - 1) == 'C')
				cnt[1]--;
			else if (str.charAt(i - 1) == 'G')
				cnt[2]--;
			else if (str.charAt(i - 1) == 'T')
				cnt[3]--;

			if (str.charAt(i + m - 1) == 'A')
				cnt[0]++;
			else if (str.charAt(i + m - 1) == 'C')
				cnt[1]++;
			else if (str.charAt(i + m - 1) == 'G')
				cnt[2]++;
			else if (str.charAt(i + m - 1) == 'T')
				cnt[3]++;

			if (cnt[0] >= arr[0] && cnt[1] >= arr[1] && cnt[2] >= arr[2] && cnt[3] >= arr[3])
				ans++;
		}

		System.out.println(ans);
	}

}

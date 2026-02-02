import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[] arr = new char[101];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int pos = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);

			arr[pos] = c;
		}

		for (int st = 0; st < 101; st++) {
			if (arr[st] == 0)
				continue;

			int g = 0, h = 0;
			for (int ed = st; ed < 101; ed++) {
				if (arr[ed] == 0)
					continue;

				if (arr[ed] == 'G')
					g++;
				else if (arr[ed] == 'H')
					h++;

				if ((g == h && g != 0) || (g == 0 && h >= 2) || (h == 0 && g >= 2))
					ans = Math.max(ans, ed - st);
			}
		}

		System.out.println(ans);
	}
}

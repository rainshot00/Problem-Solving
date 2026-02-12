import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		TreeSet<Integer> s = new TreeSet<>();
		int ans = 0;

		for (int i = 1; i <= m; i++) {
			s.add(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (s.floor(num) == null) {
				break;
			}

			s.remove(s.floor(num));
			ans++;
		}

		System.out.println(ans);
	}

}

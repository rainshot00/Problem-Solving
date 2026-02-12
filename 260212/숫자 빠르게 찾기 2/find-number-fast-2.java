import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		TreeSet<Integer> s = new TreeSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(br.readLine());

			if (s.ceiling(num) != null) {
				sb.append(s.ceiling(num) + "\n");
			} else {
				sb.append("-1\n");
			}
		}

		System.out.println(sb.toString());
	}

}

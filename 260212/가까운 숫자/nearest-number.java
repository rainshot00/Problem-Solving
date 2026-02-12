import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> s = new TreeSet<>();
		s.add(0);
		int minLength = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			s.add(num);

			if (s.lower(num) != null) {
				minLength = Math.min(minLength, num - s.lower(num));
			}

			if (s.higher(num) != null) {
				minLength = Math.min(minLength, s.higher(num) - num);
			}

			sb.append(minLength + "\n");
		}

		System.out.println(sb.toString());
	}

}

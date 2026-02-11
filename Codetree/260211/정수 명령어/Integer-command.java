import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			TreeSet<Integer> s = new TreeSet<>();

			int k = Integer.parseInt(br.readLine());

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String oper = st.nextToken().trim();
				int n = Integer.parseInt(st.nextToken());

				if (oper.equals("I")) {
					s.add(n);
				} else {
					if (s.isEmpty())
						continue;

					if (n == 1) {
						s.remove(s.last());
					} else {
						s.remove(s.first());
					}
				}
			}

			if (s.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(s.last() + " " + s.first() + "\n");
			}
		}

		System.out.println(sb.toString());
	}

}

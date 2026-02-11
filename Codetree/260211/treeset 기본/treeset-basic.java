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

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken().trim();

			if (str.equals("add")) {
				s.add(Integer.parseInt(st.nextToken()));
			} else if (str.equals("remove")) {
				s.remove(Integer.parseInt(st.nextToken()));
			} else if (str.equals("find")) {
				sb.append(s.contains(Integer.parseInt(st.nextToken())) + "\n");
			} else if (str.equals("lower_bound")) {
				int num = Integer.parseInt(st.nextToken());

				if (s.ceiling(num) == null) {
					sb.append("None\n");
				} else {
					sb.append(s.ceiling(num) + "\n");
				}
			} else if (str.equals("upper_bound")) {
				int num = Integer.parseInt(st.nextToken());

				if (s.higher(num) == null) {
					sb.append("None\n");
				} else {
					sb.append(s.higher(num) + "\n");
				}
			} else if (str.equals("largest")) {
				if (s.isEmpty()) {
					sb.append("None\n");
				} else {
					sb.append(s.last() + "\n");
				}
			} else {
				if (s.isEmpty()) {
					sb.append("None\n");
				} else {
					sb.append(s.first() + "\n");
				}
			}
		}

		System.out.println(sb.toString());
	}

}

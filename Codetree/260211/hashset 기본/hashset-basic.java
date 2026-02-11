import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Set<Integer> s = new HashSet<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String operator = st.nextToken().trim();

			if (operator.equals("add")) {
				s.add(Integer.parseInt(st.nextToken()));
			} else if (operator.equals("remove")) {
				s.remove(Integer.parseInt((st.nextToken())));
			} else {
				sb.append(s.contains(Integer.parseInt(st.nextToken())) + "\n");
			}
		}

		System.out.println(sb.toString());
	}

}

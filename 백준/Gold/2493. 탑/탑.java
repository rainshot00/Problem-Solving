import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<int[]> s = new Stack<>();
		Stack<int[]> tmp = new Stack<>();
		int[] result = new int[n];

		s.push(new int[] { 0, 0 });

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			s.push(new int[] { Integer.parseInt(st.nextToken()), i });
		}

		tmp.push(s.pop());

		while (!s.isEmpty()) {
			int[] now = s.pop();

			while (!tmp.isEmpty()) {
				if (tmp.peek()[0] < now[0]) {
					result[tmp.peek()[1]] = now[1] + 1;
					tmp.pop();
				} else {
					break;
				}
			}

			tmp.push(now);
		}

		for (int ans : result) {
			System.out.print(ans + " ");
		}

		br.close();
	}

}

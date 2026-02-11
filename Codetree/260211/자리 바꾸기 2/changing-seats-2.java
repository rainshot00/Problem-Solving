import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Set<Integer>> l = new ArrayList<>();
		int[] pos = new int[n + 1];
		int[][] arr = new int[k][2];

		for (int i = 0; i <= n; i++) {
			pos[i] = i;

			Set<Integer> s = new HashSet<>();
			s.add(i);
			l.add(s);
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0] = a;
			arr[i][1] = b;
		}

		for (int step = 0; step < 3; step++) {
			for (int i = 0; i < k; i++) {
				int a = arr[i][0];
				int b = arr[i][1];

				l.get(pos[a]).add(b);
				l.get(pos[b]).add(a);

				int tmp = pos[a];
				pos[a] = pos[b];
				pos[b] = tmp;
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(l.get(i).size());
		}
	}

}

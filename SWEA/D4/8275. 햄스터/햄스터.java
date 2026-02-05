import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int n, x, m;
	static int l, r, s;
	static int[][] hamInfo;
	static int[] combi;
	static ArrayList<int[]> possibleCombi;

	public static void hamster(int len) {
		if (len == n) {
			boolean flag = true;

			for (int i = 0; i < m; i++) {
				int sum = 0;

				for (int k = hamInfo[i][0]; k <= hamInfo[i][1]; k++) {
					sum += combi[k];
				}

				if (sum != hamInfo[i][2]) {
					flag = false;
					break;
				}
			}

			if (flag) {
				int sum = 0;

				for (int h : combi) {
					sum += h;
				}

				int[] tmp = new int[n + 1];
				tmp[0] = sum;
				System.arraycopy(combi, 0, tmp, 1, n);
				possibleCombi.add(tmp);
			}

			return;
		}

		for (int i = 0; i <= x; i++) {
			combi[len] = i;
			hamster(len + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			hamInfo = new int[m][3];
			combi = new int[n];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());

				hamInfo[i][0] = --l;
				hamInfo[i][1] = --r;
				hamInfo[i][2] = s;
			}

			possibleCombi = new ArrayList<>();
			hamster(0);

			if (!possibleCombi.isEmpty()) {
				possibleCombi.sort((a, b) -> {
					if (a[0] != b[0]) {
						return Integer.compare(b[0], a[0]);
					} else {
						return Integer.compare(a[1], b[1]);
					}
				});

				System.out.print("#" + testcase + " ");

				for (int i = 1; i <= n; i++) {
					System.out.print(possibleCombi.get(0)[i] + " ");
				}
				System.out.println();
			} else {
				System.out.println("#" + testcase + " -1");
			}
		}
	}

}

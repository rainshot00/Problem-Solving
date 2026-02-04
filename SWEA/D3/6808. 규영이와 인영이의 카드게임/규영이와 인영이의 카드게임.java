import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static boolean[] check = new boolean[9];
	static List<Integer> per = new ArrayList<>();

	static int[] gyuCard = new int[9];
	static int[] inCard = new int[9];
	static int gyuWin = 0;
	static int inWin = 0;

	public static void permutation(int len) {
		if (len == 9) {
			int gyuScore = 0;
			int inScore = 0;

			for (int i = 0; i < 9; i++) {
				if (gyuCard[i] > per.get(i)) {
					gyuScore += (gyuCard[i] + per.get(i));
				} else if (gyuCard[i] < per.get(i)) {
					inScore += (gyuCard[i] + per.get(i));
				}
			}

			if (gyuScore > inScore) {
				gyuWin++;
			} else if (gyuScore < inScore) {
				inWin++;
			}

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (check[i])
				continue;

			check[i] = true;
			per.add(inCard[i]);
			permutation(len + 1);
			per.remove(len);
			check[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyuWin = 0;
			inWin = 0;

			for (int i = 0; i < 9; i++) {
				gyuCard[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean flag = true;

				for (int k = 0; k < 9; k++) {
					if (gyuCard[k] == i) {
						flag = false;
						break;
					}
				}

				if (flag) {
					inCard[idx] = i;
					idx++;
				}
			}

			permutation(0);

			System.out.println("#" + testcase + " " + gyuWin + " " + inWin);
		}
	}

}

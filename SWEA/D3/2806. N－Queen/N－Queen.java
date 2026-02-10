import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int n, ans;
	static boolean[] col;
	static boolean[] posDiag; // sum
	static boolean[] negDiag; // sub

	static void nQueen(int row) {
		if (row == n) {
			ans++;
			return;
		}

		for (int x = 0; x < n; x++) {
			if (col[x] || posDiag[row + x] || negDiag[row - x + n])
				continue;

			col[x] = true;
			posDiag[row + x] = true;
			negDiag[row - x + n] = true;

			nQueen(row + 1);

			col[x] = false;
			posDiag[row + x] = false;
			negDiag[row - x + n] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			n = Integer.parseInt(br.readLine());
			col = new boolean[n];
			posDiag = new boolean[2 * n];
			negDiag = new boolean[2 * n];

			ans = 0;

			nQueen(0);

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}
}

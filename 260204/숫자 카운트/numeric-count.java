import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;

	public static boolean check(String num) {
		for (int i = 0; i < n; i++) {
			String hint = "" + arr[i][0];

			int strike = 0;
			int ball = 0;

			for (int a = 0; a < 3; a++) {
				for (int b = 0; b < 3; b++) {
					if (num.charAt(a) == hint.charAt(b)) {
						if (a == b)
							strike++;
						else
							ball++;
					}
				}
			}

			if (strike != arr[i][1] || ball != arr[i][2])
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			arr[i][0] = num;
			arr[i][1] = strike;
			arr[i][2] = ball;
		}

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i == j)
					continue;

				for (int k = 1; k < 10; k++) {
					if (i == k || j == k)
						continue;

					ans = check("" + i + j + k) ? ans + 1 : ans;
				}
			}
		}

		System.out.println(ans);
	}

}

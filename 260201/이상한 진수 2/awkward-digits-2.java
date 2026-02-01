import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int n = Integer.parseInt(str, 2);

		for (int ans = (1 << str.length()) - 1; ans >= 0; ans--) {
			if (Integer.bitCount(ans ^ n) == 1) {
				System.out.println(ans);
				break;
			}
		}

		br.close();
	}
}

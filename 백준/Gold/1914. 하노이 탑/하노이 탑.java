import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void hanoi(int n, int from, int to, int middle) {
		if (n == 1) {
			System.out.println(from + " " + to);
			return;
		}

		hanoi(n - 1, from, middle, to);
		System.out.println(from + " " + to);
		hanoi(n - 1, middle, to, from);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE));
		if (n <= 20) {
			hanoi(n, 1, 3, 2);
		}
        
        br.close();
	}
}

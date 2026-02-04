import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] ans = { -1, -1 };
		int nearZero = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0, right = n - 1;
		while (left < right) {
			int tmp = arr[left] + arr[right];

			if (Math.abs(tmp) < nearZero) {
				nearZero = Math.abs(tmp);
				ans[0] = left;
				ans[1] = right;
			}

			if (tmp == 0) {
				ans[0] = left;
				ans[1] = right;
				break;
			} else if (tmp > 0) {
				right--;
			} else {
				left++;
			}

		}

		System.out.println(arr[ans[0]] + " " + arr[ans[1]]);
	}

}

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> arr = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String command = st.nextToken();

			if (command.equals("push_back")) {
				int data = Integer.parseInt(st.nextToken());
				arr.add(data);
			} else if (command.equals("pop_back")) {
				arr.remove(arr.size() - 1);
			} else if (command.equals("size")) {
				System.out.println(arr.size());
			} else {
				int idx = Integer.parseInt(st.nextToken());
				System.out.println(arr.get(idx - 1));
			}
		}
	}
}

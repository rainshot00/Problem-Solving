import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String oper = st.nextToken().trim();

			if (oper.equals("push")) {
				int e = Integer.parseInt(st.nextToken());
				pq.add(-e);
			} else if (oper.equals("pop")) {
				sb.append(-pq.poll() + "\n");
			} else if (oper.equals("size")) {
				sb.append(pq.size() + "\n");
			} else if (oper.equals("empty")) {
				sb.append(pq.isEmpty() ? 1 : 0);
				sb.append("\n");
			} else {
				sb.append(-pq.peek() + "\n");
			}
		}

		System.out.println(sb.toString());
	}
}

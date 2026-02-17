import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair p) {
			if (this.x + this.y == p.x + p.y) {
				if (this.x == p.x) {
					return this.y - p.y;
				}
				return this.x - p.x;
			}
			return (this.x + this.y) - (p.x + p.y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			pq.add(new Pair(x, y));
		}

		for (int i = 0; i < m; i++) {
			Pair p = pq.poll();

			pq.add(new Pair(p.x + 2, p.y + 2));
		}

		Pair p = pq.poll();

		System.out.println(p.x + " " + p.y);
	}
}

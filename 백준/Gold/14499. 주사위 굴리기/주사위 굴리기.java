import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m, y, x, k;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { 1, -1, 0, 0 };

	// bottom -> south -> top -> north
	static List<Integer> diceCol = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
	// bottom -> east -> top -> west
	static List<Integer> diceRow = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

	static void roll(int operation) {
		int yy = y + dy[operation];
		int xx = x + dx[operation];

		if (yy < 0 || yy >= n || xx < 0 || xx >= m) {
			return;
		}

		y = yy;
		x = xx;

		if (operation == 0) {
			int newBottom = diceRow.get(1);
			int newTop = diceRow.get(3);
			diceCol.set(0, newBottom);
			diceCol.set(2, newTop);

			int tmp = diceRow.remove(0);
			diceRow.add(tmp);
		} else if (operation == 1) {
			int newBottom = diceRow.get(3);
			int newTop = diceRow.get(1);
			diceCol.set(0, newBottom);
			diceCol.set(2, newTop);

			int tmp = diceRow.remove(3);
			diceRow.add(0, tmp);
		} else if (operation == 2) {
			int newBottom = diceCol.get(3);
			int newTop = diceCol.get(1);
			diceRow.set(0, newBottom);
			diceRow.set(2, newTop);

			int tmp = diceCol.remove(3);
			diceCol.add(0, tmp);
		} else {
			int newBottom = diceCol.get(1);
			int newTop = diceCol.get(3);
			diceRow.set(0, newBottom);
			diceRow.set(2, newTop);

			int tmp = diceCol.remove(0);
			diceCol.add(tmp);
		}

		if (arr[yy][xx] == 0) {
			arr[yy][xx] = diceCol.get(0);
		} else {
			diceCol.set(0, arr[yy][xx]);
			diceRow.set(0, arr[yy][xx]);
			arr[yy][xx] = 0;
		}

		sb.append(diceCol.get(2) + "\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			roll(Integer.parseInt(st.nextToken()) - 1);
		}

		System.out.println(sb.toString());
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			int k = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr.add(new ArrayList<>());

				for (int j = 0; j < 8; j++) {
					arr.get(i).add(Integer.parseInt(st.nextToken()));
				}
			}

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int magnet = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				int[] rotate = new int[4];
				rotate[--magnet] = direction;

				for (int mag = magnet - 1; mag >= 0; mag--) {
					if (arr.get(mag).get(2) == arr.get(mag + 1).get(6))
						break;

					rotate[mag] -= rotate[mag + 1];
				}

				for (int mag = magnet + 1; mag < 4; mag++) {
					if (arr.get(mag).get(6) == arr.get(mag - 1).get(2))
						break;

					rotate[mag] -= rotate[mag - 1];
				}

				for (int idx = 0; idx < 4; idx++) {
					if (rotate[idx] > 0) {
						for (int step = 0; step < rotate[idx]; step++) {
							int tmp = arr.get(idx).get(7);
							arr.get(idx).remove(7);
							arr.get(idx).add(0, tmp);
						}
					} else if (rotate[idx] < 0) {
						for (int step = 0; step < rotate[idx] * -1; step++) {
							int tmp = arr.get(idx).get(0);
							arr.get(idx).remove(0);
							arr.get(idx).add(tmp);
						}
					}
				}
			}

			int ans = arr.get(0).get(0) * 1 + arr.get(1).get(0) * 2 + arr.get(2).get(0) * 4 + arr.get(3).get(0) * 8;
			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}

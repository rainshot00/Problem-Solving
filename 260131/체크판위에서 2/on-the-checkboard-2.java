import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int ans = 0;

        char[][] arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 1; i < r - 1; i++) {
            for (int k = 1; k < c - 1; k++) {
                if (arr[i][k] == arr[0][0])
                    continue;
                
                for (int y = i + 1; y < r - 1; y++) {
                    for (int x = k + 1; x < c - 1; x++) {
                        if (arr[y][x] == arr[i][k])
                            continue;
                        
                        if (arr[y][x] == arr[r - 1][c - 1])
                            continue;
                        
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
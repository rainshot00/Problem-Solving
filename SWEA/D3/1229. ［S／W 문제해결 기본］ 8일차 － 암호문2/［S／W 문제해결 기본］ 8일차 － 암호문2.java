import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
 
            int command = Integer.parseInt(br.readLine());
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < command; i++) {
                char c = st.nextToken().charAt(0);
 
                int pos = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
 
                if (c == 'I') {
                    for (int step = 0; step < num; step++) {
                        int data = Integer.parseInt(st.nextToken());
 
                        arr.add(pos, data);
                        pos++;
                    }
                } else if (c == 'D') {
                    for (int step = 0; step < num; step++) {
                        arr.remove(pos);
                    }
                }
            }
 
            System.out.print("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }
    }
 
}
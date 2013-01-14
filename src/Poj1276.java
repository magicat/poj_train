import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Poj1276 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		while (scan.hasNext()) {
			int cash = scan.nextInt();
			int n = scan.nextInt();
			List<Integer> ds = new ArrayList<Integer>();
			for (int i = 0; i < n; i ++) {
				int a = scan.nextInt();
				int d = scan.nextInt();
				
				int k = 1;
				int total = 1;
				while (total <= a) {
					ds.add(k*d);
					k *= 2;
					total += k;
				}
				if (a - total + k > 0) {
					ds.add((a-total+k)*d);
				}
			}
			if (cash == 0 || ds.size() == 0) {
				System.out.println(0);
				continue;
			}
			boolean[] dp = new boolean[cash+1];
			dp[0] = true;
			int k = ds.size();
			for (int i = 0; i < k; i ++) {
				for (int j = cash; j >=ds.get(i); j --) {
					dp[j] = dp[j] || dp[j-ds.get(i)];
				}
			}
			for (int i = cash; i >= 0; i --) {
				if (dp[i]) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}

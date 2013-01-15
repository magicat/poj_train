import java.util.Arrays;
import java.util.Scanner;


public class Poj2533 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n];
		for (int i = 0; i < n; i ++) {
			d[i] = sc.nextInt();
		}
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 1; i < n; i ++) {
			for (int j = 0; j < i; j ++) {
				if (d[j] < d[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		for (int j = 0; j < n; j ++) {
			res = Math.max(res, dp[j]);
		}
		System.out.println(res);
	}
}

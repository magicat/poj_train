import java.util.Scanner;


public class Poj1836 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] hs = new double[n];
		for (int i = 0; i < n; i++) {
			hs[i] = sc.nextDouble();
		}
		int[][] dp = new int[n][3];
		for (int i = 0; i < n; i ++) {
			dp[i][0]= 1;
			dp[i][1]= 1;
			dp[i][2]= 1;
		}
		for (int i = 1; i < n; i ++) {
			for (int j = i-1; j >=0; j--) {
				if (hs[i] > hs[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0]+1);
				}
				if (hs[i] < hs[j]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1]+1);
					dp[i][1] = Math.max(dp[i][1], dp[j][2]+1);
					dp[i][1] = Math.max(dp[i][1], dp[j][0]+1);
				}
				if (hs[i] == hs[j]) {
					dp[i][2] = Math.max(dp[i][2], dp[j][0]+1);
				}
			}
		}
		int res = 0;
//		for (int i = 0; i < n; i ++) {
//			System.out.println(dp[i][0] + ", " + dp[i][1] + ", " + dp[i][2]);
//		}
		for (int i = 0; i < n; i ++) {
			res = Math.max(res, dp[i][0]);
			res = Math.max(res, dp[i][1]);
			res = Math.max(res, dp[i][2]);
		}
		System.out.println(n - res);
	}
}

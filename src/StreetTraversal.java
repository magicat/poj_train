import java.util.Scanner;


public class StreetTraversal {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dis = new int[n][n];
		for (int i = 0; i < n; i ++) {
			dis[i] = new int[n];
			for (int j = 0; j < n; j ++) {
				dis[i][j] = sc.nextInt();
			}
		}
		int[][] dp = new int[n+1][n+1];
		for (int i = 1; i <= n; i ++)
			for (int j = 1; j <= n; j ++)
				dp[i][j] = Integer.MAX_VALUE / 2;
		
		dp[1][1] = 0;
		dp[1][2] = dis[0][1];
		dp[2][1] = dis[0][1];
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (i == j) continue;
				if (j == i - 1) {
					for (int k = 1; k < j; k ++) {
						dp[i][j] = Math.min(dp[i][j], dp[k][j] + dis[k-1][i-1]);
					}
				} else if (i == j - 1) {
					for (int k = 1; k < i; k ++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dis[k-1][j-1]);
					}
				} else if (i > j) {
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + dis[i-2][i-1]);
				} else {
					dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + dis[j-1][j-2]);
				}
			}
		}
		int res = Integer.MAX_VALUE/2;
		
		for (int i = 1; i <n; i ++) {
			res = Math.min(res, dp[n][i]);
		}
		System.out.println(res);
	}
	
}

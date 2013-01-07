import java.io.BufferedInputStream;
import java.util.Scanner;


public class Poj2151 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		while (true) {
			int m = scan.nextInt();
			int t = scan.nextInt();
			int n = scan.nextInt();
			if (m == 0) break;
			double[][] data = new double[t][m];
			for (int i = 0; i < t; i ++) {
				for (int j = 0; j < m; j ++) {
					data[i][j] = scan.nextDouble();
				}
			}
			double res = solve(data, t, m, n);
			System.out.printf("%.3f\n", res);
		}
		
	}

	private static double solve(double[][] data, int t, int m, int n) {
		double p1 = 1;
		for (int i = 0; i < t; i ++) {
			double p = 1;
			for (int j = 0; j < m; j ++) {
				p *= (1-data[i][j]);
			}
			p1 *= (1-p);
		}
		double p2 = 1;
		for (int i = 0; i < t; i ++) {
			double p = 0;
			double[] dp = new double[n+1];
			dp[0] = 1 - data[i][0];
			dp[1] = data[i][0];
			
			for (int j = 1; j < m; j ++) {
				double[] tmp = new double[n+1];
				for (int k = 0; k <= n; k ++) {
					tmp[k] += dp[k] * (1-data[i][j]);
					if (k < n)
						tmp[k+1] += dp[k] * data[i][j];
				}
				dp = tmp;
			}
			for (int j = 1; j < n; j ++) {
				p += dp[j];
				
			}
			p2 *= p;
		}
		return p1 - p2;
	}
}

import java.io.BufferedInputStream;
import java.util.Scanner;


public class Poj1837 {

	private static final int LENGTH = 16000;

	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		int c = scan.nextInt();
		int g = scan.nextInt();
		int[] cs = new int[c];
		int[] gs = new int[g];
		for (int i = 0; i < c; i ++) cs[i] = scan.nextInt();
		for (int i = 0; i < g; i ++) gs[i] = scan.nextInt();
		int[] dp = new int[LENGTH];
		int zero = LENGTH / 2;
		dp[zero] = 1;
		for (int i = 0; i < g; i ++) {
			int[] tmp = new int[LENGTH];
			for (int j = 0; j < c; j ++) {
				int w = gs[i] * cs[j];
				for (int k = 0; k < LENGTH; k ++) {
					if (dp[k] > 0) {
						tmp[k+w] += dp[k];
					}
				}
			}
			dp = tmp;
		}
		System.out.println(dp[zero]);
	}
}

import java.io.BufferedInputStream;
import java.util.Scanner;


public class Poj3267 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		int w = scan.nextInt();
		scan.nextInt();
		String in = scan.next();
		String dic[] = new String[w];
		for (int i = 0; i < w; i ++) {
			dic[i] = scan.next();
		}
		int[] dp = new int[in.length()+1];
		for (int i = 0; i < dp.length; i ++) {
			dp[i] = i;
		}
		for (int i = 1; i <= in.length(); i ++) {
			for (int j = 0; j < w; j ++) {
				if (i < dic[j].length()) continue;
				int p = dic[j].length()-1;
				int k = i-1;
				int gap = 0;
				while (k >= 0 && p>=0) {
					if (in.charAt(k) == dic[j].charAt(p)) {
						p --;
					} else {
						gap ++;
					}
					k--;
				}
				if (p == -1) {
					dp[i] = Math.min(dp[i], dp[k+1]+gap);
				}
			}
		}
//		for (int i = 0; i < dp.length; i ++) {
//			System.out.print(dp[i]+" ");
//		}
//		System.out.println();
		System.out.println(dp[in.length()]);
	}
}

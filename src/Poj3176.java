import java.util.Scanner;


public class Poj3176 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prev = null;
		for (int i = 1; i <= n; i ++) {
			int[] cs = new int[i];
			for (int j = 0; j < i; j ++) {
				cs[j] = sc.nextInt();
			}
			if (i > 1) {
				cs[0] += prev[0];
				cs[i-1] += prev[i-2];
				for (int j = 1; j < i-1; j ++) {
					cs[j] += Math.max(prev[j-1], prev[j]);
				}
			}
			prev = cs;
		}
		int res = 0;
		for (int i = 0; i < prev.length; i ++) {
			res = Math.max(res, prev[i]);
		}
		System.out.println(res);
	}
}

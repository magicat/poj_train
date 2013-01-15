import java.util.Scanner;


public class Poj1260 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			E[] cs = new E[m];
			for (int j = 0; j < m; j ++) {
				cs[j] = new E(sc.nextInt(), sc.nextInt());
			}
			int r = solve(cs);
			System.out.println(r);
		}
	}

	private static int solve(E[] cs) {
		int n = cs.length;
		E[] cc = new E[n];
		for (int i = 0; i < n; i ++) {
			cc[n - i - 1] = cs[i];
		}
		int[] dp = new int[n];
		dp[0] = (10 + cc[0].a) * cc[0].p;
		for (int i = 1; i < n; i ++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j ++) {
				min = Math.min(min, dp[j]);
				dp[j] = dp[j] + cc[j].p * cc[i].a;
			}
			dp[i] = min + (10 + cc[i].a) * cc[i].p;
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i ++) {
			res = Math.min(res, dp[i]);
		}
		return res;
	}
}
class E implements Comparable<E>{

	int p;
	int a;
	
	public E(int a, int p) {
		this.a = a;
		this.p = p;
	}

	@Override
	public int compareTo(E e) {
		return this.p - e.p;
	}
	
}
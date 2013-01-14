/* @author: */
import java.util.Scanner;

public class Poj2531 {
	static int[][] map = new int[22][22];
	static int n = 0;
	static boolean[] state = new boolean[22];
	static int res = 0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0);
		System.out.println(res);
	}

	private static void dfs(int i, int t) {
		state[i] = true;
		int r = t;
		for (int j = 0; j < i; j ++) {
			if (!state[j]) {
				r += map[i][j];
			}
		}
		if (i == n-1) {
			res = Math.max(res, r);
		} else {
			dfs(i+1, r);
		}
		state[i] = false;
		r = t;
		for (int j = 0; j < i; j ++) {
			if (state[j]) {
				r += map[i][j];
			}
		}
		if (i == n-1) {
			res = Math.max(res, r);
		} else {
			dfs(i+1, r);
		}
	}
}

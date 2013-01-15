import java.util.Scanner;

public class Poj1159 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int[] prev = new int[n];
		int[] pprev = new int[n+1];
		for (int i = 1; i < n; i ++) {
			int[] cur = new int[n-i];
			for (int j = 0; j < n - i; j ++) {
				char c1 = s.charAt(j);
				char c2 = s.charAt(j+i);
				if (c1 == c2) {
					cur[j] = pprev[j+1];
				} else {
					cur[j] = Math.min(prev[j], prev[j+1])+1;
				}
			}
			pprev = prev;
			prev = cur;
		}
		System.out.println(prev[0]);
	}
}

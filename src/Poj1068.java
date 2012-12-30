/* @author: */
import java.util.LinkedList;
import java.util.Scanner;

public class Poj1068 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			int m = sc.nextInt();
			int[] seq = new int[m];
			for (int j = 0; j < m; j ++) {
				seq[j] = sc.nextInt();
			}
			solve(seq);
		}
	}

	private static void solve(int[] seq) {
		String s = "";
		int prev = 0;
		for (int i = 0; i < seq.length; i ++) {
			for (int j = 0; j < seq[i]-prev; j ++) {
				s += "(";
			}
			prev = seq[i];
			s += ")";
		}
		int bef = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		String res = "";
		for (int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(bef);
			} else {
				bef ++;
				int bef1 = stack.poll();
				res += bef - bef1;
				res += " ";
			}
		}
		System.out.println(res.trim());
	}
}


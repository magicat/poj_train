import java.util.Arrays;
import java.util.Scanner;


public class Poj1328 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int no = 1;
		while (true) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			if (n == 0 && d == 0) {
				break;
			}
			Node[] ns = new Node[n];
			boolean f = false;
			for (int i = 0; i < n; i ++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if (y > d) f = true;
				ns[i] = new Node(x, y, d);
			}
			
			int res = 0;
			if (f) {
				res = -1;
			} else {
				Arrays.sort(ns);
				int i = 1;
				double pos = ns[0].e;
				res = 1;
				while (i < n) {
					double s = ns[i].s;
					double e = ns[i].e;
					if (pos < s) {
						pos = e;
						res ++;
					}
					i ++;
				}
			}
			
			System.out.println("Case " + no + ": " + res);
			no ++;
		}
	}
}

class Node implements Comparable<Node> {
	
	public Node(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.s = 0.0 + x - Math.sqrt(d * d - y * y);
		this.e = 0.0 + x + Math.sqrt(d * d - y * y);
	}
	
	int x;
	int y;
	double s;
	double e;
	
	@Override
	public int compareTo(Node n) {
		if (this.e > n.e) return 1;
		else if (this.e < n.e) return -1;
		return 0;
	}
	
}

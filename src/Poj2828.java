import java.util.Scanner;


public class Poj2828 {
	static int[] res = null;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] pos = new int[n];
			int[] val = new int[n];
			for (int i = 0; i < n; i ++) {
				pos[i] = sc.nextInt();
				val[i] = sc.nextInt();
			}
			solve(pos, val);
		}
	}

	private static void solve(int[] pos, int[] val) {
		int n = pos.length;
		int[][] tree = new int[500000][3];
		res = new int[n];
		
		tree[0][0] = 0;
		tree[0][1] = 20010;
		
		build(tree, 0);
		for (int i = n-1; i >= 0; i --) {
			int p = pos[i];
			int v = val[i];
			int m = find(tree, 0, p+1);
			res[m] = v;
		}
		String r = "";
		for (int i = 0; i < n; i ++) {
			r += " " + res[i];
		}
		System.out.println(r.trim());
	}
	
	private static int find(int[][] tree, int i, int p) {
		int l = tree[i][0];
		int r = tree[i][1];
		tree[i][2] --;
		if (l == r) {
			return r;
		}
		
		int c1 = tree[i*2+1][2];
		if (c1 >= p) return find(tree, i*2+1, p);
		else return find(tree, i*2+2, p-c1);
	}

	private static void build(int[][] tree, int i) {
		int l = tree[i][0];
		int r = tree[i][1];
		tree[i][2] = r - l+1;
		if (l == r) return;
		if (l < r) {
			int m = ((l+r)/2);
			tree[i*2+1][0] = l;
			tree[i*2+1][1] = m;
			tree[i*2+2][0] = (m+1);
			tree[i*2+2][1] = r;
			build(tree, i*2+1);
			build(tree, i*2+2);
		}
	}
}


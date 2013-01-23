import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Poj2528 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			int m = sc.nextInt();
			int[] ss = new int[m];
			int[] es = new int[m];
			for (int j = 0; j < m; j ++) {
				ss[j] = sc.nextInt();
				es[j] = sc.nextInt();
			}
			int r = solve(ss, es);
			System.out.println(r);
		}
	}

	private static int solve(int[] ss, int[] es) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < ss.length; i ++) set.add(ss[i]);
		for (int i = 0; i < es.length; i ++) set.add(es[i]);
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		Collections.sort(list);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < list.size(); i ++) {
			map.put(list.get(i), i+1);
		}
		for (int i = 0; i < ss.length; i ++) ss[i] = map.get(ss[i]);
		for (int i = 0; i < es.length; i ++) es[i] = map.get(es[i]);
		
		int[][] tree = new int[500000][3];
		tree[0][0] = 1;
		tree[0][1] = 20010;
		build(tree, 0);
		int res = 0;
		for (int i = ss.length-1; i >= 0; i --) {
			int s = ss[i];
			int e = es[i];
			if (!check(tree, 0, s, e)) {
				add(tree, 0, s, e);
				res ++;
			}
		}
		return res;
	}

	private static void add(int[][] tree, int i, int s, int e) {
		int l = tree[i][0];
		int r = tree[i][1];
		int c = tree[i][2];
		if (c == 1) {
			tree[i][2] = 1;
			return;
		}
		if (s <= l && e >= r) {
			tree[i][2] = 1;
		} else {
			if (e < l || s > r) return;
			int mid = (l+r)/2;
			if (e <= mid) {
				add(tree, i*2+1, s, e);
			} else if (s >= mid+1) {
				add(tree, i*2+2, s, e);
			} else {
				add(tree, i*2+1, s, mid);
				add(tree, i*2+2, mid+1, e);
			}
		}
	}

	private static boolean check(int[][] tree, int i, int s, int e) {
		int l = tree[i][0];
		int r = tree[i][1];
		int c = tree[i][2];
		if (c == 1) {
			return true;
		}
		if (s <= l && e >= r) {
			return false;
		}
		
		if (l == r) return false;
		int mid = (l+r)/2;
		if (mid < s) {
			return check(tree, i*2+2, s, e);
		} else if (mid >= s && mid+1 <= e) {
			return check(tree, i*2+1, s, mid) 
					&& check(tree, i*2+2, mid+1, e);
			
		} else {
			return check(tree, i*2+1, s, e);
		}
	}

	private static void build(int[][] tree, int i) {
			int l = tree[i][0];
			int r = tree[i][1];
			if (l == r) return;
			if (l < r) {
				int m = (l+r)/2;
				tree[i*2+1][0] = l;
				tree[i*2+1][1] = m;
				tree[i*2+2][0] = m+1;
				tree[i*2+2][1] = r;
				build(tree, i*2+1);
				build(tree, i*2+2);
			}
	}
	
	
}

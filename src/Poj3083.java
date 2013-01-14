import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Poj3083 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int res = solve(n, k);
		System.out.println(res);
	}

	private static int solve(int n, int k) {
		if (n >= k) return n-k;
		Queue<Node3083> q = new LinkedList<Node3083>();
		q.offer(new Node3083(n, 0));
		int res = Math.abs(n - k);
		boolean[] map = new boolean[200000];
		map[n] = true;
		while (!q.isEmpty()) {
			Node3083 cur = q.poll();
//			System.out.println(cur);
			if (cur.pos == k) {
				res = Math.min(res, cur.cnt);
				break;
			} else {
				put(map, q, cur.pos-1, cur.cnt+1);
				put(map, q, cur.pos+1, cur.cnt+1);
				put(map, q, cur.pos*2, cur.cnt+1);
			}
		}
		return res;
	}

	private static void put(boolean[] map, Queue<Node3083> q, int pos, int cnt) {
		if (pos >= map.length || pos <= 0 || map[pos]) {
			return;
		}
		map[pos] = true;
		q.offer(new Node3083(pos,cnt));
	}
}

class Node3083 {
	public Node3083(int n, int i) {
		this.pos = n;
		this.cnt = i;
	}
	int pos;
	int cnt;
	public String toString() {
		return "["+pos + ":" + cnt +"]";
	}
}

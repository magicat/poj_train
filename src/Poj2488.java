import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Poj2488 {
	static int[][] steps = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i ++) {
			int q = sc.nextInt();
			int p = sc.nextInt();
			System.out.println("Scenario #"+i+":");
			System.out.println(solve(p, q));
			if (i < n) {
				System.out.println();
			}
		}
	}

	private static String solve(int p, int q) {
		for (int i = 0; i < p; i ++) {
			for (int j = 0; j < q; j ++) {
				String r = dfs(p, q, i, j);
				if (r != null) return r;
			}
		}
		return "impossible";
	}

	private static String dfs(int p, int q, int i, int j) {
		boolean[][] visited = new boolean[p][q];
		List<Node2488> stack = new LinkedList<Node2488>();
		stack.add(new Node2488(i, j, 1));
		visited[i][j] = true;
		while (!stack.isEmpty()) {
			Node2488 cur = stack.get(stack.size()-1);
			if (cur.len == p * q) {
				String res = "";
				Node2488 node = cur;
				while (node != null) {
					res = "" + ((char)('A' + node.i)) + (node.j+1) + res; 
					node = node.prev;
				}
				return res;
			} else {
				boolean no = true;
				for (int k = cur.last; k < 8; k ++) {
					int nexti = cur.i + steps[k][0];
					int nextj = cur.j + steps[k][1];
					cur.last ++;
					if (nexti < 0 || nexti >= p || nextj < 0 || nextj >= q) {
						continue;
					}
					if (visited[nexti][nextj]) {
						continue;
					}
					Node2488 next = new Node2488(nexti, nextj, cur.len+1);
					next.prev = cur;
					stack.add(next);
					visited[nexti][nextj] = true;
					no = false;
					break;
				}
				if (no) {
					stack.remove(stack.size()-1);
					visited[cur.i][cur.j] = false;
				}
			}
		}
		return null;
	}
}

class Node2488 {
	public Node2488(int i2, int j2, int len) {
		this.i = i2;
		this.j = j2;
		this.len = len;
	}
	Node2488 prev;
	int len = 0;
	int i, j;
	int last = 0;
}

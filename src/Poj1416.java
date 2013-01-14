import java.util.Scanner;


public class Poj1416 {
	static int target = 0;
	static int res = 0;
	static boolean rejected = false;
	static String path = "";
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			res = 0;
			rejected = false;
			target = sc.nextInt();
			int num = sc.nextInt();
			if (target == 0 && num == 0) break;
			if (target == num) {
				System.out.println(target + " " + target);
			} else {
				dfs("", num + "", 0);
				if (rejected) System.out.println("rejected");
				else if (res == 0) System.out.println("error");
				else System.out.println(res + " " + path.trim());
			}
		}
	}
	private static void dfs(String p, String s, int already) {
		int n = s.length();
		int r = 0;
		for (int i = 0; i < n; i ++) {
			r *= 10;
			r += s.charAt(i) - '0';
			String left = s.substring(i+1);
			int k = already + r;
			if (!left.equals("")) {
				dfs(p + " " + r, left, k);
			} else {
				if (k > target) break;
				if (k <= target) {
					if (k > res) {
						res = k;
						path = p + " " + r;
						rejected = false;
					}
					else if (k == res) {
						rejected = true;
					}
				}
			}
		}
	}
}

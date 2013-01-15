import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Poj1080 {

	static Map<String, Integer> map = new HashMap<String, Integer>();
	static {
		map.put("AA", 5);
		map.put("AC", -1);
		map.put("AG", -2);
		map.put("AT", -1);
		map.put("A-", -3);
		
		map.put("CA", -1);
		map.put("CC", 5);
		map.put("CG", -3);
		map.put("CT", -2);
		map.put("C-", -4);
		
		map.put("GA", -2);
		map.put("GC", -3);
		map.put("GG", 5);
		map.put("GT", -2);
		map.put("G-", -2);
		
		map.put("TA", -1);
		map.put("TC", -2);
		map.put("TG", -2);
		map.put("TT", 5);
		map.put("T-", -1);
		
		map.put("-A", -3);
		map.put("-C", -4);
		map.put("-G", -2);
		map.put("-T", -1);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i ++) {
			int a = sc.nextInt();
			String s1 = sc.next();
			int b = sc.nextInt();
			String s2 = sc.next();
			int[][] dp = new int[a+1][b+1];
			dp[0][0] = 0;
			for (int j = 1; j <= a; j ++) {
				dp[j][0] = dp[j-1][0] + cal(s1.charAt(j-1), '-');
			}
			for (int j = 1; j <= b; j ++) {
				dp[0][j] = dp[0][j-1] + cal(s2.charAt(j-1), '-');
			}
			for (int j = 1; j <= a; j ++) {
				for (int k = 1; k <= b; k ++) {
					dp[j][k] = Math.max(dp[j-1][k]+cal(s1.charAt(j-1),'-'), 
								Math.max(dp[j][k-1]+cal(s2.charAt(k-1),'-'), 
									dp[j-1][k-1]+cal(s1.charAt(j-1), s2.charAt(k-1))));
				}
			}
			System.out.println(dp[a][b]);
		}
	}
	
	private static int cal(char c1, char c2) {
		String key = "" + c1+c2;
		return map.get(key);
	}
}

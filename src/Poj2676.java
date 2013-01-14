import java.util.Arrays;
import java.util.Scanner;


public class Poj2676 {
	static int[][] data = new int[9][9];
	static int[] mask1 = new int[9];
	static int[] mask2 = new int[9];
	static int[] mask3 = new int[9];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			Arrays.fill(mask1, 0);
			Arrays.fill(mask2, 0);
			Arrays.fill(mask3, 0);
			for (int j = 0; j < 9; j ++) {
				String s = sc.next();
				for (int t = 0; t < s.length(); t ++) {
					int k = s.charAt(t) - '0';
					data[j][t] = k;
					if (k > 0) {
						mask1[j]|= (1<<(k-1));
						mask2[t]|= (1<<(k-1));
						mask3[j/3*3 + (t/3)] |= (1<<(k-1));
					}
				}
			}
			dfs(0);
			for (int j = 0; j < 9; j ++) {
				for (int k = 0; k < 9; k ++) {
					System.out.print(data[j][k]);
				}
				System.out.println();
			}
		}
	}
	private static boolean dfs(int index) {
		while (index < 81 && data[index/9][index%9] > 0) {
			index ++;
		}
		if (index == 81) {
			return true;
		}
		int x = index/9;
		int y = index%9;
		for (int i = 1; i <= 9; i ++) {

			int p = 1<<(i-1);
			if ((mask1[x] & p) == 0)
				if ((mask2[y] & p) == 0)
					if ((mask3[x/3*3+(y/3)] & p) == 0) {
						mask1[x] |= p;
						mask2[y] |= p;
						mask3[x/3*3+(y/3)] |= p;
						data[x][y] = i;
						if (dfs(index+1)) return true;
						mask1[x] ^= p;
						mask2[y] ^= p;
						mask3[x/3*3+(y/3)] ^= p;
						data[x][y] = 0;
					}
		}
		return false;
	}
}

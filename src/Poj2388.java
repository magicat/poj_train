/* @author: */
import java.util.Scanner;

public class Poj2388 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cows = new int[n];
		for (int i = 0; i < n; i ++) {
			cows[i] = sc.nextInt();
		}
		System.out.println(find(cows, 0, n-1, n/2));
	}

	private static int find(int[] cows, int st, int end, int k) {
		int p = cows[st];
		int i = st + 1;
		int j = end;
		while (i <= j) {
			if (cows[i] <= p) {
				i ++;
				continue;
			}
			if (cows[j] >= p) {
				j --;
				continue;
			}
			swap(cows, i, j);
			i ++;
			j --;
		}
		swap(cows, st, j);
		if (j == k) return cows[j];
		if (j < k) return find(cows, j+1, end, k);
		else return find(cows, st, j-1, k);
	}

	private static void swap(int[] cows, int i, int j) {
		int tmp = cows[i];
		cows[i] = cows[j];
		cows[j] = tmp;
	}

}


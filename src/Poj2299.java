/* @author: */
import java.util.Scanner;

public class Poj2299 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0) break;
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) {
				a[i] = sc.nextInt();
			}
			System.out.println(slove(a));
		}
	}

	private static int slove(int[] a) {
		int n = a.length;
		int[] reverse = new int[n];
		mergeSort(a);
		
		return 0;
	}

	private static int[] mergeSort(int[] a) {
		if (a.length <= 1) return a;
		int n = a.length;
		int[] b = new int[n/2];
		for (int i = 0; i < n/2; i ++) {
			b[i] = a[i];
		}
		int[] c = new int[n - n/2];
		for (int i = 0; i < (n-n/2); i ++) {
			c[i] = a[i+n/2];
		}
		int[] d = mergeSort(b);
		int[] e = mergeSort(c);
		return merge(d, e);
	}

	private static int[] merge(int[] d, int[] e) {
		int r[] = new int[d.length + e.length];
		
		return null;
	}
}


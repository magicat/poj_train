import java.io.BufferedInputStream;
import java.util.Scanner;

public class Poj2299 {
	static long res = 0;

	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		while (scan.hasNext()) {
			int n = scan.nextInt();
			if (n == 0) {
				break;
			}
			res = 0;
			int data[] = new int[n];
			for (int i = 0; i < n; i++) {
				data[i] = scan.nextInt();
			}
			msort(data, 0, n - 1);
			System.out.println(res);
		}
	}

	private static void msort(int[] a, int s, int e) {
		if (s < e) {
			int mid = (s + e) / 2;
			msort(a, s, mid);
			msort(a, mid + 1, e);
			merge(a, s, mid, e);
		}
	}

	private static void merge(int[] a, int s, int mid, int e) {
		int i = s, j = mid + 1;
		int[] tmp = new int[e - s + 1];
		int k = 0;
		while (i <= mid && j <= e) {
			if (a[i] > a[j]) {
				tmp[k++] = a[j++];
				res += mid - i + 1;
			} else {
				tmp[k++] = a[i++];
			}
		}
		while (i <= mid) {
			tmp[k++] = a[i++];
		}
		while (j <= e) {
			tmp[k++] = a[j++];
		}
		for (i = s, k = 0; i <= e; i++, k++) {
			a[i] = tmp[k];
		}
	}
}
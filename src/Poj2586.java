/* @author: */
import java.util.Scanner;

public class Poj2586 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			int res = 0;
			for (int i = 0; i < (1<<12); i ++) {
				boolean f = true;
				for (int j = 0; j < 8; j ++) {
					int a = 0;
					for (int k = j; k < j + 5; k ++) {
						if ((i & (1<<k)) > 0) {
							a += s;
						} else {
							a -= d;
						}
					}
					if (a > 0) {
						f = false;
						break;
					}
				}
				if (f) {
					int a = 0;
					for (int j = 0; j < 12; j ++) {
						if ((i & (1<<j)) > 0) {
							a += s;
						} else {
							a -= d;
						}
					}
					if (a > 0)
						res = Math.max(res, a);
				}
			}
			if (res == 0) {
				System.out.println("Deficit");
			} else {
				System.out.println(res);
			}
		}
	}
}

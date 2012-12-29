import java.math.BigInteger;
import java.util.Scanner;

public class Poj2109 {

	static final BigInteger TWO = new BigInteger("2");
    static final BigInteger ONE = BigInteger.ONE;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger p;
		int n;
		while (in.hasNextInt()) {
			n = in.nextInt();
			p = in.nextBigInteger();
			BigInteger st = ONE;
			BigInteger en = p;
			BigInteger res = null;
			BigInteger mid = null;
			while (st.compareTo(en) <= 0) {
				mid = en.add(st).divide(TWO);
				res = ONE;
				int i = 0;
				for (; i < n; i ++) {
					res = res.multiply(mid);
					if (res.compareTo(p) >= 0) {
						break;
					}
				}
				if (i+1 == n && res.compareTo(p) == 0) {
					break;
				}
				if (res.compareTo(p) < 0) {
					st = mid.add(ONE);
				} else {
					en = mid.subtract(ONE);
				}
			}
			System.out.println(mid);
		}
	}
}

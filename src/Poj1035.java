/* @author: */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Poj1035 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int f = 0;
		Set<String> dic = new HashSet<String>();
		List<String> dl = new ArrayList<String>();
		List<String> prob = new ArrayList<String>();
		while(true) {
			String s = sc.next();
			if (s.equals("#")) {
				f ++;
			} else {
				if (f == 0) {
					dic.add(s);
					dl.add(s);
				} else {
					prob.add(s);
				}
			}
			if (f == 2) {
				break;
			}
		}
		for (String p: prob) {
			if (dic.contains(p)) {
				System.out.println(p + " is correct");
			} else {
				String res = p + ":";
				for (String d: dl) {
					if (check(p, d)) {
						res += " " + d;
					}
				}
				System.out.println(res);
			}
		}
	}

	private static boolean check(String p, String d) {
		if (Math.abs(p.length() - d.length()) >= 2) return false;
		if (p.length() == d.length()) {
			int c = 0;
			for (int i = 0; i < p.length(); i ++) {
				if (p.charAt(i) != d.charAt(i)) c ++;
			}
			if (c > 1) return false;
			return true;
		} else {
			if (p.length() < d.length()) {
				String tmp = p;
				p = d;
				d = tmp;
			}
			boolean f = false;
			for (int i = 0; i < d.length();) {
				if (!f) {
					if (p.charAt(i) != d.charAt(i)) {
						f = true;
					} else {
						i ++;
					}
				} else {
					if (p.charAt(i+1) != d.charAt(i)) {
						return false;
					}
					i ++;
				}
			}
			return true;
		}
		
	}
}


import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Poj1840 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		int[] a = new int[5];
		for (int i = 0; i < 5; i ++) {
			a[i] = scan.nextInt();
		}
		Map<Integer, Integer> map1 = cal(a, 0, 2);
		Map<Integer, Integer> map2 = cal(a, 3, 4);
		int res = 0;
		for (Entry<Integer, Integer> entry: map2.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			res += value * get(map1, -key);
		}
		System.out.println(res);
	}

	private static Map<Integer, Integer> cal(int[] a, int s, int e) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = -50; i <= 50; i ++) {
			if (i == 0) continue;
			int key = a[s] * i * i * i;
			map.put(key, get(map, key)+1);
		}
		for (int i = s+1; i <=e; i ++) {
			Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
			for (int j = -50; j <= 50; j ++) {
				if (j == 0) continue;
				for (Entry<Integer, Integer> entry: map.entrySet()) {
					int key = entry.getKey();
					int value = entry.getValue();
					int key1 = key + j * j * j * a[i];
					m1.put(key1, value + get(m1, key1));
				}				
			}
			map = m1;
		}
		return map;
	}

	private static int get(Map<Integer, Integer> map, int key) {
		if (map.containsKey(key)) return map.get(key);
		return 0;
	}
	
	
}

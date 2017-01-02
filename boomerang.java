import java.util.*;

public class boomerang {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int nights = scan.nextInt();
		for (int i = 1; i <= nights; i++) {
			int size = scan.nextInt();
			int[] x = new int[size];
			int[] y = new int[size];
			for (int j = 0; j < size; j++) {
				x[j] = scan.nextInt();
				y[j] = scan.nextInt();
			}
			int ans = 0;
			for (int k = 0; k < size; k++) {
				HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
				ArrayList<Double> indices = new ArrayList<Double>();
				for (int t = 0; t < size; t++) {
					if (t != k) {
						double distance = Math
								.sqrt(Math.pow(Math.abs(x[k] - x[t]), 2) + Math.pow(Math.abs(y[k] - y[t]), 2));
						if (cnt.get(distance) == null) {
							cnt.put(distance, 1);
						} else {
							cnt.put(distance, cnt.get(distance) + 1);
						}
						if (!indices.contains(distance)) {
							indices.add(distance);
						}
					}
				}
				for (double ind : indices) {
					if (cnt.get(ind) > 1) {
						int a = cnt.get(ind);
						ans += (a * (a - 1)) / 2;
					}
				}
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}
}

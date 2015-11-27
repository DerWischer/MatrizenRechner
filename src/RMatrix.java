
public class RMatrix {

	public static int[][] random(int n){
		int[][] m = new int[n][n];
		
		System.out.println("### ###");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++){
				int tmp= (int) (Math.random() * 100);
				m[i][j] = tmp;
				System.out.print(tmp + " ");
			}
			System.out.println();
		}		
		System.out.println("### ###");
		return m;
	}
	
}

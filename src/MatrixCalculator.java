public class MatrixCalculator {

	public int det(int[][] m) {
		int det = 0;
		int n = getDim(m);

		if (n == 1) {
			det = m[0][0];
			return det;
		} else {
			int[] first = m[0];
			for (int i = 0; i < first.length; i++) {
				int colFak = first[i];
				if (i % 2 == 1) {
					colFak *= -1;
				}
				int[][] subm = getSubmatrix(m, i);
				det += colFak * det(subm);
			}
		}
		return det;
	}

	private int[][] getSubmatrix(int[][] m, int ignoreCol) {
		int dim = getDim(m);
		int subm[][] = new int[dim - 1][dim - 1];

		for (int i = 1; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (j < ignoreCol) {
					subm[i - 1][j] = m[i][j];
				} else if (j > ignoreCol) {
					subm[i - 1][j - 1] = m[i][j];
				} else {
					continue;
				}
			}
		}

		return subm;
	}

	private int getDim(int[][] matrix) {
		return matrix.length;
	}

}

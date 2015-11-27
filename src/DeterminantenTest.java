import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeterminantenTest {

	private MatrixCalculator calculator;
	private int[][] random;

	@Before
	public void setUp() throws Exception {
		calculator = new MatrixCalculator();
		random = RMatrix.random(10);
	}

	@After
	public void tearDown() throws Exception {
		calculator = null;
	}

	@Test
	public void test_n1() {
		int[][] m = { { 7 } };
		int det = calculator.det(m);
		assertEquals(det, 7);
	}

	@Test
	public void test_n2() {
		int[][] m = { { 7, 2 }, { 2, 1 } };
		int det = calculator.det(m);
		assertEquals(det, 3);
	}

	@Test
	public void test_n3_a() {
		int[][] m = { { 7, 2, 3 }, { 2, 1, 3 }, { 2, 2, 1 } };
		int det = calculator.det(m);
		assertEquals(det, -21);
	}
	
	@Test
	public void test_n3_ma() {
		int[][] m = { { 2, 1, 3 }, { 7, 2, 3 }, { 2, 2, 1 } };
		int det = calculator.det(m);
		assertEquals(det, 21);
	}

	@Test
	public void test_n3_b() {
		int[][] m = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		int det = calculator.det(m);
		assertEquals(det, 0);
	}
	
	@Test
	public void test_n3_c() {
		int[][] m = { { 0, 1, 1 }, { 0, 2, 2 }, { 0, 3, 3 } };
		int det = calculator.det(m);
		assertEquals(det, 0);
	}
	
	@Test
	public void test_n3_d() {
		int[][] m = { { 7, 2, 3 }, { 2, 1, 3 }, { 2, 2, 1 } };
		int[][] m_trans = { {7, 2, 2}, {2, 1, 2}, {3, 3, 1} };
		int det = calculator.det(m);
		int det_trans = calculator.det(m_trans);
		assertEquals(det, det_trans);
	}

	@Test
	public void test_n6() {
		int[][] m = { { 7, 2, 3, 4, 8, 2 }, { 2, 1, 3, 4, 0, 8 },
				{ 2, 2, 1, 4, 1, 9 }, { -7, 2, 3, 4, 5, 12 },
				{ 1, 2, 9, 4, 8, -1 }, { 7, 6, 3, 4, 4, 2}

		};
		int det = calculator.det(m);
		assertEquals(det, -7296);
	}
	
	@Test
	public void test_random() {		
		int det = calculator.det(random);
		assertEquals(det, 0);
	}

	@Test(expected = NullPointerException.class)
	public void test_null() {
		int[][] m = null;		
		calculator.det(m);				
	}

}

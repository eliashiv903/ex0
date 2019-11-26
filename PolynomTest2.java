package myMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomTest2 {

	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Polynom test =new Polynom("2x");
		double output=test.f(3);
		assertEquals(6.0, output);
	}
	

}

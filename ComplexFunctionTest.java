package myMath;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ComplexFunctionTest {
	

	

		
		@SuppressWarnings("deprecation")
		@Test
		public void testF() {
			Polynom test =new Polynom("2x");
			double output=test.f(3);
			assertEquals(output, 6);
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testAddPolynom() {
			Polynom test =new Polynom("2x");
			test.add(new Polynom("2x+3+5x^4"));
			assertEquals(test.toString(), "3.0+4.0x+5.0x^4");
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testAddMonom() {
			Polynom test =new Polynom("2x+3+5x^4");
			test.add(new Monom("2x^5"));
			assertEquals(test.toString(), "3.0+2.0x+5.0x^4+2.0x^5");
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testSubstract() {
			Polynom test =new Polynom("2x+3+5x^4");
			test.substract(new Polynom("3+x+5x^4"));
			assertEquals(test.toString(),"x");
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testMultiplyPolynom() {
			Polynom test =new Polynom("2x+3+5x^4");
			test.multiply(new Polynom("2+x"));
			assertEquals(test.toString(),"6.0+7.0x+2.0x^2+10.0x^4+5.0x^5");
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testMultiplyMonom() {
			Polynom test =new Polynom("2x+3+5x^4");
			test.multiply(new Monom("x^5"));
			assertEquals(test.toString(),"3.0x^5+2.0x^6+5.0x^9");
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testInitFromString() {
			Polynom test =new Polynom();
			assertEquals(test.initFromString("3.0x^5+2.0x^6+5.0x^9").toString(),"3.0x^5+2.0x^6+5.0x^9" );
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testEquals() {
			Polynom test =new Polynom("2x");
			function test1 =new Monom("2x");
			assertEquals(test.equals(test1), true);
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testIsZero() {
			Polynom test =new Polynom("0");
			assertEquals(test.isZero(), true);
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testRoot() {
			Polynom test =new Polynom("5x^3+7");
			assertEquals(test.root(-100, 100, 0.0000001), -1.1186889838427305);
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testDerivative() {
			Polynom test =new Polynom("2x+3+2x^7");
			assertEquals(test.derivative(), "2.0+14.0x^6");
		}
		@SuppressWarnings("deprecation")
		@Test
		public void testArea() {
			Polynom test =new Polynom("480.0-164.0x-52.0x^2+5.0x^3+x^4");
			assertEquals(test.area(-5, 1, 0.01),2510.5459999980026);
		}
		@Test
		public void testCopy() {
			Polynom test =new Polynom("2x+1");
			assertEquals(test.copy(), "2x+1");
		}
		

	}





package myMath;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MonomTest2 {

	@Test
	public void testGet_coefficient() {
		Monom test =new Monom(2,1);
		double output=test.get_coefficient();
		assertEquals(output, 2);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGet_power() {
		Monom test =new Monom("22x^6");
		double output=test.get_power();
		assertEquals(output, 6);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testDerivative() {
		Monom test =new Monom(2,5);
		String output=test.derivative().toString();
		assertEquals(output, "10.0x^4");
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testF() {
		Monom test =new Monom("4x^2");
		double output=test.f(2);
		assertEquals(output, 16);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testIsZero() {
		Monom test =new Monom(0,0);
		boolean output=test.isZero();
		assertEquals(output, true);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testMultiply() {
		Monom test =new Monom("2x^3");
		Monom test1 =new Monom("x^2");
		test.multipy(test1);
		Monom output=new Monom(test.toString());
		assertEquals(output.toString(), "2.0x^5");
	}
	@Test
	public void testAdd() {
		Monom test =new Monom("4x^3");
		Monom test1 =new Monom("3x^3");
		test.add(test1);
		Monom output=new Monom(test.toString());
		assertEquals(output.toString(), "7.0x^3");
	}
	@Test
	public void testInitFromString() {
	Polynom test=new Polynom("2x");	
	Monom test1 =new Monom("3x^3");
	boolean output=test1.initFromString("2x").equals(test);
		assertEquals(output, true);
	}
	@Test
	public void testEquals() {
		Monom test =new Monom("4x^3");
		Monom test1 =new Monom(4,3);
		assertEquals(test, test1);
	}
	@Test
	public void testCopy() {
			Monom test =new Monom("4x^3");
			Monom test1 =new Monom(test);
		assertEquals(test1, test);
	}
	
	
}

package myMath;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ComplexFunctionTest {
	@SuppressWarnings("deprecation")
	@Test
	public void testErrInput() {

		for (int i = 0; i < 6; i++) {
		try{
			ComplexFunction test =new ComplexFunction("pplus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");	
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 1);
		try{
			ComplexFunction test =new ComplexFunction("plus(div(1+x+m,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 2);
		try{
			ComplexFunction test =new ComplexFunction("(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 3);
		try{
			ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x))),2.0)");
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 4);
		try{
			ComplexFunction test =new ComplexFunction("plus(div,(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 5);
		try{
			ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0");
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 6);
		try{
			ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x3,-2.0+x),-4.0+x)),2.0)");
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 7);
		Polynom e=new Polynom("3x^4");
		Polynom d=new Polynom("x^5+x+78");
		try{
			ComplexFunction test =new ComplexFunction("muel",e,d);
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 8);
		try{
			ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x))),2.0)");	
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 9);
		try{
			ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0,+x),-4.0+x)),2.0)");
		}
		catch(Exception f) {
			i++;
		}
		assertEquals(i, 10);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testF() {
		ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
		double output=test.f(8);
		assertEquals(output, 2.034090909090909);
		ComplexFunction test1 =new ComplexFunction("min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)");
		double output1=test1.f(-4);
		assertEquals(output1, -306.7);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testInitFromString() {
		ComplexFunction a=new ComplexFunction();
		assertEquals( a.initFromString("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)"),"plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCopy() {
		ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
		Polynom f1 =new Polynom("2x+3+5x^4");
		test.plus(f1);
		ComplexFunction test1 =new ComplexFunction(test.copy());
		test1.plus(f1);
		assertEquals(test.copy().toString(), test.toString());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testEquals() {
		Polynom test =new Polynom("2x+3+5x^4");
		test.substract(new Polynom("3+x+5x^4"));
		assertEquals(test.toString(),"x");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDivMaxMulMinCompPlus() {
		function y= new Polynom("x+3");
		function j= new Polynom("x-2");
		function b= new Polynom("x-4");
		function n= new Polynom("2");
		function m= new Polynom("x+1");
		ComplexFunction f5=new ComplexFunction(y);
		f5.mul(j);
		f5.mul(b);
		ComplexFunction test=new ComplexFunction(m);
		test.div(f5);
		test.plus(n);
		test.comp(m);
		test.min(n);
		test.max(test);
		assertEquals(test.toString(), "max(min(comp(plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0),1+x),2.0),min(comp(plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0),1+x),2.0))");
	}


	@Test
	public void testLeft() {
		ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
		assertEquals(test.left(),"div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x))");
	}
	@Test
	public void testRight() {
		ComplexFunction test =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
		assertEquals(test.right(),"2.0");
	}
	@Test
	public void testGetOp() {
		ComplexFunction test =new ComplexFunction("max(min(comp(plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0),1+x),2.0),min(comp(plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0),1+x),2.0))");
		assertEquals(test.getOp(),Operation.Max);
	}




}





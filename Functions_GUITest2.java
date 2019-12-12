package myMath;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class Functions_GUITest2 {
	@SuppressWarnings("deprecation")
	@Test

	
	public void testInitFromFileAndSaveToFileAndDrawFunctions1() {
	Functions_GUI ans = new Functions_GUI();
	String s1 = "3.1 +2.4x^2 -x^4";
	String s2 = "5 +2x -3.3x +0.1x^5";
	String[] s3 = {"x +3","x -2", "x -4"};
	Polynom p1 = new Polynom(s1);
	Polynom p2 = new Polynom(s2);
	Polynom p3 = new Polynom(s3[0]);
	ComplexFunction cf3 = new ComplexFunction(p3);
	for(int i=1;i<s3.length;i++) {
		cf3.mul(new Polynom(s3[i]));
	}
	ComplexFunction cf = new ComplexFunction(Operation.Plus, p1,p2);
	ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x +1"),cf3);
	cf4.plus(new Monom("2"));
	ans.add(cf.copy());
	ans.add(cf4.copy());
	cf.div(p1);
	ans.add(cf.copy());
	String s = cf.toString();
	function cf5 = cf4.initFromString(s1);
	function cf6 = cf4.initFromString(s2);
	ans.add(cf5.copy());
	ans.add(cf6.copy());
	Iterator<function> iter = ans.iterator();
	function f = iter.next();
	ComplexFunction max = new ComplexFunction(f);
	ComplexFunction min = new ComplexFunction(f);
	while(iter.hasNext()) {
		f = iter.next();
		max.max(f);
		min.min(f);
	}
	ans.add(max);
	ans.add(min);	
			String file = "function_filesdf.txt";
			Functions_GUI ans2 = new Functions_GUI();
			try {
				ans.saveToFile(file);
				ans2.initFromFile(file);
				                                         
			}
			catch(Exception e) {e.printStackTrace();}
			int  res=200;
			Range rx = new Range(-10,10);
			Range ry = new Range(-5,15);
			
			ans2.drawFunctions(1000,600,rx,ry,res);
			assertEquals(ans2.containsAll(ans), true);
}
	@SuppressWarnings("deprecation")
	@Test

	public void testInitFromFileAndSaveToFileAndDrawFunctions2() {
		ComplexFunction cf = new ComplexFunction();
		String s1="plus(-1.0x^4+2.4x^2+3.1,+0.1x^5-1.2999999999999998x+5.0)";
		String s2="plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)";
		String s3="div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)";
		String s4="-1.0x^4 +2.4x^2 +3.1";
		String s5="max(max(max(max(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)";
		String s6="min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)";
		String s7="+0.1x^5 -1.2999999999999998x +5.0";
		Functions_GUI a=new Functions_GUI();
		Polynom w=new Polynom(s4);
		Polynom w1=new Polynom("45+34x+x^5");
		ComplexFunction cf4 = new ComplexFunction("comp", new Polynom("x +1"),w);
		cf4.comp(cf.initFromString(s7));
		cf4.comp(cf.initFromString(s2));
		cf4.comp(w);
		cf4.comp(w1);
		cf4.comp(cf4);
		Polynom w2=new Polynom(s4);
		a.add(cf.initFromString(s1));
		a.add(cf.initFromString(s2));
		a.add(cf.initFromString(s3));
		a.add(cf.initFromString(s4));
		a.add(cf.initFromString(s5));
		a.add(cf.initFromString(s6));
		a.add(cf.initFromString(s7));
		a.add(cf4);
			String file = "function_filesgg.txt";
			Functions_GUI ans2 = new Functions_GUI();
			try {
				a.saveToFile(file);
				ans2.initFromFile(file);
				                                         
			}
			catch(Exception e) {e.printStackTrace();}
			int  res=200;
			Range rx = new Range(-10,10);
			Range ry = new Range(-5,15);
			a.drawFunctions(1000,600,rx,ry,res);
			assertEquals(ans2.containsAll(a), true);
}
	
	
}

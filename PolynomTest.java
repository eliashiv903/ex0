package myMath;

import java.util.Iterator;

public class PolynomTest {
	public static final double EPSILON = 0.0000001;
	public static void main(String[] args) {
		testInput();
		testCopy();
		testIsZero();
		testAddSubstract();
		testMultiply();
		testEqualsderivative();
		testAreaRoot();
		System.out.println("sucss all PolynomTest:) (this also test for Monom)");
	}
	
	private static void testCopy() {
		Polynom b=new Polynom("0");	
		Polynom f=new Polynom("34567");	
		Polynom g=new Polynom("34567");	
		Iterator itr = g.copy().iteretor();
		while (itr.hasNext()) 	b.add(((Monom)itr.next()));;
		if(!b.toString().equals("34567.0"))throw new RuntimeException("ERR ");
		g.add(f);
		b.add(f);
		if(!b.toString().equals("69134.0"))throw new RuntimeException("ERR ");
		if(!g.toString().equals("69134.0"))throw new RuntimeException("ERR ");
		if(!f.toString().equals("34567.0"))throw new RuntimeException("ERR ");
	}
	
	private static void testInput() {
		for (int i = 0; i < 10; i++) {
			try{
				Polynom f=new Polynom(".");	
			}
			catch(Exception f) {
				i++;
			}
			if(i==0)throw new RuntimeException("ERR");
			try{
				Polynom f=new Polynom(",");
			}
			catch(Exception f) {
				i++;
			}
			if(i==1)throw new RuntimeException("ERR");
			try{
				Polynom f=new Polynom("gx^5");
			}
			catch(Exception f) {
				i++;
			}
			if(i==2)throw new RuntimeException("ERR");
			try{
				Polynom f=new Polynom("6^3");
			}
			catch(Exception f) {
				i++;
			}
			if(i==3)throw new RuntimeException("ERR");
			try{
				Polynom f=new Polynom("");
			}
			catch(Exception f) {
				i++;
			}
			if(i==4)throw new RuntimeException("ERR");
			try{
				Polynom f=new Polynom("x2");
			}
			catch(Exception f) {
				i++;
			}
			if(i==5)throw new RuntimeException("ERR");
			try{
				Polynom f=new Polynom("3x^4.2");
			}
			catch(Exception f) {
				i++;
			}
			if(i==6)throw new RuntimeException("ERR");
			Polynom e=new Polynom("3x^4");
			try{
				e.root(1, 3, 0.01);
			}
			catch(Exception f) {
				i++;
			}
			if(i==7)throw new RuntimeException("ERR");
		}
	}
	
	private static void testIsZero() {
		Polynom f1=new Polynom("345x+324+4x^3");
		Polynom y1=new Polynom("-345x-324");
		Monom s=new Monom(-4,3);
		f1.add(y1);
		f1.add(s);
		Monom i=new Monom(0,0);
		Polynom f=new Polynom("0");
		Polynom y=new Polynom();
		y1.multiply(f);
		y1.multiply(i);
		if(!f1.isZero())throw new RuntimeException("ERR");
		if(!f.isZero())throw new RuntimeException("ERR");
		if(!y.isZero())throw new RuntimeException("ERR");
		if(!f1.isZero())throw new RuntimeException("ERR");
	}
	
	private static void testAreaRoot() {
		Polynom f=new Polynom("5x^3+7");
		Polynom q=new Polynom("x-2");
		Polynom w=new Polynom("x+8");
		Polynom e=new Polynom("x-6");
		Polynom r=new Polynom("x+5");
		q.multiply(w);
		q.multiply(e);
		q.multiply(r);
		if(f.root(-100, 100, EPSILON)!=-1.1186889838427305)throw new RuntimeException("ERR");
		if(q.root(-6, 0,EPSILON)!=-5.000000014901161)throw new RuntimeException("ERR");
		if(q.area(-5, 1, 0.01)!=2510.5459999980026)throw new RuntimeException("ERR");
		if(f.area(-5, 10, 0.01)!=11845.704374999079)throw new RuntimeException("ERR");
	}
	
	private static void testEqualsderivative() {
		Polynom f1=new Polynom("0.9999999999x+23.0000001+22.9999991x^2+40.0000009x^4");
		Polynom c1=new Polynom("x+23+23x^2+40x^4");
		if(!c1.equals(f1))throw new RuntimeException("ERR a not equals b "+c1+"-"+f1);
		Polynom f=new Polynom("x+23+22x^2+40x^4");
		Polynom c=new Polynom("21x+4+3x^5");
		Polynom a=new Polynom("21x+8+3x^5");
		Polynom b=new Polynom("4+3x^5+4+21x");
		if(!a.equals(b))throw new RuntimeException("ERR a not equals b "+a+"-"+b);
		if(a.equals(c))throw new RuntimeException("ERR a equals c, got: "+a+"-"+c);
		if(!a.derivative().toString().equals("21.0+15.0x^4"))throw new RuntimeException("ERR  , got: "+a);
		if(!f.derivative().toString().equals("1+44.0x+160.0x^3"))throw new RuntimeException("ERR  , got: "+f);
		if(f.area(0, 2, 0.001)!=363.05478066661703)throw new RuntimeException("ERR  , got: "+a+"-"+b);
		if(c.area(2, 5, 0.00001)!=8013.048130049205)throw new RuntimeException("ERR  , got: "+a+"-"+b);
		if(a.area(10, 12, 0.000001)!=993470.5231127911)throw new RuntimeException("ERR  , got: "+a+"-"+b);
	}
	
	public static void testAddSubstract() {
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		String[] monoms = {"1","x","x^2", "0.5x^2"};
		Monom v = new Monom(0,8);
		Monom v1 = new Monom(23,8);
		Monom m = new Monom("x");
		Monom m1 = new Monom("x");
		Monom c = new Monom("-2");
		Monom c1 = new Monom("x");
		Monom c2 = new Monom("-2");
		p1.add(m);
		p1.substract(p1);//0
		if(!p1.toString().equals("0"))throw new RuntimeException("ERR  , got: "+p1);
		p2.add(m1);//x
		p2.add(c);//x-2
		p1.substract(p2);//2-x
		if(!p1.toString().equals("2.0-x"))throw new RuntimeException("ERR , got: "+p1);
		p1.add(v);//2-x
		p1.add(v1);//2-x+23x^8
		p2.polynomZero();//0
		p2.add(c1);//x
		p2.add(c2);//x-2
		p1.substract(p2);//23x^8-2x
		if(!p1.toString().equals("4.0-2.0x+23.0x^8"))throw new RuntimeException("ERR , got: "+p1);
	}
	public static void testMultiply() {
		Polynom q1= new Polynom();
		Polynom q2= new Polynom();
		Polynom q3= new Polynom();
		Monom q4 = new Monom(0,1);
		Polynom p1 = new Polynom(), p2 =  new Polynom();
		String[] monoms1 = {"2", "-x","-3.2x^2","4","-1.5x^2"};
		String[] monoms2 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for(int i=0;i<monoms2.length;i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		if(!p1.toString().equals("6.0-x-4.7x^2"))throw new RuntimeException("ERR the  , got: "+p1);
		if(!p2.toString().equals("2.0+1.7x+1.7000000000000002x^2"))throw new RuntimeException("ERR  , got: "+p2);
		p1.add(p2);
		if(!p1.toString().equals("8.0+0.7x-3.0x^2"))throw new RuntimeException("ERR , got: "+p1);
		p1.multiply(p2);
		if(!p1.toString().equals("16.0+15.0x+8.790000000000001x^2-3.9099999999999997x^3-5.1000000000000005x^4"))throw new RuntimeException("ERR  , got: "+p1);
	}
}

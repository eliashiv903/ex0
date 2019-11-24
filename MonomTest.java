package myMath;
import java.util.ArrayList;

public class MonomTest {
	public static void main(String[] args) {
		testKelt();
		test1();
		test2();
		System.out.println();
		System.out.println("sucss all MonomTest,most the test to Monom in PolynomTest :)");
	}
	
	private static void testKelt() {
		Monom a;
		String[] monoms1 = {"", "  ","2.2.0","4^2","-1.5x^2.1,3xf^5"};
		String[] monoms2 = {"5jx", "-1.7x^-3","g","-3+","--x^2","000x0"};
		boolean e=false;
		for (int i = 0; i < monoms1.length; i++) {
			try {
			a=new Monom(monoms1[i]);
			}
			catch (Exception m) {
				e=true;
		}
			if(!e)throw new RuntimeException("ERR the  power should  be int, got: "+monoms1[i]);
			e=false;
		}
		for (int i = 0; i < monoms2.length; i++) {
			try {
				a=new Monom(monoms2[i]);
				}
			catch (Exception m) {
					e=true;
			}
				if(!e)throw new RuntimeException("ERR the  power should  be int, got: "+monoms2[i]);
				e=false;
		}
	}

	private static void test1() {
		System.out.println("*****  Test1:  *****");
		String[] monoms = {"2", "-x","-3.2x^2","0"};
		for(int i=0;i<monoms.length;i++) {
			Monom m = new Monom(monoms[i]);
			String s = m.toString();
			m = new Monom(s);
			double fx = m.f(i);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"\t f("+i+") = "+fx);
		}
	}
	private static void test2() {
		System.out.println("*****  Test2:  *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(0,5));
		monoms.add(new Monom(-1,0));
		monoms.add(new Monom(-1.3,1));
		monoms.add(new Monom(-2.2,2));
		for(int i=0;i<monoms.size();i++) {
			Monom m = new Monom(monoms.get(i));
			String s = m.toString();
			Monom m1 = new Monom(s);
			boolean e = m.isZero();
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"  \teq: "+e);
		}
	}
}

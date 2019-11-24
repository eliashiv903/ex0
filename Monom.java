
package myMath;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
		if(a==0)this.set_power(0);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {//
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
	public double f(double x) {
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	public boolean isZero() {return this.get_coefficient() == 0;}
	// ***************** add your code below **********************
	public Monom(String s) {
		error1(s);
		int indexOfX=s.indexOf('x');
		if(indexOfX==0) {
			s="1"+s;
			indexOfX++;
		}
		if (indexOfX!=-1) {
			String theCoefficient=s.substring(0, indexOfX);
			if(theCoefficient.equals("-"))theCoefficient="-1";
			if(theCoefficient.equals("+"))theCoefficient="1";
			error2(theCoefficient);
			this.set_coefficient(Double.parseDouble(theCoefficient));
			int indexOfPower=s.indexOf('^');
			if(indexOfPower!=-1) {
				if(indexOfPower-indexOfX!=1)throw new RuntimeException("ERR the  Monom should  be wife power afrer x immediately , got: "+s);
				String thePower=s.substring(indexOfPower+1);
				error3(thePower);
				this.set_power(	Integer.parseInt(thePower));
			}
			else 	{
				error4(s,indexOfX);
				this.set_power(1);
			}
		}
		else {
			error2(s);
			this.set_coefficient(Double.parseDouble(s));
			this.set_power(0);
		}
		if(_coefficient==0)set_power(0);
	}

	private void error4(String s, int indexOfX) {
		if(s.length()!=indexOfX+1)
			throw new RuntimeException("ERR the  Monom should  be wife power afrer x or empty , got: "+s);
	}

	private void error3(String thePower) {
		try{
			int test = Integer.parseInt(thePower);
		}
		catch(NumberFormatException test) {
			throw new RuntimeException("ERR the  power should  be int, got: "+thePower);
		}	

	}

	private void error2(String theCoefficient) {
		try{
			double test = Double.parseDouble(theCoefficient);
		}
		catch(NumberFormatException test) {
			throw new RuntimeException("ERR the coefficient should  be double, got: "+theCoefficient);
		}	
	}

	private void error1(String s) {
		if(s.equals(""))throw new RuntimeException("ERR the  Monom should not be empty, got: "+s);
	}
	public void add(Monom m) {
		if(m._power!=this._power)throw new RuntimeException("ERR the  function add should not be diffrent power, got powers: "+m._power+","+this._power);
		this.set_coefficient(this._coefficient+m._coefficient);
	}

	public void multipy(Monom d) {
		this.set_coefficient(this._coefficient*d._coefficient);
		this.set_power(this._power+d._power);
	}

	public String toString() {
		String ansPower="";
		String ans="";
		if(_power!=0) 	ansPower="x^"+_power;
		if(_power==1)ansPower="x";
		if(_coefficient!=1)ans = _coefficient+ansPower;
		if(_coefficient==-1)ans="-"+ansPower;
		if(_coefficient==1)ans=ansPower;
		if(_coefficient==0)ans="0";
		if(ans.equals("-"))ans="-1";
		if(_coefficient==1 &&_power==0)ans="1";
		return ans;
	}
	// you may (always) add other methods.

	public void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient; 
	private int _power;
	
	public static void main(String[] args) {
		
	}
	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public function copy() {
		// TODO Auto-generated method stub
		return null;
	}

}

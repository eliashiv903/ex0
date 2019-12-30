package Ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;


/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author yoav 304939648
 * @author eliashiv 314763210
 *  @author boaz 2088331990
 *  
 */
public class Polynom implements Polynom_able{
	private ArrayList<Monom> monoms;
	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
		Monom zero=new Monom("0");
		monoms = new ArrayList<Monom>();
		monoms.add(zero);
	}
	public Polynom(Polynom_able p1) {
		this.monoms = new ArrayList<Monom>();
		Iterator itr = p1.iteretor();
		while (itr.hasNext()) { 
			Monom temp=new Monom((Monom)itr.next());
			this.monoms.add(temp);
		}
	}
	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x"};
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) {
		monoms = new ArrayList<Monom>();
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)=='-'||s.charAt(i)=='+') {
				Monom monom=new Monom(s.substring(0,i));
				monoms.add(monom);
				s=s.substring(i);
				i=0;
			}
		}
		Monom monom=new Monom(s);
		monoms.add(monom);
		cinos();
	}

	private void cinos() {
		Collections.sort( monoms, new  Monom_Comperator());
		for (int i = 0; i < monoms.size()-1; i++) {
			if(monoms.get(i).get_power()==monoms.get(i+1).get_power()) {
				monoms.get(i).set_coefficient(monoms.get(i).get_coefficient()+monoms.get(i+1).get_coefficient());
				monoms.remove(i+1);
			}
		}
		deleteAllZero();
	}
	@Override
	public double f(double x) {
		double sum=0;
		for (int i = 0; i < monoms.size(); i++) sum+=this.monoms.get(i).f(x);
		return sum;
	}

	@Override
	public void add(Polynom_able p1) {
		Polynom tempP1=new Polynom(p1);
		for (int i = 0; i < tempP1.monoms.size(); i++)  this.monoms.add(tempP1.monoms.get(i));
		cinos();
	}
	@Override
	public void add(Monom m1) {
		Monom temp=new Monom(m1.get_coefficient(),m1.get_power());
		this.monoms.add(temp);
		cinos();
	}

	private void deleteAllZero() {
		for (int i = monoms.size()-1; i >-1; i--) deleteZero(this, i);
	}
	@Override
	public void substract(Polynom_able p1) {
		Monom minos1 = new Monom(-1,0);
		if(this.equals(p1)) {
			polynomZero();
			return;
		}
		Polynom tempP1=new Polynom(p1);
		tempP1.multiply(minos1);
		this.add(tempP1);
	}

	public void polynomZero() {
		this.monoms = new ArrayList<Monom>();
		Monom zero = new Monom(0,0);
		add(zero);
	}
	@Override
	public void multiply(Polynom_able p1) {
		Polynom ansSum=new Polynom("0");
		Iterator itr = p1.iteretor();
		while (itr.hasNext()) { 
			Monom tepmP1Monom=new Monom((Monom)itr.next());
			Polynom copyThis=new Polynom(this);
			for (int i = 0; i < monoms.size(); i++) 	copyThis.monoms.get(i).multipy(tepmP1Monom);
			ansSum.add(copyThis);
		}
		polynomZero();
		for (int i = 0; i < ansSum.monoms.size(); i++) 	this.monoms.add(ansSum.monoms.get(i));
		deleteAllZero();
	}
	@Override
	public boolean equals(Object obj) {
		ComplexFunction a=new ComplexFunction(obj.toString());
		double x=100;
		for (int i = 0; i < 120; i++,x+=0.1) if(a.f(x)-this.f(x)>0.0000001 && a.f(x)-this.f(x)<-0.0000001) 		return false;
		x=-100;
		for (int i = 0; i < 120; i++,x-=0.1) if(((a.f(x)-this.f(x))>0.0000001) && (a.f(x)-this.f(x))<-0.0000001)return false;	
		return true;
	}
		
	public boolean equals(Polynom p1) {
		String a=p1.toString();
		Polynom p1Regilur=new Polynom(a);
		if(this.monoms.size()!=p1Regilur.monoms.size())return false;
		for (int i = 0; i < monoms.size(); i++) {
			if(this.monoms.get(i).get_power()!= p1Regilur.monoms.get(i).get_power())return false;
			if(Math.abs(this.monoms.get(i).get_coefficient()-p1Regilur.monoms.get(i).get_coefficient())>=0.000001)return false;
		}
		return true;
	}
	@Override
	public void  deleteZero(Polynom p1,int i) {
		if(monoms.size()!=1 && p1.monoms.get(i).get_coefficient()==0) p1.monoms.remove(i);
	}
	@Override
	public boolean isZero() {
		if(this.monoms.get(0).get_coefficient()==0)return true;
		return false;
	}
	@Override
	public double root(double x0, double x1, double eps) {
		if((this.f(x0)>0 &&this.f(x1)>0)||(this.f(x0)<0 &&this.f(x1)<0))throw new RuntimeException("ERR the  f(x0,x1) need to be one postive and one negetiv: "+x0+","+x1);
		eps=Math.abs(eps);
		double mid=0;
		while (x1-x0>eps) {
			mid = (x1+x0) / 2;
			if (f(x0)*f(mid)<=0) x1=mid;
			else  x0=mid;
		}
		return (x0+x1)/2;
	}
	@Override
	public function copy() {
		Polynom ans=new Polynom(this);
		return ans;
	}
	@Override
	public Polynom_able derivative() {
		Polynom ans=new Polynom("0");
		for (int i = 0; i < monoms.size(); i++) 	ans.add(monoms.get(i).derivative());
		return ans;
	}	
	@Override
	public double area(double x0, double x1, double eps) {
		if(x0==x1||x1<x0)return 0;
		double sum=0;
		double high=x0;
		while(high<x1) {
			if(this.f(high)>0)sum+=(this.f(high)*eps);
			high+=eps;
		}
		return sum;
	}
	@Override
	public Iterator<Monom> iteretor() {
		return monoms.iterator();
	}
	@Override
	public void multiply(Monom m1) {
		if(m1.get_coefficient()==0)polynomZero();
		for (int i = 0; i < monoms.size(); i++) 	this.monoms.get(i).multipy(m1);
	}

	public String toString() {
		String ans="";
		for (int i = 0; i <monoms.size(); i++) {
			if(i!=0 && monoms.get(i).get_coefficient()>=0)ans+="+";
			ans+=monoms.get(i).toString();
		}
		return ans;
	}
	@Override
	public function initFromString(String s) {
		Polynom a=new Polynom(s);
		return a;
	}
	
}

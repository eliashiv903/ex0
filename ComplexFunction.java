package myMath;

public class ComplexFunction implements complex_function{
	private Polynom a;
public  ComplexFunction(Polynom a) {
	this.a=new Polynom(a);
}

	@Override
	public double f(double x) {	return a.f(x);}
	

	@Override
	public function initFromString(String s) {
		Polynom a=new Polynom(this.toString());
		return a;
	}

	@Override
	public function copy() {
		Polynom a=new Polynom(this.toString());
		return a;
	}

	@Override
	public void plus(function f1) {
		Polynom f=new Polynom(f1.toString());
		a.add(f);
	}

	@Override
	public void mul(function f1) {
		Polynom f=new Polynom(f1.toString());
		a.multiply(f);
	}

	@Override
	public void div(function f1) {
		
	}

	@Override
	public void max(function f1) {
		
	}

	@Override
	public void min(function f1) {
		
	}

	@Override
	public void comp(function f1) {
		
	}

	@Override
	public function left() {
		return null;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

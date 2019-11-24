package myMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public  class Functions_GUI implements functions{
	private ArrayList<Polynom> polynoms;
	public Functions_GUI(String s) {
		polynoms=new ArrayList<Polynom>();
		int sum=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==',') {
				Polynom a=new Polynom(s.substring(0, i));
				polynoms.add(a);
				s=s.substring(i+1);
			}
		}
	}
	public Functions_GUI(Functions_GUI p1) {
		polynoms=new ArrayList<Polynom>();
		for (int i = 0; i < polynoms.size(); i++) {
			Polynom a=new Polynom(p1.polynoms.get(i));
		polynoms.add(a);
		}
	}
	@Override
	public double f(double x) {
		
		return 0;
	}

	@Override
	public function initFromString(String s) {
		Functions_GUI a=new Functions_GUI(s);
		return a;
	}

	@Override
	public function copy() {
		Functions_GUI ans=new Functions_GUI(this);
		return ans;
	}

	@Override
	public void plus(function f1) {
		Functions_GUI a=new Functions_GUI(f1.toString());
		for (int i = 0; i < a.polynoms.size(); i++) {
			Polynom c=new Polynom(a.polynoms.get(i));
			polynoms.add(c);
		}
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
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
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(function e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends function> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
		
	}
	

}

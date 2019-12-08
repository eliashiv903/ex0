package myMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI  implements functions {
private ArrayList<function> functions1;
public Functions_GUI() {
	functions1=new ArrayList<function>();
}
	public Functions_GUI(String s) {
		functions1=new ArrayList<function>();
		int sum=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='!') {
				Polynom a=new Polynom(s.substring(0, i));
				functions1.add(a);
				s=s.substring(i+1);
			}
		}
	}
	public Functions_GUI(Functions_GUI p1) {
		functions1=new ArrayList<function>();
		for (int i = 0; i < functions1.size(); i++) {
			Polynom a=new Polynom(p1.functions1.get(i).toString());
			functions1.add(a);
		}
	}
	
	@Override
	public int size() {
		
		return functions1.size();
	}

	@Override
	public boolean isEmpty() {
		if(functions1.size()==0)	return true;
		return false;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < functions1.size(); i++)	if(functions1.get(i).equals(o))	return true;
		return false;
	}

	@Override
	public Iterator<function> iterator() {
		return functions1.iterator();
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
		functions1.add(e);
		
		return true;
	}
	public function get(int index) {
		return functions1.get(index);
	}
	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < functions1.size(); i++)	if(functions1.get(i).equals(o))	functions1.remove(i);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if(functions1.containsAll(c))return true;
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		functions1.addAll(c);
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		functions1.removeAll(c);
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		functions1.removeAll(this);
		
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
	public String toString() {
		String a="";
		for (int i = 0; i < functions1.size(); i++) {
			a+=functions1.get(i)+"!";
		}
		return a;
	}

}

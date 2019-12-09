package myMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class vi  implements functions {
private ArrayList<function> functions;
public vi() {
	functions=new ArrayList<function>();
}
	public vi(String s) {
		functions=new ArrayList<function>();
		int sum=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='!') {
				Polynom a=new Polynom(s.substring(0, i));
				functions.add(a);
				s=s.substring(i+1);
			}
		}
	}
	public vi(vi p1) {
		functions=new ArrayList<function>();
		for (int i = 0; i < functions.size(); i++) {
			Polynom a=new Polynom(p1.functions.get(i).toString());
			functions.add(a);
		}
	}
	
	@Override
	public int size() {
		
		return functions.size();
	}

	@Override
	public boolean isEmpty() {
		if(functions.size()==0)	return true;
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return functions.contains(o);
	}

	@Override
	public Iterator<function> iterator() {
		return functions.iterator();
	}

	@Override
	public Object[] toArray() {
		
		return functions.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return functions.toArray(a);
	}
	@Override
	public boolean add(function e) {
		functions.add(e);
		
		return true;
	}
	public function get(int index) {
		return functions.get(index);
	}
	@Override
	public boolean remove(Object o) {
		return functions.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return functions.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		return functions.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return functions.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return functions.retainAll(c);
	}

	@Override
	public void clear() {
		functions.clear();
		
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
		for (int i = 0; i < functions.size(); i++) {
			int n=i+1;
			a+=" "+n+":"+functions.get(i).toString()+"\n";
		}
		return a;
	}

}

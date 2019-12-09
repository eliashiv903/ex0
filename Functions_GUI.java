package myMath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI  implements functions {
private ArrayList<function> functions=new ArrayList<function>();

public Functions_GUI() {}

	public Functions_GUI(Functions_GUI p1) {
		for (int i = 0; i < functions.size(); i++) 	functions.add(new Polynom(p1.functions.get(i).toString()));
	}
	
	@Override
	public boolean isEmpty() {
		return functions.isEmpty();
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
		return functions.add(e.copy());
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
		   var fileName = "src/resources/"+file+".txt";
		   File file1 = new File("C:\\Users\\יואב\\Desktop\\new\\new yaer\\"+file+".txt"); 
		   BufferedReader br = new BufferedReader(new FileReader(file)); 
		   String st; 
		   while ((st = br.readLine()) != null)   this.add( new ComplexFunction().initFromString(st)); 
	}

	@Override
	public void saveToFile(String file) throws IOException {
		   File file1 = new File(file);
	          //Create the file
	          if (file1.createNewFile()){
	            System.out.println("File is created!");
	          }else{
	            System.out.println("File already exists.");
	          }
	          //Write Content
	          FileWriter writer = new FileWriter(file1);
	          for (int i = 0; i <this.size(); i++) 
	          writer.write(this.functions.get(i).toString()+"\n");
	          writer.close();
	    }

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public int size() {
		return functions.size();
	}
	public static void main(String[] args) {
		
	}

}

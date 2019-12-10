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
import java.awt.*;
import java.io.FileReader;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, 
			Color.red, Color.GREEN, Color.PINK};
	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		
		int n = resolution;
		StdDraw.setCanvasSize(width, height);
		int size = this.size();
		double[] x = new double[n+1];
		double[][] yy = new double[size][n+1];
		double x_step = (rx.get_max()-rx.get_min())/n;
		double x0 = rx.get_min();
		for (int i=0; i<=n; i++) {
			x[i] = x0;
			for(int a=0;a<size;a++) {
				yy[a][i] = this.get(a).f(x[i]);
			}
			x0+=x_step;
		}
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
	
		
		// plot the approximation to the function
		for(int a=0;a<size;a++) {
			int c = a%Colors.length;
			StdDraw.setPenColor(Colors[c]);
		
			System.out.println(a+") "+Colors[a]+"  f(x)= "+this.get(a));
			for (int i = 0; i < n; i++) {
				StdDraw.line(x[i], yy[a][i], x[i+1], yy[a][i+1]);
			}
		}	
	}

	@Override
	public void drawFunctions(String json_file) {
		 JSONParser parser = new JSONParser();
		 System.out.println(1);
	        try {
	 
	            Object obj = parser.parse(new FileReader(
	                    "/Users/<username>/Documents/file1.txt"));
	 
	            JSONObject jsonObject = (JSONObject) obj;
	 
	            String name = (String) jsonObject.get("Name");
	            String author = (String) jsonObject.get("Author");
	            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
	 
	            System.out.println("Name: " + name);
	            System.out.println("Author: " + author);
	            System.out.println("\nCompany List:");
	            Iterator<String> iterator = companyList.iterator();
	            while (iterator.hasNext()) {
	                System.out.println(iterator.next());
	            }
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	

	@Override
	public int size() {
		return functions.size();
	}
	public static void main(String[] args) {
		ComplexFunction cf = new ComplexFunction();
		String s1="plus(-1.0x^4+2.4x^2+3.1,+0.1x^5-1.2999999999999998x+5.0)";
		
		String s2="plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)";
		String s3="div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)";
		String s4="-1.0x^4 +2.4x^2 +3.1";
		String s5="max(max(max(max(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)";
		String s6="min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)";
		String s7="+0.1x^5 -1.2999999999999998x +5.0";
		Functions_GUI a=new Functions_GUI();
		a.add(cf.initFromString(s1));
		a.add(cf.initFromString(s2));
		a.add(cf.initFromString(s3));
		a.add(cf.initFromString(s4));
		a.add(cf.initFromString(s5));
		a.add(cf.initFromString(s6));
		a.add(cf.initFromString(s7));
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i).f(0));
		}
		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
	
		a.drawFunctions(1000,600,rx,ry,res);
	}

}

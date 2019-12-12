package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.io.FileReader;
import java.util.Iterator;
import com.google.gson.*;

public class Functions_GUI  implements functions {

	private ArrayList<function> functions=new ArrayList<function>();

	public Functions_GUI() {
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
		return functions.add(e.initFromString(e.toString()));
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
		var fileName = file;
		File file1 = new File(file); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 
		while ((st = br.readLine()) != null)   this.add( new ComplexFunction().initFromString(st)); 
	}

	@Override
	public void saveToFile(String file) throws IOException {
		File file1 = new File(file);
		//Create the file
		if (file1.createNewFile())  System.out.println("File is created!");
		else System.out.println("File already exists.");
		//Write Content
		FileWriter writer = new FileWriter(file1);
		for (int i = 0; i <this.size(); i++)  writer.write(this.functions.get(i).toString()+"\n");
		writer.close();
	}
	
	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, 
			Color.red, Color.GREEN, Color.PINK};
	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		int n = resolution;
		StdDraw.setCanvasSize(width, height);
		int size = size();
		double[] x = new double[n+1];
		double[][] yy = new double[size][n+1];
		double x_step = (rx.get_max()-rx.get_min())/n;
		double x0 = rx.get_min();
		for (int i=0; i<=n; i++) {
			x[i] = x0;
			for(int a=0;a<size;a++) 	yy[a][i] = this.get(a).f(x[i]);
			x0+=x_step;
		}
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		StdDraw.setPenRadius(0.0009);
		for (double i = rx.get_min(); i <= rx.get_max(); i++) StdDraw.line(i, ry.get_min(), i, ry.get_max());
		for (double i = ry.get_min(); i <= ry.get_max(); i++) 	StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		StdDraw.setPenRadius(0.007);
		StdDraw.line(rx.get_min(),0, rx.get_max(),0);
		StdDraw.line(0,ry.get_min(), 0,ry.get_max());
		StdDraw.setPenRadius(0.004);
		for(double y=ry.get_min();y<=ry.get_max();y++) StdDraw.text(-0.5,y ,""+(int)y);
		for(double x1=rx.get_min();x1<=rx.get_max();x1++) 	StdDraw.text(x1,-0.4 ,""+(int)x1);
		for(int i=0;i<size;i++) {
			int g = i%Colors.length;
			StdDraw.setPenColor(Colors[g]);
			for (int j = 0; j < n; j++) 	StdDraw.line(x[j], yy[i][j], x[j+1], yy[i][j+1]);
		}
	}

	@Override
	public void drawFunctions(String json_file) {
		Gson gson = new Gson();

		//Option 1: from JSON String to Object 

		try 
		{
			//Option 2: from JSON file to Object
			FileReader reader = new FileReader(json_file);
			DataStdDraw dataStdDraw = gson.fromJson(reader,DataStdDraw.class);
			Range x=new Range(dataStdDraw.getRange_X()[0], dataStdDraw.getRange_X()[1]);
			Range y=new Range(dataStdDraw.getRange_Y()[0], dataStdDraw.getRange_Y()[1]);
			drawFunctions(dataStdDraw.getWidth(), dataStdDraw.getHeight(), x,y, dataStdDraw.getResolution());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}



	@Override
	public int size() {
		return functions.size();
	}
	
	
}

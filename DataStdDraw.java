package myMath;

public class DataStdDraw {

	private int Width;
	private int Height;
	private int Resolution;
	private double [] Range_X= new double[2];
	private double [] Range_Y=new double[2];
	
public int getWidth () {
	return this.Width;
}
public int getHeight () {
	return this.Height;
}
public int getResolution () {
	return this.Resolution;
}
public double[] getRange_X() {
	return this.Range_X;
}
public double[] getRange_Y() {
	return this.Range_Y;
}
}

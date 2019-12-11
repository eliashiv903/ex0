package myMath;

public class DataStdDraw {

	private int width;
	private int height;
	private int resolution;
	private Range range_X;
	private Range range_Y;
public DataStdDraw (int width,int height,int resolution,Range range_X,Range range_Y) {
	this.width=width;
	this.height=height;
	this.resolution=resolution;
	this.range_X=range_X;
	this.range_Y=range_Y;
}
public int getWidth () {
	return this.width;
}
public int getHeight () {
	return this.height;
}
public int getResolution () {
	return this.resolution;
}
public Range getRange_X() {
	return this.range_X;
}
public Range getRange_Y () {
	return this.range_Y;
}
public static void main(String[] args) {
	Range b=new Range(1, 2);
	DataStdDraw a=new DataStdDraw (1,1,1,b,b);

}
}

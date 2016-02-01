package ua.goit.andre.lab4;

public class Square {
	
	public static double getSquareBox (double a, double b) {
		return a*b;
	}
	
	public static double getSquareTriangle(double a, double b, double c){
		double p=(a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c)); 
	}

	public static double getSquareCircle(double r) {
		return Math.PI*r*r;
	}
}

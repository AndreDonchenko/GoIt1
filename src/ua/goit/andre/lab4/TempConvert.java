package ua.goit.andre.lab4;

public class TempConvert {
	
	public static double getTempC2F(double t) {
		return (t*9.0)/5+32;
	}

	public static double getTempF2C(double t) {
		return (t-32.0)*5/9;
	}

}

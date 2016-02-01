package ua.goit.andre.lab4extra;

public class MonteCarloRun {

	public static void main(String[] args) {
		System.out.println("(1-x*x)=" + MonteCarlo.calc(-1,1,0,1,100000,new ExampleFunc()));
		
		int radius=4;
		System.out.println("Pi=" + MonteCarlo.calc(0,radius,0,radius,100000,new PiFunc(radius)));

	}
}

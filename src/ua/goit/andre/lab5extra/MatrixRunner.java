package ua.goit.andre.lab5extra;

public class MatrixRunner {

	private static final String LINE_STRING = "------------";

	public static void main(String[] args) {
		System.out.println("Matrix1 = ");
		Matrix m1 = new Matrix(3);
		m1.fillRandom(10);
		m1.showArray();
		System.out.println(LINE_STRING);
		System.out.println();

		System.out.println("Matrix2 = ");
		Matrix m2 = new Matrix(3);
		m2.fillRandom(10);
		m2.showArray();
		System.out.println(LINE_STRING);
		System.out.println();

		System.out.println("Matrix1 + Matrix2 = ");

		m1.operation(m2, '+');
		m1.showArray();
		System.out.println(LINE_STRING);
		System.out.println();

		
		System.out.println("Matrix1 - Matrix2 = ");
		m1.operation(m2, '-');
		m1.showArray();
		System.out.println(LINE_STRING);
		System.out.println();

		
	}
}

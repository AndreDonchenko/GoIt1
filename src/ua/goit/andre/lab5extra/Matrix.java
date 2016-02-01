package ua.goit.andre.lab5extra;

import java.util.Arrays;

public class Matrix {
	private final double [][] data;
	private final int dimension;

	public Matrix (int dimension) {
		this.dimension=dimension;
		data = new double[dimension][dimension];
	}

	public int getDimension() {
		return dimension;
	}

	public double getElement(int x, int y) {
		return data[x][y];
	}
	
	public void setElement(int x, int y, double value) {
		data[x][y]=value;
	}

	public void fillRandom(int maxRandom) {
		for (int i=0; i < dimension; i++) {
			for (int j=0; j<dimension; j++) {
				int value=((int) (maxRandom*java.lang.Math.random()));
				setElement(i, j, value);
			}
		}
	}

	public void showArray(){
		for (int i=0; i<dimension; i++)
		{
			System.out.println(Arrays.toString(data[i])); 
		}
	}
		
	public void operation(Matrix matrix, char oper) {
		double value;
		for (int i=0; i < dimension; i++) {
			for (int j=0; j<dimension; j++) {
				switch (oper) {
					case '+': 	value=getElement(i,j) + matrix.getElement(i,j);
								break;
					case '-':	value=getElement(i,j) - matrix.getElement(i,j);
								break;
					case '*':	value=getElement(i,j) * matrix.getElement(i,j);
								break;
					case '/':	value=getElement(i,j) / matrix.getElement(i,j);
								break;
					default:	value=getElement(i,j);
				}
				setElement(i,j, value);
			}
		}		
	}
}

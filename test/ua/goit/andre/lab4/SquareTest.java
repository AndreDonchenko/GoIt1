package ua.goit.andre.lab4;

import org.junit.Assert;
import org.junit.Test;

public class SquareTest {

	@Test
	public void testGetSquareBox() throws Exception {
		double a=2;
		double b=2;

		Assert.assertEquals(a*b,Square.getSquareBox(a,b),0);
	}

	@Test
	public void testGetSquareTriangle() throws Exception {
		//Прямоугольный треугольник
		double a=3;
		double b=4;
		double c=5;
		Assert.assertEquals(a*b/2, Square.getSquareTriangle(a,b,c), 0);

		//Произвольный треугольник
		a=1;
		b=2;
		c=3;
		double p=(a+b+c)/2;
		Assert.assertEquals(Math.sqrt(p*(p-a)*(p-b)*(p-c)),Square.getSquareTriangle(a,b,c),0);
	}

	@Test
	public void testGetSquareCircle() throws Exception {
		double r=1;
		Assert.assertEquals(Math.PI,Square.getSquareCircle(r),0);

		r=5;
		Assert.assertEquals(Math.PI*r*r,Square.getSquareCircle(r),0);

	}
}

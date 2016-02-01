package ua.goit.andre.lab4extra;

public class MonteCarlo {
	
    public static double calc(final int minX, final int maxX, final int minY, final int maxY, final long numberOfRandom, final AbstractFunc function) {

    	/*
		assert (maxX > minX);
		assert (maxY > minY);
		assert (numberOfRandom > 0);
		assert (null!=function);
		*/
    	
    	long sum = 0;
    	final double deltaX = maxX - minX;
    	final double deltaY = maxY - minY;
    	double x,y;
       	
    	for (int i = 0; i < numberOfRandom; i++) 
        	{
             	x = java.lang.Math.random() * deltaX + minX; //генерируем x в интервале [mixX, maxX]
             	y = java.lang.Math.random() * deltaY + minY; //генерируем x в интервале [mixY, maxY]
             	if (y <= function.func(x)) {
             		sum++;
             	}
             }
    	return sum/(double)numberOfRandom * (maxX-minX);
     }
}

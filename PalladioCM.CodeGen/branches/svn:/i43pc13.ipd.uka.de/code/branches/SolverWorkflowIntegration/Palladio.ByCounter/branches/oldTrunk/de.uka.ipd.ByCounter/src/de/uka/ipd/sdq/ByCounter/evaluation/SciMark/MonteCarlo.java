package de.uka.ipd.sdq.ByCounter.evaluation.SciMark;

/**
 Estimate Pi by approximating the area of a circle.

 How: generate N random numbers in the unit square, (0,0) to (1,1)
 and see how are within a radius of 1 or less, i.e.
 <pre>  

 sqrt(x^2 + y^2) < r

 </pre>
  since the radius is 1.0, we can square both sides
  and avoid a sqrt() computation:
  <pre>

    x^2 + y^2 <= 1.0

  </pre>
  this area under the curve is (Pi * r^2)/ 4.0,
  and the area of the unit of square is 1.0,
  so Pi can be approximated by 
  <pre>
		        # points with x^2+y^2 < 1
     Pi =~ 		--------------------------  * 4.0
		             total # points

  </pre>

*/

public class MonteCarlo
{
	final static int SEED = 113;
	final static int NUM_SAMPLES = 1000*1000;

	/**TODO
	 * @param Num_samples
	 * @return approximation of PI
	 */
	public static final double integrate(int Num_samples)
	{

		Random R = new Random(SEED);


		int under_curve = 0;
		for (int count=0; count<Num_samples; count++)
		{
			double x= R.nextDouble();
			double y= R.nextDouble();

			if ( x*x + y*y <= 1.0)
				 under_curve ++;
			
		}

		return ((double) under_curve / Num_samples) * 4.0;
	}
	
	/**TODO
	 * @param Num_samples
	 * @return approximation of PI
	 */
	public static final double integrateMK()
	{
		int Num_samples = NUM_SAMPLES;
		Random R = new Random(SEED);


		int under_curve = 0;
		for (int count=0; count<Num_samples; count++)
		{
			double x= R.nextDouble();
			double y= R.nextDouble();

			if ( x*x + y*y <= 1.0)
				 under_curve ++;
			
		}

		return ((double) under_curve / Num_samples) * 4.0;
	}
	
	/**TODO
	 * @param args
	 */
	public static void main(String[] args){//added by MK 
		long start = System.nanoTime();
		double result = integrateMK();
		long stop  = System.nanoTime();
	    long ns = stop-start;
	    long mus = Math.round((double)ns/1000);
	    long ms = Math.round((double)mus/1000);
	    long s = Math.round((double)ms/1000);
	    System.out.println("MonteCarlo.integrate("+NUM_SAMPLES+") " +
	    		"executed in "
	    		+ns+" ns = "+mus+" us = "+ms+" ms = "+s+" s, giving PI="+result);//MK TODO
	}

	

	/**TODO
	 * @param Num_samples
	 * @return number of flops
	 */
	public static final double num_flops(int Num_samples)
	{
		// 3 flops in x^2+y^2 and 1 flop in random routine

		return ((double) Num_samples)* 4.0;

	}


}

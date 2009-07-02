/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.util;

/**
 * @author Ihssane
 *
 */
public class Line {
		
		private double a;
		private double b;

		/**
		 * @param x1
		 * @param y1
		 * @param x2
		 * @param y2
		 */
		public Line(double x1, double y1, double x2, double y2) {
			if (x2-x1 == 0.0) {
				throw new RuntimeException("Two samples of the PDF have the same value. Note that an initial sample with value 0 is assumed, so you must not specify another one with value 0.");
			}
			a = (y2 - y1) / (x2 - x1);
			b = y1 - (a * x1);
		}
		
		/**
		 * @param y
		 * @return
		 */
		public double getX(double y) {
			double result = (y-b)/a;
			return result;
		}
}

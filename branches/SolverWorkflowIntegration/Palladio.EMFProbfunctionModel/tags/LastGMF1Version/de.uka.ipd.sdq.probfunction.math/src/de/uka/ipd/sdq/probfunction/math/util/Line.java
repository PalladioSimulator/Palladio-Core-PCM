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
			
			a = (y2 - y1) / (x2 - x1);
			b = y1 - (a * x1);

// HK
//			if (x1 != 0)
//				b = y1 - (a * x1);
//			else
//				b = y2 - (a * x2);
		}
		
		/**
		 * @param y
		 * @return
		 */
		public double getX(double y) {
			return (y-b)/a;
		}
}

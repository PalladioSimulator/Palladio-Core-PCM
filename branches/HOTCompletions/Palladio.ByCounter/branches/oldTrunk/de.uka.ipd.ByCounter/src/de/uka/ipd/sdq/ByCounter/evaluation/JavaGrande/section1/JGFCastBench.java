/**************************************************************************
 *                                                                         *
 *             Java Grande Forum Benchmark Suite - Version 2.0             *
 *                                                                         *
 *                            produced by                                  *
 *                                                                         *
 *                  Java Grande Benchmarking Project                       *
 *                                                                         *
 *                                at                                       *
 *                                                                         *
 *                Edinburgh Parallel Computing Centre                      *
 *                                                                         * 
 *                email: epcc-javagrande@epcc.ed.ac.uk                     *
 *                                                                         *
 *                                                                         *
 *      This version copyright (c) The University of Edinburgh, 1999.      *
 *                         All rights reserved.                            *
 *                                                                         *
 **************************************************************************/

package de.uka.ipd.sdq.ByCounter.evaluation.JavaGrande.section1;

import de.uka.ipd.sdq.ByCounter.evaluation.JavaGrande.jgfutil.JGFInstrumentor;
//import de.uka.ipd.sdq.ByCounter.evaluation.JavaGrande.jgfutil.JGFSection1;

public class JGFCastBench/* implements JGFSection1 */{

	private static final int INITSIZE = 14*1000;
	private static final int MAXSIZE = 100*1000/*MK TODO earlier: *10000 */;
//	MK TODO private static final double TARGETTIME = 10.0;

	public void JGFrun() {
		long start = System.nanoTime();//MK TODO

		int i, size;
		double time;

		int i1 = 0;
		long l1 = 0;
		float f1 = 0.0F;
		double d1 = 0.0D;

//		JGFInstrumentor.addTimer("Section1:Cast:IntFloat", "casts");

		time = 0.0;
		size = INITSIZE;
		i1 = 6;

		while (/*MK TODO time < TARGETTIME && */size < MAXSIZE) {
			JGFInstrumentor.resetTimer("Section1:Cast:IntFloat");
			JGFInstrumentor.startTimer("Section1:Cast:IntFloat");
			for (i = 0; i < size; i++) {
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
				f1 = (float) i1;
				i1 = (int) f1;
			}
//			JGFInstrumentor.stopTimer("Section1:Cast:IntFloat");

			// try to defeat dead code elimination
			if (f1 == -1.0F)
				System.out.println(f1);
//			time = JGFInstrumentor.readTimer("Section1:Cast:IntFloat");
//			JGFInstrumentor.addOpsToTimer("Section1:Cast:IntFloat", (double) 32
//					* size);
			size *= 2;
		}

		JGFInstrumentor.printperfTimer("Section1:Cast:IntFloat");

		JGFInstrumentor.addTimer("Section1:Cast:IntDouble", "casts");

		time = 0.0;
		size = INITSIZE;
		i1 = 6;

		while (/*MK TODO time < TARGETTIME && */size < MAXSIZE) {
			JGFInstrumentor.resetTimer("Section1:Cast:IntDouble");
			JGFInstrumentor.startTimer("Section1:Cast:IntDouble");
			for (i = 0; i < size; i++) {
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
				d1 = (double) i1;
				i1 = (int) d1;
			}
			JGFInstrumentor.stopTimer("Section1:Cast:IntDouble");

			// try to defeat dead code elimination
			if (d1 == -1.0D)
				System.out.println(d1);
			time = JGFInstrumentor.readTimer("Section1:Cast:IntDouble");
			JGFInstrumentor.addOpsToTimer("Section1:Cast:IntDouble",
					(double) 32 * size);
			size *= 2;
		}

		JGFInstrumentor.printperfTimer("Section1:Cast:IntDouble");

		JGFInstrumentor.addTimer("Section1:Cast:LongFloat", "casts");

		time = 0.0;
		size = INITSIZE;
		l1 = 7;

		while (/*MK time < TARGETTIME && */size < MAXSIZE) {
			JGFInstrumentor.resetTimer("Section1:Cast:LongFloat");
			JGFInstrumentor.startTimer("Section1:Cast:LongFloat");
			for (i = 0; i < size; i++) {
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
				f1 = (float) l1;
				l1 = (long) f1;
			}
			JGFInstrumentor.stopTimer("Section1:Cast:LongFloat");

			// try to defeat dead code elimination
			if (f1 == -1.0F)
				System.out.println(f1);
			time = JGFInstrumentor.readTimer("Section1:Cast:LongFloat");
			JGFInstrumentor.addOpsToTimer("Section1:Cast:LongFloat",
					(double) 32 * size);
			size *= 2;
		}

		JGFInstrumentor.printperfTimer("Section1:Cast:LongFloat");

		JGFInstrumentor.addTimer("Section1:Cast:LongDouble", "casts");

		time = 0.0;
		size = INITSIZE;
		l1 = 7;

		while (/*MK time < TARGETTIME && */size < MAXSIZE) {
			JGFInstrumentor.resetTimer("Section1:Cast:LongDouble");
			JGFInstrumentor.startTimer("Section1:Cast:LongDouble");
			for (i = 0; i < size; i++) {
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
				d1 = (double) l1;
				l1 = (long) d1;
			}
			JGFInstrumentor.stopTimer("Section1:Cast:LongDouble");

			// try to defeat dead code elimination
			if (d1 == -1.0D)
				System.out.println(d1);
			time = JGFInstrumentor.readTimer("Section1:Cast:LongDouble");
			JGFInstrumentor.addOpsToTimer("Section1:Cast:LongDouble",
					(double) 32 * size);
			size *= 2;
		}

		JGFInstrumentor.printperfTimer("Section1:Cast:LongDouble");
		long stop = System.nanoTime();//MK TODO
//	    System.out.println("JGFCastBench.JGFrun() with INITSIZE=" + INITSIZE
//	    		+" and MAXSIZE="+MAXSIZE
//	    		+"executed in "+(stop-start)+" ns");//MK TODO
	    long ns = stop-start;
	    long mus = Math.round((double)ns/1000);
	    long ms = Math.round((double)mus/1000);
	    long s =  Math.round((double)ms/1000);
	    System.out.println("JGFCastBench.JGFrun() itself reports: with INITSIZE=" + INITSIZE
	    		+" and MAXSIZE="+MAXSIZE+" executed in "
	    		+ns+" ns = "+mus+" mus = "+ms+" ms = "+s+" s.");//MK TODO

	}

	public static void main(String argv[]) {

		//MK JGFInstrumentor.printHeader(1, 0);

		JGFCastBench cb = new JGFCastBench();
		cb.JGFrun();

	}
}

package de.uka.ipd.sdq.ByCounter.test;

import org.apache.log4j.Logger;

/**
 * Class for running the instrumentation for paper validation
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class CountingSubject {
	public static void main(String args[]){
		CountingSubject dts = new CountingSubject();
		dts.decimalsForCounting(1000);
		dts.fibonacciForCounting(1000);
		dts.decimalsForCounting_equalized(1000);
		dts.fibonacciForCounting_equalized(1000);
		int[] dummy = new int[1];
		@SuppressWarnings("unused")
		int dummy2;
		dummy[0] = 1;
		dummy[0] = 1;
		dummy[0] = 1;
		dummy2 = dummy [0];
		dummy2 = dummy [0];
		dummy2 = dummy [0];
	}
	
	public long end = 0L;//PAPER
	
	private Logger log;
	
	public int[]numbers;
	
	public long start=0L;

	public int TEMP = 2;
	
	public CountingSubject(){
		log = Logger.getLogger(this.getClass().getCanonicalName());
		log.info(getClass().getCanonicalName() + " was constructed.");
	}
	
	public long fibonacciForCounting_efficient(int nr) {
		numbers = new int[nr];
		start = System.nanoTime();
		int beforeLast;
		int last;
		int current;
		numbers[0] = 1;
		numbers[1] = 1;
		beforeLast = 1;
		last = 1;

		for (int i = 2; i<nr; i++) {
			current = last+beforeLast;
			beforeLast=last;
			last=current;
			numbers[i] = current;
		}
		end = System.nanoTime();
		return end - start;
	}

	public long decimalsForCounting(int nr) {
		numbers = new int[nr];
		start = System.nanoTime();
		int dividend = 22;
		int divisor = 7;

		for (int i = 0; i<nr; i++) {
			numbers[i] = dividend/divisor;
			dividend = 10*(dividend
					- numbers[i]*divisor);
		}
		end = System.nanoTime();
		return end - start;
	}
	
	public long decimalsForCounting_equalized(int nr) {
		start = System.nanoTime();
		numbers = new int[nr];
		int dividend = 22;
		int divisor = 7;

		for (int i = 0; i<nr; i++) {
			numbers[i] = dividend/divisor;
			dividend = 10*(dividend
					- numbers[i]*divisor);
		}
		end = System.nanoTime();
		dividend++; //MK EQUALIZER
		dividend--; //MK EQUALIZER
		dividend++; //MK EQUALIZER
		dividend--; //MK EQUALIZER
		dividend++; //MK EQUALIZER
		dividend--; //MK EQUALIZER
		return end - start;
	}
	
	public long fibonacciForCounting(int nr) {
		start = System.nanoTime();
		numbers = new int[nr];
		numbers[0] = 1;
		numbers[1] = 1;

		for (int i = 2; i<nr; i++) { //TODO warum stürzt der Zähler ab, wenn ich "i<(nr+2) mache?
			numbers[i] = numbers[i - 1]
			           + numbers[i - 2];
		}
		end = System.nanoTime();
		return end - start;
	}

	public long fibonacciForCounting_equalized(int nr) {
		start = System.nanoTime();
		numbers = new int[nr];
		numbers[0] = 1;
		numbers[1] = 1;

		for (int i = 2; i<nr; i++) {
			numbers[i] = numbers[i - 1]
			           + numbers[i - TEMP];//equalizer
		}
		end = System.nanoTime();
		return end - start;
	}
}

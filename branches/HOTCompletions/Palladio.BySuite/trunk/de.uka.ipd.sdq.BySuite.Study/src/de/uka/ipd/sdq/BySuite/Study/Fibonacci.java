package de.uka.ipd.sdq.BySuite.Study;

import java.util.Random;

/**
 * Implements the measurement of the calculation of fibonacci numbers.
 * @author Martin, Michael
 */
public class Fibonacci extends SimpleTiming {
		
	private static final int[] precomputedFibonacciNumbers = new int[]{1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597, 2584, 4181, 6765};

	/**
	 * Start the SimpleTiming with this subclass.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		fib.start();
	}
	
	/**
	 * Array used to store the results of the fibonacci calculation.
	 */
	public int[] numbers; //made "public" to prevent JIT optimisations
	
	public int randomStartValueA;
	public int randomStartValueB;
	private Random rd;
	private boolean randomStartValuesInEachRun = true;

	/**
	 * Construct the {@link Fibonacci} instance. Prints a log.info message.
	 */
	public Fibonacci() {
		log.info("Fibonacci Calculation");
		rd = new Random();
	}

	/**
	 * Construct the {@link Fibonacci} instance. Prints a log.info message.
	 */
	public Fibonacci(boolean randomStartValuesInEachRun) {
		log.info("Fibonacci Calculation");
		rd = new Random();
		this.randomStartValuesInEachRun = randomStartValuesInEachRun;
	}

	/**
	 * {@inheritDoc}
	 */
	protected final void afterRun() {
		StringBuilder sb = new StringBuilder(numbers[0] + ".");
		for(int i = 1; i < 50 && i < DEFAULT_PROBLEM_SIZE; i++) {
			sb.append(numbers[i]);
		}
		log.info(sb.toString());
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected final void beforeRun() {
		// choose the prime numbers
		if(randomStartValuesInEachRun){
			int index = rd.nextInt(precomputedFibonacciNumbers.length-1);
			randomStartValueA = precomputedFibonacciNumbers[index];
			randomStartValueB = precomputedFibonacciNumbers[index+1];
		}else{
			randomStartValueA = 1;
			randomStartValueB = 1;
		}
		log.debug("Fibonacci starters: " + randomStartValueA + " and " + randomStartValueB + ".");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final long run(int nr) {
		// start measured section
		start = System.nanoTime();
		numbers = new int[nr];
		numbers[0] = randomStartValueA;
		numbers[1] = randomStartValueB;
		for (int i=2;i<nr;i++) {
			numbers[i] = numbers[i - 1] + numbers[i - 2];
		}
		end = System.nanoTime();
		// end measured section
		return end-start;
	}

}

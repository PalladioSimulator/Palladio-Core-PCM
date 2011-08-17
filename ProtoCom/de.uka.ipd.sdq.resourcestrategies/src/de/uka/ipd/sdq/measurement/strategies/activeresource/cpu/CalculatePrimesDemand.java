package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import de.uka.ipd.sdq.measurement.strategies.activeresource.AbstractDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;

public class CalculatePrimesDemand extends AbstractDemandStrategy {

	/** number to start the search with */
	private final long number = 2;

	/**
	 * Initialize the search for the next given number of primes
	 */
	public CalculatePrimesDemand() {
		super(-3, 0, 3, 100, 100);
	}

	/**
	 * Search for the next primes.
	 */
	private long calculatePrime(double numberNextPrimes) { 
		
		boolean isPrime = true;
		long currentNumber = number;
		long primesFound = 0;
		long currentDivisor;
		long upperBound;

		while (primesFound < numberNextPrimes) {
			// test primality of currentNumber
			currentDivisor = 2;
			upperBound = currentNumber / 2;
			while ((currentDivisor < upperBound) && (isPrime)) {
				isPrime = currentNumber % currentDivisor != 0;
				currentDivisor++;
			}
			// count primes and continue
			if (isPrime) {
				primesFound++;
			}
			// prepare for next iteration
			isPrime = true;
			currentNumber++;
		}
		return currentNumber;
	}

	@Override
	public void run(long initial) {
		calculatePrime(initial);
	}

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public String getName() {
		return "CalculatePrimes";
	}

	@Override
	public void cleanup() {
		// Do nothing.
	}
}

package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;

public class CalculatePrimesDemand extends AbstractDemandStrategy {

	/** number to start the search with */
	private final long number = 2;

	/**
	 * Initialize the search for the next given number of primes
	 */
	public CalculatePrimesDemand() { 
		//this.number = numberStart;
		
		/** define the calibration accuracy parameter */
		high = 3; 
		medium = 0;
		low = -3;
		
		/** which prime number is calculated for the test */
		defaultIterationCount = 100;
		
		/** number of warm up cycles before calibrating */
		warmUpCycles = 1000;
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
}

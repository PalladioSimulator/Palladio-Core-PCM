package de.uka.ipd.sdq.benchmarking;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class JITSpeedupQuantifier {
	
	public static void main(String args[]) {
		JITSpeedupQuantifier jsq = new JITSpeedupQuantifier();
		jsq.run();
	}
	
	public void run(){
		JITSpeedupQuantifier durchschuss;
		durchschuss = new JITSpeedupQuantifier();
		List<Long> summary = new ArrayList<Long>();
		List<Long> currReturn;
		System.out.println("DecimalsComputations_efficient_noinit");
		currReturn = durchschuss.measureManyDecimalsComputations_efficient_noinit   (3000, 20000, 20000);
		Collections.sort(currReturn);
		summary.add(currReturn.get(0));
		summary.add(currReturn.get(currReturn.size()/2));
		summary.add(currReturn.get(currReturn.size()-1));
		
		System.out.println("DecimalsComputations_inefficient_noinit");
		currReturn = durchschuss.measureManyDecimalsComputations_inefficient_noinit (3000, 20000, 20000);
		Collections.sort(currReturn);
		summary.add(currReturn.get(0));
		summary.add(currReturn.get(currReturn.size()/2));
		summary.add(currReturn.get(currReturn.size()-1));
		
		System.out.println("FibonacciComputations_efficient_noinit");
		currReturn = durchschuss.measureManyFibonacciComputations_efficient_noinit  (3000, 20000, 20000);
		Collections.sort(currReturn);
		summary.add(currReturn.get(0));
		summary.add(currReturn.get(currReturn.size()/2));
		summary.add(currReturn.get(currReturn.size()-1));
		
		System.out.println("FibonacciComputations_inefficient_noinit");
		currReturn = durchschuss.measureManyFibonacciComputations_inefficient_noinit(3000, 20000, 20000);
		Collections.sort(currReturn);
		summary.add(currReturn.get(0));
		summary.add(currReturn.get(currReturn.size()/2));
		summary.add(currReturn.get(currReturn.size()-1));

		printSummaryToCMD(summary);
		
		writeCSV(summary);
	}

	private void printSummaryToCMD(List<Long> summary) {
		System.out.println("\n\n\n");
		System.out.println("["+summary.get(0)+";"+summary.get(1)+";"+summary.get(2)+"] :");
		System.out.println("DecimalsComputations_efficient_noinit");
		System.out.println("["+summary.get(3)+";"+summary.get(4)+";"+summary.get(5)+"] :");
		System.out.println("DecimalsComputations_inefficient_noinit");
		System.out.println("["+summary.get(6)+";"+summary.get(7)+";"+summary.get(8)+"] :");
		System.out.println("FibonacciComputations_efficient_noinit");
		System.out.println("["+summary.get(9)+";"+summary.get(10)+";"+summary.get(11)+"] :");
		System.out.println("FibonacciComputations_inefficient_noinit");
	}

	private void writeCSV(List<Long> summary) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("./results/"+
					this.getClass().getName()+
					"."+System.nanoTime()+".csv");
			fos.write(new String("Algo;min;median;max;\n").getBytes());
			fos.write(new String(
					"DecimalsComputations_efficient_noinit;"+
							summary.get(0)+";"+
							summary.get(1)+";"+
							summary.get(2)+";\n").getBytes());
			fos.write(new String(
					"DecimalsComputations_inefficient_noinit;"+
							summary.get(3)+";"+
							summary.get(4)+";"+
							summary.get(5)+";\n").getBytes());
			fos.write(new String(
					"FibonacciComputations_efficient_noinit;"+
							summary.get(6)+";"+
							summary.get(7)+";"+
							summary.get(8)+";\n").getBytes());
			fos.write(new String(
					"FibonacciComputations_inefficient_noinit;"+
							summary.get(9)+";"+
							summary.get(10)+";"+
							summary.get(11)+";\n").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	long[] currRet;
	
	long end = 0L;
	
	List<Long> measurements;
	
	int[] numbers;
	
	Random rd;
	
	List<Long> resultDummies;
		
	long start=0L;
	
	public JITSpeedupQuantifier(){
		rd = new Random();
	}

	private long[] basicDecimalsComputation_efficient_noinit(int nr) {
		numbers = new int[nr];
		start = System.nanoTime();
		int dividend = 22;
		int divisor = 7;
		int quotient;
		for (int i = 0; i<nr; i++) {
			quotient = dividend/divisor;
			numbers[i] = quotient;
			dividend = 10*(dividend
					- quotient*divisor);
		}
		end = System.nanoTime();
		return new long[]{(end - start), numbers[rd.nextInt(nr)]};
	}
		
	private long[] basicDecimalsComputation_inefficient_noinit(int nr) {
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
		return new long[]{(end - start), numbers[rd.nextInt(nr)]};
	}
	
	private long[] basicFibonacciComputation_efficient_noinit(int nr) {
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
		return new long[]{(end - start), numbers[rd.nextInt(nr)]};
	}

	private long[] basicFibonacciComputation_inefficient_noinit(int nr) {
		numbers = new int[nr];
		start = System.nanoTime();
		numbers[0] = 1;
		numbers[1] = 1;
	
		for (int i = 2; i<nr; i++) {
			numbers[i] = numbers[i - 1]
			           + numbers[i - 2];//NO equalizer
		}
		end = System.nanoTime();
		return new long[]{(end - start), numbers[rd.nextInt(nr)]};
	}
	
	private List<Long> measureManyDecimalsComputations_efficient_noinit(
			int nrOfWarmups, 
			int nrOfMeasurements, 
			int problemSize) {
		System.out.println("Decimals: Started session with "+nrOfWarmups+
				" as number of warmups: "+
				new Timestamp(System.currentTimeMillis()));
		resultDummies = new ArrayList<Long>(nrOfMeasurements);
		measurements = new ArrayList<Long>(nrOfMeasurements);
		for(int i=0; i<nrOfWarmups; i++){
			currRet = this.basicDecimalsComputation_efficient_noinit(problemSize);
			measurements.add(currRet[0]);
			resultDummies.add(currRet[1]);
		}
		System.out.println("Output (just for preventing JIT optimisations): "+
				resultDummies.get(rd.nextInt(resultDummies.size())));
		System.out.println("Output (just for preventing JIT optimisations): "+
				measurements.get(rd.nextInt(measurements.size())));

		resultDummies = new ArrayList<Long>(nrOfMeasurements);
		measurements = new ArrayList<Long>(nrOfMeasurements);
		for(int j=0; j<nrOfMeasurements; j++){
			currRet = this.basicDecimalsComputation_efficient_noinit(problemSize);
			measurements.add(currRet[0]);
			resultDummies.add(currRet[1]);
		}
		System.out.println("Decimals: Finished session with warmup: "+
				new Timestamp(System.currentTimeMillis()));
		Collections.sort(measurements);
		Collections.sort(resultDummies);
		System.out.println("["+measurements.get(0)+","+
				measurements.get(nrOfMeasurements-1)+"]"+
				"median: "+measurements.get(nrOfMeasurements/2));
		System.out.println("Output (just for preventing JIT optimisations): "+
				resultDummies.get(rd.nextInt(resultDummies.size())));
		return measurements;
	}

	private List<Long> measureManyDecimalsComputations_inefficient_noinit(
			int nrOfWarmups, 
			int nrOfMeasurements, 
			int problemSize) {
		
		System.out.println("Started session with "+nrOfWarmups+
				" as number of warmups: "+
				new Timestamp(System.currentTimeMillis()));
		resultDummies = new ArrayList<Long>(nrOfMeasurements);
		measurements = new ArrayList<Long>(nrOfMeasurements);
		for(int i=0; i<nrOfWarmups; i++){
			currRet = this.basicDecimalsComputation_inefficient_noinit(problemSize);
			measurements.add(currRet[0]);
			resultDummies.add(currRet[1]);
		}
		System.out.println("Output (just for preventing JIT optimisations): "+
				resultDummies.get(rd.nextInt(resultDummies.size())));
		System.out.println("Output (just for preventing JIT optimisations): "+
				measurements.get(rd.nextInt(measurements.size())));
		resultDummies = new ArrayList<Long>(nrOfMeasurements);
		measurements = new ArrayList<Long>(nrOfMeasurements);
		for(int j=0; j<nrOfMeasurements; j++){
			currRet = this.basicDecimalsComputation_inefficient_noinit(problemSize);
			measurements.add(currRet[0]);
			resultDummies.add(currRet[1]);
		}
		System.out.println("Finished session with warmup: "+
				new Timestamp(System.currentTimeMillis()));
		Collections.sort(measurements);
		Collections.sort(resultDummies);
		System.out.println("["+measurements.get(0)+","+
				measurements.get(nrOfMeasurements-1)+"]"+
				"median: "+measurements.get(nrOfMeasurements/2));
		System.out.println("Output (just for preventing JIT optimisations): "+
				resultDummies.get(rd.nextInt(resultDummies.size())));
		return measurements;
	}
	
	private List<Long> measureManyFibonacciComputations_efficient_noinit(
			int nrOfWarmups, 
			int nrOfMeasurements, 
			int problemSize) {
		
		System.out.println("Started session with "+nrOfWarmups+
				" as number of warmups: "+
				new Timestamp(System.currentTimeMillis()));
		resultDummies = new ArrayList<Long>(nrOfMeasurements);
		measurements = new ArrayList<Long>(nrOfMeasurements);
		for(int i=0; i<nrOfWarmups; i++){
			currRet = this.basicFibonacciComputation_efficient_noinit(problemSize);
			measurements.add(currRet[0]);
			resultDummies.add(currRet[1]);
		}
		System.out.println("Output (just for preventing JIT optimisations): "+
				resultDummies.get(rd.nextInt(resultDummies.size())));
		System.out.println("Output (just for preventing JIT optimisations): "+
				measurements.get(rd.nextInt(measurements.size())));
		resultDummies = new ArrayList<Long>(nrOfMeasurements);
		measurements = new ArrayList<Long>(nrOfMeasurements);
		for(int j=0; j<nrOfMeasurements; j++){
			currRet = this.basicFibonacciComputation_efficient_noinit(problemSize);
			measurements.add(currRet[0]);
			resultDummies.add(currRet[1]);
		}
		System.out.println("Finished session with warmup: "+
				new Timestamp(System.currentTimeMillis()));
		Collections.sort(measurements);
		Collections.sort(resultDummies);
		System.out.println("["+measurements.get(0)+","+
				measurements.get(nrOfMeasurements-1)+"]"+
				"median: "+measurements.get(nrOfMeasurements/2));
		System.out.println("Output (just for preventing JIT optimisations): "+
				resultDummies.get(rd.nextInt(resultDummies.size())));
		return measurements;
	}

	private List<Long> measureManyFibonacciComputations_inefficient_noinit(
			int nrOfWarmups, 
			int nrOfMeasurements, 
			int problemSize) {
		
		System.out.println("Started session with "+nrOfWarmups+
				" as number of warmups: "+
				new Timestamp(System.currentTimeMillis()));
		resultDummies = new ArrayList<Long>(nrOfMeasurements);
		measurements = new ArrayList<Long>(nrOfMeasurements);
		for(int i=0; i<nrOfWarmups; i++){
			currRet = this.basicFibonacciComputation_inefficient_noinit(problemSize);
			measurements.add(currRet[0]);
			resultDummies.add(currRet[1]);
		}
		System.out.println("Output (just for preventing JIT optimisations): "+
				resultDummies.get(rd.nextInt(resultDummies.size())));
		System.out.println("Output (just for preventing JIT optimisations): "+
				measurements.get(rd.nextInt(measurements.size())));
		resultDummies = new ArrayList<Long>(nrOfMeasurements);
		measurements = new ArrayList<Long>(nrOfMeasurements);
		for(int j=0; j<nrOfMeasurements; j++){
			currRet = this.basicFibonacciComputation_inefficient_noinit(problemSize);
			measurements.add(currRet[0]);
			resultDummies.add(currRet[1]);
		}
		System.out.println("Finished session with warmup: "+
				new Timestamp(System.currentTimeMillis()));
		Collections.sort(measurements);
		Collections.sort(resultDummies);
		System.out.println("["+measurements.get(0)+","+
				measurements.get(nrOfMeasurements-1)+"]"+
				"median: "+measurements.get(nrOfMeasurements/2));
		System.out.println("Output (just for preventing JIT optimisations): "+
				resultDummies.get(rd.nextInt(resultDummies.size())));
		return measurements;
	}
}

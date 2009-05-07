package de.uka.ipd.sdq.ByCounter.SPECevaluation.scimark;

import java.util.ArrayList;
import java.util.List;

public class SPECScimarkMeasurer {
	public static void main(String[] args){
		SPECScimarkMeasurer ssm = new SPECScimarkMeasurer();
		ssm.run();
	}

	private ArrayList<Long> loop_pr_ns_fi_List = new ArrayList<Long>();
	private ArrayList<Long> meth_pr_ns_fi_List = new ArrayList<Long>();

	private final long computeFibonacciNumbers_pr_st_fi() {
		long time1 = 0L;
		long time2 = 0L;
		time1 = System.nanoTime();
		
		time2 = System.nanoTime();
		return time2 - time1;
	}

	private List<ArrayList<Long>> makeLoopMeasurements(int nrOfRepetitions) {
		//the following code can be looped!
		List<ArrayList<Long>> results = new ArrayList<ArrayList<Long>>();
		this.loop_pr_ns_fi_List = repeatLoop_pr_ns_fi(nrOfRepetitions);
		results.add((ArrayList<Long>) loop_pr_ns_fi_List);
		return results;
	}
	
	private List<ArrayList<Long>> makeMethodMeasurements(int nrOfRepetitions) {
		List<ArrayList<Long>> results = new ArrayList<ArrayList<Long>>();

		for (int j = 0; j < nrOfRepetitions; j++) {
			meth_pr_ns_fi_List.add(computeFibonacciNumbers_pr_st_fi());
		}
		results.add((ArrayList<Long>) meth_pr_ns_fi_List);
		return results;
	}

	private final ArrayList<Long> repeatLoop_pr_ns_fi(int nrOfRepetitions) {
		ArrayList<Long> results = new ArrayList<Long>();
		for (int j = 0; j < nrOfRepetitions; j++) {
			long time1 = 0L;
			long time2 = 0L;
			time1 = System.nanoTime();
			time2 = System.nanoTime();
			results.add(time2 - time1);
		}
		return results;
	}
	
	private void run() {
		this.makeLoopMeasurements(3000);
		this.makeMethodMeasurements(3000);
	}
	
}

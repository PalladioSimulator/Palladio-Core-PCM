package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

public class Thresholds {
	
	//@author catia: threshold value for max CPU utilisation
	public final double thresholdMaxCpu = 0.35;
	
	//@author catia: threshold value for max CPU queue length
	public final double thresholdCpuQL = 0.2;
	
	//@author catia: threshold value for min CPU utilisation
	public final double thresholdMinCpu = 0.1;
	
	//@author catia: threshold value for max HDD utilisation
	public final double thresholdMaxHdd = 0.3;
    
    //@author catia: threshold value for max CPU queue length
	public final double thresholdHddQL = 0.15;
	
	//@author catia: threshold value for min CPU utilisation
	public final double thresholdMinHdd = 0.05;
	
	//@author catia: threshold value for max queue length of passive resources
    double thresholdPrQL = 0.5;
}
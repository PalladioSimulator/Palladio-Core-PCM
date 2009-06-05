package de.uka.ipd.sdq.ByCounterV2;

public class ByCounterOverFlowException extends Exception {
	long prevCounterAmount;
	long increment;
	int counterNumber;
	String readableCounterSubject;
	long timestamp;
}

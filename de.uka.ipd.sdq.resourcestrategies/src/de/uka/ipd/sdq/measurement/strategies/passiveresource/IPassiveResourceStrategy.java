package de.uka.ipd.sdq.measurement.strategies.passiveresource;

public interface IPassiveResourceStrategy {
	
	void acquire(int num);
	
	void release(int num);

}

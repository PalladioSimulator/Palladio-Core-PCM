package com.palladio_simulator.protocom.resourcestrategies.passiveresource;

public interface IPassiveResourceStrategy {
	
	void acquire(int num);
	
	void release(int num);

}

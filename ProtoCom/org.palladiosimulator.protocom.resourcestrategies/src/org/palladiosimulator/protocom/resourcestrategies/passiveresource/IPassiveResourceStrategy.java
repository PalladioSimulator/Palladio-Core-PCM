package org.palladiosimulator.protocom.resourcestrategies.passiveresource;

public interface IPassiveResourceStrategy {
	
	void acquire(int num);
	
	void release(int num);

}

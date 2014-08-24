package org.palladiosimulator.protocom.resourcestrategies.ee.passiveresource;

public interface IPassiveResourceStrategy {

    void acquire(int num);

    void release(int num);

}

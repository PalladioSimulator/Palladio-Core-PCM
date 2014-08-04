package org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.AbstractDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;

public class FibonacciDemand extends AbstractDemandStrategy {

    public FibonacciDemand() {
        super(-3, 0, 2, 10000, 5000);
    }

    private long fibonacci(double iterationCount) {
        long i1 = 1;
        long i2 = 1;
        long i3 = 0;
        for (long i = 0; i < iterationCount; i++) {
            i3 = i1 + i2;
            i2 = i1;
            i1 = i3;
        }
        return i3;
    }

    @Override
    public void run(long initial) {
        fibonacci(initial);
    }

    @Override
    public ResourceTypeEnum getStrategysResource() {
        return ResourceTypeEnum.CPU;
    }

    @Override
    public String getName() {
        return "Fibonacci";
    }

    @Override
    public void cleanup() {
        // Do nothing.
    }

}

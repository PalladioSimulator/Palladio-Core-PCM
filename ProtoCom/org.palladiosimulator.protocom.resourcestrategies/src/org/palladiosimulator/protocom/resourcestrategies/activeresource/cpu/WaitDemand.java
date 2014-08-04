package org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.AbstractDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;

public class WaitDemand extends AbstractDemandStrategy {

    public WaitDemand() {
        super(-2, 0, 3, 10, 50);
    }

    private void waitFor(long waitingTime) {
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run(long initial) {
        waitFor(initial);
    }

    @Override
    public ResourceTypeEnum getStrategysResource() {
        return ResourceTypeEnum.CPU;
    }

    @Override
    public String getName() {
        return "Wait";
    }

    @Override
    public void cleanup() {
        // Do nothing.
    }

}

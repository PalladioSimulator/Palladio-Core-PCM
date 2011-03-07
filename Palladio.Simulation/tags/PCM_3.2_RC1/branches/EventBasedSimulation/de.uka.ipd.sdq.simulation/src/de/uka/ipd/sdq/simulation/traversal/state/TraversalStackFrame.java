package de.uka.ipd.sdq.simulation.traversal.state;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simulation.SimulatedComponentInstance;

public class TraversalStackFrame<T extends Entity> {

    private final Map<T, ITraversalStrategyState> actionToStateMap;
    private final Queue<T> finishedActionsQueue;
    private T currentPosition;
    private T previousPosition;
    private SimulatedComponentInstance component;
    
    private SimulatedStackframe<Object> resultStackFrame;
    private SimulatedStackframe<Object> methodBodyStackFrame;

    public TraversalStackFrame() {
        this.actionToStateMap = new HashMap<T, ITraversalStrategyState>();
        this.finishedActionsQueue = new LinkedList<T>();
    }

    public void addState(final T action, final ITraversalStrategyState state) {
        this.actionToStateMap.put(action, state);
    }

    public ITraversalStrategyState getState(final T action) {
        return this.actionToStateMap.get(action);
    }

    public T getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(final T position) {
        this.currentPosition = position;
    }

    public T getPreviousPosition() {
        return this.previousPosition;
    }

    public void setPreviousPosition(final T previousPosition) {
        this.previousPosition = previousPosition;
    }

    public void enqueueFinishedAction(final T action) {
        this.finishedActionsQueue.add(action);
    }

    public T dequeueFinishedAction() {
        return this.finishedActionsQueue.poll();
    }

    public boolean hasFinishedActions() {
        return !this.finishedActionsQueue.isEmpty();
    }

    public SimulatedComponentInstance getComponent() {
        return component;
    }

    public void setComponent(SimulatedComponentInstance component) {
        this.component = component;
    }

    public SimulatedStackframe<Object> getResultStackFrame() {
        return resultStackFrame;
    }

    public void setResultStackFrame(SimulatedStackframe<Object> resultStackFrame) {
        this.resultStackFrame = resultStackFrame;
    }

    public SimulatedStackframe<Object> getMethodBodyStackFrame() {
        return methodBodyStackFrame;
    }

    public void setMethodBodyStackFrame(SimulatedStackframe<Object> methodBodyStackFrame) {
        this.methodBodyStackFrame = methodBodyStackFrame;
    }
    
}

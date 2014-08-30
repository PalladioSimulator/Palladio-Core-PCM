package de.uka.ipd.sdq.reliability.core;

public interface IFailureStatisticsListener {

    public abstract void executionResultRecorder(MarkovFailureType failureType);

}

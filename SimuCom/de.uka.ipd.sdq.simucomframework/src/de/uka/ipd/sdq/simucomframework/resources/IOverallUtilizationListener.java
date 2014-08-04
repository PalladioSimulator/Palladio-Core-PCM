package de.uka.ipd.sdq.simucomframework.resources;

public interface IOverallUtilizationListener {

    /**
     * Gets fired as soon as the overall utilization of a resource is known.
     */
    void utilizationChanged(double resourceDemand, double totalTime);

}

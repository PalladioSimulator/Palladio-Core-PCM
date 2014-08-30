package de.uka.ipd.sdq.scheduler.factory;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public interface SchedulerExtensionFactory {

    /**
     * This interface has to be implemented by a scheduler factory that contributes schedulers to
     * the Palladio simulation.
     * 
     * @param model
     *            the SchedulerModel of the simulation. Contains initial simulation configuration,
     *            but is mainly passed because it is needed by SimuCom's AbstractActiveResource
     *            constructor.
     * @param resourceName
     *            the name of the scheduler. This should conform to the id of the scheduler
     *            extension
     * @param resourceId
     *            the id of the resource. Multiple resources sharing the same scheduler have
     *            different resource ids.
     * @return the resource with the corresponding scheduler for the simulation
     */
    public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId,
            long numberOfCores);

}

package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class SimuComExtensionResource extends AbstractActiveResource {

    public SimuComExtensionResource(SchedulerModel model, long capacity, String name, String id) {
        super(model, capacity, name, id);
    }

    public abstract void initialize(SimuComModel simuComModel);

}

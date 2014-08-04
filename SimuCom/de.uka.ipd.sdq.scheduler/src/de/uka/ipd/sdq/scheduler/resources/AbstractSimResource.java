package de.uka.ipd.sdq.scheduler.resources;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

public abstract class AbstractSimResource extends SchedulerEntity {

    protected long capacity;
    private String name = "";
    private String id = "";
    protected SchedulingFactory factory;

    public AbstractSimResource(SchedulerModel model, long capacity, String name, String id) {
        super(model, AbstractSimResource.class.getName());
        this.capacity = capacity;
        this.name = name;
        this.id = id;

        factory = new SchedulingFactory(model);
    }

    public long getCapacity() {
        return capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof AbstractSimResource) {
            AbstractSimResource res = (AbstractSimResource) obj;
            return this.id.equals(res.getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return name + id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

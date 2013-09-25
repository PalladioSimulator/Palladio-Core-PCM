package de.uka.ipd.sdq.simulation.abstractsimengine;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 * 
 * @see ISimProcess
 */
public abstract class AbstractSimProcessDelegator extends AbstractSimEntityDelegator implements
        ISimProcess {

    private static AtomicLong processIdGenerator = new AtomicLong(0);

    /**
     * the delegate has the simulation-library-specific knowledge of how this process can be
     * suspended and resumed again. The delegate, however, is not aware of the lifecycle associated
     * with this process, which is why it invokes the <code>lifecycle</code> method as soon as the
     * process is to be executed.
     */
    private ISimProcess delegate;
    private long id;

    public AbstractSimProcessDelegator(ISimulationModel model, String name) {
        super(model, name);
        this.delegate = model.getSimEngineFactory().createSimProcess(this, name);
        this.id = generateNextID();
    }

    // TODO This method should be rather named getId() but there is already such a method. Thus,
    // getId() should be renamed to getTextualId() or similar.
    public long getRawId() {
        return id;
    }

    public String getId() {
        return getName() + "_" + id;
    }

    private static long generateNextID() {
        return processIdGenerator.incrementAndGet();
    }

    public abstract void lifeCycle();

    /**
     * {@inheritDoc}
     */
    public boolean isTerminated() {
        return delegate.isTerminated();
    }

    /**
     * {@inheritDoc}
     */
    public void passivate() {
        delegate.passivate();
    }

    /**
     * {@inheritDoc}
     */
    public void scheduleAt(double d) {
        delegate.scheduleAt(d);
    }

    /**
     * {@inheritDoc}
     */    
    public void passivate(double delay) {
        delegate.passivate(delay);
    }

    public void addProcessListener(ISimProcessListener l) {
        delegate.addProcessListener(l);
    }

    public void removeProcessListener(ISimProcessListener l) {
        delegate.removeProcessListener(l);
    }
    
//    public boolean isScheduled() {
//        return delegate.isScheduled();
//    }
//
//    public void reschedule(double d) {
//        delegate.reschedule(d);
//    }

}

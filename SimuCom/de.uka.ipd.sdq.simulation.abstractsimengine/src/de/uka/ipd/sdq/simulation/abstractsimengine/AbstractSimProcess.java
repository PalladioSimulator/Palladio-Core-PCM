package de.uka.ipd.sdq.simulation.abstractsimengine;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 * @see ISimProcess
 */
public abstract class AbstractSimProcess<M extends ISimulationModel<M>> extends SimulationElement<M> implements
        ISimProcess {

    private static AtomicLong processIdGenerator = new AtomicLong(0);

    /**
     * the delegate has the simulation-library-specific knowledge of how this process can be
     * suspended and resumed again. The delegate, however, is not aware of the lifecycle associated
     * with this process, which is why it invokes the <code>lifecycle</code> method as soon as the
     * process is to be executed.
     */
    private ISimProcess delegate = null;
    private long id;

    public AbstractSimProcess(M model, String name) {
        super(model, name);
        this.delegate = model.getSimEngineFactory().createSimProcess(this, name);
        this.id = generateNextID();
    }

    // TODO This method should be called getId() but there is already such a method. Thus, getId()
    // should be renamed to getTextualId() or something like that.
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

    public void addProcessListener(ISimProcessListener l) {
        delegate.addProcessListener(l);
    }

    public void removeProcessListener(ISimProcessListener l) {
        delegate.removeProcessListener(l);
    }

}

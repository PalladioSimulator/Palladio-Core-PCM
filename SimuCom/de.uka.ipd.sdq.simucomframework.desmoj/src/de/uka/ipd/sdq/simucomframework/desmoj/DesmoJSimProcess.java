/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimProcess;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimProcess;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;
import desmoj.core.exception.SimAbortedException;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

/**
 * @author Steffen Becker
 * 
 */
public class DesmoJSimProcess<M extends ISimulationModel<M>> extends SimProcess implements ISimProcess {

    private AbstractSimProcess<M> process;

    public DesmoJSimProcess(AbstractSimProcess<M> process, DesmoJModel<M> owner, String name) {
        super(owner, name, false);
        this.process = process;
    }

    public void hold(double delay) {
        this.hold(new TimeSpan(delay));
    }

    @Override
    public void lifeCycle() {
        try {
            // delegate the call to the encapsulated process
            process.lifeCycle();
        } catch (SimFinishedException ex) {
            // TODO re-throw exception?
        } catch (SimAbortedException ex) {
            // TODO re-throw exception?
        }
    }

    public void scheduleAt(double delay) {
        this.activate(new TimeSpan(delay));
    }

}

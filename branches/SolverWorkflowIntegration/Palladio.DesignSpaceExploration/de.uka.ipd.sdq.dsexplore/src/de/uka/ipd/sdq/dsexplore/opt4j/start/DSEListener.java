package de.uka.ipd.sdq.dsexplore.opt4j.start;

import org.eclipse.core.runtime.IProgressMonitor;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;

/**
 * Adds the possibility to terminate a run in the eclipse Progress view. 
 * If cancel operation is clicked there, IProgressMonitor.isCanceled evaluates to true and 
 * the optimisation is asked to terminate after completing the current iteration.
 * @author Anne
 *
 */
public class DSEListener implements OptimizerIterationListener {

	private IProgressMonitor monitor;

	public DSEListener(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public void iterationComplete(Optimizer optimizer, int iteration) {
		if (this.monitor.isCanceled()){
			Opt4JStarter.terminate();
		}

	}

}

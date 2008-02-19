package de.uka.ipd.sdq.simucomframework;



/**
 * Control interface for the SimuCom Framework. It defines two methods, which
 * for starting and stopping simulation are responsible.
 * 
 * @author Roman Andrej
 */
public interface ISimuComControl {

	public SimuComStatus startSimulation(SimuComConfig config, IStatusObserver statusObserver);
	public void stopSimulation();
	public Throwable getErrorThrowable();
}

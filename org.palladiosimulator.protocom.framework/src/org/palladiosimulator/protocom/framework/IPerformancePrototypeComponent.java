package org.palladiosimulator.protocom.framework;

/**
 * Basic component interface for performance prototypes.
 * 
 * TODO: Add parameter for context class.
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 */
public interface IPerformancePrototypeComponent extends IComponent{
	public void setComponentFrame(de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame);
}

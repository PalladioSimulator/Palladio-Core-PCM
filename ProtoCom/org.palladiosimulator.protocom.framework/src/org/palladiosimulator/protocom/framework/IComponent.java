package org.palladiosimulator.protocom.framework;

/**
 * Basic component interface.
 * 
 * TODO: Add parameter for context class.
 * 
 * @author zolynski
 */
public interface IComponent {

	public void setContext(Object myContext);

	public void setComponentFrame(de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame);

	
}

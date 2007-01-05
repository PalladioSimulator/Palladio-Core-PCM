package de.uka.ipd.sdq.simucomframework.variables;

import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class EvaluationProxy {
	private String stoex;
	private SimulatedStackframe contextFrame;

	public EvaluationProxy (String stoex, SimulatedStackframe contextFrame)
	{
		this.stoex = stoex;
		this.contextFrame = contextFrame;
	}

	public SimulatedStackframe getStackFrame() {
		return contextFrame;
	}

	public String getStoEx() {
		return stoex;
	}
}

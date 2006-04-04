package de.uka.ipd.sdq.simucom.threads;

import java.util.ArrayList;

import de.uka.ipd.sdq.simucom.component.Component;
import de.uka.ipd.sdq.simucom.component.Method;
import de.uka.ipd.sdq.simucom.component.ServiceEffect;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class ArchitectureVisitor
extends ReflectiveVisitor
implements IThreadActionVisitor {

	protected ArrayList<HistoryElement> localHistory;
	protected SimProcess parent = null;
	
	public ArchitectureVisitor(SimProcess parent, ArrayList<HistoryElement> history)
	{
		localHistory = history;
		this.parent = parent;
	}
	
	public void visitMethod(Method m) throws Exception {
		addHistoryEntry("SimulatedThread visits "+m.toString());
		m.getServiceEffectSpecification().accept(this);
	}

	public void visitServiceEffect(ServiceEffect se) throws Exception {
		addHistoryEntry("SimulatedThread visits "+se.toString());
		new ActivityVisitor(parent,localHistory).visitActivity(se.getSimulatedActivity());
	}
	
	public void visitComponent(Component c) throws Exception {
		addHistoryEntry("SimulatedThread visisits "+c.toString());
		for (Method m : c.getMethods()){
			m.accept(this);
		}
	}
	
	private void addHistoryEntry(String message) {
		localHistory.add(new HistoryElement(SimTime.NOW,message));
	}
}

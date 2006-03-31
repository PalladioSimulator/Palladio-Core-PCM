package de.uka.ipd.simucom.threads;

import java.util.ArrayList;
import de.uka.ipd.simucom.component.Component;
import de.uka.ipd.simucom.threads.history.HistoryElement;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;


public class SimulatedThread 
extends SimProcess {

	protected ArrayList<HistoryElement> localHistory;
	
	protected Component startComponent = null;

	public SimulatedThread(Model arg0, String arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		localHistory = new ArrayList<HistoryElement>();
	}
	
	public void init (Component startComponent){
		this.startComponent = startComponent;
	}
	
	@Override
	public void lifeCycle() {
		addHistoryEntry("SimulatedThread started");
		try
		{
			new ArchitectureVisitor(this,localHistory).visit(startComponent);
		}
		catch (Exception ex)
		{
			System.out.println("Visitor exception: "+ex);
		}
		dumpHistory();
	}
	
	private void dumpHistory() {
		System.out.println("Dump of history of thread "+this.getName());
		for (HistoryElement e : localHistory) {
			System.out.println(e);
		}
	}
	
	private void addHistoryEntry(String message) {
		localHistory.add(new HistoryElement(SimTime.NOW,message));
	}
}

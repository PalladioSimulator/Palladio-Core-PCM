package de.uka.ipd.sdq.simucom.threads;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.Action;
import org.eclipse.uml2.Activity;
import org.eclipse.uml2.ActivityFinalNode;
import org.eclipse.uml2.ActivityNode;
import org.eclipse.uml2.ControlFlow;
import org.eclipse.uml2.InitialNode;
import org.eclipse.uml2.LoopNode;

import de.uka.ipd.sdq.simucom.activity.ActivityQueries;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import de.uka.ipd.sdq.simucom.umlhelper.UMLHelper;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class ActivityVisitor extends ReflectiveVisitor {

	protected ArrayList<HistoryElement> localHistory;
	protected SimProcess parent = null;
	
	public ActivityVisitor(SimProcess parent, ArrayList<HistoryElement> history)
	{
		localHistory = history;
		this.parent = parent;
	}

	public void visitActivity(Activity a) throws Exception {
		addHistoryEntry("SimulatedActivity enter "+UMLHelper.ElementToString(a));
		visit(ActivityQueries.getInitialNode(a));
		addHistoryEntry("SimulatedActivity exits "+UMLHelper.ElementToString(a));
	}

	public void visitAction(Action n) throws Exception
	{
		visitActivityNode(n);
	}

	public void visitActivityFinalNode(ActivityFinalNode n) throws Exception
	{
		visitActivityNode(n);
	}

	public void visitInitialNode(InitialNode n) throws Exception
	{
		visitActivityNode(n);
	}
	
	public void visitLoopNode(LoopNode n) throws Exception
	{
		ActivityNode next = null;
		
		addHistoryEntry("Processing LoopNode "+UMLHelper.ElementToString(n));
		int repetitions = (Integer)UMLHelper.getStereotypeValue(n, "PA::PALoop", "Repetitions");
		for (int i=0; i<repetitions; i++)
		{
			visit(ActivityQueries.getInitialNode(n.getBodyParts()));
		}
		if ((next = getNextNode(n)) != null)
			visit(next);		
	}
	
	public void visitActivityNode(ActivityNode a) throws Exception
	{
		ActivityNode next = null;
		
		addHistoryEntry("Processing ActivityNode "+UMLHelper.ElementToString(a));
		if (UMLHelper.isStereotypeApplied(a, "PA::TimeConsumer"))
		{
			int delay = (Integer)UMLHelper.getStereotypeValue(a, "PA::TimeConsumer", "MeanTimeConsumption");
			addHistoryEntry("Consuming time "+delay);
			parent.hold(new SimTime(delay));
		}
		if ((next = getNextNode(a)) != null)
			visit(next);
	}
	
	private void addHistoryEntry(String message) {
		localHistory.add(new HistoryElement(SimTime.NOW,message));
	}
	
	protected ActivityNode getNextNode(ActivityNode currentNode)
	{
		EList outgoingEdges = currentNode.getOutgoings();
		if (outgoingEdges.size()>0)
		{
			ControlFlow edge = (ControlFlow)outgoingEdges.get(0);
			return edge.getTarget();
		}	
		return null;
	}
}


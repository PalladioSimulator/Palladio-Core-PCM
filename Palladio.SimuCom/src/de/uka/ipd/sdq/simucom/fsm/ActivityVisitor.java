package de.uka.ipd.sdq.simucom.activity;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.Action;
import org.eclipse.uml2.Activity;
import org.eclipse.uml2.ActivityEdge;
import org.eclipse.uml2.ActivityFinalNode;
import org.eclipse.uml2.ActivityNode;
import org.eclipse.uml2.CallBehaviorAction;
import org.eclipse.uml2.ControlFlow;
import org.eclipse.uml2.InitialNode;
import org.eclipse.uml2.LoopNode;

import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import de.uka.ipd.sdq.simucom.umlhelper.UMLHelper;
import desmoj.core.dist.IntDistEmpirical;
import desmoj.core.dist.RealDistUniform;
import desmoj.core.dist.UniformRandomGenerator;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class ActivityVisitor extends ReflectiveVisitor {

	protected ArrayList<HistoryElement> localHistory;
	protected SimProcess parent = null;
	protected RealDistUniform alternativeDistribution = null;
	
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
	
	public void visitCallBehaviorAction(CallBehaviorAction a) throws Exception
	{
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
	
	protected void addHistoryEntry(String message) {
		localHistory.add(new HistoryElement(SimTime.NOW,message));
	}
	
	protected ActivityNode getNextNode(ActivityNode currentNode)
	{
		EList outgoingEdges = currentNode.getOutgoings();
		if (outgoingEdges.size()>0)
		{
			if (outgoingEdges.size()==1)
			{
				ControlFlow edge = (ControlFlow)outgoingEdges.get(0);
				return edge.getTarget();
			}
			else
			{
				SimuComModel myModel = (SimuComModel)parent.getModel();
				IntDistEmpirical ide = myModel.getDistributionObjectsStorage().getDecisionNodeDistribution(currentNode);
				int position = (int) ide.sample();
				ActivityEdge edge = (ActivityEdge) outgoingEdges.get(position);
				return edge.getTarget();
			}
		}	
		return null;
	}
}


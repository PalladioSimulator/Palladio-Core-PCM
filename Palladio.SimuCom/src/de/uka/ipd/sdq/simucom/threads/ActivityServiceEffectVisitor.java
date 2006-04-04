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

import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import de.uka.ipd.sdq.simucom.umlhelper.UMLHelper;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class ActivityServiceEffectVisitor extends de.uka.ipd.sdq.simucom.activity.ActivityVisitor {
	public ActivityServiceEffectVisitor(SimProcess parent, ArrayList<HistoryElement> history) {
		super(parent, history);
		// TODO Auto-generated constructor stub
	}

	@Override
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
}


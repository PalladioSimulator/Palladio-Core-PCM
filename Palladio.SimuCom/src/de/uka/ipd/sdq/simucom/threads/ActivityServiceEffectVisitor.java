package de.uka.ipd.sdq.simucom.threads;

import java.util.ArrayList;

import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import desmoj.core.simulator.SimProcess;

public class ActivityServiceEffectVisitor 
extends de.uka.ipd.sdq.simucom.activity.ActivityVisitor {

	public ActivityServiceEffectVisitor(SimProcess parent, ArrayList<HistoryElement> history) {
		super(parent, history);
	}

//	@Override
//	public void visitActivityNode(Object a) throws Exception
//	{
////		ActivityNode next = null;
////		
////		addHistoryEntry("Processing ActivityNode "+UMLHelper.ElementToString(a));
////		if (UMLHelper.isStereotypeApplied(a, "PA::TimeConsumer"))
////		{
////			int delay = (Integer)UMLHelper.getStereotypeValue(a, "PA::TimeConsumer", "MeanTimeConsumption");
////			addHistoryEntry("Consuming time "+delay);
////			parent.hold(new SimTime(delay));
////		}
////		if ((next = getNextNode(a)) != null)
////			visit(next);
//	}
}


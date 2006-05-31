package de.uka.ipd.sdq.simucom.usage;

import java.util.ArrayList;

import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import desmoj.core.simulator.SimProcess;

public class UserActivityVisitor 
extends de.uka.ipd.sdq.simucom.activity.ActivityVisitor {
	
	public UserActivityVisitor(SimProcess parent, ArrayList<HistoryElement> history) {
		super(parent, history);
	}

//	@Override
//	public void visitActivityNode(ActivityNode a) throws Exception
//	{
//		ActivityNode next = null;
//		
//		addHistoryEntry("User is processing ActivityNode "+UMLHelper.ElementToString(a));
//		if ((next = getNextNode(a)) != null)
//			visit(next);
//	}
//	
//	@Override
//	public void visitCallBehaviorAction(CallBehaviorAction a) throws Exception
//	{
//		ArchitectureVisitor visitor = new ArchitectureVisitor(parent,this.localHistory);
//		String methodToCall = a.getBehavior().getName();
//		Method method = interactionComponent.findMethod(methodToCall); 
//		visitor.visitMethod(method);
//	}
//
}


package de.uka.ipd.sdq.simucom.user;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.Action;
import org.eclipse.uml2.Activity;
import org.eclipse.uml2.ActivityFinalNode;
import org.eclipse.uml2.ActivityNode;
import org.eclipse.uml2.CallBehaviorAction;
import org.eclipse.uml2.ControlFlow;
import org.eclipse.uml2.InitialNode;
import org.eclipse.uml2.LoopNode;

import de.uka.ipd.sdq.simucom.component.Component;
import de.uka.ipd.sdq.simucom.component.Method;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.threads.ArchitectureVisitor;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import de.uka.ipd.sdq.simucom.umlhelper.UMLHelper;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;
import desmoj.extensions.applicationDomains.harbour.MyTruck;

public class UserActivityVisitor extends de.uka.ipd.sdq.simucom.activity.ActivityVisitor {
	
	protected Component interactionComponent;
	
	public UserActivityVisitor(SimProcess parent, ArrayList<HistoryElement> history, Component interactionComponent) {
		super(parent, history);
		// TODO Auto-generated constructor stub
		this.interactionComponent = interactionComponent;
	}

	@Override
	public void visitActivityNode(ActivityNode a) throws Exception
	{
		ActivityNode next = null;
		
		addHistoryEntry("User is processing ActivityNode "+UMLHelper.ElementToString(a));
		if ((next = getNextNode(a)) != null)
			visit(next);
	}
	
	@Override
	public void visitCallBehaviorAction(CallBehaviorAction a) throws Exception
	{
		ArchitectureVisitor visitor = new ArchitectureVisitor(parent,this.localHistory);
		String methodToCall = a.getBehavior().getName();
		Method method = interactionComponent.findMethod(methodToCall); 
		visitor.visitMethod(method);
	}

}


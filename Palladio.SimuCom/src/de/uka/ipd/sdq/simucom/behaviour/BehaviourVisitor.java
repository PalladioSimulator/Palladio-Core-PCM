package de.uka.ipd.sdq.simucom.behaviour;

import java.util.ArrayList;

import PalladioCM.SEFFPackage.Behaviour;
import PalladioCM.SEFFPackage.ExternalCall;
import PalladioCM.SEFFPackage.InternalAction;
import PalladioCM.SEFFPackage.Loop;
import PalladioCM.SEFFPackage.StartAction;
import PalladioCM.SEFFPackage.StopAction;

import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.emfhelper.EMFHelper;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import de.uka.ipd.sdq.simucom.threads.history.HistoryHelper;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class BehaviourVisitor extends ReflectiveVisitor {
	
	protected ArrayList<HistoryElement> myHistory = new ArrayList<HistoryElement>();

	protected SimProcess myParentProcess = null;

	protected SystemPackage.System mySystem;

	public BehaviourVisitor(SimProcess parent) {
		super();
		this.myParentProcess = parent;
		mySystem = ((SimuComModel) myParentProcess.getModel()).getSystem();
	}

	public void visitBehaviour(Behaviour behaviour) throws Exception
	{
		StartAction startAction = (StartAction)EMFHelper.getObjectByType(behaviour.getSteps_Behaviour(), StartAction.class);
		visit(startAction);
	}
	
	public void visitStartAction(StartAction start) throws Exception
	{
		visit(start.getSuccessor_AbstractAction());
	}
	
	public void visitStopAction(StopAction stop) throws Exception
	{
		HistoryHelper.dumpHistory("Behaviour visitor", myHistory);
	}
	
	public void visitInternalAction(InternalAction action) throws Exception
	{
		myHistory.add(new HistoryElement(SimTime.NOW,"Executing internal action "+action.getEntityName()));
		visit(action.getSuccessor_AbstractAction());
	}

	public void visitLoop(Loop loop) throws Exception
	{
		myHistory.add(new HistoryElement(SimTime.NOW,"Executing loop "+loop.getEntityName()));
		visit(loop.getSuccessor_AbstractAction());
	}
	
	public void visitExternalCall(ExternalCall call) throws Exception
	{
		myHistory.add(new HistoryElement(SimTime.NOW,"Calling component service "+call.getCalledService_ExternalService().getServiceName()));
		visit(call.getSuccessor_AbstractAction());
	}
}

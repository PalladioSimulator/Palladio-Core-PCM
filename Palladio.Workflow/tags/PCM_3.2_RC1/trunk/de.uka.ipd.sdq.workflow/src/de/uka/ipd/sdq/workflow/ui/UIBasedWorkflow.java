package de.uka.ipd.sdq.workflow.ui;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.Blackboard;
import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.WorkflowExceptionHandler;

/**
 * A workflow which is able to interact with the Eclipse GUI, i.e., for message logging or
 * error dialogs. Additionally the workflow supports the use of a blackboard for all its jobs to 
 * exchange information, e.g., EMF models
 * @author Steffen
 * @param <T> The type of the blackboard to be used in this workflow
 */
public class UIBasedWorkflow<T extends Blackboard<?>> 
extends BlackboardBasedWorkflow<T> {

	public UIBasedWorkflow(
			IJob job, 
			IProgressMonitor monitor, 
			WorkflowExceptionHandler workflowExceptionHandler,
			T blackboard) {
		super(job, monitor, workflowExceptionHandler, blackboard);
	}
}

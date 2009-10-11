package de.uka.ipd.sdq.workflow.mdsd.oaw;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitorAdapter;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public abstract class AbstractOAWWorkflowJobBridge<T extends AbstractExpressionsUsingWorkflowComponent>
implements IJob {

	private Logger logger = Logger.getLogger(AbstractOAWWorkflowJobBridge.class);
	
	protected T oawJob = null;
	private HashMap<String, EObject> slotContents;
	
	public AbstractOAWWorkflowJobBridge(T job) {
		this(job,new HashMap<String, EObject>());
	}
	
	public AbstractOAWWorkflowJobBridge(T job,
			HashMap<String, EObject> slotContents) {
		super();
		
		this.oawJob = job;
		this.slotContents = slotContents;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		Issues issues = new IssuesImpl();
		WorkflowContext ctx = new WorkflowContextDefaultImpl();
		setupContext(ctx);
		
		try {
			setupOAWJob(oawJob);
			
			logger.info("Validating oAW configuration settings...");
			oawJob.checkConfiguration(issues);
			if (issues.hasErrors()) {
				String message = issues.toString();
				throw new JobFailedException("oAW Job configuration is invalid: "+message);
			}
			
			logger.info("Running oAW task....");
			oawJob.invoke(ctx, new ProgressMonitorAdapter(monitor), issues);
			if (issues.hasErrors())
				throw new JobFailedException("oAW Job failed");	
		} catch(Exception e) {
			throw new JobFailedException("oAW Failed",e);
		}
	}

	protected void setupContext(WorkflowContext ctx) {
		for (String slot : slotContents.keySet()) {
			ctx.set(slot, slotContents.get(slot));
		}
	}

	protected abstract void setupOAWJob(T oawJob2);

	public String getName() {
		return oawJob.getId() == null ? "oAW Job" : oawJob.getId();
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
	}

}

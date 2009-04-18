/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;
import org.openarchitectureware.check.CheckFacade;
import org.openarchitectureware.expression.ExecutionContext;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.workflow.issues.Issue;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.issues.IssuesImpl;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.ResourceSetPartition;
import de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.dialogs.issues.IssuesDialog;
import de.uka.ipd.sdq.pcm.allocation.Allocation;


class ErrorDisplayRunner implements Runnable {
	
	private List<SeverityAndIssue> issues;
	private boolean shouldProceed;

	public boolean shouldProceedAfterErrorDialog() {
		return shouldProceed;
	}

	public ErrorDisplayRunner(List<SeverityAndIssue> overallResult) {
		super();
		this.issues = overallResult;
	}

	public void run() {
		Dialog dialog = new IssuesDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), issues);
		dialog.open();
		this.shouldProceed = dialog.getReturnCode() == IssuesDialog.IGNORE_BUTTON;
	}

}

/**
 * @author Snowball
 *
 */
public class ValidateModelJob 
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	private Logger logger = Logger.getLogger(ValidateModelJob.class);
	private MDSDBlackboard blackboard = null;
	private SimuComWorkflowConfiguration configuration;
	private ExecutionContextImpl ctx;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.ISimulationJob#execute()
	 */
	public ValidateModelJob(SimuComWorkflowConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException{
		List<SeverityAndIssue> result = checkModel();
		
		if (result.size() > 0) {
			logger.warn("Found validation problems in the models");
			displayValidationErrors(result);
			logger.warn("Continuing workflow, ignoring model validation issues");
		}
	}

	private void displayValidationErrors(
			List<SeverityAndIssue> overallResult)
			throws UserCanceledException {
		ErrorDisplayRunner runner = new ErrorDisplayRunner(overallResult);

		/**
		 * Disable the IssuesDialog, if SimuComConfig.SHOULD_THROW_EXCEPTION set
		 * of false
		 */
		if (configuration.isInteractive()) {
			PlatformUI.getWorkbench().getDisplay().syncExec(runner);
			if (!runner.shouldProceedAfterErrorDialog())
				throw new UserCanceledException();
		}
	}

	private ArrayList<SeverityAndIssue> getSeverityAndIssues(
			Issues issues) {
		ArrayList<SeverityAndIssue> result = new ArrayList<SeverityAndIssue>();
		for (Issue issue : issues.getErrors())
			result.add(new SeverityAndIssue(SeverityAndIssue.ERROR,issue.getMessage(),(EObject)issue.getElement()));
		for (Issue issue : issues.getWarnings())
			result.add(new SeverityAndIssue(SeverityAndIssue.WARNING,issue.getMessage(),(EObject)issue.getElement()));
		return result;
	}

	private Collection<EObject> getElementsInResource(Resource resource) {
		TreeIterator<EObject> items = resource.getAllContents();
		ArrayList<EObject> result = new ArrayList<EObject>();
		for (;items.hasNext();) {
			result.add(items.next());
		}
		// TODO: Temporary workaround. In the end, we should check all files referenced directly or indirectly...
		if (resource.getContents().get(0) instanceof Allocation){
			Allocation a = (Allocation) resource.getContents().get(0);
			if (a.getTargetResourceEnvironment_Allocation() != null){
				result.add(a.getTargetResourceEnvironment_Allocation());
				items = a.getTargetResourceEnvironment_Allocation().eAllContents();
				for (;items.hasNext();) {
					result.add(items.next());
				}
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.ISimulationJob#getName()
	 */
	public String getName() {
		return "Checking model constraints";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.ISimulationJob#rollback()
	 */
	public void rollback(IProgressMonitor monitor) {
		// Nothing to do here
	}

	private ArrayList<SeverityAndIssue> checkModel() {
		Issues issues = new IssuesImpl();
		ArrayList<SeverityAndIssue> result = new ArrayList<SeverityAndIssue>();
		ResourceSetPartition pcmPartition = this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

		for (Resource r : pcmPartition.getResourceSet().getResources()) {
			// Check resource with oAW's check language
			CheckFacade.checkAll(getCheckFileName(), getElementsInResource(r),
					getExecutionContext(), issues);
			result.addAll(getSeverityAndIssues(issues));

			// Check PCM internal OCL constraints
			Diagnostician diagnostician = new Diagnostician();
			Diagnostic d = diagnostician.validate(r.getContents().get(0));
			appendSeverityAndIssueFromDiagnostic(result,d);
			// TODO: Temporary workaround...
			if (r.getContents().get(0) instanceof Allocation){
				Allocation a = (Allocation) r.getContents().get(0);
				if (a.getTargetResourceEnvironment_Allocation() != null){
					d = diagnostician.validate(a.getTargetResourceEnvironment_Allocation());
					appendSeverityAndIssueFromDiagnostic(result,d);
				}
			}
		}
		return result;
	}

	private void appendSeverityAndIssueFromDiagnostic(ArrayList<SeverityAndIssue> result, Diagnostic d) {
		if (d.getSeverity() >= Diagnostic.ERROR) {
			SeverityAndIssue sai = new SeverityAndIssue(
					SeverityAndIssue.WARNING,
					d.getMessage(),
					(EObject)d.getData().get(0));
			result.add(sai);
		}
		for (Diagnostic child : d.getChildren())
			appendSeverityAndIssueFromDiagnostic(result, child);
	}

	private ExecutionContext getExecutionContext() {
		if (ctx == null) {
			ctx = new ExecutionContextImpl();
			List<EPackage> l = getMetamodelPackages();
			for (Iterator<EPackage> iter = l.iterator(); iter.hasNext();) {
				EPackage pkg = iter.next();
				ctx.registerMetaModel(new EmfMetaModel(pkg));
			}
		}
		return ctx;
	}

	private List<EPackage> getMetamodelPackages() {
		return Arrays.asList(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
	}

	private String getCheckFileName() {
		return "pcm";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob#setBlackbard(de.uka.ipd.sdq.codegen.workflow.Blackboard)
	 */
	public void setBlackbard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}
}

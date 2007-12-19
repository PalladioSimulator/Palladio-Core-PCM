/**
 * 
 */
package de.uka.ipd.sdq.codegen.workflow.jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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

import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;
import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.dialogs.issues.IssuesDialog;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;


class ErrorDisplayRunner implements Runnable {
	
	private ArrayList<SeverityAndIssue> issues;
	private boolean shouldProceed;

	public boolean shouldProceedAfterErrorDialog() {
		return shouldProceed;
	}

	public ErrorDisplayRunner(ArrayList<SeverityAndIssue> issues) {
		super();
		this.issues = issues;
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
public class CheckOAWConstraintsJob implements IJob {

	private ExecutionContextImpl ctx;
	private List<String> files;
	private boolean shouldThrowException;

	private EPackage[] ePackages = new EPackage[]{
		SeffPackage.eINSTANCE,
		RepositoryPackage.eINSTANCE,
		ParameterPackage.eINSTANCE,
		UsagemodelPackage.eINSTANCE,
		SystemPackage.eINSTANCE,
		ResourcetypePackage.eINSTANCE,
		ResourceenvironmentPackage.eINSTANCE,
		AllocationPackage.eINSTANCE,
		StoexPackage.eINSTANCE,
		CorePackage.eINSTANCE
	};
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.ISimulationJob#execute()
	 */
	public CheckOAWConstraintsJob(List<String> files, boolean shouldThrowException) {
		this.shouldThrowException = shouldThrowException;
		this.files = new ArrayList<String>();
		this.files.addAll(files);
	}

	public void execute() throws JobFailedException, UserCanceledException{
		ArrayList<SeverityAndIssue> overallResult = new ArrayList<SeverityAndIssue>();
		
		for (String file:files) {
			ArrayList<SeverityAndIssue> result = checkElements(file);
			overallResult.addAll(result);
		}
		
		if (overallResult.size() > 0) {
			displayValidationErrors(overallResult);
		}
	}

	private void displayValidationErrors(
			ArrayList<SeverityAndIssue> overallResult)
			throws UserCanceledException {
		ErrorDisplayRunner runner = new ErrorDisplayRunner(overallResult);

		/**
		 * Disable the IssuesDialog, if SimuComConfig.SHOULD_THROW_EXCEPTION set
		 * of false
		 */
		if (!shouldThrowException) {
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
	public void rollback() {
		// Nothing to do here
	}

	private ArrayList<SeverityAndIssue> checkElements(String file) {
		Resource r = getResource(file);
		Issues issues = new IssuesImpl();

		CheckFacade.checkAll(getCheckFileName(), getElementsInResource(r),
				getExecutionContext(), issues);

		ArrayList<SeverityAndIssue> result = getSeverityAndIssues(issues);

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

	private Resource getResource(String file) {
		ResourceSet rs = new ResourceSetImpl();
		try {
			Resource resource = rs.getResource(URI.createFileURI(file), true);
			return resource;
		} catch(IllegalArgumentException ex) {
			Resource resource = rs.getResource(URI.createURI(file), true);
			return resource;
		}
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
		return Arrays.asList(ePackages);
	}

	private String getCheckFileName() {
		return "pcm";
	}
}

package de.uka.ipd.sdq.workflow.mdsd.oaw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.SeverityEnum;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.validation.ModelValidationJob;

/**
 * Execute a model validation check using a given oAW check file. The oAW check language allows 
 * powerfull specification of model validation rules similar to OCL constraints.
 * @author Steffen Becker
 */
public class PerformOAWCheckValidation 
extends ModelValidationJob {

	private MDSDBlackboard blackboard;
	private ExecutionContextImpl ctx;

	private String partitionName;
	private String checkFilename;
	private EPackage[] ePackages;

	/**
	 * Create a new oAW check job
	 * @param partitionName The blackboard model partition containing the model to validate
	 * @param checkFilename The URL of the check file containing the rules for well-formed models
	 * @param packages The EPackages used in the model to be checked
	 */
	public PerformOAWCheckValidation(
			String partitionName,
			String checkFilename, EPackage[] packages) {
		super(SeverityEnum.ERROR);
		
		this.partitionName = partitionName;
		this.checkFilename = checkFilename;
		ePackages = packages;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {

		Issues issues = new IssuesImpl();

		ResourceSetPartition partition = this.blackboard.getPartition(this.partitionName);
		partition.resolveAllProxies();

		for (Resource r : partition.getResourceSet().getResources()) {
			// Check resource with oAW's check language
			CheckFacade.checkAll(
					this.checkFilename, 
					getElementsInResource(r),
					getExecutionContext(), 
					issues);
		}

		this.setJobResult(getSeverityAndIssues(issues));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IJob#getName()
	 */
	public String getName() {
		return "Checking oAW constraints";
	}

	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	private Collection<EObject> getElementsInResource(Resource resource) {
		TreeIterator<EObject> items = resource.getAllContents();
		ArrayList<EObject> result = new ArrayList<EObject>();
		for (;items.hasNext();) {
			result.add(items.next());
		}
		
		return result;
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
	
	private List<SeverityAndIssue> getSeverityAndIssues(
			Issues issues) {
		ArrayList<SeverityAndIssue> result = new ArrayList<SeverityAndIssue>();
		for (MWEDiagnostic issue : issues.getErrors()){
			if (issue.getElement() instanceof EObject){
				result.add(new SeverityAndIssue(SeverityEnum.ERROR,issue.getMessage(),(EObject)issue.getElement()));
			} else 
				result.add(new SeverityAndIssue(SeverityEnum.ERROR,issue.getMessage()+issue.getElement().toString(),null));
		}
		
		for (MWEDiagnostic issue : issues.getWarnings())
			result.add(new SeverityAndIssue(SeverityEnum.WARNING,issue.getMessage(),(EObject)issue.getElement()));
		return result;
	}
	
	private List<EPackage> getMetamodelPackages() {
		return Arrays.asList(this.ePackages);
	}
}

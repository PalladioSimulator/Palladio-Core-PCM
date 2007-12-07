package de.uka.sdq.pcm.transformations;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;

/**
 * This M2M Transform alters a StoEx or feature value to perform sensitivity analysis
 * @author Steffen
 *
 */
public class SensitivityWorkflowComponent 
	extends AbstractWorkflowComponent2 {

	private int runNo;
	private double step;
	private String variable;
	private double min;

	public void setRunNo(String value){
		try{
			runNo = Integer.parseInt(value) - 1;
		}catch(Exception e){
			variable = null;
		}
	}
	
	public void setMin(String value) {
		try{
			min = Double.parseDouble(value);
		}catch(Exception e){
			variable = null;
		}
	}

	public void setVariable(String value) {
		variable = value;
	}
	
	public void setStep(String value) {
		try{
			step = Double.parseDouble(value);
		}catch(Exception e){
			variable = null;
		}
	}
	
	@Override
	protected void checkConfigurationInternal(Issues arg0) {
		// nothing to do here
	}
	
	@Override
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor,
			Issues issues) {
		if (variable != null && !variable.equals("")){
			for(String slot : context.getSlotNames()) {
				EObject o = findEObject((EObject)context.get(slot));
				if ( o != null ) {
					alterObject(o);
				}
			}
		}
	}

	private void alterObject(EObject o) {
		int modifier = (int)(min + runNo * step);
		if (o instanceof PCMRandomVariable) {
			PCMRandomVariable pcmRandVar = (PCMRandomVariable) o;
			String spec = pcmRandVar.getSpecification();
			spec += " " + (modifier < 0 ? " - " + Math.abs(modifier) : " + " + Math.abs(modifier));
			pcmRandVar.setSpecification(
				spec	
				);
		}
		if (o instanceof ClosedWorkload) {
			ClosedWorkload cw = (ClosedWorkload) o;
			int number = cw.getPopulation();
			number += modifier;
			cw.setPopulation(number);
		}
	}

	private EObject findEObject(EObject object) {
		Iterator<EObject> it = object.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();
			if (EcoreUtil.getURI(eo).toString().equals(variable))
				return eo;
		}
		return null;
	}
}

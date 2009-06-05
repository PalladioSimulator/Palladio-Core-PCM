package de.uka.ipd.sdq.capra.simulator.builder;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.capra.core.BoundedLoop;
import de.uka.ipd.sdq.capra.core.Choice;
import de.uka.ipd.sdq.capra.core.DemandAction;
import de.uka.ipd.sdq.capra.core.ParallelComposition;
import de.uka.ipd.sdq.capra.core.ProbabilisticPrefix;
import de.uka.ipd.sdq.capra.core.Renaming;
import de.uka.ipd.sdq.capra.core.Restriction;
import de.uka.ipd.sdq.capra.core.SuccessfulTermination;
import de.uka.ipd.sdq.capra.core.util.CoreSwitch;
import de.uka.ipd.sdq.capra.extension.AcquireAction;
import de.uka.ipd.sdq.capra.extension.ReleaseAction;
import de.uka.ipd.sdq.capra.extension.util.ExtensionSwitch;
import de.uka.ipd.sdq.capra.measurement.TimeProbe;
import de.uka.ipd.sdq.capra.measurement.VisitProbe;
import de.uka.ipd.sdq.capra.measurement.util.MeasurementSwitch;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;

public class CapraExpressionVisitor {
	
	CapraExpressionTransformer expressionTransformer;

	public CapraExpressionVisitor(CapraExpressionTransformer processTransformer) {
		super();
		this.expressionTransformer = processTransformer;
	}
	
	public SimCapraExpression visit(EObject theEObject) {
		SimCapraExpression result = cSwitch.doSwitch(theEObject);
		if(result == null){
			result = eSwitch.doSwitch(theEObject);
			if (result == null){
				result = mSwitch.doSwitch(theEObject);
				if(result == null){
					System.out.println("Unknown object type: " + theEObject.eClass().getName());
				}
			}
		}
		return result;
	}
	
	
	private CoreSwitch<SimCapraExpression> cSwitch = new CoreSwitch<SimCapraExpression>(){
		@Override
		public SimCapraExpression caseDemandAction(DemandAction object) {
			return expressionTransformer.transformDemandAction(object);
		}
		
		@Override
		public SimCapraExpression caseProbabilisticPrefix(
				ProbabilisticPrefix object) {
			return expressionTransformer.transformProbabilisticPrefix(object); 
		}
		
		@Override
		public SimCapraExpression caseSuccessfulTermination(
				SuccessfulTermination object) {
			return expressionTransformer.transformSuccessfulTermination(object);
		}	
		
		@Override
		public SimCapraExpression caseBoundedLoop(BoundedLoop object) {
			return expressionTransformer.transformBoundedLoop(object);
		}
				
		@Override
		public SimCapraExpression caseChoice(Choice object) {
			return expressionTransformer.transformChoice(object);
		}
		
		@Override
		public SimCapraExpression caseParallelComposition(
				ParallelComposition object) {
			return expressionTransformer.transformParallelComposition(object);
		}
		
		@Override
		public SimCapraExpression caseRenaming(Renaming object) {
			return expressionTransformer.transformRenaming(object);
		}
		
		@Override
		public SimCapraExpression caseRestriction(Restriction object) {
			return expressionTransformer.transformRestriction(object);
		}
	};
	
	private MeasurementSwitch<SimCapraExpression> mSwitch = new MeasurementSwitch<SimCapraExpression>(){
		@Override
		public SimCapraExpression caseTimeProbe(TimeProbe object) {
			return expressionTransformer.transformTimeProbe(object);
		}
		
		@Override
		public SimCapraExpression caseVisitProbe(VisitProbe object) {
			return expressionTransformer.transformVisitProbe(object);
		}
	};
	
	private ExtensionSwitch<SimCapraExpression> eSwitch = new ExtensionSwitch<SimCapraExpression>(){
		@Override
		public SimCapraExpression caseAcquireAction(AcquireAction object) {
			return expressionTransformer.transformAcquireAction(object);
		}
		
		@Override
		public SimCapraExpression caseReleaseAction(ReleaseAction object) {
			return expressionTransformer.transformReleaseAction(object);
		}
	};

}

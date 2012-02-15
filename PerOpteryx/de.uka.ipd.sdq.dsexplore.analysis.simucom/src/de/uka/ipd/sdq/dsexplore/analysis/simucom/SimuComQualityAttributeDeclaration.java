/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.analysis.simucom;


import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.dsexplore.analysis.AbstractPerformanceAttributeDeclaration;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttributeDeclaration;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Mean;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;

/**
 * This class declares, which {@code Dimension} and {@code EvaluationAspect} can 
 * be evaluated by this extension.
 * 
 * 
 * @author noorshams
 *
 */
public class SimuComQualityAttributeDeclaration extends AbstractPerformanceAttributeDeclaration implements IAnalysisQualityAttributeDeclaration {
	
	public SimuComQualityAttributeDeclaration(){
		super();


	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttribute#canEvaluateAspect(de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect)
	 */
	@Override
	public boolean canEvaluateAspectForDimension(EvaluationAspect aspect, Dimension dimension) {
		if(EcoreUtil.equals(dimension, this.responseTimeDimension) && aspect instanceof Mean) {
			return true;
		}
		if(EcoreUtil.equals(dimension, this.throughputDimension) && aspect instanceof Mean) {
			return true;
		}
		return false;
	}

}

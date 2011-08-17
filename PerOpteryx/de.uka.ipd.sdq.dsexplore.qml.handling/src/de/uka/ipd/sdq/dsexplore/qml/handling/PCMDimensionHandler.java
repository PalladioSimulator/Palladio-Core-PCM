/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.qml.handling;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Mean;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Value;

/**
 * 
 * @author noorshams
 *
 */
public class PCMDimensionHandler {
	
	// Examines aspects of dimensions
	// Needed for runconfig 
	
	//TODO: MOVE THIS STUFF TO IANALYSIS
	public boolean canEvaluateResponseTimeAspect(EvaluationAspect aspect){
		if(aspect instanceof Mean) {
			return true;
		}
		return false;
	}
	
	public boolean canEvaluateCostAspect(EvaluationAspect aspect){
		if(aspect instanceof Value) {
			return true;
		}
		return false;
	}
	
	public boolean canEvaluateReliabilityAspect(EvaluationAspect aspect){
		if(aspect instanceof Value) {
			return true;
		}
		return false;
	}
	
	// Examine aspects of dimensions for evaluators here
	
//	public boolean canEvaluateAspect(IAnalysis analysis){
//		if(analysis instanceof ) {
//			
//		} else if (analysis instanceof ) {
//			
//		} else if (analysis instanceof ) {
//			
//		} else if (analysis instanceof ) {
//			
//		}
//		return false;
//	}
}

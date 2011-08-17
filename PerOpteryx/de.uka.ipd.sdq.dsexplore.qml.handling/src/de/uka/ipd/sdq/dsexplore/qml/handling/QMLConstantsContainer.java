/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.qml.handling;

/**
 * Due to cyclic dependencies, QML needs its own constants container
 * @author noorshams
 *
 */
public class QMLConstantsContainer {


	public static final String STANDARD_CONTRACT_TYPE_PATH = 
		"pathmap://PCM_MODELS/PCMStandardQMLContractType.qmldeclarations";
	
	public static final String QUALITY_ATTRIBUTE_DIMENSION_COST_DEFINITION_PATH = "pathmap://PCM_MODELS/Dimension_cost.qmlcontracttype";
	public static final String QUALITY_ATTRIBUTE_DIMENSION_POFOD_DEFINITION_PATH = "pathmap://PCM_MODELS/Dimension_pofod.qmlcontracttype";
	public static final String QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH = "pathmap://PCM_MODELS/Dimension_responsetime.qmlcontracttype";
	public static final String QUALITY_ATTRIBUTE_DIMENSION_THROUGHPUT_DEFINITION_PATH = "pathmap://PCM_MODELS/Dimension_throughput.qmlcontracttype"; 
	
	public static final String[] QUALITY_ATTRIBUTE_DIMENSION_DEFINITION_PATHS = new String[] {		
		QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH,
		QUALITY_ATTRIBUTE_DIMENSION_THROUGHPUT_DEFINITION_PATH,
		QUALITY_ATTRIBUTE_DIMENSION_POFOD_DEFINITION_PATH,
		QUALITY_ATTRIBUTE_DIMENSION_COST_DEFINITION_PATH
	};
}

/**
 * 
 */
package de.fzi.se.quality.util;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.VariableReference;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

/**Utility functions for handling PCM model elements.
 * @author groenda
 *
 */
public class PCMUtil {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(PCMUtil.class.getCanonicalName());
	
	/**Returns the qualified name for the number of elements in a collection.
	 * @param parameter The collection parameter.
	 * @return The qualified name.
	 */
	public static String getQualifiedCollectionNoE(Parameter parameter) {
		if (! (parameter.getDataType__Parameter() instanceof CollectionDataType)) {
			String msg = "Requested number of elements for a parameter which is not a collection data type and does not have a definition of number of elements.";
			logger.severe(msg);
			throw new IllegalArgumentException(msg);
		}
		return parameter.getParameterName() + "." + VariableCharacterisationType.NUMBER_OF_ELEMENTS;
	}
	
	/**Returns the qualified name for the parameter.
	 * @param parameter The parameter.
	 * @return The qualified name.
	 */
	public static String getQualifiedName(Parameter parameter) {
		return parameter.getParameterName();
	}
	
	
	/**Returns a qualified name for the given variable characterization.
	 * @param variableCharacterization The variable characterization.
	 * @return The qualified name, e.g. name.space.variableName.characterization.
	 */
	public static String getQualifiedName(VariableCharacterisation variableCharacterization) {
		return getQualifiedName(variableCharacterization.getVariableUsage_VariableCharacterisation()) + "." + variableCharacterization.getType();
	}

	/**Returns a qualified name for the given variable usage.
	 * @param variableUsage The variable usage.
	 * @return The qualified name, e.g. name.space.variableName.
	 */
	public static String getQualifiedName(VariableUsage variableUsage) {
		return getQualifiedName(variableUsage.getNamedReference__VariableUsage());
	}

	/**Returns a qualified name for the given reference.
	 * @param reference The reference.
	 * @return The qualified name, e.g. name.space.variableName.
	 */
	public static String getQualifiedName(AbstractNamedReference reference) {
		if (reference == null) {
			return "";
		}
		return anr2qnConverter.doSwitch(reference);
	}
	
	/**Converts an {@link AbstractNamedReference} to a qualified variable name.
	 * @author groenda
	 */
	private static final StoexSwitch<String> anr2qnConverter = new StoexSwitch<String>() {
		@Override
		public String caseNamespaceReference(NamespaceReference object) {
			return object.getReferenceName() + "." + doSwitch(object.getInnerReference_NamespaceReference());
		}
		
		@Override
		public String caseVariableReference(VariableReference object) {
			return object.getReferenceName();
		}
		
		@Override
		public String caseAbstractNamedReference(AbstractNamedReference object) {
			throw new IllegalArgumentException("The provided variable reference is not supported by this implementation.");
		}
	}; 

	/**Gets the parameters associated with an RDSEFF.
	 * @param rdseff The RDSEFF.
	 * @return Parameter list.
	 */
	public static List<Parameter> getParameters(ResourceDemandingSEFF rdseff) {
		List<Parameter> parameters = new LinkedList<Parameter>();
		if (rdseff.getDescribedService__SEFF() == null) { // return empty list
		} else if (rdseff.getDescribedService__SEFF() instanceof OperationSignature) {
			parameters.addAll(((OperationSignature)rdseff.getDescribedService__SEFF()).getParameters__OperationSignature());
		} else if (rdseff.getDescribedService__SEFF() instanceof InfrastructureSignature) {
			parameters.addAll(((InfrastructureSignature)rdseff.getDescribedService__SEFF()). getParameters__InfrastructureSignature());
		} else {
			throw new IllegalArgumentException("The provided ResourceDemandingSEFF did not describe a known signature. Unable to determine input parameters and to continue.");
		}
		return parameters;
	}

	/**
	 * Gets the initial action for the given behavior. Assumes a valid behavior.
	 * 
	 * @param behaivor
	 *            The behavior.
	 * @return The initial action.
	 */
	public static StartAction getInitialAction(ResourceDemandingBehaviour behaivor) {
		for (AbstractAction action : behaivor.getSteps_Behaviour()) {
			if (action.getPredecessor_AbstractAction() == null
					&& action instanceof StartAction) {
				return (StartAction) action;
			}
		}
		String msg = "The model was not valid. A ResourceDemandingBehavior must contain exactly one StartAction. That StartAction must not contain a predecessor. Fix the model.";
		logger.severe(msg);
		throw new IllegalArgumentException(msg);
	}

	/**Provides a textual identifier in order to help humans to identify the action.  
	 * @param action The action.
	 * @return The textual identifer.
	 */
	public static String prettyPrint(AbstractAction action) {
		if (action == null) {
			return "<null>";
		}
		return action.getEntityName() + "#" + action.getId() + " <" + action.eClass().getName() + ">"; 
	}
	
	/**Provides a textual identifier in order to help humans to identify the component.  
	 * @param component The component.
	 * @return The textual identifer.
	 */
	public static String prettyPrint(RepositoryComponent component) {
		return component.getEntityName() + "#" + component.getId() + " <" + component.eClass().getName() + ">";
	}

	/**Provides a textual identifier in order to help humans to identify the required signature.  
	 * @param signature The operation signature.
	 * @return The textual identifer.
	 */
	public static String prettyPrint(OperationSignature signature) {
		return prettyPrint(signature.getReturnType__OperationSignature()) + " " + signature.getInterface__OperationSignature().getEntityName() + "::" + signature.getEntityName() + "(...)" + " #" + signature.getId();
	}

	/**Provides a textual identifier in order to help humans to identify the required role.  
	 * @param requiredRole The required role.
	 * @return The textual identifer.
	 */
	public static String prettyPrint(RequiredRole requiredRole) {
		return requiredRole.getEntityName() + " #" + requiredRole.getId();
	}
	
	/**Provides a textual identifier in order to help humans to identify the data type.
	 * @param dataType the data type.
	 * @return The textual identifier.
	 */
	public static String prettyPrint(DataType dataType) {
		return new RepositorySwitch<String>() {
			@Override
			public String caseCollectionDataType(CollectionDataType object) {
				return object.getEntityName() + " #" + object.getId();
			}
			@Override
			public String caseCompositeDataType(CompositeDataType object) {
				return object.getEntityName() + " #" + object.getId();
			}
			@Override
			public String casePrimitiveDataType(PrimitiveDataType object) {
				return object.getType().getName();
			}
			@Override
			public String caseDataType(DataType object) {
				String msg = "Unknown data type experienced. eType was: " + object.eClass().getName();
				logger.severe(msg);
				throw new IllegalArgumentException(msg);
			}
		}.doSwitch(dataType);
	}

	/**Provides textual information for the given variable usages. Does not shows the specification values themselves.
	 * @param usages The variable usages.
	 * @return The textual information.
	 */
	public static String prettyPrint(
			List<VariableUsage> usages) {
		String result = "";
		for (VariableUsage vu : usages) {
			result += getQualifiedName(vu) + "(";
			for (VariableCharacterisation vc  : vu.getVariableCharacterisation_VariableUsage()) {
				result += vc.getType().getName() + ",";
			}
			result.substring(0, result.length()-2);
			result += ")";
		}
		return result;
	}

	
}

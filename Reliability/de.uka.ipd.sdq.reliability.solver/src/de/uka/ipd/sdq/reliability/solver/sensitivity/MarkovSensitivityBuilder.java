/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import de.uka.ipd.sdq.reliability.core.helper.EMFHelper;
import de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter;
import de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;
import de.uka.ipd.sdq.sensitivity.HardwareMTTFParameter;
import de.uka.ipd.sdq.sensitivity.HardwareMTTRParameter;
import de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.NetworkReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter;
import de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter;
import de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityConfiguration;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SensitivityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.SoftwareReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;
import de.uka.ipd.sdq.sensitivity.SystemCallParameter;
import de.uka.ipd.sdq.sensitivity.UsageBranchParameter;

/**
 * Creates sensitivity information from a given input sensitivity model.
 * 
 * @author brosch
 * 
 */
public class MarkovSensitivityBuilder {

	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger
			.getLogger(MarkovSensitivityBuilder.class.getName());

	/**
	 * Creates the sensitivity information.
	 * 
	 * @param sensitivityModelFileName
	 *            the sensitivity model file name
	 * @param sensitivityLogFileName
	 *            the sensitivity log file name
	 * @return
	 */
	public MarkovSensitivity buildSensitivity(
			final String sensitivityModelFileName,
			final String sensitivityLogFileName) {
		SensitivityConfiguration sensitivityConfig = (SensitivityConfiguration) EMFHelper
				.loadFromXMIFile(sensitivityModelFileName,
						SensitivityPackage.eNS_URI,
						SensitivityPackage.eINSTANCE);
		return createMarkovSensitivity(sensitivityConfig
				.getSensitivityParameters__SensitivityConfiguration(),
				sensitivityLogFileName);
	}

	/**
	 * Creates a Markov sensitivity object according to the given parameter.
	 * 
	 * @param parameter
	 *            the sensitivity parameter
	 * @param sensitivityLogFileName
	 *            the sensitivity log file name
	 * @return the resulting Markov sensitivity object
	 */
	private MarkovSensitivity createMarkovSensitivity(
			final SensitivityParameter parameter,
			final String sensitivityLogFileName) {
		if (parameter instanceof CombinedSensitivityParameter) {
			return createMultiSensitivity(
					(CombinedSensitivityParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof CommunicationLinkReliabilityParameter) {
			logger.error("Parameter type \"" + parameter.eClass().toString()
					+ "\" not yet supported.");
			return null;
		} else if (parameter instanceof ComponentReliabilityParameter) {
			return createComponentSensitivity(
					(ComponentReliabilityParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof HardwareMTTFParameter) {
			return createMTTFSensitivity((HardwareMTTFParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof HardwareMTTRParameter) {
			return createMTTRSensitivity((HardwareMTTRParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof InternalActionReliabilityParameter) {
			return createInternalActionSensitivity(
					(InternalActionReliabilityParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof NetworkReliabilityParameter) {
			return createNetworkSensitivity(
					(NetworkReliabilityParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof ProbabilisticBranchParameter) {
			return createProbabilisticBranchSensitivity(
					(ProbabilisticBranchParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof ResourceMTTFParameter) {
			return createResourceMTTFSensitivity(
					(ResourceMTTFParameter) parameter, sensitivityLogFileName);
		} else if (parameter instanceof ResourceMTTRParameter) {
			return createResourceMTTRSensitivity(
					(ResourceMTTRParameter) parameter, sensitivityLogFileName);
		} else if (parameter instanceof SoftwareReliabilityParameter) {
			return createSoftwareSensitivity(
					(SoftwareReliabilityParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof SystemCallParameter) {
			return createSystemCallSensitivity((SystemCallParameter) parameter,
					sensitivityLogFileName);
		} else if (parameter instanceof UsageBranchParameter) {
			return createUsageBranchSensitivity(
					(UsageBranchParameter) parameter, sensitivityLogFileName);
		} else {
			logger.error("Parameter type \"" + parameter.eClass().toString()
					+ "\" not yet supported.");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private UsageBranchSensitivity createUsageBranchSensitivity(
			final UsageBranchParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new UsageBranchSensitivity(parameter.getEntityName(),
					parameter.getBranch__UsageBranchParameter().getId(),
					parameter.getBranch__UsageBranchParameter()
							.getScenarioBehaviour_AbstractUserAction().getId(),
					(DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private SystemCallSensitivity createSystemCallSensitivity(
			final SystemCallParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof StringParameterSequence) {
			return new SystemCallSensitivity(
					parameter.getEntityName(),
					parameter.getEntryLevelSystemCall__SystemCallParameter()
							.getId(),
					parameter.getInputParameterName(),
					parameter
							.getVariableCharacterisationType__SystemCallParameter(),
					(StringParameterSequence) variation, sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private SoftwareSensitivity createSoftwareSensitivity(
			final SoftwareReliabilityParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new SoftwareSensitivity(parameter.getEntityName(),
					(DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private ResourceMTTRSensitivity createResourceMTTRSensitivity(
			final ResourceMTTRParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new ResourceMTTRSensitivity(parameter.getEntityName(),
					parameter.getResourceContainer__ResourceMTTRParameter()
							.getId(), parameter
							.getProcessingResourceType__ResourceMTTRParameter()
							.getId(), (DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private ResourceMTTFSensitivity createResourceMTTFSensitivity(
			final ResourceMTTFParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new ResourceMTTFSensitivity(parameter.getEntityName(),
					parameter.getResourceContainer__ResourceMTTFParameter()
							.getId(), parameter
							.getProcessingResourceType__ResourceMTTFParameter()
							.getId(), (DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private ProbabilisticBranchSensitivity createProbabilisticBranchSensitivity(
			final ProbabilisticBranchParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new ProbabilisticBranchSensitivity(
					parameter.getEntityName(),
					parameter
							.getProbabilisticBranchTransition__ProbabilisticBranchParameter()
							.getId(), (DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private NetworkSensitivity createNetworkSensitivity(
			final NetworkReliabilityParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new NetworkSensitivity(parameter.getEntityName(),
					(DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private InternalActionSensitivity createInternalActionSensitivity(
			final InternalActionReliabilityParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new InternalActionSensitivity(
					parameter.getEntityName(),
					parameter
							.getInternalAction__InternalActionReliabilityParameter()
							.getId(),
					parameter
							.getSoftwareInducedFailureType__InternalActionReliabilityParameter()
							.getId(), (DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private MTTRSensitivity createMTTRSensitivity(
			final HardwareMTTRParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new MTTRSensitivity(parameter.getEntityName(),
					(DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private MTTFSensitivity createMTTFSensitivity(
			final HardwareMTTFParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new MTTFSensitivity(parameter.getEntityName(),
					(DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private ComponentSensitivity createComponentSensitivity(
			final ComponentReliabilityParameter parameter,
			final String sensitivityLogFileName) {
		SensitivityParameterVariation variation = parameter
				.getSensitivityParameterVariation__SingleSensitivityParameter();
		if (variation instanceof DoubleParameterVariation) {
			return new ComponentSensitivity(parameter.getEntityName(),
					parameter
							.getBasicComponent__ComponentReliabilityParameter()
							.getId(), (DoubleParameterVariation) variation,
					sensitivityLogFileName);
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString()
					+ "\" not supported for parameter type \""
					+ parameter.eClass().toString() + "\".");
			return null;
		}
	}

	/**
	 * 
	 * @param parameter
	 * @param sensitivityLogFileName
	 * @return
	 */
	private MultiSensitivity createMultiSensitivity(
			final CombinedSensitivityParameter parameter,
			final String sensitivityLogFileName) {
		List<MarkovSensitivity> subSensitivities = new ArrayList<MarkovSensitivity>();
		for (SensitivityParameter subParameter : parameter
				.getChildParameters__CombinedSensitivityParameter()) {
			subSensitivities.add(createMarkovSensitivity(subParameter,
					sensitivityLogFileName));
		}
		return new MultiSensitivity(parameter.getEntityName(),
				subSensitivities, parameter.isCombinatory(),
				sensitivityLogFileName);
	}
}

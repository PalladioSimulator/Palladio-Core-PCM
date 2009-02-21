package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;

/**
 * This class represents a visitor for a UsageModel within a PCM instance. The
 * visitor is used in the transformation from PCM with solved dependencies into
 * a Markov Chain Model for reliability prediction.
 * 
 * @author brosch
 * 
 */
public class MarkovUsageModelVisitor extends UsagemodelSwitch<MarkovChain> {

	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger
			.getLogger(MarkovUsageModelVisitor.class.getName());

	/**
	 * The solved PCM instance that serves as an input for the transformation.
	 */
	private PCMInstance pcmInstance;

	/**
	 * The ContextWrapper provides easy access to the decorations of the solved
	 * PCM instance.
	 */
	private ContextWrapper contextWrapper = null;

	/**
	 * The constructor.
	 * 
	 * @param inst
	 *            the solved PCM Instance
	 */
	public MarkovUsageModelVisitor(final PCMInstance inst) {
		pcmInstance = inst;
	}

	/**
	 * Returns a Markov Chain that corresponds to the first SystemLevelEntryCall
	 * within this ScenarioBehaviour.
	 * 
	 * @param scenarioBehaviour
	 *            the scenario behaviour
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseScenarioBehaviour(
			final ScenarioBehaviour scenarioBehaviour) {
		logger.debug("Visit ScenarioBehaviour ["
				+ scenarioBehaviour.getEntityName() + "]");
		Start startAction = (Start) EMFHelper.getObjectByType(scenarioBehaviour
				.getActions_ScenarioBehaviour(), Start.class);
		return (MarkovChain) doSwitch(startAction);
	}

	/**
	 * Returns a Markov Chain that corresponds to the first SystemLevelEntryCall
	 * after this starting point.
	 * 
	 * @param start
	 *            the starting point
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseStart(final Start start) {
		logger.debug("Visit Start [" + start.getEntityName() + "]");
		return (MarkovChain) doSwitch(start.getSuccessor());
	}

	/**
	 * Return a Markov Chain that corresponds to this EntryLevelSystemCall.
	 * 
	 * @param entryLevelSystemCall
	 *            the call
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseEntryLevelSystemCall(
			final EntryLevelSystemCall entryLevelSystemCall) {
		logger.debug("Visit EntryLevelSystemCall ["
				+ entryLevelSystemCall.getEntityName() + "]");

		// Create a new context wrapper for this entry level system call:
		if (contextWrapper == null) {
			contextWrapper = new ContextWrapper(entryLevelSystemCall,
					pcmInstance);
		} else {
			contextWrapper = contextWrapper
					.getContextWrapperFor(entryLevelSystemCall);
		}

		// We need to get from the entryLevelSystemCall to the RDSEFF that
		// fulfills the call:
		ServiceEffectSpecification seff = getSeff(entryLevelSystemCall);
		if (seff == null) {
			return null;
		} else {
			MarkovSeffVisitor seffVisitor = new MarkovSeffVisitor(
					contextWrapper);
			return seffVisitor.doSwitch((ResourceDemandingSEFF) seff);
		}
	}

	/**
	 * Gets the RDSEFF that correpsonds to a given entryLevelSystemCall.
	 * 
	 * @param call
	 *            the entryLevelSystemCall
	 * @return the RDSEFF
	 */
	private ServiceEffectSpecification getSeff(final EntryLevelSystemCall call) {

		// Get the signature of the call:
		Signature signature = call.getSignature_EntryLevelSystemCall();

		// Get the system's provided role for the corresponding interface:
		ProvidedRole providedRole = call.getProvidedRole_EntryLevelSystemCall();

		// Get the delegation connector that leads to the component offering the
		// service:
		ProvidedDelegationConnector delegationConnector = null;
		EList<ProvidedDelegationConnector> delegationConnectors = this.pcmInstance
				.getSystem()
				.getProvidedDelegationConnectors_ComposedStructure();
		for (int i = 0; i < delegationConnectors.size(); i++) {
			if (delegationConnectors.get(i)
					.getOuterProvidedRole_ProvidedDelegationConnector().getId()
					.equals(providedRole.getId())) {
				delegationConnector = delegationConnectors.get(i);
				break;
			}
		}

		// No delegation connector found?
		if (delegationConnector == null) {
			logger
					.error("Could not find a ProvidedDelegationConnector for the EntryLevelSystemCall");
			return null;
		}

		// Get the component that provides the service:
		ProvidesComponentType offeringComponent = delegationConnector
				.getChildComponentContext_ProvidedDelegationConnector()
				.getEncapsulatedComponent_ChildComponentContext();

		// Is it a basic component?
		if (offeringComponent instanceof BasicComponent) {

			// Now we can finally retrieve the RDSEFF from the offering
			// component:
			BasicComponent basicComponent = (BasicComponent) offeringComponent;
			EList<ServiceEffectSpecification> seffs = basicComponent
					.getServiceEffectSpecifications__BasicComponent();
			for (int i = 0; i < seffs.size(); i++) {
				if (seffs.get(i).getDescribedService__SEFF().getServiceName()
						.equals(signature.getServiceName())) {
					return seffs.get(i);
				}
			}

			// No corresponding RDSEFF found?
			logger
					.error("Could not find a RDSEFF for the EntryLevelSystemCall");
			return null;
		} else {
			logger.error("Composite Component type not yet supported.");
			return null;
		}
	}
}

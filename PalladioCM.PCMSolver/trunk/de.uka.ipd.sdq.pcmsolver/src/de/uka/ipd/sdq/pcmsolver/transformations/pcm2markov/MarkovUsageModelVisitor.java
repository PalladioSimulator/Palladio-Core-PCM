package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ListIterator;

import markov.MarkovChain;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
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
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.TransformSeffVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;

public class MarkovUsageModelVisitor extends UsagemodelSwitch {

	private static Logger logger = Logger
			.getLogger(MarkovUsageModelVisitor.class.getName());

	private PCMInstance pcmInstance;
	private ContextWrapper contextWrapper = null;

	/**
	 * @param inst
	 *            an instance of the Palladio Component Metamodel
	 */
	public MarkovUsageModelVisitor(PCMInstance inst) {
		pcmInstance = inst;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseScenarioBehaviour(de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour)
	 */
	@Override
	public MarkovChain caseScenarioBehaviour(ScenarioBehaviour scenarioBehaviour) {
		logger.info("Visit ScenarioBehaviour [" + scenarioBehaviour.getEntityName() + "]");
		Start startAction = (Start) EMFHelper.getObjectByType(scenarioBehaviour
				.getActions_ScenarioBehaviour(), Start.class);
		return (MarkovChain) doSwitch(startAction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseStart(de.uka.ipd.sdq.pcm.usagemodel.Start)
	 */
	@Override
	public MarkovChain caseStart(Start start) {
		logger.info("Visit Start [" + start.getEntityName() + "]");
		return (MarkovChain) doSwitch(start.getSuccessor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseEntryLevelSystemCall(de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall)
	 */
	@Override
	public Object caseEntryLevelSystemCall(
			EntryLevelSystemCall entryLevelSystemCall) {
		logger.info("Visit EntryLevelSystemCall [" + entryLevelSystemCall.getEntityName() + "]");

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
	 * Gets the RDSEFF that fulfills a given entryLevelSystemCall.
	 * 
	 * @param call
	 *            the entryLevelSystemCall
	 * @return the RDSEFF
	 */
	private ServiceEffectSpecification getSeff(EntryLevelSystemCall call) {

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

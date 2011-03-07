/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * @generated
 */
public class PcmParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser variableCharacterisationVariableCharacterisation_2002Parser;

	/**
	 * @generated
	 */
	private IParser getVariableCharacterisationVariableCharacterisation_2002Parser() {
		if (variableCharacterisationVariableCharacterisation_2002Parser == null) {
			variableCharacterisationVariableCharacterisation_2002Parser = createVariableCharacterisationVariableCharacterisation_2002Parser();
		}
		return variableCharacterisationVariableCharacterisation_2002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createVariableCharacterisationVariableCharacterisation_2002Parser() {
		List features = new ArrayList(2);
		features.add(ParameterPackage.eINSTANCE.getVariableCharacterisation()
				.getEStructuralFeature("type")); //$NON-NLS-1$
		features.add(StoexPackage.eINSTANCE.getRandomVariable()
				.getEStructuralFeature("specification")); //$NON-NLS-1$
		PcmStructuralFeaturesParser parser = new PcmStructuralFeaturesParser(
				features);
		parser.setViewPattern("{0} {1}");
		parser.setEditPattern("{0} {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionEntityName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionEntityName_4003Parser() {
		if (loopActionLoopActionEntityName_4003Parser == null) {
			loopActionLoopActionEntityName_4003Parser = createLoopActionLoopActionEntityName_4003Parser();
		}
		return loopActionLoopActionEntityName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionEntityName_4003Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionInternalActionEntityName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionInternalActionEntityName_4005Parser() {
		if (internalActionInternalActionEntityName_4005Parser == null) {
			internalActionInternalActionEntityName_4005Parser = createInternalActionInternalActionEntityName_4005Parser();
		}
		return internalActionInternalActionEntityName_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionInternalActionEntityName_4005Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser parametricResourceDemandParametricResourceDemand_2008Parser;

	/**
	 * @generated
	 */
	private IParser getParametricResourceDemandParametricResourceDemand_2008Parser() {
		if (parametricResourceDemandParametricResourceDemand_2008Parser == null) {
			parametricResourceDemandParametricResourceDemand_2008Parser = createParametricResourceDemandParametricResourceDemand_2008Parser();
		}
		return parametricResourceDemandParametricResourceDemand_2008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createParametricResourceDemandParametricResourceDemand_2008Parser() {
		List features = new ArrayList(2);
		features.add(StoexPackage.eINSTANCE.getRandomVariable()
				.getEStructuralFeature("specification")); //$NON-NLS-1$
		features.add(SeffPackage.eINSTANCE.getParametricResourceDemand()
				.getEStructuralFeature("unit")); //$NON-NLS-1$
		PcmStructuralFeaturesParser parser = new PcmStructuralFeaturesParser(
				features);
		parser.setViewPattern("{0} {1}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionBranchActionEntityName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionBranchActionEntityName_4008Parser() {
		if (branchActionBranchActionEntityName_4008Parser == null) {
			branchActionBranchActionEntityName_4008Parser = createBranchActionBranchActionEntityName_4008Parser();
		}
		return branchActionBranchActionEntityName_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionBranchActionEntityName_4008Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser probabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_4007Parser;

	/**
	 * @generated
	 */
	private IParser getProbabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_4007Parser() {
		if (probabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_4007Parser == null) {
			probabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_4007Parser = createProbabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_4007Parser();
		}
		return probabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProbabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_4007Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				SeffPackage.eINSTANCE.getProbabilisticBranchTransition()
						.getEStructuralFeature("branchProbability")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser externalCallActionExternalCallActionEntityName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getExternalCallActionExternalCallActionEntityName_4006Parser() {
		if (externalCallActionExternalCallActionEntityName_4006Parser == null) {
			externalCallActionExternalCallActionEntityName_4006Parser = createExternalCallActionExternalCallActionEntityName_4006Parser();
		}
		return externalCallActionExternalCallActionEntityName_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExternalCallActionExternalCallActionEntityName_4006Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser externalCallActionExternalCallActionEntityName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getExternalCallActionExternalCallActionEntityName_4002Parser() {
		if (externalCallActionExternalCallActionEntityName_4002Parser == null) {
			externalCallActionExternalCallActionEntityName_4002Parser = createExternalCallActionExternalCallActionEntityName_4002Parser();
		}
		return externalCallActionExternalCallActionEntityName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExternalCallActionExternalCallActionEntityName_4002Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionEntityName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionEntityName_4009Parser() {
		if (loopActionLoopActionEntityName_4009Parser == null) {
			loopActionLoopActionEntityName_4009Parser = createLoopActionLoopActionEntityName_4009Parser();
		}
		return loopActionLoopActionEntityName_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionEntityName_4009Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionBranchActionEntityName_4011Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionBranchActionEntityName_4011Parser() {
		if (branchActionBranchActionEntityName_4011Parser == null) {
			branchActionBranchActionEntityName_4011Parser = createBranchActionBranchActionEntityName_4011Parser();
		}
		return branchActionBranchActionEntityName_4011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionBranchActionEntityName_4011Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionInternalActionEntityName_4012Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionInternalActionEntityName_4012Parser() {
		if (internalActionInternalActionEntityName_4012Parser == null) {
			internalActionInternalActionEntityName_4012Parser = createInternalActionInternalActionEntityName_4012Parser();
		}
		return internalActionInternalActionEntityName_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionInternalActionEntityName_4012Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	private IParser loopActionIterations_4003Parser;

	private IParser getLoopActionIterations_4003Parser() {
		if (loopActionIterations_4003Parser == null) {
			loopActionIterations_4003Parser = createLoopActionIterations_4003Parser();
		}
		return loopActionIterations_4003Parser;
	}

	private IParser loopActionIterations_4009Parser;

	private IParser getLoopActionIterations_4009Parser() {
		if (loopActionIterations_4009Parser == null) {
			loopActionIterations_4009Parser = createLoopActionIterations_4003Parser();
		}
		return loopActionIterations_4009Parser;
	}

	protected IParser createLoopActionIterations_4003Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				StoexPackage.eINSTANCE.getRandomVariable_Specification()); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID:
			return getProbabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_4007Parser();
		case LoopIterationsLabelEditPart.VISUAL_ID:
			return getLoopActionIterations_4003Parser();
		case LoopIterationsLabel2EditPart.VISUAL_ID:
			return getLoopActionIterations_4009Parser();
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisationVariableCharacterisation_2002Parser();
		case LoopActionEntityNameEditPart.VISUAL_ID:
			return getLoopActionLoopActionEntityName_4003Parser();
		case InternalActionEntityNameEditPart.VISUAL_ID:
			return getInternalActionInternalActionEntityName_4005Parser();
		case ParametricResourceDemandEditPart.VISUAL_ID:
			return getParametricResourceDemandParametricResourceDemand_2008Parser();
		case BranchActionEntityNameEditPart.VISUAL_ID:
			return getBranchActionBranchActionEntityName_4008Parser();
		case ExternalCallActionEntityName2EditPart.VISUAL_ID:
			return getExternalCallActionExternalCallActionEntityName_4006Parser();
		case ExternalCallActionEntityNameEditPart.VISUAL_ID:
			return getExternalCallActionExternalCallActionEntityName_4002Parser();
		case LoopActionEntityName2EditPart.VISUAL_ID:
			return getLoopActionLoopActionEntityName_4009Parser();
		case BranchActionEntityName2EditPart.VISUAL_ID:
			return getBranchActionBranchActionEntityName_4011Parser();
		case InternalActionEntityName2EditPart.VISUAL_ID:
			return getInternalActionInternalActionEntityName_4012Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(PcmVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(PcmVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (PcmElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}
}

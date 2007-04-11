/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AquireActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AquireActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionIdEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser variableCharacterisationVariableCharacterisation_3002Parser;

	/**
	 * @generated
	 */
	private IParser getVariableCharacterisationVariableCharacterisation_3002Parser() {
		if (variableCharacterisationVariableCharacterisation_3002Parser == null) {
			variableCharacterisationVariableCharacterisation_3002Parser = createVariableCharacterisationVariableCharacterisation_3002Parser();
		}
		return variableCharacterisationVariableCharacterisation_3002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createVariableCharacterisationVariableCharacterisation_3002Parser() {
		List features = new ArrayList(2);
		features.add(ParameterPackage.eINSTANCE
				.getVariableCharacterisation_Type());
		features.add(StoexPackage.eINSTANCE.getRandomVariable_Specification());
		PalladioComponentModelStructuralFeaturesParser parser = new PalladioComponentModelStructuralFeaturesParser(
				features);
		parser.setViewPattern("{0} = {1}");
		parser.setEditPattern("{0} = {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionEntityName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionEntityName_5003Parser() {
		if (loopActionLoopActionEntityName_5003Parser == null) {
			loopActionLoopActionEntityName_5003Parser = createLoopActionLoopActionEntityName_5003Parser();
		}
		return loopActionLoopActionEntityName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionEntityName_5003Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionInternalActionEntityName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionInternalActionEntityName_5005Parser() {
		if (internalActionInternalActionEntityName_5005Parser == null) {
			internalActionInternalActionEntityName_5005Parser = createInternalActionInternalActionEntityName_5005Parser();
		}
		return internalActionInternalActionEntityName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionInternalActionEntityName_5005Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser parametricResourceDemandParametricResourceDemand_3008Parser;

	/**
	 * @generated
	 */
	private IParser getParametricResourceDemandParametricResourceDemand_3008Parser() {
		if (parametricResourceDemandParametricResourceDemand_3008Parser == null) {
			parametricResourceDemandParametricResourceDemand_3008Parser = createParametricResourceDemandParametricResourceDemand_3008Parser();
		}
		return parametricResourceDemandParametricResourceDemand_3008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createParametricResourceDemandParametricResourceDemand_3008Parser() {
		List features = new ArrayList(2);
		features.add(StoexPackage.eINSTANCE.getRandomVariable_Specification());
		features.add(SeffPackage.eINSTANCE.getParametricResourceDemand_Unit());
		PalladioComponentModelStructuralFeaturesParser parser = new PalladioComponentModelStructuralFeaturesParser(
				features);
		parser.setViewPattern("{0} {1}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionBranchActionEntityName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionBranchActionEntityName_5008Parser() {
		if (branchActionBranchActionEntityName_5008Parser == null) {
			branchActionBranchActionEntityName_5008Parser = createBranchActionBranchActionEntityName_5008Parser();
		}
		return branchActionBranchActionEntityName_5008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionBranchActionEntityName_5008Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser probabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_5007Parser;

	/**
	 * @generated
	 */
	private IParser getProbabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_5007Parser() {
		if (probabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_5007Parser == null) {
			probabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_5007Parser = createProbabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_5007Parser();
		}
		return probabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProbabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_5007Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				SeffPackage.eINSTANCE
						.getProbabilisticBranchTransition_BranchProbability());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser externalCallActionExternalCallActionEntityName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getExternalCallActionExternalCallActionEntityName_5006Parser() {
		if (externalCallActionExternalCallActionEntityName_5006Parser == null) {
			externalCallActionExternalCallActionEntityName_5006Parser = createExternalCallActionExternalCallActionEntityName_5006Parser();
		}
		return externalCallActionExternalCallActionEntityName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExternalCallActionExternalCallActionEntityName_5006Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser aquireActionAquireActionEntityName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getAquireActionAquireActionEntityName_5019Parser() {
		if (aquireActionAquireActionEntityName_5019Parser == null) {
			aquireActionAquireActionEntityName_5019Parser = createAquireActionAquireActionEntityName_5019Parser();
		}
		return aquireActionAquireActionEntityName_5019Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAquireActionAquireActionEntityName_5019Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser releaseActionReleaseActionEntityName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getReleaseActionReleaseActionEntityName_5020Parser() {
		if (releaseActionReleaseActionEntityName_5020Parser == null) {
			releaseActionReleaseActionEntityName_5020Parser = createReleaseActionReleaseActionEntityName_5020Parser();
		}
		return releaseActionReleaseActionEntityName_5020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createReleaseActionReleaseActionEntityName_5020Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser guardedBranchTransitionGuardedBranchTransitionId_5018Parser;

	/**
	 * @generated
	 */
	private IParser getGuardedBranchTransitionGuardedBranchTransitionId_5018Parser() {
		if (guardedBranchTransitionGuardedBranchTransitionId_5018Parser == null) {
			guardedBranchTransitionGuardedBranchTransitionId_5018Parser = createGuardedBranchTransitionGuardedBranchTransitionId_5018Parser();
		}
		return guardedBranchTransitionGuardedBranchTransitionId_5018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createGuardedBranchTransitionGuardedBranchTransitionId_5018Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				IdentifierPackage.eINSTANCE.getIdentifier_Id());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser collectionIteratorActionCollectionIteratorActionEntityName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getCollectionIteratorActionCollectionIteratorActionEntityName_5013Parser() {
		if (collectionIteratorActionCollectionIteratorActionEntityName_5013Parser == null) {
			collectionIteratorActionCollectionIteratorActionEntityName_5013Parser = createCollectionIteratorActionCollectionIteratorActionEntityName_5013Parser();
		}
		return collectionIteratorActionCollectionIteratorActionEntityName_5013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCollectionIteratorActionCollectionIteratorActionEntityName_5013Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser variableCharacterisationVariableCharacterisation_3016Parser;

	/**
	 * @generated
	 */
	private IParser getVariableCharacterisationVariableCharacterisation_3016Parser() {
		if (variableCharacterisationVariableCharacterisation_3016Parser == null) {
			variableCharacterisationVariableCharacterisation_3016Parser = createVariableCharacterisationVariableCharacterisation_3016Parser();
		}
		return variableCharacterisationVariableCharacterisation_3016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createVariableCharacterisationVariableCharacterisation_3016Parser() {
		List features = new ArrayList(2);
		features.add(ParameterPackage.eINSTANCE
				.getVariableCharacterisation_Type());
		features.add(StoexPackage.eINSTANCE.getRandomVariable_Specification());
		PalladioComponentModelStructuralFeaturesParser parser = new PalladioComponentModelStructuralFeaturesParser(
				features);
		parser.setViewPattern("{0} = {1}");
		parser.setEditPattern("{0} = {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser externalCallActionExternalCallActionEntityName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getExternalCallActionExternalCallActionEntityName_5002Parser() {
		if (externalCallActionExternalCallActionEntityName_5002Parser == null) {
			externalCallActionExternalCallActionEntityName_5002Parser = createExternalCallActionExternalCallActionEntityName_5002Parser();
		}
		return externalCallActionExternalCallActionEntityName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExternalCallActionExternalCallActionEntityName_5002Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionEntityName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionEntityName_5009Parser() {
		if (loopActionLoopActionEntityName_5009Parser == null) {
			loopActionLoopActionEntityName_5009Parser = createLoopActionLoopActionEntityName_5009Parser();
		}
		return loopActionLoopActionEntityName_5009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionEntityName_5009Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionBranchActionEntityName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionBranchActionEntityName_5011Parser() {
		if (branchActionBranchActionEntityName_5011Parser == null) {
			branchActionBranchActionEntityName_5011Parser = createBranchActionBranchActionEntityName_5011Parser();
		}
		return branchActionBranchActionEntityName_5011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionBranchActionEntityName_5011Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionInternalActionEntityName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionInternalActionEntityName_5012Parser() {
		if (internalActionInternalActionEntityName_5012Parser == null) {
			internalActionInternalActionEntityName_5012Parser = createInternalActionInternalActionEntityName_5012Parser();
		}
		return internalActionInternalActionEntityName_5012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionInternalActionEntityName_5012Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser collectionIteratorActionCollectionIteratorActionEntityName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getCollectionIteratorActionCollectionIteratorActionEntityName_5015Parser() {
		if (collectionIteratorActionCollectionIteratorActionEntityName_5015Parser == null) {
			collectionIteratorActionCollectionIteratorActionEntityName_5015Parser = createCollectionIteratorActionCollectionIteratorActionEntityName_5015Parser();
		}
		return collectionIteratorActionCollectionIteratorActionEntityName_5015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCollectionIteratorActionCollectionIteratorActionEntityName_5015Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser aquireActionAquireActionEntityName_5021Parser;

	/**
	 * @generated
	 */
	private IParser getAquireActionAquireActionEntityName_5021Parser() {
		if (aquireActionAquireActionEntityName_5021Parser == null) {
			aquireActionAquireActionEntityName_5021Parser = createAquireActionAquireActionEntityName_5021Parser();
		}
		return aquireActionAquireActionEntityName_5021Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAquireActionAquireActionEntityName_5021Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser releaseActionReleaseActionEntityName_5022Parser;

	/**
	 * @generated
	 */
	private IParser getReleaseActionReleaseActionEntityName_5022Parser() {
		if (releaseActionReleaseActionEntityName_5022Parser == null) {
			releaseActionReleaseActionEntityName_5022Parser = createReleaseActionReleaseActionEntityName_5022Parser();
		}
		return releaseActionReleaseActionEntityName_5022Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createReleaseActionReleaseActionEntityName_5022Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisationVariableCharacterisation_3002Parser();
		case LoopActionEntityNameEditPart.VISUAL_ID:
			return getLoopActionLoopActionEntityName_5003Parser();
		case InternalActionEntityNameEditPart.VISUAL_ID:
			return getInternalActionInternalActionEntityName_5005Parser();
		case ParametricResourceDemandEditPart.VISUAL_ID:
			return getParametricResourceDemandParametricResourceDemand_3008Parser();
		case BranchActionEntityNameEditPart.VISUAL_ID:
			return getBranchActionBranchActionEntityName_5008Parser();
		case ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID:
			return getProbabilisticBranchTransitionProbabilisticBranchTransitionBranchProbability_5007Parser();
		case ExternalCallActionEntityName2EditPart.VISUAL_ID:
			return getExternalCallActionExternalCallActionEntityName_5006Parser();
		case AquireActionEntityNameEditPart.VISUAL_ID:
			return getAquireActionAquireActionEntityName_5019Parser();
		case ReleaseActionEntityNameEditPart.VISUAL_ID:
			return getReleaseActionReleaseActionEntityName_5020Parser();
		case GuardedBranchTransitionIdEditPart.VISUAL_ID:
			return getGuardedBranchTransitionGuardedBranchTransitionId_5018Parser();
		case CollectionIteratorActionEntityNameEditPart.VISUAL_ID:
			return getCollectionIteratorActionCollectionIteratorActionEntityName_5013Parser();
		case VariableCharacterisation2EditPart.VISUAL_ID:
			return getVariableCharacterisationVariableCharacterisation_3016Parser();
		case ExternalCallActionEntityNameEditPart.VISUAL_ID:
			return getExternalCallActionExternalCallActionEntityName_5002Parser();
		case LoopActionEntityName2EditPart.VISUAL_ID:
			return getLoopActionLoopActionEntityName_5009Parser();
		case BranchActionEntityName2EditPart.VISUAL_ID:
			return getBranchActionBranchActionEntityName_5011Parser();
		case InternalActionEntityName2EditPart.VISUAL_ID:
			return getInternalActionInternalActionEntityName_5012Parser();
		case CollectionIteratorActionEntityName2EditPart.VISUAL_ID:
			return getCollectionIteratorActionCollectionIteratorActionEntityName_5015Parser();
		case AquireActionEntityName2EditPart.VISUAL_ID:
			return getAquireActionAquireActionEntityName_5021Parser();
		case ReleaseActionEntityName2EditPart.VISUAL_ID:
			return getReleaseActionReleaseActionEntityName_5022Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(PalladioComponentModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(PalladioComponentModelVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (PalladioComponentModelElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}
}

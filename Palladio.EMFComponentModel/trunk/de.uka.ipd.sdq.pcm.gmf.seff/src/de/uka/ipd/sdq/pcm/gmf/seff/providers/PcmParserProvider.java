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
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionParametricParameterUsageSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionIterations2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionIterationsEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.PrimitiveParametricParameterUsageSpecificationEditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class PcmParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionEntityName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionEntityName_4002Parser() {
		if (loopActionLoopActionEntityName_4002Parser == null) {
			loopActionLoopActionEntityName_4002Parser = createLoopActionLoopActionEntityName_4002Parser();
		}
		return loopActionLoopActionEntityName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionEntityName_4002Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionIterations_4003Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionIterations_4003Parser() {
		if (loopActionLoopActionIterations_4003Parser == null) {
			loopActionLoopActionIterations_4003Parser = createLoopActionLoopActionIterations_4003Parser();
		}
		return loopActionLoopActionIterations_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionIterations_4003Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				SeffPackage.eINSTANCE.getLoopAction().getEStructuralFeature(
						"iterations")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionInternalActionEntityName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionInternalActionEntityName_4004Parser() {
		if (internalActionInternalActionEntityName_4004Parser == null) {
			internalActionInternalActionEntityName_4004Parser = createInternalActionInternalActionEntityName_4004Parser();
		}
		return internalActionInternalActionEntityName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionInternalActionEntityName_4004Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionBranchActionEntityName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionBranchActionEntityName_4006Parser() {
		if (branchActionBranchActionEntityName_4006Parser == null) {
			branchActionBranchActionEntityName_4006Parser = createBranchActionBranchActionEntityName_4006Parser();
		}
		return branchActionBranchActionEntityName_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionBranchActionEntityName_4006Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchTransitionBranchTransitionBranchProbability_4005Parser;

	/**
	 * @generated
	 */
	private IParser getBranchTransitionBranchTransitionBranchProbability_4005Parser() {
		if (branchTransitionBranchTransitionBranchProbability_4005Parser == null) {
			branchTransitionBranchTransitionBranchProbability_4005Parser = createBranchTransitionBranchTransitionBranchProbability_4005Parser();
		}
		return branchTransitionBranchTransitionBranchProbability_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchTransitionBranchTransitionBranchProbability_4005Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				SeffPackage.eINSTANCE.getBranchTransition()
						.getEStructuralFeature("branchProbability")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser externalCallActionExternalCallActionEntityName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getExternalCallActionExternalCallActionEntityName_4001Parser() {
		if (externalCallActionExternalCallActionEntityName_4001Parser == null) {
			externalCallActionExternalCallActionEntityName_4001Parser = createExternalCallActionExternalCallActionEntityName_4001Parser();
		}
		return externalCallActionExternalCallActionEntityName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExternalCallActionExternalCallActionEntityName_4001Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionEntityName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionEntityName_4007Parser() {
		if (loopActionLoopActionEntityName_4007Parser == null) {
			loopActionLoopActionEntityName_4007Parser = createLoopActionLoopActionEntityName_4007Parser();
		}
		return loopActionLoopActionEntityName_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionEntityName_4007Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionIterations_4008Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionIterations_4008Parser() {
		if (loopActionLoopActionIterations_4008Parser == null) {
			loopActionLoopActionIterations_4008Parser = createLoopActionLoopActionIterations_4008Parser();
		}
		return loopActionLoopActionIterations_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionIterations_4008Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				SeffPackage.eINSTANCE.getLoopAction().getEStructuralFeature(
						"iterations")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionBranchActionEntityName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionBranchActionEntityName_4009Parser() {
		if (branchActionBranchActionEntityName_4009Parser == null) {
			branchActionBranchActionEntityName_4009Parser = createBranchActionBranchActionEntityName_4009Parser();
		}
		return branchActionBranchActionEntityName_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionBranchActionEntityName_4009Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionInternalActionEntityName_4010Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionInternalActionEntityName_4010Parser() {
		if (internalActionInternalActionEntityName_4010Parser == null) {
			internalActionInternalActionEntityName_4010Parser = createInternalActionInternalActionEntityName_4010Parser();
		}
		return internalActionInternalActionEntityName_4010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionInternalActionEntityName_4010Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveParametricParameterUsagePrimitiveParametricParameterUsageSpecification_4011Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveParametricParameterUsagePrimitiveParametricParameterUsageSpecification_4011Parser() {
		if (primitiveParametricParameterUsagePrimitiveParametricParameterUsageSpecification_4011Parser == null) {
			primitiveParametricParameterUsagePrimitiveParametricParameterUsageSpecification_4011Parser = createPrimitiveParametricParameterUsagePrimitiveParametricParameterUsageSpecification_4011Parser();
		}
		return primitiveParametricParameterUsagePrimitiveParametricParameterUsageSpecification_4011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPrimitiveParametricParameterUsagePrimitiveParametricParameterUsageSpecification_4011Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				StochasticsPackage.eINSTANCE.getRandomVariable()
						.getEStructuralFeature("specification")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser collectionParametricParameterUsageCollectionParametricParameterUsageSpecification_4012Parser;

	/**
	 * @generated
	 */
	private IParser getCollectionParametricParameterUsageCollectionParametricParameterUsageSpecification_4012Parser() {
		if (collectionParametricParameterUsageCollectionParametricParameterUsageSpecification_4012Parser == null) {
			collectionParametricParameterUsageCollectionParametricParameterUsageSpecification_4012Parser = createCollectionParametricParameterUsageCollectionParametricParameterUsageSpecification_4012Parser();
		}
		return collectionParametricParameterUsageCollectionParametricParameterUsageSpecification_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCollectionParametricParameterUsageCollectionParametricParameterUsageSpecification_4012Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				StochasticsPackage.eINSTANCE.getRandomVariable()
						.getEStructuralFeature("specification")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser parametricResourceDemandParametricResourceDemandDemand_4013Parser;

	/**
	 * @generated
	 */
	private IParser getParametricResourceDemandParametricResourceDemandDemand_4013Parser() {
		if (parametricResourceDemandParametricResourceDemandDemand_4013Parser == null) {
			parametricResourceDemandParametricResourceDemandDemand_4013Parser = createParametricResourceDemandParametricResourceDemandDemand_4013Parser();
		}
		return parametricResourceDemandParametricResourceDemandDemand_4013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createParametricResourceDemandParametricResourceDemandDemand_4013Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				SeffPackage.eINSTANCE.getParametricResourceDemand()
						.getEStructuralFeature("demand")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case LoopActionEntityNameEditPart.VISUAL_ID:
			return getLoopActionLoopActionEntityName_4002Parser();
		case LoopActionIterationsEditPart.VISUAL_ID:
			return getLoopActionLoopActionIterations_4003Parser();
		case InternalActionEntityNameEditPart.VISUAL_ID:
			return getInternalActionInternalActionEntityName_4004Parser();
		case BranchActionEntityNameEditPart.VISUAL_ID:
			return getBranchActionBranchActionEntityName_4006Parser();
		case BranchTransitionBranchProbabilityEditPart.VISUAL_ID:
			return getBranchTransitionBranchTransitionBranchProbability_4005Parser();
		case ExternalCallActionEntityNameEditPart.VISUAL_ID:
			return getExternalCallActionExternalCallActionEntityName_4001Parser();
		case LoopActionEntityName2EditPart.VISUAL_ID:
			return getLoopActionLoopActionEntityName_4007Parser();
		case LoopActionIterations2EditPart.VISUAL_ID:
			return getLoopActionLoopActionIterations_4008Parser();
		case BranchActionEntityName2EditPart.VISUAL_ID:
			return getBranchActionBranchActionEntityName_4009Parser();
		case InternalActionEntityName2EditPart.VISUAL_ID:
			return getInternalActionInternalActionEntityName_4010Parser();
		case PrimitiveParametricParameterUsageSpecificationEditPart.VISUAL_ID:
			return getPrimitiveParametricParameterUsagePrimitiveParametricParameterUsageSpecification_4011Parser();
		case CollectionParametricParameterUsageSpecificationEditPart.VISUAL_ID:
			return getCollectionParametricParameterUsageCollectionParametricParameterUsageSpecification_4012Parser();
		case ParametricResourceDemandDemandEditPart.VISUAL_ID:
			return getParametricResourceDemandParametricResourceDemandDemand_4013Parser();
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

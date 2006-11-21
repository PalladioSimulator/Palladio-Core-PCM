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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import java.util.ArrayList;
import java.util.List;

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
				StochasticsPackage.eINSTANCE.getRandomVariable_Specification()); //$NON-NLS-1$
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
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser parametricResourceDemandParametricResourceDemand_2007Parser;

	/**
	 * @generated
	 */
	private IParser getParametricResourceDemandParametricResourceDemand_2007Parser() {
		if (parametricResourceDemandParametricResourceDemand_2007Parser == null) {
			parametricResourceDemandParametricResourceDemand_2007Parser = createParametricResourceDemandParametricResourceDemand_2007Parser();
		}
		return parametricResourceDemandParametricResourceDemand_2007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createParametricResourceDemandParametricResourceDemand_2007Parser() {
		List features = new ArrayList(2);
		features.add(StochasticsPackage.eINSTANCE.getRandomVariable()
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
	private IParser branchActionBranchActionEntityName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionBranchActionEntityName_4007Parser() {
		if (branchActionBranchActionEntityName_4007Parser == null) {
			branchActionBranchActionEntityName_4007Parser = createBranchActionBranchActionEntityName_4007Parser();
		}
		return branchActionBranchActionEntityName_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionBranchActionEntityName_4007Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser externalCallActionExternalCallActionEntityName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getExternalCallActionExternalCallActionEntityName_4005Parser() {
		if (externalCallActionExternalCallActionEntityName_4005Parser == null) {
			externalCallActionExternalCallActionEntityName_4005Parser = createExternalCallActionExternalCallActionEntityName_4005Parser();
		}
		return externalCallActionExternalCallActionEntityName_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExternalCallActionExternalCallActionEntityName_4005Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
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
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionLoopActionEntityName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionLoopActionEntityName_4008Parser() {
		if (loopActionLoopActionEntityName_4008Parser == null) {
			loopActionLoopActionEntityName_4008Parser = createLoopActionLoopActionEntityName_4008Parser();
		}
		return loopActionLoopActionEntityName_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionLoopActionEntityName_4008Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionBranchActionEntityName_4010Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionBranchActionEntityName_4010Parser() {
		if (branchActionBranchActionEntityName_4010Parser == null) {
			branchActionBranchActionEntityName_4010Parser = createBranchActionBranchActionEntityName_4010Parser();
		}
		return branchActionBranchActionEntityName_4010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionBranchActionEntityName_4010Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionInternalActionEntityName_4011Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionInternalActionEntityName_4011Parser() {
		if (internalActionInternalActionEntityName_4011Parser == null) {
			internalActionInternalActionEntityName_4011Parser = createInternalActionInternalActionEntityName_4011Parser();
		}
		return internalActionInternalActionEntityName_4011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionInternalActionEntityName_4011Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case LoopActionEntityNameEditPart.VISUAL_ID:
			return getLoopActionLoopActionEntityName_4002Parser();
		case LoopIterationsLabelEditPart.VISUAL_ID:
			return getLoopActionIterations_4003Parser();
		case LoopIterationsLabel2EditPart.VISUAL_ID:
			return getLoopActionIterations_4009Parser();
		case InternalActionEntityNameEditPart.VISUAL_ID:
			return getInternalActionInternalActionEntityName_4004Parser();
		case ParametricResourceDemandEditPart.VISUAL_ID:
			return getParametricResourceDemandParametricResourceDemand_2007Parser();
		case BranchActionEntityNameEditPart.VISUAL_ID:
			return getBranchActionBranchActionEntityName_4007Parser();
		case ExternalCallActionEntityName2EditPart.VISUAL_ID:
			return getExternalCallActionExternalCallActionEntityName_4005Parser();
		case ExternalCallActionEntityNameEditPart.VISUAL_ID:
			return getExternalCallActionExternalCallActionEntityName_4001Parser();
		case LoopActionEntityName2EditPart.VISUAL_ID:
			return getLoopActionLoopActionEntityName_4008Parser();
		case BranchActionEntityName2EditPart.VISUAL_ID:
			return getBranchActionBranchActionEntityName_4010Parser();
		case InternalActionEntityName2EditPart.VISUAL_ID:
			return getInternalActionInternalActionEntityName_4011Parser();
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

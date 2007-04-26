/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourId2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourId3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourIdEditPart;

import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser branchTransitionBranchTransitionBranchProbability_5007Parser;

	/**
	 * @generated
	 */
	private IParser getBranchTransitionBranchTransitionBranchProbability_5007Parser() {
		if (branchTransitionBranchTransitionBranchProbability_5007Parser == null) {
			branchTransitionBranchTransitionBranchProbability_5007Parser = createBranchTransitionBranchTransitionBranchProbability_5007Parser();
		}
		return branchTransitionBranchTransitionBranchProbability_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchTransitionBranchTransitionBranchProbability_5007Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				UsagemodelPackage.eINSTANCE
						.getBranchTransition_BranchProbability());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser closedWorkloadClosedWorkloadPopulation_5003Parser;

	/**
	 * @generated
	 */
	private IParser getClosedWorkloadClosedWorkloadPopulation_5003Parser() {
		if (closedWorkloadClosedWorkloadPopulation_5003Parser == null) {
			closedWorkloadClosedWorkloadPopulation_5003Parser = createClosedWorkloadClosedWorkloadPopulation_5003Parser();
		}
		return closedWorkloadClosedWorkloadPopulation_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClosedWorkloadClosedWorkloadPopulation_5003Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				UsagemodelPackage.eINSTANCE.getClosedWorkload_Population());
		parser.setViewPattern("Population: {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case BranchTransitionBranchProbabilityEditPart.VISUAL_ID:
			return getBranchTransitionBranchTransitionBranchProbability_5007Parser();
		case ClosedWorkloadPopulationEditPart.VISUAL_ID:
			return getClosedWorkloadClosedWorkloadPopulation_5003Parser();
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

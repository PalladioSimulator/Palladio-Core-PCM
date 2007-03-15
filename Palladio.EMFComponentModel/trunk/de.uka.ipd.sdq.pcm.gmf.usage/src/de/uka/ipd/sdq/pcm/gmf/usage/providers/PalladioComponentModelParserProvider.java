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
	private IParser scenarioBehaviourScenarioBehaviourId_5005Parser;

	/**
	 * @generated
	 */
	private IParser getScenarioBehaviourScenarioBehaviourId_5005Parser() {
		if (scenarioBehaviourScenarioBehaviourId_5005Parser == null) {
			scenarioBehaviourScenarioBehaviourId_5005Parser = createScenarioBehaviourScenarioBehaviourId_5005Parser();
		}
		return scenarioBehaviourScenarioBehaviourId_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createScenarioBehaviourScenarioBehaviourId_5005Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				IdentifierPackage.eINSTANCE.getIdentifier_Id());
		parser.setViewPattern("ID: {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser scenarioBehaviourScenarioBehaviourId_5004Parser;

	/**
	 * @generated
	 */
	private IParser getScenarioBehaviourScenarioBehaviourId_5004Parser() {
		if (scenarioBehaviourScenarioBehaviourId_5004Parser == null) {
			scenarioBehaviourScenarioBehaviourId_5004Parser = createScenarioBehaviourScenarioBehaviourId_5004Parser();
		}
		return scenarioBehaviourScenarioBehaviourId_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createScenarioBehaviourScenarioBehaviourId_5004Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				IdentifierPackage.eINSTANCE.getIdentifier_Id());
		parser.setViewPattern("ID: {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser scenarioBehaviourScenarioBehaviourId_5001Parser;

	/**
	 * @generated
	 */
	private IParser getScenarioBehaviourScenarioBehaviourId_5001Parser() {
		if (scenarioBehaviourScenarioBehaviourId_5001Parser == null) {
			scenarioBehaviourScenarioBehaviourId_5001Parser = createScenarioBehaviourScenarioBehaviourId_5001Parser();
		}
		return scenarioBehaviourScenarioBehaviourId_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createScenarioBehaviourScenarioBehaviourId_5001Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				IdentifierPackage.eINSTANCE.getIdentifier_Id());
		parser.setViewPattern("ID: {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser closedWorkloadClosedWorkloadPopulation_5002Parser;

	/**
	 * @generated
	 */
	private IParser getClosedWorkloadClosedWorkloadPopulation_5002Parser() {
		if (closedWorkloadClosedWorkloadPopulation_5002Parser == null) {
			closedWorkloadClosedWorkloadPopulation_5002Parser = createClosedWorkloadClosedWorkloadPopulation_5002Parser();
		}
		return closedWorkloadClosedWorkloadPopulation_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClosedWorkloadClosedWorkloadPopulation_5002Parser() {
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
		case ScenarioBehaviourId2EditPart.VISUAL_ID:
			return getScenarioBehaviourScenarioBehaviourId_5005Parser();
		case ScenarioBehaviourIdEditPart.VISUAL_ID:
			return getScenarioBehaviourScenarioBehaviourId_5004Parser();
		case ScenarioBehaviourId3EditPart.VISUAL_ID:
			return getScenarioBehaviourScenarioBehaviourId_5001Parser();
		case ClosedWorkloadPopulationEditPart.VISUAL_ID:
			return getClosedWorkloadClosedWorkloadPopulation_5002Parser();
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

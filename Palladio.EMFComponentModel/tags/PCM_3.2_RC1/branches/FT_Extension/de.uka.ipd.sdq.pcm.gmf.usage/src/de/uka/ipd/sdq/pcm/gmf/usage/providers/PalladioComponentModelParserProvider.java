/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadTitleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser closedWorkloadPopulation_5002Parser;

	/**
	 * @generated
	 */
	private IParser getClosedWorkloadPopulation_5002Parser() {
		if (closedWorkloadPopulation_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { UsagemodelPackage.eINSTANCE
					.getClosedWorkload_Population() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Population: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("Population: {0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			closedWorkloadPopulation_5002Parser = parser;
		}
		return closedWorkloadPopulation_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser variableCharacterisation_3013Parser;

	/**
	 * @generated
	 */
	private IParser getVariableCharacterisation_3013Parser() {
		if (variableCharacterisation_3013Parser == null) {
			EAttribute[] features = new EAttribute[] { ParameterPackage.eINSTANCE
					.getVariableCharacterisation_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} = {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} = {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0} = {1}"); //$NON-NLS-1$
			variableCharacterisation_3013Parser = parser;
		}
		return variableCharacterisation_3013Parser;
	}

	/**
	 * @generated
	 */
	private IParser branchTransitionBranchProbability_5007Parser;

	/**
	 * @generated
	 */
	private IParser getBranchTransitionBranchProbability_5007Parser() {
		if (branchTransitionBranchProbability_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { UsagemodelPackage.eINSTANCE
					.getBranchTransition_BranchProbability() };
			MessageFormatParser parser = new MessageFormatParser(features);
			branchTransitionBranchProbability_5007Parser = parser;
		}
		return branchTransitionBranchProbability_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ClosedWorkloadTitleLabelEditPart.VISUAL_ID:
			return getClosedWorkloadPopulation_5002Parser();
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3013Parser();
		case BranchTransitionBranchProbabilityEditPart.VISUAL_ID:
			return getBranchTransitionBranchProbability_5007Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
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

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		private final IElementType elementType;

		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}
}

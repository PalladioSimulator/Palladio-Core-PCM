/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionIdEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser externalCallActionEntityName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getExternalCallActionEntityName_5002Parser() {
		if (externalCallActionEntityName_5002Parser == null) {
			externalCallActionEntityName_5002Parser = createExternalCallActionEntityName_5002Parser();
		}
		return externalCallActionEntityName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExternalCallActionEntityName_5002Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionEntityName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionEntityName_5009Parser() {
		if (loopActionEntityName_5009Parser == null) {
			loopActionEntityName_5009Parser = createLoopActionEntityName_5009Parser();
		}
		return loopActionEntityName_5009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionEntityName_5009Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionEntityName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionEntityName_5011Parser() {
		if (branchActionEntityName_5011Parser == null) {
			branchActionEntityName_5011Parser = createBranchActionEntityName_5011Parser();
		}
		return branchActionEntityName_5011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionEntityName_5011Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionEntityName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionEntityName_5012Parser() {
		if (internalActionEntityName_5012Parser == null) {
			internalActionEntityName_5012Parser = createInternalActionEntityName_5012Parser();
		}
		return internalActionEntityName_5012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionEntityName_5012Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser collectionIteratorActionEntityName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getCollectionIteratorActionEntityName_5015Parser() {
		if (collectionIteratorActionEntityName_5015Parser == null) {
			collectionIteratorActionEntityName_5015Parser = createCollectionIteratorActionEntityName_5015Parser();
		}
		return collectionIteratorActionEntityName_5015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCollectionIteratorActionEntityName_5015Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser setVariableActionEntityName_5023Parser;

	/**
	 * @generated
	 */
	private IParser getSetVariableActionEntityName_5023Parser() {
		if (setVariableActionEntityName_5023Parser == null) {
			setVariableActionEntityName_5023Parser = createSetVariableActionEntityName_5023Parser();
		}
		return setVariableActionEntityName_5023Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSetVariableActionEntityName_5023Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser acquireActionEntityName_5029Parser;

	/**
	 * @generated
	 */
	private IParser getAcquireActionEntityName_5029Parser() {
		if (acquireActionEntityName_5029Parser == null) {
			acquireActionEntityName_5029Parser = createAcquireActionEntityName_5029Parser();
		}
		return acquireActionEntityName_5029Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcquireActionEntityName_5029Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser releaseActionEntityName_5022Parser;

	/**
	 * @generated
	 */
	private IParser getReleaseActionEntityName_5022Parser() {
		if (releaseActionEntityName_5022Parser == null) {
			releaseActionEntityName_5022Parser = createReleaseActionEntityName_5022Parser();
		}
		return releaseActionEntityName_5022Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createReleaseActionEntityName_5022Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser forkActionEntityName_5024Parser;

	/**
	 * @generated
	 */
	private IParser getForkActionEntityName_5024Parser() {
		if (forkActionEntityName_5024Parser == null) {
			forkActionEntityName_5024Parser = createForkActionEntityName_5024Parser();
		}
		return forkActionEntityName_5024Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createForkActionEntityName_5024Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser variableCharacterisation_3033Parser;

	/**
	 * @generated
	 */
	private IParser getVariableCharacterisation_3033Parser() {
		if (variableCharacterisation_3033Parser == null) {
			variableCharacterisation_3033Parser = createVariableCharacterisation_3033Parser();
		}
		return variableCharacterisation_3033Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createVariableCharacterisation_3033Parser() {
		EAttribute[] features = new EAttribute[] { ParameterPackage.eINSTANCE
				.getVariableCharacterisation_Type(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0} = {1}");
		parser.setEditorPattern("{0} = {1}");
		parser.setEditPattern("{0} = {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser variableCharacterisation_3035Parser;

	/**
	 * @generated
	 */
	private IParser getVariableCharacterisation_3035Parser() {
		if (variableCharacterisation_3035Parser == null) {
			variableCharacterisation_3035Parser = createVariableCharacterisation_3035Parser();
		}
		return variableCharacterisation_3035Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createVariableCharacterisation_3035Parser() {
		EAttribute[] features = new EAttribute[] { ParameterPackage.eINSTANCE
				.getVariableCharacterisation_Type(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0} = {1}");
		parser.setEditorPattern("{0} = {1}");
		parser.setEditPattern("{0} = {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser loopActionEntityName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getLoopActionEntityName_5003Parser() {
		if (loopActionEntityName_5003Parser == null) {
			loopActionEntityName_5003Parser = createLoopActionEntityName_5003Parser();
		}
		return loopActionEntityName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopActionEntityName_5003Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser internalActionEntityName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getInternalActionEntityName_5005Parser() {
		if (internalActionEntityName_5005Parser == null) {
			internalActionEntityName_5005Parser = createInternalActionEntityName_5005Parser();
		}
		return internalActionEntityName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInternalActionEntityName_5005Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser branchActionEntityName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getBranchActionEntityName_5008Parser() {
		if (branchActionEntityName_5008Parser == null) {
			branchActionEntityName_5008Parser = createBranchActionEntityName_5008Parser();
		}
		return branchActionEntityName_5008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBranchActionEntityName_5008Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser probabilisticBranchTransitionBranchProbability_5007Parser;

	/**
	 * @generated
	 */
	private IParser getProbabilisticBranchTransitionBranchProbability_5007Parser() {
		if (probabilisticBranchTransitionBranchProbability_5007Parser == null) {
			probabilisticBranchTransitionBranchProbability_5007Parser = createProbabilisticBranchTransitionBranchProbability_5007Parser();
		}
		return probabilisticBranchTransitionBranchProbability_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProbabilisticBranchTransitionBranchProbability_5007Parser() {
		EAttribute[] features = new EAttribute[] { SeffPackage.eINSTANCE
				.getProbabilisticBranchTransition_BranchProbability(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("Probability: {0}");
		parser.setEditorPattern("Probability: {0}");
		parser.setEditPattern("Probability: {0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser externalCallActionEntityName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getExternalCallActionEntityName_5006Parser() {
		if (externalCallActionEntityName_5006Parser == null) {
			externalCallActionEntityName_5006Parser = createExternalCallActionEntityName_5006Parser();
		}
		return externalCallActionEntityName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExternalCallActionEntityName_5006Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser acquireActionEntityName_5028Parser;

	/**
	 * @generated
	 */
	private IParser getAcquireActionEntityName_5028Parser() {
		if (acquireActionEntityName_5028Parser == null) {
			acquireActionEntityName_5028Parser = createAcquireActionEntityName_5028Parser();
		}
		return acquireActionEntityName_5028Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcquireActionEntityName_5028Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser releaseActionEntityName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getReleaseActionEntityName_5020Parser() {
		if (releaseActionEntityName_5020Parser == null) {
			releaseActionEntityName_5020Parser = createReleaseActionEntityName_5020Parser();
		}
		return releaseActionEntityName_5020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createReleaseActionEntityName_5020Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser forkActionEntityName_5026Parser;

	/**
	 * @generated
	 */
	private IParser getForkActionEntityName_5026Parser() {
		if (forkActionEntityName_5026Parser == null) {
			forkActionEntityName_5026Parser = createForkActionEntityName_5026Parser();
		}
		return forkActionEntityName_5026Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createForkActionEntityName_5026Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser collectionIteratorActionEntityName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getCollectionIteratorActionEntityName_5013Parser() {
		if (collectionIteratorActionEntityName_5013Parser == null) {
			collectionIteratorActionEntityName_5013Parser = createCollectionIteratorActionEntityName_5013Parser();
		}
		return collectionIteratorActionEntityName_5013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCollectionIteratorActionEntityName_5013Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser setVariableActionEntityName_5027Parser;

	/**
	 * @generated
	 */
	private IParser getSetVariableActionEntityName_5027Parser() {
		if (setVariableActionEntityName_5027Parser == null) {
			setVariableActionEntityName_5027Parser = createSetVariableActionEntityName_5027Parser();
		}
		return setVariableActionEntityName_5027Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSetVariableActionEntityName_5027Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser variableCharacterisation_3037Parser;

	/**
	 * @generated
	 */
	private IParser getVariableCharacterisation_3037Parser() {
		if (variableCharacterisation_3037Parser == null) {
			variableCharacterisation_3037Parser = createVariableCharacterisation_3037Parser();
		}
		return variableCharacterisation_3037Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createVariableCharacterisation_3037Parser() {
		EAttribute[] features = new EAttribute[] { ParameterPackage.eINSTANCE
				.getVariableCharacterisation_Type(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0} = {1}");
		parser.setEditorPattern("{0} = {1}");
		parser.setEditPattern("{0} = {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser guardedBranchTransitionEntityName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getGuardedBranchTransitionEntityName_5018Parser() {
		if (guardedBranchTransitionEntityName_5018Parser == null) {
			guardedBranchTransitionEntityName_5018Parser = createGuardedBranchTransitionEntityName_5018Parser();
		}
		return guardedBranchTransitionEntityName_5018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createGuardedBranchTransitionEntityName_5018Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ExternalCallActionEntityNameEditPart.VISUAL_ID:
			return getExternalCallActionEntityName_5002Parser();
		case LoopActionEntityNameEditPart.VISUAL_ID:
			return getLoopActionEntityName_5009Parser();
		case BranchActionEntityNameEditPart.VISUAL_ID:
			return getBranchActionEntityName_5011Parser();
		case InternalActionEntityNameEditPart.VISUAL_ID:
			return getInternalActionEntityName_5012Parser();
		case CollectionIteratorActionEntityNameEditPart.VISUAL_ID:
			return getCollectionIteratorActionEntityName_5015Parser();
		case SetVariableActionEntityNameEditPart.VISUAL_ID:
			return getSetVariableActionEntityName_5023Parser();
		case AcquireActionEntityNameEditPart.VISUAL_ID:
			return getAcquireActionEntityName_5029Parser();
		case ReleaseActionEntityNameEditPart.VISUAL_ID:
			return getReleaseActionEntityName_5022Parser();
		case ForkActionEntityNameEditPart.VISUAL_ID:
			return getForkActionEntityName_5024Parser();
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3033Parser();
		case VariableCharacterisation2EditPart.VISUAL_ID:
			return getVariableCharacterisation_3035Parser();
		case LoopActionEntityName2EditPart.VISUAL_ID:
			return getLoopActionEntityName_5003Parser();
		case InternalActionEntityName2EditPart.VISUAL_ID:
			return getInternalActionEntityName_5005Parser();
		case BranchActionEntityName2EditPart.VISUAL_ID:
			return getBranchActionEntityName_5008Parser();
		case ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID:
			return getProbabilisticBranchTransitionBranchProbability_5007Parser();
		case ExternalCallActionEntityName2EditPart.VISUAL_ID:
			return getExternalCallActionEntityName_5006Parser();
		case AcquireActionEntityName2EditPart.VISUAL_ID:
			return getAcquireActionEntityName_5028Parser();
		case ReleaseActionEntityName2EditPart.VISUAL_ID:
			return getReleaseActionEntityName_5020Parser();
		case ForkActionEntityName2EditPart.VISUAL_ID:
			return getForkActionEntityName_5026Parser();
		case CollectionIteratorActionEntityName2EditPart.VISUAL_ID:
			return getCollectionIteratorActionEntityName_5013Parser();
		case SetVariableActionEntityName2EditPart.VISUAL_ID:
			return getSetVariableActionEntityName_5027Parser();
		case VariableCharacterisation3EditPart.VISUAL_ID:
			return getVariableCharacterisation_3037Parser();
		case GuardedBranchTransitionEntityNameEditPart.VISUAL_ID:
			return getGuardedBranchTransitionEntityName_5018Parser();
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

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

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

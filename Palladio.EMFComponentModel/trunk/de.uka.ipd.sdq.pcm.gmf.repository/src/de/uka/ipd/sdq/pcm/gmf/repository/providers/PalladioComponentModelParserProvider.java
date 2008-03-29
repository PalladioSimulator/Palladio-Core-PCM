/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

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

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser interfaceEntityName_5101Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceEntityName_5101Parser() {
		if (interfaceEntityName_5101Parser == null) {
			interfaceEntityName_5101Parser = createInterfaceEntityName_5101Parser();
		}
		return interfaceEntityName_5101Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceEntityName_5101Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser basicComponentEntityName_5102Parser;

	/**
	 * @generated
	 */
	private IParser getBasicComponentEntityName_5102Parser() {
		if (basicComponentEntityName_5102Parser == null) {
			basicComponentEntityName_5102Parser = createBasicComponentEntityName_5102Parser();
		}
		return basicComponentEntityName_5102Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBasicComponentEntityName_5102Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser completeComponentTypeEntityName_5103Parser;

	/**
	 * @generated
	 */
	private IParser getCompleteComponentTypeEntityName_5103Parser() {
		if (completeComponentTypeEntityName_5103Parser == null) {
			completeComponentTypeEntityName_5103Parser = createCompleteComponentTypeEntityName_5103Parser();
		}
		return completeComponentTypeEntityName_5103Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCompleteComponentTypeEntityName_5103Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser providesComponentTypeEntityName_5104Parser;

	/**
	 * @generated
	 */
	private IParser getProvidesComponentTypeEntityName_5104Parser() {
		if (providesComponentTypeEntityName_5104Parser == null) {
			providesComponentTypeEntityName_5104Parser = createProvidesComponentTypeEntityName_5104Parser();
		}
		return providesComponentTypeEntityName_5104Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProvidesComponentTypeEntityName_5104Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser compositeComponentEntityName_5105Parser;

	/**
	 * @generated
	 */
	private IParser getCompositeComponentEntityName_5105Parser() {
		if (compositeComponentEntityName_5105Parser == null) {
			compositeComponentEntityName_5105Parser = createCompositeComponentEntityName_5105Parser();
		}
		return compositeComponentEntityName_5105Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCompositeComponentEntityName_5105Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser signature_3101Parser;

	/**
	 * @generated
	 */
	private IParser getSignature_3101Parser() {
		if (signature_3101Parser == null) {
			signature_3101Parser = createSignature_3101Parser();
		}
		return signature_3101Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSignature_3101Parser() {
		EAttribute[] features = new EAttribute[] { RepositoryPackage.eINSTANCE
				.getSignature_ServiceName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceDemandingSEFF_3102Parser;

	/**
	 * @generated
	 */
	private IParser getResourceDemandingSEFF_3102Parser() {
		if (resourceDemandingSEFF_3102Parser == null) {
			resourceDemandingSEFF_3102Parser = createResourceDemandingSEFF_3102Parser();
		}
		return resourceDemandingSEFF_3102Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceDemandingSEFF_3102Parser() {
		EAttribute[] features = new EAttribute[] { SeffPackage.eINSTANCE
				.getServiceEffectSpecification_SeffTypeID(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser passiveResource_3103Parser;

	/**
	 * @generated
	 */
	private IParser getPassiveResource_3103Parser() {
		if (passiveResource_3103Parser == null) {
			passiveResource_3103Parser = createPassiveResource_3103Parser();
		}
		return passiveResource_3103Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPassiveResource_3103Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser variableCharacterisation_3105Parser;

	/**
	 * @generated
	 */
	private IParser getVariableCharacterisation_3105Parser() {
		if (variableCharacterisation_3105Parser == null) {
			variableCharacterisation_3105Parser = createVariableCharacterisation_3105Parser();
		}
		return variableCharacterisation_3105Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createVariableCharacterisation_3105Parser() {
		EAttribute[] features = new EAttribute[] { ParameterPackage.eINSTANCE
				.getVariableCharacterisation_Type(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case InterfaceEntityNameEditPart.VISUAL_ID:
			return getInterfaceEntityName_5101Parser();
		case BasicComponentEntityNameEditPart.VISUAL_ID:
			return getBasicComponentEntityName_5102Parser();
		case CompositeComponentEntityNameEditPart.VISUAL_ID:
			return getCompositeComponentEntityName_5105Parser();
		case CompleteComponentTypeEntityNameEditPart.VISUAL_ID:
			return getCompleteComponentTypeEntityName_5103Parser();
		case ProvidesComponentTypeEntityNameEditPart.VISUAL_ID:
			return getProvidesComponentTypeEntityName_5104Parser();
		case SignatureEditPart.VISUAL_ID:
			return getSignature_3101Parser();
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getResourceDemandingSEFF_3102Parser();
		case PassiveResourceEditPart.VISUAL_ID:
			return getPassiveResource_3103Parser();
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3105Parser();
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

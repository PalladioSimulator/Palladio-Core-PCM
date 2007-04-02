/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
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
	private IParser signatureSignature_3101Parser;

	/**
	 * @generated
	 */
	private IParser getSignatureSignature_3101Parser() {
		if (signatureSignature_3101Parser == null) {
			signatureSignature_3101Parser = createSignatureSignature_3101Parser();
		}
		return signatureSignature_3101Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSignatureSignature_3101Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				RepositoryPackage.eINSTANCE.getSignature_ServiceName());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceDemandingSEFFResourceDemandingSEFF_3102Parser;

	/**
	 * @generated
	 */
	private IParser getResourceDemandingSEFFResourceDemandingSEFF_3102Parser() {
		if (resourceDemandingSEFFResourceDemandingSEFF_3102Parser == null) {
			resourceDemandingSEFFResourceDemandingSEFF_3102Parser = createResourceDemandingSEFFResourceDemandingSEFF_3102Parser();
		}
		return resourceDemandingSEFFResourceDemandingSEFF_3102Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceDemandingSEFFResourceDemandingSEFF_3102Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				SeffPackage.eINSTANCE
						.getServiceEffectSpecification_SeffTypeID());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceInterfaceEntityName_5101Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceInterfaceEntityName_5101Parser() {
		if (interfaceInterfaceEntityName_5101Parser == null) {
			interfaceInterfaceEntityName_5101Parser = createInterfaceInterfaceEntityName_5101Parser();
		}
		return interfaceInterfaceEntityName_5101Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceInterfaceEntityName_5101Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser basicComponentBasicComponentEntityName_5102Parser;

	/**
	 * @generated
	 */
	private IParser getBasicComponentBasicComponentEntityName_5102Parser() {
		if (basicComponentBasicComponentEntityName_5102Parser == null) {
			basicComponentBasicComponentEntityName_5102Parser = createBasicComponentBasicComponentEntityName_5102Parser();
		}
		return basicComponentBasicComponentEntityName_5102Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBasicComponentBasicComponentEntityName_5102Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser completeComponentTypeCompleteComponentTypeEntityName_5103Parser;

	/**
	 * @generated
	 */
	private IParser getCompleteComponentTypeCompleteComponentTypeEntityName_5103Parser() {
		if (completeComponentTypeCompleteComponentTypeEntityName_5103Parser == null) {
			completeComponentTypeCompleteComponentTypeEntityName_5103Parser = createCompleteComponentTypeCompleteComponentTypeEntityName_5103Parser();
		}
		return completeComponentTypeCompleteComponentTypeEntityName_5103Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCompleteComponentTypeCompleteComponentTypeEntityName_5103Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser providesComponentTypeProvidesComponentTypeEntityName_5104Parser;

	/**
	 * @generated
	 */
	private IParser getProvidesComponentTypeProvidesComponentTypeEntityName_5104Parser() {
		if (providesComponentTypeProvidesComponentTypeEntityName_5104Parser == null) {
			providesComponentTypeProvidesComponentTypeEntityName_5104Parser = createProvidesComponentTypeProvidesComponentTypeEntityName_5104Parser();
		}
		return providesComponentTypeProvidesComponentTypeEntityName_5104Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProvidesComponentTypeProvidesComponentTypeEntityName_5104Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SignatureEditPart.VISUAL_ID:
			return getSignatureSignature_3101Parser();
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getResourceDemandingSEFFResourceDemandingSEFF_3102Parser();
		case InterfaceEntityNameEditPart.VISUAL_ID:
			return getInterfaceInterfaceEntityName_5101Parser();
		case BasicComponentEntityNameEditPart.VISUAL_ID:
			return getBasicComponentBasicComponentEntityName_5102Parser();
		case CompleteComponentTypeEntityNameEditPart.VISUAL_ID:
			return getCompleteComponentTypeCompleteComponentTypeEntityName_5103Parser();
		case ProvidesComponentTypeEntityNameEditPart.VISUAL_ID:
			return getProvidesComponentTypeProvidesComponentTypeEntityName_5104Parser();
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

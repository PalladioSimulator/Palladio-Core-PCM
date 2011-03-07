/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
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
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PcmVisualIDRegistry;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class PcmParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser signatureSignature_2001Parser;

	/**
	 * @generated
	 */
	private IParser getSignatureSignature_2001Parser() {
		if (signatureSignature_2001Parser == null) {
			signatureSignature_2001Parser = createSignatureSignature_2001Parser();
		}
		return signatureSignature_2001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSignatureSignature_2001Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				RepositoryPackage.eINSTANCE.getSignature()
						.getEStructuralFeature("serviceName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceDemandingSEFFResourceDemandingSEFF_2002Parser;

	/**
	 * @generated
	 */
	private IParser getResourceDemandingSEFFResourceDemandingSEFF_2002Parser() {
		if (resourceDemandingSEFFResourceDemandingSEFF_2002Parser == null) {
			resourceDemandingSEFFResourceDemandingSEFF_2002Parser = createResourceDemandingSEFFResourceDemandingSEFF_2002Parser();
		}
		return resourceDemandingSEFFResourceDemandingSEFF_2002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceDemandingSEFFResourceDemandingSEFF_2002Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				SeffPackage.eINSTANCE.getServiceEffectSpecification()
						.getEStructuralFeature("seffTypeID")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceInterfaceEntityName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceInterfaceEntityName_4001Parser() {
		if (interfaceInterfaceEntityName_4001Parser == null) {
			interfaceInterfaceEntityName_4001Parser = createInterfaceInterfaceEntityName_4001Parser();
		}
		return interfaceInterfaceEntityName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceInterfaceEntityName_4001Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser basicComponentBasicComponentEntityName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getBasicComponentBasicComponentEntityName_4002Parser() {
		if (basicComponentBasicComponentEntityName_4002Parser == null) {
			basicComponentBasicComponentEntityName_4002Parser = createBasicComponentBasicComponentEntityName_4002Parser();
		}
		return basicComponentBasicComponentEntityName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBasicComponentBasicComponentEntityName_4002Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SignatureEditPart.VISUAL_ID:
			return getSignatureSignature_2001Parser();
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getResourceDemandingSEFFResourceDemandingSEFF_2002Parser();
		case InterfaceEntityNameEditPart.VISUAL_ID:
			return getInterfaceInterfaceEntityName_4001Parser();
		case BasicComponentEntityNameEditPart.VISUAL_ID:
			return getBasicComponentBasicComponentEntityName_4002Parser();
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

/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser allocationContextAllocationContextEntityName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getAllocationContextAllocationContextEntityName_5001Parser() {
		if (allocationContextAllocationContextEntityName_5001Parser == null) {
			allocationContextAllocationContextEntityName_5001Parser = createAllocationContextAllocationContextEntityName_5001Parser();
		}
		return allocationContextAllocationContextEntityName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAllocationContextAllocationContextEntityName_5001Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceContainerResourceContainerEntityName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getResourceContainerResourceContainerEntityName_5003Parser() {
		if (resourceContainerResourceContainerEntityName_5003Parser == null) {
			resourceContainerResourceContainerEntityName_5003Parser = createResourceContainerResourceContainerEntityName_5003Parser();
		}
		return resourceContainerResourceContainerEntityName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceContainerResourceContainerEntityName_5003Parser() {
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
		case AllocationContextEntityNameEditPart.VISUAL_ID:
			return getAllocationContextAllocationContextEntityName_5001Parser();
		case ResourceContainerEntityNameEditPart.VISUAL_ID:
			return getResourceContainerResourceContainerEntityName_5003Parser();
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

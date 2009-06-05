/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

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

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart;

import de.uka.ipd.sdq.pcm.gmf.allocation.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser resourceContainerEntityName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getResourceContainerEntityName_5003Parser() {
		if (resourceContainerEntityName_5003Parser == null) {
			resourceContainerEntityName_5003Parser = createResourceContainerEntityName_5003Parser();
		}
		return resourceContainerEntityName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceContainerEntityName_5003Parser() {
		EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser allocationContextEntityName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getAllocationContextEntityName_5001Parser() {
		if (allocationContextEntityName_5001Parser == null) {
			allocationContextEntityName_5001Parser = createAllocationContextEntityName_5001Parser();
		}
		return allocationContextEntityName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAllocationContextEntityName_5001Parser() {
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
		case ResourceContainerEntityNameEditPart.VISUAL_ID:
			return getResourceContainerEntityName_5003Parser();
		case AllocationContextEntityNameEditPart.VISUAL_ID:
			return getAllocationContextEntityName_5001Parser();
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

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}
}

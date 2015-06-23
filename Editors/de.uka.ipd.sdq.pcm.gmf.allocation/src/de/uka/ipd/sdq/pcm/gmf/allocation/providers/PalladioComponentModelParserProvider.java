/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends org.eclipse.gmf.runtime.common.core.service.AbstractProvider implements org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider {
	
	
	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.common.ui.services.parser.IParser resourceContainerEntityName_5008Parser;

	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.common.ui.services.parser.IParser getResourceContainerEntityName_5008Parser() {
		if (resourceContainerEntityName_5008Parser == null) {
						org.eclipse.emf.ecore.EAttribute[] features = new org.eclipse.emf.ecore.EAttribute[] {
				de.uka.ipd.sdq.pcm.core.entity.EntityPackage.eINSTANCE.getNamedElement_EntityName()
			};
				de.uka.ipd.sdq.pcm.gmf.allocation.parsers.MessageFormatParser parser = new de.uka.ipd.sdq.pcm.gmf.allocation.parsers.MessageFormatParser(features);
								resourceContainerEntityName_5008Parser = parser;
		}
		return resourceContainerEntityName_5008Parser;
	}


	
	
	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.common.ui.services.parser.IParser allocationContextEntityName_5006Parser;

	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.common.ui.services.parser.IParser getAllocationContextEntityName_5006Parser() {
		if (allocationContextEntityName_5006Parser == null) {
						org.eclipse.emf.ecore.EAttribute[] features = new org.eclipse.emf.ecore.EAttribute[] {
				de.uka.ipd.sdq.pcm.core.entity.EntityPackage.eINSTANCE.getNamedElement_EntityName()
			};
				de.uka.ipd.sdq.pcm.gmf.allocation.parsers.MessageFormatParser parser = new de.uka.ipd.sdq.pcm.gmf.allocation.parsers.MessageFormatParser(features);
								allocationContextEntityName_5006Parser = parser;
		}
		return allocationContextEntityName_5006Parser;
	}


	

		/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.ui.services.parser.IParser getParser(int visualID) {
		switch (visualID) {
				case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart.VISUAL_ID: return getResourceContainerEntityName_5008Parser();
				case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart.VISUAL_ID: return getAllocationContextEntityName_5006Parser();
				}
		return null;
	}
		/**
 * Utility method that consults ParserService
 * @generated
 */
	public static org.eclipse.gmf.runtime.common.ui.services.parser.IParser getParser(org.eclipse.gmf.runtime.emf.type.core.IElementType type, org.eclipse.emf.ecore.EObject object, String parserHint) {
		return org.eclipse.gmf.runtime.common.ui.services.parser.ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}
		/**
 * @generated
 */
	public org.eclipse.gmf.runtime.common.ui.services.parser.IParser getParser(
			org.eclipse.core.runtime.IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(vid));
		}
		org.eclipse.gmf.runtime.notation.View view =
				(org.eclipse.gmf.runtime.notation.View) hint.getAdapter(org.eclipse.gmf.runtime.notation.View.class);
		if (view != null) {
			return getParser(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

		/**
 * @generated
 */
	public boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {
		if (operation instanceof org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation) {
			org.eclipse.core.runtime.IAdaptable hint =
					((org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation) operation).getHint();
			if (de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

		/**
 * @generated
 */
	private static class HintAdapter extends org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter {

		/**
 * @generated
 */
		private final org.eclipse.gmf.runtime.emf.type.core.IElementType elementType;

		/**
 * @generated
 */
		public HintAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType type,
				org.eclipse.emf.ecore.EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
 * @generated
 */
		public Object getAdapter(Class adapter) {
			if (org.eclipse.gmf.runtime.emf.type.core.IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

	}

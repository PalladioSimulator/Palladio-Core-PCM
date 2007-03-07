package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PcmVisualIDRegistry;

/**
 * @generated
 */
public class PcmParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser allocationContextAllocationContextEntityName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getAllocationContextAllocationContextEntityName_4001Parser() {
		if (allocationContextAllocationContextEntityName_4001Parser == null) {
			allocationContextAllocationContextEntityName_4001Parser = createAllocationContextAllocationContextEntityName_4001Parser();
		}
		return allocationContextAllocationContextEntityName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAllocationContextAllocationContextEntityName_4001Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceContainerResourceContainerEntityName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getResourceContainerResourceContainerEntityName_4002Parser() {
		if (resourceContainerResourceContainerEntityName_4002Parser == null) {
			resourceContainerResourceContainerEntityName_4002Parser = createResourceContainerResourceContainerEntityName_4002Parser();
		}
		return resourceContainerResourceContainerEntityName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceContainerResourceContainerEntityName_4002Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser allocationContextAllocationContextEntityName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getAllocationContextAllocationContextEntityName_4003Parser() {
		if (allocationContextAllocationContextEntityName_4003Parser == null) {
			allocationContextAllocationContextEntityName_4003Parser = createAllocationContextAllocationContextEntityName_4003Parser();
		}
		return allocationContextAllocationContextEntityName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAllocationContextAllocationContextEntityName_4003Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement()
						.getEStructuralFeature("entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case AllocationContextEntityNameEditPart.VISUAL_ID:
			return getAllocationContextAllocationContextEntityName_4001Parser();
		case ResourceContainerEntityNameEditPart.VISUAL_ID:
			return getResourceContainerResourceContainerEntityName_4002Parser();
		case AllocationContextEntityName2EditPart.VISUAL_ID:
			return getAllocationContextAllocationContextEntityName_4003Parser();
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

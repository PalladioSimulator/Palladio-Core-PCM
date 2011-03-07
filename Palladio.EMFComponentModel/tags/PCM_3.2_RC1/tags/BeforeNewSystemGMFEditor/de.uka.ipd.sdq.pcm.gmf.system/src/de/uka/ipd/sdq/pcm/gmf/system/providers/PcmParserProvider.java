/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemProvidedRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemRequiredRoleEntityNameEditPart;

import de.uka.ipd.sdq.pcm.gmf.system.part.PcmVisualIDRegistry;

/**
 * @generated
 */
public class PcmParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser assemblyContextAssemblyContextEntityName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getAssemblyContextAssemblyContextEntityName_4003Parser() {
		if (assemblyContextAssemblyContextEntityName_4003Parser == null) {
			assemblyContextAssemblyContextEntityName_4003Parser = createAssemblyContextAssemblyContextEntityName_4003Parser();
		}
		return assemblyContextAssemblyContextEntityName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssemblyContextAssemblyContextEntityName_4003Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser systemProvidedRoleSystemProvidedRoleEntityName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getSystemProvidedRoleSystemProvidedRoleEntityName_4004Parser() {
		if (systemProvidedRoleSystemProvidedRoleEntityName_4004Parser == null) {
			systemProvidedRoleSystemProvidedRoleEntityName_4004Parser = createSystemProvidedRoleSystemProvidedRoleEntityName_4004Parser();
		}
		return systemProvidedRoleSystemProvidedRoleEntityName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSystemProvidedRoleSystemProvidedRoleEntityName_4004Parser() {
		PcmStructuralFeatureParser parser = new PcmStructuralFeatureParser(
				EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(
						"entityName")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser systemRequiredRoleSystemRequiredRoleEntityName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getSystemRequiredRoleSystemRequiredRoleEntityName_4005Parser() {
		if (systemRequiredRoleSystemRequiredRoleEntityName_4005Parser == null) {
			systemRequiredRoleSystemRequiredRoleEntityName_4005Parser = createSystemRequiredRoleSystemRequiredRoleEntityName_4005Parser();
		}
		return systemRequiredRoleSystemRequiredRoleEntityName_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSystemRequiredRoleSystemRequiredRoleEntityName_4005Parser() {
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
		case AssemblyContextEntityNameEditPart.VISUAL_ID:
			return getAssemblyContextAssemblyContextEntityName_4003Parser();
		case SystemProvidedRoleEntityNameEditPart.VISUAL_ID:
			return getSystemProvidedRoleSystemProvidedRoleEntityName_4004Parser();
		case SystemRequiredRoleEntityNameEditPart.VISUAL_ID:
			return getSystemRequiredRoleSystemRequiredRoleEntityName_4005Parser();
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

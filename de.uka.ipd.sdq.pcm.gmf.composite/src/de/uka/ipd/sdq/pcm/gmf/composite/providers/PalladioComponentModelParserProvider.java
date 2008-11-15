/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEntityNameEditPart;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser assemblyContextAssemblyContextEntityName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getAssemblyContextAssemblyContextEntityName_5004Parser() {
		if (assemblyContextAssemblyContextEntityName_5004Parser == null) {
			assemblyContextAssemblyContextEntityName_5004Parser = createAssemblyContextAssemblyContextEntityName_5004Parser();
		}
		return assemblyContextAssemblyContextEntityName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssemblyContextAssemblyContextEntityName_5004Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser providedRoleProvidedRoleEntityName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getProvidedRoleProvidedRoleEntityName_5001Parser() {
		if (providedRoleProvidedRoleEntityName_5001Parser == null) {
			providedRoleProvidedRoleEntityName_5001Parser = createProvidedRoleProvidedRoleEntityName_5001Parser();
		}
		return providedRoleProvidedRoleEntityName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProvidedRoleProvidedRoleEntityName_5001Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser providedRoleProvidedRoleEntityName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getProvidedRoleProvidedRoleEntityName_5003Parser() {
		if (providedRoleProvidedRoleEntityName_5003Parser == null) {
			providedRoleProvidedRoleEntityName_5003Parser = createProvidedRoleProvidedRoleEntityName_5003Parser();
		}
		return providedRoleProvidedRoleEntityName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProvidedRoleProvidedRoleEntityName_5003Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser requiredRoleRequiredRoleEntityName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getRequiredRoleRequiredRoleEntityName_5006Parser() {
		if (requiredRoleRequiredRoleEntityName_5006Parser == null) {
			requiredRoleRequiredRoleEntityName_5006Parser = createRequiredRoleRequiredRoleEntityName_5006Parser();
		}
		return requiredRoleRequiredRoleEntityName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRequiredRoleRequiredRoleEntityName_5006Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser requiredRoleRequiredRoleEntityName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getRequiredRoleRequiredRoleEntityName_5005Parser() {
		if (requiredRoleRequiredRoleEntityName_5005Parser == null) {
			requiredRoleRequiredRoleEntityName_5005Parser = createRequiredRoleRequiredRoleEntityName_5005Parser();
		}
		return requiredRoleRequiredRoleEntityName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRequiredRoleRequiredRoleEntityName_5005Parser() {
		PalladioComponentModelStructuralFeatureParser parser = new PalladioComponentModelStructuralFeatureParser(
				EntityPackage.eINSTANCE.getNamedElement_EntityName());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser composedProvidingRequiringEntityComposedProvidingRequiringEntityEntityName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getComposedProvidingRequiringEntityComposedProvidingRequiringEntityEntityName_5002Parser() {
		if (composedProvidingRequiringEntityComposedProvidingRequiringEntityEntityName_5002Parser == null) {
			composedProvidingRequiringEntityComposedProvidingRequiringEntityEntityName_5002Parser = createComposedProvidingRequiringEntityComposedProvidingRequiringEntityEntityName_5002Parser();
		}
		return composedProvidingRequiringEntityComposedProvidingRequiringEntityEntityName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createComposedProvidingRequiringEntityComposedProvidingRequiringEntityEntityName_5002Parser() {
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
		case AssemblyContextEntityNameEditPart.VISUAL_ID:
			return getAssemblyContextAssemblyContextEntityName_5004Parser();
		case ProvidedRoleEntityNameEditPart.VISUAL_ID:
			return getProvidedRoleProvidedRoleEntityName_5001Parser();
		case RequiredRoleEntityNameEditPart.VISUAL_ID:
			return getRequiredRoleRequiredRoleEntityName_5005Parser();
		case ProvidedRoleEntityName2EditPart.VISUAL_ID:
			return getProvidedRoleProvidedRoleEntityName_5003Parser();
		case RequiredRoleEntityName2EditPart.VISUAL_ID:
			return getRequiredRoleRequiredRoleEntityName_5006Parser();
		case ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID:
			return getComposedProvidingRequiringEntityComposedProvidingRequiringEntityEntityName_5002Parser();
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

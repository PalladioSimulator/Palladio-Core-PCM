package de.uka.ipd.sdq.dialogs.datatype;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TableViewer;

import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.Repository;

/**
 * @author roman
 * The class is an object repository. An access on stored objects of different places makes possible.
 */
public class DialogRepository {
	
	// TransaktionEditingDomain ID
	public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain";

	// Srt the current in table selected object
	private static EObject selectedEObject;

	// Set the current resource, which edit to are selected.
	private static Repository editedRepository;

	// Created CompositeDataType in dialog PalladioCreateDataType
	private static CompositeDataType newCompositeDataType;

	// All TableViewer, which are called when using of dialogue.
	private static TableViewer operationsViewer;
	private static TableViewer parametersViewer;
	private static TableViewer declarationViewer;

	/**
	 * @return the viewer
	 */
	public static TableViewer getOperationsViewer() {
		return operationsViewer;
	}

	/**
	 * @param viewer
	 *            the viewer to set
	 */
	public static void setOperationsViewer(TableViewer viewer) {
		DialogRepository.operationsViewer = viewer;
	}

	/**
	 * @return the parametersViewer
	 */
	public static TableViewer getParametersViewer() {
		return parametersViewer;
	}

	/**
	 * @param parametersViewer
	 *            the parametersViewer to set
	 */
	public static void setParametersViewer(TableViewer parametersViewer) {
		DialogRepository.parametersViewer = parametersViewer;
	}

	
	/**
	 * @return the editedRepository
	 */
	public static Repository getEditedRepository() {
		return editedRepository;
	}

	/**
	 * @param editedRepository
	 *            the editedRepository to set
	 */
	public static void setEditedRepository(Repository editedRepository) {
		DialogRepository.editedRepository = editedRepository;
	}

	/**
	 * @return the newCompositeDataType
	 */
	public static CompositeDataType getNewCompositeDataType() {
		return newCompositeDataType;
	}

	/**
	 * @param newCompositeDataType
	 *            the newCompositeDataType to set
	 */
	public static void setNewCompositeDataType(
			CompositeDataType newCompositeDataType) {
		DialogRepository.newCompositeDataType = newCompositeDataType;
	}

	/**
	 * @return the declarationViewer
	 */
	public static TableViewer getDeclarationViewer() {
		return declarationViewer;
	}

	/**
	 * @param declarationViewer
	 *            the declarationViewer to set
	 */
	public static void setDeclarationViewer(TableViewer declarationViewer) {
		DialogRepository.declarationViewer = declarationViewer;
	}

	/**
	 * @return the selectedEObject
	 */
	public static EObject getSelectedEObject() {
		return selectedEObject;
	}

	/**
	 * @param selectedEObject
	 *            the selectedEObject to set
	 */
	public static void setSelectedEObject(EObject selectedEObject) {
		DialogRepository.selectedEObject = selectedEObject;
	}
}

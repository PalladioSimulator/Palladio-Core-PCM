package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.jface.viewers.TableViewer;

import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * @author roman
 * 
 * A Containerklass for the administration of images, the columns and
 * decorierten AdapterFactories for each table, which is used with OperationsTab.
 */
public class OperationsTabRepository {

	// Set selected Signature in the tab
	private static Signature editedSignature;
	
	// Operations TableViewer
	private static TableViewer operationsViewer;
	
	/**
	 * @return the viewer
	 */
	public static TableViewer getOperationsViewer() {
		return operationsViewer;
	}

	/**
	 * @param viewer the viewer to set
	 */
	public static void setOperationsViewer(TableViewer viewer) {
		OperationsTabRepository.operationsViewer = viewer;
	}

	/**
	 * @return the editedSignature
	 */
	public static Signature getEditedSignature() {
		return editedSignature;
	}

	/**
	 * @param editedSignature the editedSignature to set
	 */
	public static void setEditedSignature(Signature editedSignature) {
		OperationsTabRepository.editedSignature = editedSignature;
	}
}

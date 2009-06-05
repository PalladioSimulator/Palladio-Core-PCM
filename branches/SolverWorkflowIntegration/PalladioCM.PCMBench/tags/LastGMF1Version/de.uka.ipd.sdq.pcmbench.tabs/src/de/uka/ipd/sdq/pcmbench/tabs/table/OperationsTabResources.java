package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.TableViewer;

import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.tabs.PCMBenchTabsActivator;

/**
 * @author roman
 * 
 * A Containerklass for the administration of images, the columns and
 * decorierten AdapterFactories for each table, which is used with OperationsTab.
 */
public class OperationsTabResources {

	public static String PLUGIN_ID = PCMBenchTabsActivator.PLUGIN_ID;
	
	/**
	 * Decorated adapterFactory
	 */
	private static AdapterFactory operationsDecoratedFactory;
	private static AdapterFactory attributeDecoratedFactory;
	private static AdapterFactory declarationDecoratedFactory;
	
	// TODO
	private static Signature editedSignature;
	private static Parameter editedParameter;
	private static EObject selectedEObject;
	
	// Set the current resource, which edit to are selected.
	private static Repository editedRepository;
	
	// Created CompositeDataType in dialog PalladioCreateDataType
	private static CompositeDataType newCompositeDataType;
	
	/**
	 * Operations TableViewer
	 */
	private static TableViewer operationsViewer;
	private static TableViewer parametersViewer;
	private static TableViewer declarationViewer;
	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String ADD_SIGN 	= "add_sign";
	public static final String DELETE_SIGN  = "delete_sign";
	public static final String ADD_PARAM 	= "add_param";
	public static final String DELETE_PARAM = "delete_param";
	
	// For the toolbar images
	public static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 

	static {
		String iconPath = "icons/";
		
		imageRegistry.put(ADD_SIGN,
				 getImageDescriptor(iconPath + ADD_SIGN + ".gif")
		);
		
		imageRegistry.put(DELETE_SIGN,
				 getImageDescriptor(iconPath + DELETE_SIGN + ".gif")
				);
		
		imageRegistry.put(ADD_PARAM,
				 getImageDescriptor(iconPath + ADD_PARAM + ".gif")
		);
		
		imageRegistry.put(DELETE_PARAM,
				 getImageDescriptor(iconPath + DELETE_PARAM + ".gif")
				);
	}
	
	/**
	 *@param imageFilePath the relative to the root of the plug-in; the path must be legal
     *@return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return PCMBenchTabsActivator.imageDescriptorFromPlugin(OperationsTabResources.PLUGIN_ID, imageFilePath);
	}

	
	/**
	 * Columns of a table, which is used into ParameterEditDialog
	 */
	
	public final static String ATTRIBUTE_ICON_COLUMN 	= "";
	public final static String CONTEXT_COLUMN			= "Context";
	public final static String TYPE_COLUMN 				= "Type";
	public final static String NAME_COLUMN 				= "Name";
	
	//	 Set column names of Tabele
	private static String[] attributeTableColumn = new String[] {  ATTRIBUTE_ICON_COLUMN,CONTEXT_COLUMN,
			NAME_COLUMN, TYPE_COLUMN};

	public static String[] getAttributeTableColumn() {
		return attributeTableColumn;
	}
	
	/**
	 * Columns of a table, which is used into operations table
	 */
	
	public final static String OPERATIONS_ICON_COLUMN	= "";
	public final static String OWNEDPARAMETER_COLUMN 	= "OwnedParameters";
	public final static String RETURNTYPE_COLUMN 		= "ReturnType";
	public final static String SERVICENAME_COLUMN 		= "ServiceName";
	public final static String EXEPTIONTYPE_COLUM		= "ExeptionType";
	
	//	 Set column names of Tabele
	private static String[] operationsTableColumn = new String[] { OPERATIONS_ICON_COLUMN,RETURNTYPE_COLUMN,
			SERVICENAME_COLUMN, OWNEDPARAMETER_COLUMN, EXEPTIONTYPE_COLUM };

	public static String[] getOperationsTableColumn() {
		return operationsTableColumn;
	}

	/**
	 * @return the operationsDecoratedFactory
	 */
	public static AdapterFactory getOperationsDecoratedFactory() {
		return operationsDecoratedFactory;
	}

	/**
	 * @param operationsDecoratedFactory the operationsDecoratedFactory to set
	 */
	public static void setOperationsDecoratedFactory(
			AdapterFactory operationsDecoratedFactory) {
		OperationsTabResources.operationsDecoratedFactory = operationsDecoratedFactory;
	}

	/**
	 * @return the attributeDecoratedFactory
	 */
	public static AdapterFactory getAttributeDecoratedFactory() {
		return attributeDecoratedFactory;
	}

	/**
	 * @param attributeDecoratedFactory the attributeDecoratedFactory to set
	 */
	public static void setAttributeDecoratedFactory(
			AdapterFactory attributeDecoratedFactory) {
		OperationsTabResources.attributeDecoratedFactory = attributeDecoratedFactory;
	}

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
		OperationsTabResources.operationsViewer = viewer;
	}

	/**
	 * @return the parametersViewer
	 */
	public static TableViewer getParametersViewer() {
		return parametersViewer;
	}

	/**
	 * @param parametersViewer the parametersViewer to set
	 */
	public static void setParametersViewer(TableViewer parametersViewer) {
		OperationsTabResources.parametersViewer = parametersViewer;
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
		OperationsTabResources.editedSignature = editedSignature;
	}

	/**
	 * @return the editedParameter
	 */
	public static Parameter getEditedParameter() {
		return editedParameter;
	}

	/**
	 * @param editedParameter the editedParameter to set
	 */
	public static void setEditedParameter(Parameter editedParameter) {
		OperationsTabResources.editedParameter = editedParameter;
	}

	/**
	 * @return the editedRepository
	 */
	public static Repository getEditedRepository() {
		return editedRepository;
	}

	/**
	 * @param editedRepository the editedRepository to set
	 */
	public static void setEditedRepository(Repository editedRepository) {
		OperationsTabResources.editedRepository = editedRepository;
	}

	/**
	 * @return the newCompositeDataType
	 */
	public static CompositeDataType getNewCompositeDataType() {
		return newCompositeDataType;
	}

	/**
	 * @param newCompositeDataType the newCompositeDataType to set
	 */
	public static void setNewCompositeDataType(
			CompositeDataType newCompositeDataType) {
		OperationsTabResources.newCompositeDataType = newCompositeDataType;
	}

	/**
	 * @return the declarationDecoratedFactory
	 */
	public static AdapterFactory getDeclarationDecoratedFactory() {
		return declarationDecoratedFactory;
	}

	/**
	 * @param declarationDecoratedFactory the declarationDecoratedFactory to set
	 */
	public static void setDeclarationDecoratedFactory(
			AdapterFactory declarationDecoratedFactory) {
		OperationsTabResources.declarationDecoratedFactory = declarationDecoratedFactory;
	}

	/**
	 * @return the declarationViewer
	 */
	public static TableViewer getDeclarationViewer() {
		return declarationViewer;
	}

	/**
	 * @param declarationViewer the declarationViewer to set
	 */
	public static void setDeclarationViewer(TableViewer declarationViewer) {
		OperationsTabResources.declarationViewer = declarationViewer;
	}

	/**
	 * @return the selectedEObject
	 */
	public static EObject getSelectedEObject() {
		return selectedEObject;
	}

	/**
	 * @param selectedEObject the selectedEObject to set
	 */
	public static void setSelectedEObject(EObject selectedEObject) {
		OperationsTabResources.selectedEObject = selectedEObject;
	}

}

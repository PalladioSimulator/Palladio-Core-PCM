package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Arrays;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import de.uka.ipd.sdq.pcmbench.tabs.PCMBenchTabsActivator;

/**
 * @author admin
 *
 */
public class TabResources {

	public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain";
	
	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected static TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain(EDITING_DOMAIN_ID);
	
	public static String PLUGIN_ID = PCMBenchTabsActivator.PLUGIN_ID;

	//	 Names of images used to represent actions in ToolBar
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
		return PCMBenchTabsActivator.imageDescriptorFromPlugin(TabResources.PLUGIN_ID, imageFilePath);
	}

	
	/**
	 * attribute table resource
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
	 * operations table resourcen
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
	 * @return the editingDomain
	 */
	public static TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}
}

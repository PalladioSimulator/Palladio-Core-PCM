package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Arrays;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcmbench.tabs.PCMBenchTabsActivator;

public class OperationsPropertySectionTable {
	
	private TableViewer tableViewer;
	private Table table;
	private ToolBar toolBar;
	private ToolItem addItem, deleteItem;

	public static final int EXCEPTIONS_COLUMN_INDEX = 4;
	public static final int SIGNATURENAME_COLUMN_INDEX = 2;
	public static final int RETURNTYPE_COLUMN_INDEX = 1;
	public static final int PARAMETER_COLUMN_INDEX = 3;
	public static final int ICON_COLUMN_INDEX = 0;
	
	final String OWNEDPARAMETER_COLUMN 		= "OwnedParameters";
	final String RETURNTYPE_COLUMN	 		= "ReturnType";
	final String SERVICENAME_COLUMN 		= "ServiceName";
	final String EXEPTIONTYPE_COLUM 		= "ExeptionType";
	

	// Set column names of Tabele
	String[] columnNames = new String[] { 
			RETURNTYPE_COLUMN,
			SERVICENAME_COLUMN,
			OWNEDPARAMETER_COLUMN,
			EXEPTIONTYPE_COLUM 		
			};
	
	private static String PLUGIN_ID = PCMBenchTabsActivator.PLUGIN_ID;

	//	 Names of images used to represent checkboxes
	public static final String ADD_IMAGE 	= "add";
	public static final String DELETE_IMAGE  = "delete";

	// For the toolbar images
	private static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 

	static {
		String iconPath = "icons/";
		
		imageRegistry.put(ADD_IMAGE,
				 getImageDescriptor(iconPath + ADD_IMAGE + ".gif")
		);
		
		imageRegistry.put(DELETE_IMAGE,
				 getImageDescriptor(iconPath + DELETE_IMAGE + ".gif")
				);
	}
	
	/**
	 *@param imageFilePath the relative to the root of the plug-in; the path must be legal
     *@return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return PCMBenchTabsActivator.imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);
	}
	
	public OperationsPropertySectionTable(Composite composite) {
		/**
		 * @See composite - de.uka.ipd.sdq.pcmbench.tabs.OperationsPropertySection#createControls(Composite, TabbedPropertySheetPage)
		 */
		this.createToolBar(composite);
		this.createTable(composite);
		this.createTableViewer();
	}
	
	public void createTable(Composite composite) {
		
		//style the style of table to construct
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | 
		SWT.FULL_SELECTION | SWT.HIDE_SELECTION;
		
		table = new Table(composite,style);
		
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(toolBar,6);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		
		table.setLayoutData(data);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		// 1st column 
		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("");
		column.setWidth(25);
		
		for(int i = 0; i < columnNames.length ; i++){ 
			
			//n-te column with task Description
			column = new TableColumn(table, SWT.LEFT,i+1);
			column.setText(columnNames[i]);
			column.setWidth(140);
		}
	}
	
	
	public void createTableViewer() {

		TextCellEditor textEditor;
		
		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);
		tableViewer.setColumnProperties(columnNames);
	
		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];

		for(int i = 1; i < columnNames.length ; i++){ 
			
			textEditor = new TextCellEditor(table);
			editors[i] = textEditor;
		}

		// Assign the cell editors to the viewer 
		tableViewer.setCellEditors(editors);
		tableViewer.setCellModifier(new CellModifierImpl(getColumnNames()));
	}    
	   
	public void createToolBar(Composite composite) {
		
		FormData fd = new FormData();
		fd.left = new FormAttachment(96, 0);
		fd.top = new FormAttachment(0, 0);
		fd.right = new FormAttachment(100, 0);
		fd.bottom = new FormAttachment(100, 0);
		
		toolBar = new ToolBar (composite, SWT.VERTICAL | SWT.FLAT | SWT.RIGHT);
		
		addItem = new ToolItem (toolBar, SWT.PUSH);
		Image addIcon = imageRegistry.get(ADD_IMAGE);
		addItem.setImage(addIcon);
				
	    deleteItem = new ToolItem (toolBar, SWT.PUSH);
	    Image deleteIcon = imageRegistry.get(DELETE_IMAGE);
	    deleteItem.setImage(deleteIcon);

		toolBar.setLayoutData(fd);
	}
	
	/**
	 * Adds the listener to the collection of listeners for ToolItems: addItem, deleteItem
	 * @param the selected one interface in the navigator
	 */
	public void setToolBarListener(Interface input){
		addItem.addSelectionListener(new AddNewSignature(input));
		deleteItem.addSelectionListener(new DeleteSignature());
	}

	public TableViewer getTableViewer() {
		return tableViewer;
	}

	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}
	
	public java.util.List getColumnNames() {
		return Arrays.asList(columnNames);
	}

}

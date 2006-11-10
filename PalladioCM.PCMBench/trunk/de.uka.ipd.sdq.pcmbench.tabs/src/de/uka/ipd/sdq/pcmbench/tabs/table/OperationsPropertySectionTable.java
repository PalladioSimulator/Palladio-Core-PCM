package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Arrays;

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
	

	// Set column names
	String[] columnNames = new String[] { 
			RETURNTYPE_COLUMN,
			SERVICENAME_COLUMN,
			OWNEDPARAMETER_COLUMN,
			EXEPTIONTYPE_COLUM 		
			};
	

	public OperationsPropertySectionTable(Composite composite) {
		this.createToolBar(composite);
		this.createTable(composite);
		this.createTableViewer();
	}

	/**
	 * @param composite
	 * @return
	 */
	public void createTable(Composite parent) {
		
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | 
		SWT.FULL_SELECTION | SWT.HIDE_SELECTION;
		
		table = new Table(parent,style);
		
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
	   
	/**
	 * @param composite
	 * @return
	 */
	public void createToolBar(Composite composite) {
		
		FormData fd = new FormData();
		fd.left = new FormAttachment(96, 0);
		fd.top = new FormAttachment(0, 0);
		fd.right = new FormAttachment(100, 0);
		fd.bottom = new FormAttachment(100, 0);
		
		toolBar = new ToolBar (composite, SWT.VERTICAL | SWT.FLAT | SWT.RIGHT);
		
		addItem = new ToolItem (toolBar, SWT.PUSH);
		//// geht noch nicht...
		//Image addIcon = new Image(composite.getDisplay(), "G:\\add.gif");
		//Image addIcon = new Image(composite.getDisplay(), "icons/add.gif");
		//addItem.setImage(addIcon);
				
	    deleteItem = new ToolItem (toolBar, SWT.PUSH);
	    // geht noch nicht...
//		Image deleteIcon = new Image(composite.getDisplay(), "G:\\delete.gif");
//		Image addIcon = new Image(composite.getDisplay(), "icons/delete.gif");
//		deleteItem.setImage(deleteIcon);

		toolBar.setLayoutData(fd);
	}
	
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

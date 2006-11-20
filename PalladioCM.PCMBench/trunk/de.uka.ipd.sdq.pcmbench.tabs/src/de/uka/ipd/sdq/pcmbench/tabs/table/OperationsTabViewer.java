package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Arrays;

import org.eclipse.jface.util.Assert;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.uka.ipd.sdq.pcm.repository.Signature;

public class OperationsTabViewer {

	private TableViewer tableViewer;

	private Table table;

	private ToolBar toolBar;

	private ToolItem addItem, deleteItem;

	public static final int ICON_COLUMN_INDEX = 0;
	public static final int RETURNTYPE_COLUMN_INDEX = 1;
	public static final int SIGNATURENAME_COLUMN_INDEX = 2;
	public static final int PARAMETER_COLUMN_INDEX = 3;
	public static final int EXCEPTIONS_COLUMN_INDEX = 4;

	final String OWNEDPARAMETER_COLUMN = "OwnedParameters";
	final String RETURNTYPE_COLUMN = "ReturnType";
	final String SERVICENAME_COLUMN = "ServiceName";
	final String EXEPTIONTYPE_COLUM = "ExeptionType";

	// Set column names of Tabele
	String[] columnNames = new String[] { RETURNTYPE_COLUMN,
			SERVICENAME_COLUMN, OWNEDPARAMETER_COLUMN, EXEPTIONTYPE_COLUM };

	public OperationsTabViewer(Composite composite) {
		/**
		 * @See composite -
		 *      de.uka.ipd.sdq.pcmbench.tabs.OperationsPropertySection#createControls(Composite,
		 *      TabbedPropertySheetPage)
		 */
		this.createToolBar(composite);
		this.createTable(composite);
		this.createTableViewer(composite);
	}

	public void createTable(Composite composite) {

		// style the style of table to construct
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		table = new Table(composite, style);

		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(toolBar, 6);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);

		table.setLayoutData(data);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// 1st column
		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("");
		column.setWidth(25);

		for (int i = 0; i < columnNames.length; i++) {

			// n-te column with task Description
			column = new TableColumn(table, SWT.LEFT, i + 1);
			column.setText(columnNames[i]);
			column.setWidth(140);
		}
	}

	public void createTableViewer(Composite composite) {

		CellEditor textEditor;

		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);
		tableViewer.setColumnProperties(columnNames);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length + 1];

		editors[RETURNTYPE_COLUMN_INDEX] = createDialogCellEditor(table, RETURNTYPE_COLUMN); 
			
		textEditor = new TextCellEditor(table);
		editors[SIGNATURENAME_COLUMN_INDEX] = textEditor;

		editors[PARAMETER_COLUMN_INDEX] = createDialogCellEditor(table, OWNEDPARAMETER_COLUMN);

		textEditor = new TextCellEditor(table);
		editors[EXCEPTIONS_COLUMN_INDEX] = textEditor;

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		tableViewer.setCellModifier(new CellModifierImpl(getColumnNames()));
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {
						Object selected;
						IStructuredSelection selection = new StructuredSelection();
						if (!event.getSelection().isEmpty()) {
							deleteItem.setEnabled(true);

							selection = (IStructuredSelection) event
									.getSelection();
							selected = selection.getFirstElement();
							Assert.isTrue(selected instanceof Signature);

							(DeleteActionListener.getSingelton())
									.setSelectedSignature((Signature) selected);

						} else
							deleteItem.setEnabled(false);
					}
				});
	}

	public void createToolBar(Composite composite) {

		FormData fd = new FormData();
		fd.left = new FormAttachment(96, 0);
		fd.top = new FormAttachment(0, 0);
		fd.right = new FormAttachment(100, 0);
		fd.bottom = new FormAttachment(100, 0);

		toolBar = new ToolBar(composite, SWT.VERTICAL | SWT.FLAT | SWT.RIGHT);

		addItem = new ToolItem(toolBar, SWT.PUSH);
		Image addIcon = TabResources.imageRegistry.get(TabResources.ADD_SIGN);
		addItem.setImage(addIcon);
		addItem.addSelectionListener(AddActionListener.getSingelton());

		deleteItem = new ToolItem(toolBar, SWT.PUSH);
		Image deleteIcon = TabResources.imageRegistry
				.get(TabResources.DELETE_SIGN);
		deleteItem.setImage(deleteIcon);
		deleteItem.setEnabled(false);
		deleteItem.addSelectionListener(DeleteActionListener.getSingelton());

		toolBar.setLayoutData(fd);
	}

	public TableViewer getTableViewer() {
		return tableViewer;
	}

	public java.util.List getColumnNames() {
		return Arrays.asList(columnNames);
	}
	
	/**
	 * The function provides a DialogCellEditor. With a pressure on the Button right
	 * in the cell an AttributeTypeDialog is opened
	 * 
	 * @param table, properties - column Name
	 * @return DialogCellEditor
	 */
	private CellEditor	createDialogCellEditor(Table table, String propertie){
		final String columnName = propertie;
		
		CellEditor cellEditor =  new DialogCellEditor(table) {
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				AttributeTypeDialog dialog = new AttributeTypeDialog(
						cellEditorWindow.getShell(), columnName);
				dialog.open();
				return null;
			}
		};
		return cellEditor;
	}
}

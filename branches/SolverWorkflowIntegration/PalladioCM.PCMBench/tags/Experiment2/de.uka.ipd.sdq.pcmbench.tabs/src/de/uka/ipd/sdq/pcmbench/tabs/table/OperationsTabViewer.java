package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.uka.ipd.sdq.dialogs.parameters.ParametersDialog;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.tabs.PCMBenchTabsImages;

public class OperationsTabViewer {

	private TableViewer tableViewer;
	private Table table;
	private ToolBar toolBar;
	private ToolItem addItem, deleteItem;
	private Signature selectedSignature;
	private String[] columnNames;
	private TransactionalEditingDomain editingDomain;
	private CellEditor[] editors;

	public static final int ICON_COLUMN_INDEX = 0;
	public static final int RETURNTYPE_COLUMN_INDEX = 1;
	public static final int SIGNATURENAME_COLUMN_INDEX = 2;
	public static final int PARAMETER_COLUMN_INDEX = 3;
	public static final int EXCEPTIONS_COLUMN_INDEX = 4;
	
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

	public OperationsTabViewer(Composite composite) {
		/**
		 * @See composite -
		 *      de.uka.ipd.sdq.pcmbench.tabs.OperationsPropertySection#createControls(Composite,
		 *      TabbedPropertySheetPage)
		 */
		columnNames = getOperationsTableColumn();

		this.createToolBar(composite);
		this.createTable(composite);
		this.createTableViewer(composite);
	}

	public void setEditingDomain(TransactionalEditingDomain editingDomain){
		this.editingDomain = editingDomain;
		((TypeDialogCellEditor)editors[RETURNTYPE_COLUMN_INDEX]).setEditingDomain(editingDomain);
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

		for (int i = 1; i < columnNames.length; i++) {

			// n-te column with task Description
			column = new TableColumn(table, SWT.LEFT, i);
			column.setText((String) columnNames[i]);
			column.setWidth(140);
		}
	}

	public void createTableViewer(Composite composite) {

		CellEditor textEditor;

		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);
		tableViewer.setColumnProperties(columnNames);

		// Create the cell editors
		editors = new CellEditor[columnNames.length];

		textEditor = new TextCellEditor(table);
		editors[SIGNATURENAME_COLUMN_INDEX] = textEditor;

		textEditor = new TextCellEditor(table);
		//editors[EXCEPTIONS_COLUMN_INDEX] = textEditor;

		editors[RETURNTYPE_COLUMN_INDEX] = new TypeDialogCellEditor(table);

		editors[PARAMETER_COLUMN_INDEX] = new DialogCellEditor(table) {
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				ParametersDialog dialog = new ParametersDialog(
						cellEditorWindow.getShell(),
						selectedSignature);
				if (dialog.open() == dialog.OK)
					tableViewer.refresh();
				return null;
			}
		};

		// Assign the cell editors to the viewe
		tableViewer.setCellEditors(editors);
		tableViewer.setCellModifier(new OperationsCellModifier());
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

							selectedSignature = (Signature) selected;

							(DeleteActionListener.getSingelton())
									.setSelectedSignature(selectedSignature);
							// TODO
							OperationsTabRepository
									.setEditedSignature(selectedSignature);

						} else
							deleteItem.setEnabled(false);
					}
				});
		// TODO
		OperationsTabRepository.setOperationsViewer(tableViewer);
	}

	public void createToolBar(Composite composite) {

		FormData fd = new FormData();
		fd.left = new FormAttachment(96, 0);
		fd.top = new FormAttachment(0, 0);
		fd.right = new FormAttachment(100, 0);
		fd.bottom = new FormAttachment(100, 0);

		toolBar = new ToolBar(composite, SWT.VERTICAL | SWT.FLAT | SWT.RIGHT);

		addItem = new ToolItem(toolBar, SWT.PUSH);
		addItem.setImage(PCMBenchTabsImages.imageRegistry
				.get(PCMBenchTabsImages.ADD_SIGN));
		addItem.addSelectionListener(AddActionListener.getSingelton());

		deleteItem = new ToolItem(toolBar, SWT.PUSH);
		deleteItem.setImage( PCMBenchTabsImages.imageRegistry
				.get(PCMBenchTabsImages.DELETE_SIGN));
		deleteItem.setEnabled(false);
		deleteItem.addSelectionListener(DeleteActionListener.getSingelton());

		toolBar.setLayoutData(fd);
	}

	public TableViewer getTableViewer() {
		return tableViewer;
	}

	/**
	 * @return the selectedSignature
	 */
	public Signature getSelectedSignature() {
		return selectedSignature;
	}

	/**
	 * @param selectedSignature
	 *            the selectedSignature to set
	 */
	public void setSelectedSignature(Signature selectedSignature) {
		this.selectedSignature = selectedSignature;
	}

}

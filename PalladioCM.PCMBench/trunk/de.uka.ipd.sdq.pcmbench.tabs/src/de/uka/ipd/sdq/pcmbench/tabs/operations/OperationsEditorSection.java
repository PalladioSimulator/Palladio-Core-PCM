package de.uka.ipd.sdq.pcmbench.tabs.operations;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;

import de.uka.ipd.sdq.pcm.dialogs.parameters.ParametersDialog;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection;

public class OperationsEditorSection extends EditorSection {
	

	/** In Viewer selected signature. */
	private Signature selectedSignature;
	/** The TableViewer cell editors. */
	private CellEditor[] editors;
	/** Define the TypeDialogCellEditor. */
	private TypeDialogCellEditor typeCellEditor;

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
	public static String[] columnNames = new String[] { OPERATIONS_ICON_COLUMN,RETURNTYPE_COLUMN,
			SERVICENAME_COLUMN, OWNEDPARAMETER_COLUMN, EXEPTIONTYPE_COLUM };

	/** Constructor */
	public OperationsEditorSection(Composite composite) {
		super(composite);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.EditorSection#createTable(org.eclipse.swt.widgets.Composite, org.eclipse.swt.widgets.ToolBar)
	 */
	@Override
	protected Table createTable(Composite composite, ToolBar toolBar) {

		// style the style of table to construct
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		Table table = new Table(composite, style);

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
		
		return table;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.EditorSection#createViewer(org.eclipse.swt.widgets.Table)
	 */
	@Override
	protected TableViewer createViewer(Table table) {

		final TableViewer viewer = new TableViewer(table);
		viewer.setUseHashlookup(true);
		viewer.setColumnProperties(columnNames);

		// Create the cell editors
		editors = new CellEditor[columnNames.length];

		CellEditor textEditor = new TextCellEditor(table);
		editors[SIGNATURENAME_COLUMN_INDEX] = textEditor;

		textEditor = new TextCellEditor(table);
		// editors[EXCEPTIONS_COLUMN_INDEX] = textEditor;

		// Set the TypeDialogCellEditor
		typeCellEditor = new TypeDialogCellEditor(viewer);
		
		editors[RETURNTYPE_COLUMN_INDEX] = typeCellEditor;

		editors[PARAMETER_COLUMN_INDEX] = new DialogCellEditor(table) {
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				ParametersDialog dialog = new ParametersDialog(cellEditorWindow
						.getShell(), selectedSignature);
				if (dialog.open() == Dialog.OK)
					viewer.refresh();
				return null;
			}
		};

		// Assign the cell editors to the viewe
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new OperationsCellModifier(viewer));
		viewer.addSelectionChangedListener(deleteActionListener);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			/* (non-Javadoc)
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();

				Object input = ((IStructuredSelection) selection)
						.getFirstElement();

				if (input instanceof Signature) {
					setSelectedSignature((Signature) input);
				} else {
					getDeleteButton().setEnabled(false);
				}
			}
		});
		
		return viewer;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createAddButtonActionListener(java.lang.Object)
	 */
	@Override
	protected SelectionListener createAddButtonActionListener(Object input) {
		return new AddActionListener((Interface) input);
	}

	/** The method set in TableViewer selected signature to 'TypeDialogCellEditor'. */
	public void setSelectedSignature(Signature selectedSignature) {
		this.selectedSignature = selectedSignature;
		this.typeCellEditor.setSignature(selectedSignature);
	}
}

package de.uka.ipd.sdq.dialogs.parameters;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IContentProvider;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.uka.ipd.sdq.dialogs.DialogsImages;
import de.uka.ipd.sdq.dialogs.datatype.DialogRepository;

/**
 * TODO
 * 
 * @author roman
 * 
 */
public class CreateEditorContents {
	// TODO
	private TableViewer viewer;
	private ToolItem addItem,deleteItem;
	private TransactionalEditingDomain editingDomain;

	public static final int ICON_COLUMN_INDEX = 0;
	public static final int CONTEXT_COLUMN_INDEX = 1;
	public static final int TYPE_COLUMN_INDEX = 2;
	public static final int NAME_COLUMN_INDEX = 3;

	/**
	 * Columns of a table, which is used into ParameterEditDialog
	 */

	public final static String ATTRIBUTE_ICON_COLUMN = "";
	public final static String CONTEXT_COLUMN = "Context";
	public final static String TYPE_COLUMN = "Type";
	public final static String NAME_COLUMN = "Name";

	// Set column names of Tabele
	private static String[] columnNames = new String[] { ATTRIBUTE_ICON_COLUMN,
			CONTEXT_COLUMN, NAME_COLUMN, TYPE_COLUMN };

	private CreateEditorContents(Composite composite, TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
		init(composite);
	}

	/**
	 * Factory Method
	 */
	public static CreateEditorContents create(Composite composite, TransactionalEditingDomain editingDomain){
		return new CreateEditorContents(composite,editingDomain);
	}
	
	
	public void setViewerContentProvider(IContentProvider contentProvider){
		viewer.setContentProvider(contentProvider);
	}
	
	public void setViewerLabelProvider(IBaseLabelProvider labelProvider) {
		viewer.setLabelProvider(labelProvider);
	}
	
	public void setViewerCellModifier(ICellModifier cellModifier){
		viewer.setCellModifier(cellModifier);
	}
	
	public void setAddButtonActionListener(SelectionListener listener){
		addItem.addSelectionListener(listener);
	}
	
	public void setDeleteButtonActionListener(SelectionListener listener){
		deleteItem.addSelectionListener(listener);
	}
	
	public void setViewerInput(Object input){
		viewer.setInput(input);
	}

	/**
	 * TODO
	 */
	public void init(Composite composite) {

		FormData fdToolBar = new FormData();
		fdToolBar.top = new FormAttachment(0, 5);
		fdToolBar.right = new FormAttachment(100, -7);
		fdToolBar.left = new FormAttachment(100, -37);
		fdToolBar.bottom = new FormAttachment(94, 0);

		final ToolBar toolBar = new ToolBar(composite, SWT.VERTICAL | SWT.NONE);
		toolBar.setLayoutData(fdToolBar);

		addItem = new ToolItem(toolBar, SWT.PUSH);
		addItem.setImage(DialogsImages.imageRegistry.get(DialogsImages.ADD));

		deleteItem = new ToolItem(toolBar, SWT.PUSH);
		deleteItem.setImage(DialogsImages.imageRegistry
				.get(DialogsImages.DELETE));
		deleteItem.setEnabled(false);

		final FormData fdTableViewer = new FormData();
		fdTableViewer.right = new FormAttachment(toolBar, -5, SWT.LEFT);
		fdTableViewer.top = new FormAttachment(0, 5);
		fdTableViewer.left = new FormAttachment(0, 5);
		fdTableViewer.bottom = new FormAttachment(94, 0);

		viewer = new TableViewer(composite, SWT.FULL_SELECTION
				| SWT.BORDER);
		Table table = viewer.getTable();
		table.setLayoutData(fdTableViewer);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		viewer.setColumnProperties(columnNames);

		/**
		 * Create the cell editors for Name, Type column
		 */
		CellEditor[] editors = new CellEditor[columnNames.length];

		editors[NAME_COLUMN_INDEX] = new TextCellEditor(table);
		editors[TYPE_COLUMN_INDEX] = new TypeDialogCellEditor(table,editingDomain);

		// Assign the cell editors to the viewer
		viewer.setCellEditors(editors);
		viewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						if (!event.getSelection().isEmpty()) {
							deleteItem.setEnabled(true);
							setSelectionsEObject(event);
						} else
							deleteItem.setEnabled(false);
					}
				});

		// Definere the table columns
		final TableColumn zeroColumn = new TableColumn(table, SWT.NONE);
		zeroColumn.setResizable(false);
		zeroColumn.setWidth(30);

		final TableColumn contextColumn = new TableColumn(table, SWT.NONE);
		contextColumn.setWidth(100);
		contextColumn.setText(CONTEXT_COLUMN);

		final TableColumn typeColumn = new TableColumn(table, SWT.NONE);
		typeColumn.setWidth(140);
		typeColumn.setText(TYPE_COLUMN);

		final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		nameColumn.setWidth(100);
		nameColumn.setText(NAME_COLUMN);

		// Set the curent viewer for OperationsTabResources
		DialogRepository.setParametersViewer(viewer);
	}

	/**
	 * @param container
	 */
	public void createSeparator(Composite composite) {

		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 5);
		formData.right = new FormAttachment(100, -7);
		formData.bottom = new FormAttachment(100, -3);
		formData.top = new FormAttachment(100, -8);

		Label separator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(formData);
	}

	/**
	 * TODO
	 * 
	 * @param IStructuredSelection
	 */
	private void setSelectionsEObject(SelectionChangedEvent event) {

		Object selected = ((IStructuredSelection) event.getSelection())
				.getFirstElement();

		Assert.isTrue(selected instanceof EObject);
		DialogRepository.setSelectedEObject((EObject) selected);
	}

	/**
	 * @return the columnNames
	 */
	public static String[] getColumnNames() {
		return columnNames;
	}

	/**
	 * @return the viewer
	 */
	public TableViewer getViewer() {
		return viewer;
	}

}

package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;

/**
 * TODO
 * @author roman
 *
 */
public class ParametersDialogResources {
	
	private TableViewer tableViewer;
	//private ToolBar toolBar;
	
	public static final int ICON_COLUMN_INDEX 		= 0;
	public static final int CONTEXT_COLUMN_INDEX	= 1;
	public static final int TYPE_COLUMN_INDEX 		= 2;
	public static final int NAME_COLUMN_INDEX		= 3;
	
	String[] columnNames = OperationsTabResources.getAttributeTableColumn();

	/**
	 * TODO
	 */
	protected void createToolBarWithTableViewer(Composite composite,
			IContentProvider contentProvider, IBaseLabelProvider labelProvider,
			ICellModifier cellModifier,
			SelectionListener addActionListener,
			SelectionListener deleteActionListener, Object input) {

		/**
		 * defined Images for actions buttons
		 */
		Image addIcon = OperationsTabResources.imageRegistry
				.get(OperationsTabResources.ADD_PARAM);
		Image deleteIcon = OperationsTabResources.imageRegistry
				.get(OperationsTabResources.DELETE_PARAM);

		FormData fdToolBar = new FormData();
		fdToolBar.top = new FormAttachment(0, 5);
		fdToolBar.right = new FormAttachment(100, -7);
		fdToolBar.left = new FormAttachment(100, -37);
		fdToolBar.bottom = new FormAttachment(94, 0);

		final ToolBar toolBar = new ToolBar(composite, SWT.VERTICAL | SWT.NONE);
		toolBar.setLayoutData(fdToolBar);

		final ToolItem addItem = new ToolItem(toolBar, SWT.PUSH);
		addItem.setImage(addIcon);
		addItem.addSelectionListener(addActionListener);

		final ToolItem deleteItem = new ToolItem(toolBar, SWT.PUSH);
		deleteItem.addSelectionListener(deleteActionListener);
		deleteItem.setImage(deleteIcon);
		deleteItem.setEnabled(false);

		final FormData fdTableViewer = new FormData();
		fdTableViewer.right = new FormAttachment(toolBar, -5, SWT.LEFT);
		fdTableViewer.top = new FormAttachment(0, 5);
		fdTableViewer.left = new FormAttachment(0, 5);
		fdTableViewer.bottom = new FormAttachment(94, 0);

		
		tableViewer = new TableViewer(composite, SWT.FULL_SELECTION
				| SWT.BORDER);
		Table table = tableViewer.getTable();
		table.setLayoutData(fdTableViewer);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		tableViewer.setColumnProperties(columnNames);
		tableViewer.setContentProvider(contentProvider);
		tableViewer.setLabelProvider(labelProvider);
		/**
		 * Create the cell editors for Name, Type column
		 */
		CellEditor[] editors = new CellEditor[columnNames.length];

		editors[NAME_COLUMN_INDEX] = new TextCellEditor(table);
		editors[TYPE_COLUMN_INDEX] = new ReturnTypeDialogCellEditor(table);

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		tableViewer.setCellModifier(cellModifier);
		tableViewer
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
		contextColumn.setText(OperationsTabResources.CONTEXT_COLUMN);

		final TableColumn typeColumn = new TableColumn(table, SWT.NONE);
		typeColumn.setWidth(140);
		typeColumn.setText(OperationsTabResources.TYPE_COLUMN);

		final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		nameColumn.setWidth(100);
		nameColumn.setText(OperationsTabResources.NAME_COLUMN);
		
		// Set the curent viewer for OperationsTabResources
		OperationsTabResources.setParametersViewer(tableViewer);
		// Set input fot TableViewer
		tableViewer.setInput(input);
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

		Object selected = ((IStructuredSelection) event.getSelection()).getFirstElement();
		
		Assert.isTrue(selected instanceof EObject);
		OperationsTabResources.setSelectedEObject((EObject) selected);
	}
}

package de.uka.ipd.sdq.pcmbench.tabs.dialog;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;

/**
 * @author roman
 * 
 * The dialogue serves the input of parameter names and types in table cells. It
 * a simple editor implemented for providing and deletion of types.
 */
public class ParametersDialogViewer extends TitleAreaDialog {

	private Table table;
	private String properties;
	private Signature signature;
	private TableViewer tableViewer;

	public static final int ICON_COLUMN_INDEX 		= 0;
	public static final int CONTEXT_COLUMN_INDEX	= 1;
	public static final int TYPE_COLUMN_INDEX 		= 2;
	public static final int NAME_COLUMN_INDEX		= 3;

	/**
	 * Creates a dialog with the given parent and edited properties name
	 * 
	 * @param parentShell
	 *            -object that returns the current parent shell columnName -
	 *            edited properties
	 */
	public ParametersDialogViewer(Shell parentShell, String columnName,
			Signature signature) {
		super(parentShell);
		this.properties = columnName;
		this.signature = signature;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		String[] columnNames = OperationsTabResources.getAttributeTableColumn();

		ToolBar toolBar;
		toolBar = new ToolBar(container, SWT.VERTICAL | SWT.NONE);
		final FormData fdToolBar = new FormData();
		fdToolBar.top = new FormAttachment(0, 5);
		fdToolBar.right = new FormAttachment(100, -7);
		fdToolBar.left = new FormAttachment(100, -37);
		toolBar.setLayoutData(fdToolBar);

		final ToolItem addToolItem = new ToolItem(toolBar, SWT.PUSH);
		Image addIcon = OperationsTabResources.imageRegistry.get(OperationsTabResources.ADD_PARAM);
		addToolItem.setImage(addIcon);
		addToolItem.addSelectionListener(new AddParameterActionListener(signature));

		final ToolItem deleteToolItem = new ToolItem(toolBar, SWT.PUSH);
		deleteToolItem.addSelectionListener(DeleteParameterActionListener
				.getSingelton());
		Image deleteIcon = OperationsTabResources.imageRegistry
				.get(OperationsTabResources.DELETE_PARAM);
		deleteToolItem.setImage(deleteIcon);

		tableViewer = new TableViewer(container, SWT.FULL_SELECTION
				| SWT.BORDER);
		table = tableViewer.getTable();
		final FormData fdTableViewer = new FormData();
		fdTableViewer.right = new FormAttachment(toolBar, -5, SWT.LEFT);
		fdTableViewer.top = new FormAttachment(0, 5);
		fdTableViewer.left = new FormAttachment(0, 5);
		table.setLayoutData(fdTableViewer);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		tableViewer.setColumnProperties(columnNames);

		/**
		 * Create the cell editors for Name, Type column
		 */
		CellEditor[] editors = new CellEditor[columnNames.length];

		editors[NAME_COLUMN_INDEX] = new TextCellEditor(table);;
		editors[TYPE_COLUMN_INDEX] = new DataTypeDialogCellEditor(table);

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		tableViewer.setCellModifier(new ParametersCellModifier(this));
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {
						Object selected;
						IStructuredSelection selection = new StructuredSelection();
						if (!event.getSelection().isEmpty()) {
							deleteToolItem.setEnabled(true);

							Parameter selectedParameter;

							selection = (IStructuredSelection) event
									.getSelection();
							selected = selection.getFirstElement();
							Assert.isTrue(selected instanceof Parameter);

							selectedParameter = (Parameter) selected;

							(DeleteParameterActionListener.getSingelton())
									.setParentSignature(signature);

							(DeleteParameterActionListener.getSingelton())
									.setSelectedParameter(selectedParameter);

						} else
							deleteToolItem.setEnabled(false);
					}
				});

		
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

		Label separator;
		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		fdToolBar.bottom = new FormAttachment(separator, -5, SWT.DEFAULT);
		fdTableViewer.bottom = new FormAttachment(separator, -5, SWT.DEFAULT);
		final FormData fdSeparator = new FormData();
		fdSeparator.left = new FormAttachment(0, 5);
		fdSeparator.right = new FormAttachment(100, -7);
		fdSeparator.bottom = new FormAttachment(100, -3);
		fdSeparator.top = new FormAttachment(100, -8);
		separator.setLayoutData(fdSeparator);
		setTitle(properties);
		//
		return area;
	}

	/**
	 * Create contents of the button bar
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(470, 440);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Properties");
	}

	/**
	 * @return the tableViewer
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}
}

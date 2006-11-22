package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.TableViewer;
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

/**
 * @author roman
 *
 * The dialogue serves the input of parameter names and types in table cells.
 * It a simple editor implemented for providing and deletion of types.
 */
public class AttributeTypeDialog extends TitleAreaDialog {

	private Table table;
	private String properties;
	
	final String CONTEXT_COLUMN = "Context";
	final String TYPE_COLUMN    = "Type";
	final String NAME_COLUMN    = "Name";
	
	/**
	 * Creates a dialog with the given parent and edited properties name
	 * 
	 * @param parentShell -object that returns the current parent shell
	 * 		  columnName - edited properties
	 */
	public AttributeTypeDialog(Shell parentShell, String columnName) {
		super(parentShell);
		this.properties = columnName;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		

		final TableViewer tableViewer = new TableViewer(container, SWT.BORDER);
		table = tableViewer.getTable();
		final FormData fdTableViewer = new FormData();
		fdTableViewer.top = new FormAttachment(0, 5);
		fdTableViewer.left = new FormAttachment(0, 5);
		table.setLayoutData(fdTableViewer);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn zeroColumn = new TableColumn(table, SWT.NONE);
		zeroColumn.setResizable(false);
		zeroColumn.setWidth(20);

		final TableColumn contextColumn = new TableColumn(table, SWT.NONE);
		contextColumn.setWidth(100);
		contextColumn.setText(CONTEXT_COLUMN);

		/**
		 * The dialogue column Name is faded out, if the dialogue for Return Type properies is called.
		 */
		if (!properties.endsWith(TYPE_COLUMN)){
			final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
			nameColumn.setWidth(140);
			nameColumn.setText(NAME_COLUMN);
		}
		
		final TableColumn typeColumn = new TableColumn(table, SWT.NONE);
		typeColumn.setWidth(100);
		typeColumn.setText(TYPE_COLUMN);
		//tableViewer.setInput(new Object());

		ToolBar toolBar;
		toolBar = new ToolBar(container,SWT.VERTICAL | SWT.NONE);
		fdTableViewer.right = new FormAttachment(toolBar, -5, SWT.LEFT);
		final FormData fdToolBar = new FormData();
		fdToolBar.right = new FormAttachment(100, -7);
		fdToolBar.left = new FormAttachment(100, -37);
		fdToolBar.top = new FormAttachment(0, 5);
		toolBar.setLayoutData(fdToolBar);
		
		final ToolItem addToolItem = new ToolItem(toolBar, SWT.PUSH);
		Image addIcon = TabResources.imageRegistry.get(TabResources.ADD_PARAM);
		addToolItem.setImage(addIcon);

		final ToolItem deleteToolItem = new ToolItem(toolBar, SWT.PUSH);
		Image deleteIcon = TabResources.imageRegistry.get(TabResources.DELETE_PARAM);
		deleteToolItem.setImage(deleteIcon);

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
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(430, 400);
	}
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Properties");
	}
}

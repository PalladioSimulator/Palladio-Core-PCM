package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

/**
 * @author roman
 *
 * The dialogue serves the input of parameter names and types in table cells.
 * It a simple editor implemented for providing and deletion of types.
 */
public class AttributeTypeDialog extends Dialog {

	private Tree tree;
	private Table table;
	private Composite container;
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
		container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());

		final Label titelLabel = new Label(container, SWT.NONE);
		final FormData fdTitelLable = new FormData();
		fdTitelLable.bottom = new FormAttachment(0, 30);
		fdTitelLable.top = new FormAttachment(0, 10);
		titelLabel.setLayoutData(fdTitelLable);
		titelLabel.setText(properties);

		final TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
		//TODO treeViewer.setInput(properties);
		tree = treeViewer.getTree();
		final FormData fdTreeViewer = new FormData();
		fdTreeViewer.width = 0;
		fdTreeViewer.bottom = new FormAttachment(100, -16);
		fdTreeViewer.right = new FormAttachment(0, 180);
		fdTreeViewer.top = new FormAttachment(titelLabel, 0, SWT.TOP);
		fdTreeViewer.left = new FormAttachment(0, 15);
		tree.setLayoutData(fdTreeViewer);

		final TableViewer tableViewer = new TableViewer(container, SWT.BORDER);
		table = tableViewer.getTable();
		fdTitelLable.left = new FormAttachment(table, 0, SWT.LEFT);
		final FormData fdTableViewer = new FormData();
		fdTableViewer.top = new FormAttachment(titelLabel, 10, SWT.DEFAULT);
		fdTableViewer.left = new FormAttachment(tree, 15, SWT.DEFAULT);
		table.setLayoutData(fdTableViewer);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn zeroColumn = new TableColumn(table, SWT.NONE);
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
		typeColumn.setWidth(140);
		typeColumn.setText(TYPE_COLUMN);
		// TODO tableViewer.setInput(new Object());

		ToolBar toolBar;
		toolBar = new ToolBar(container, SWT.VERTICAL | SWT.NONE );
		fdTitelLable.right = new FormAttachment(toolBar, 0, SWT.RIGHT);
		fdTableViewer.right = new FormAttachment(toolBar, -5, SWT.LEFT);
		final FormData fdToolBar = new FormData();
		fdToolBar.top = new FormAttachment(titelLabel, 10, SWT.DEFAULT);
		fdToolBar.left = new FormAttachment(100, -47);
		fdToolBar.right = new FormAttachment(100, -12);
		fdToolBar.bottom = new FormAttachment(table, 0, SWT.BOTTOM);
		toolBar.setLayoutData(fdToolBar);

		final ToolItem addItem = new ToolItem(toolBar, SWT.PUSH);
		Image addIcon = TabResources.imageRegistry.get(TabResources.ADD_PARAM);
	    addItem.setImage(addIcon);

		final ToolItem deleteItem = new ToolItem(toolBar, SWT.PUSH);
		Image deleteIcon = TabResources.imageRegistry.get(TabResources.DELETE_PARAM);
	    deleteItem.setImage(deleteIcon);

		Label separatorLabel;
		separatorLabel = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		fdTableViewer.bottom = new FormAttachment(separatorLabel, -15, SWT.DEFAULT);
		final FormData fdSeparator = new FormData();
		fdSeparator.bottom = new FormAttachment(100, -11);
		fdSeparator.left = new FormAttachment(table, 0, SWT.LEFT);
		fdSeparator.right = new FormAttachment(toolBar, 0, SWT.RIGHT);
		fdSeparator.top = new FormAttachment(tree, 0, SWT.BOTTOM);
		separatorLabel.setLayoutData(fdSeparator);
		//
		return container;
	}

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
		return new Point(580, 500);
	}
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Properties");
	}

}

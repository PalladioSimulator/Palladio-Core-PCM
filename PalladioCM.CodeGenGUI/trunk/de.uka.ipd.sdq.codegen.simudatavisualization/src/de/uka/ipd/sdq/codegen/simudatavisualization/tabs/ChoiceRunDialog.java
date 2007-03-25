package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import de.uka.ipd.sdq.codegen.simudatavisualization.views.TreeViewLabelProvider;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;

public class ChoiceRunDialog extends TitleAreaDialog {

	private ExperimentRun selectedRun = null;

	private Label selectedField;

	/**
	 * Create the dialog
	 * 
	 * @param parentShell
	 */
	public ChoiceRunDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final TreeViewer viewer = new TreeViewer(container, SWT.BORDER);
		final Tree tree = viewer.getTree();
		final FormData fd_tree = new FormData();
		fd_tree.bottom = new FormAttachment(100, -50);
		fd_tree.right = new FormAttachment(100, -5);
		fd_tree.top = new FormAttachment(0, 5);
		fd_tree.left = new FormAttachment(0, 5);
		tree.setLayoutData(fd_tree);

		viewer.setContentProvider(new ChoiceRunDialogContentProvider());
		viewer.setLabelProvider(new TreeViewLabelProvider());
		viewer.setInput(new ArrayList());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				Object objeckt = (Object) sel.getFirstElement();

				if (objeckt instanceof ExperimentRun) {
					selectedRun = (ExperimentRun) objeckt;
					if (selectedField != null)
						selectedField.setText(selectedRun
								.getExperimentDateTime());
				}
			}
		});

		Label selectedRunLabel;
		selectedRunLabel = new Label(container, SWT.NONE);
		final FormData fd_selectedRunLabel = new FormData();
		fd_selectedRunLabel.top = new FormAttachment(tree, 10, SWT.DEFAULT);
		fd_selectedRunLabel.bottom = new FormAttachment(100, -20);
		fd_selectedRunLabel.left = new FormAttachment(0, 10);
		selectedRunLabel.setLayoutData(fd_selectedRunLabel);
		GridLayout labelLayout = new GridLayout();
		labelLayout.numColumns = 2;
		selectedRunLabel.setText("Selected Run:");

		selectedField = new Label(container, SWT.NONE);
		fd_selectedRunLabel.right = new FormAttachment(selectedField, -5,
				SWT.LEFT);
		final FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(tree, 10, SWT.DEFAULT);
		fd_label.bottom = new FormAttachment(100, -27);
		fd_label.left = new FormAttachment(0, 95);
		fd_label.right = new FormAttachment(tree, 0, SWT.RIGHT);
		selectedField.setLayoutData(fd_label);
		selectedField.setText("...");

		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		final FormData fd_separator = new FormData();
		fd_separator.top = new FormAttachment(selectedField, 12, SWT.DEFAULT);
		fd_separator.left = new FormAttachment(0, 5);
		fd_separator.right = new FormAttachment(100, -5);
		fd_separator.bottom = new FormAttachment(100, -5);
		separator.setLayoutData(fd_separator);

		setMessage("Choise you run...");
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
		return new Point(397, 372);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Selection Run");
	}

	public ExperimentRun getResult() {
		return selectedRun;
	}
}

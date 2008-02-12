package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.visualisation.views.TreeLabelProvider;
import de.uka.ipd.sdq.sensorframework.visualisation.views.TreeObject;

/** @author roman */
public class ExperimentRunsDialog extends TitleAreaDialog {

	private TreeObject selectedObject = null;

	private Label selectedField;
	private Button okButton,cancelButton;

	public ExperimentRunsDialog(Shell parentShell) {
		super(parentShell);
		this.setShellStyle(SWT.RESIZE|SWT.MAX|SWT.CLOSE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select Run");
		newShell.addShellListener(new ShellAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ShellAdapter#shellClosed(org.eclipse.swt.events.ShellEvent)
			 */
			@Override
			public void shellClosed(ShellEvent e) {
				selectedObject = null;
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
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

		viewer.setContentProvider(new ExperimentRunsDialogContentProvider());
		viewer.setLabelProvider(new TreeLabelProvider());
		viewer.setInput(new ArrayList<Object>());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				Object objeckt = sel.getFirstElement();

				if (objeckt instanceof TreeObject) {
					selectedObject = (TreeObject) objeckt;
					setSelectedField(selectedObject);
					okButton.setEnabled(true);
				} else
					okButton.setEnabled(false);
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

		setMessage("Select you run...");
		//
		return area;
	}

	/** set selectedField value */
	private void setSelectedField(TreeObject treeObject) {
		ExperimentRun run = (ExperimentRun) treeObject.getObject();

		if (selectedField != null)
			selectedField.setText(run.getExperimentDateTime());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		cancelButton =createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		cancelButton.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedObject = null;
			}
		});
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		okButton.setEnabled(false);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(397, 372);
	}

	public TreeObject getResult() {
		return selectedObject;
	}
}

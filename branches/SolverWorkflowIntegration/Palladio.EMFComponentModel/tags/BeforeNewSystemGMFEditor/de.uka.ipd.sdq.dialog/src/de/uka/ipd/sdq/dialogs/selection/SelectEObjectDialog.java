package de.uka.ipd.sdq.dialogs.selection;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

public class SelectEObjectDialog extends Dialog {

	private Tree list;
	protected Object result;

	protected Shell shell;
	private Collection filterList;
	private Object input;
	private TreeViewer listViewer;
	private AdapterFactory adapterFactory;
	private EObject selection = null;
	private Label label;

	/**
	 * Create the dialog
	 * @param parent
	 */
	public SelectEObjectDialog(Shell parent, AdapterFactory adapterFactory, Collection filterList, Object input) {
		super(parent, SWT.NONE);
		this.filterList = filterList;
		this.input = input;
		this.adapterFactory = adapterFactory;
	}

	/**
	 * Open the dialog
	 * @return the result
	 */
	public Object open() {
		createContents();
		listViewer.setContentProvider(new AdapterFactoryContentProvider(new FilteredItemsAdapterFactory(adapterFactory, filterList)));
		listViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		listViewer.setInput(input);
		listViewer.expandAll();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return result;
	}

	/**
	 * Create contents of the dialog
	 */
	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		final GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);
		shell.setSize(487, 365);
		shell.setText("Select Object...");

		final Group selectObjectGroup = new Group(shell, SWT.NONE);
		selectObjectGroup.setLayoutData(new GridData());
		selectObjectGroup.setText("Select object");

		listViewer = new TreeViewer(selectObjectGroup, SWT.BORDER);
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection)event.getSelection();
				selection = (EObject)sel.getFirstElement();
				label.setText(new AdapterFactoryLabelProvider(adapterFactory).getText(selection));
			}
		});
		list = listViewer.getTree();
		list.setBounds(10, 20, 454, 232);

		final Label selectedObjectLabel = new Label(selectObjectGroup, SWT.NONE);
		selectedObjectLabel.setText("Selected object:");
		selectedObjectLabel.setBounds(10, 260, 97, 13);

		label = new Label(selectObjectGroup, SWT.NONE);
		label.setText("...");
		label.setBounds(113, 260, 188, 13);

		final Composite composite = new Composite(shell, SWT.RIGHT_TO_LEFT);
		composite.setLayout(new RowLayout());
		final GridData gridData = new GridData(SWT.RIGHT, SWT.BOTTOM, true, false);
		gridData.widthHint = 468;
		composite.setLayoutData(gridData);

		final Button okButton = new Button(composite, SWT.NONE);
		okButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		final RowData rowData_1 = new RowData();
		rowData_1.width = 86;
		okButton.setLayoutData(rowData_1);
		okButton.setSelection(true);
		okButton.setText("OK");

		final Button cancelButton = new Button(composite, SWT.NONE);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selection = null;
				shell.close();
			}
		});
		final RowData rowData = new RowData();
		rowData.width = 84;
		cancelButton.setLayoutData(rowData);
		cancelButton.setText("Cancel");
		//
	}
	
	public EObject getResult()
	{
		return selection;
	}
}

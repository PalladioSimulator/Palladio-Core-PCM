package de.uka.ipd.sdq.dialogs.dataset;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorfactory.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

public class DataSetDialog extends TitleAreaDialog {

	private Button addButton, removeButton, okButton;
	private Object input;
	private IDAOFactory selectedDataSet;
	private TableViewer viewer;
	
	/** Create the dialog */
	public DataSetDialog(Shell parentShell, Object input) {
		super(parentShell);
		this.input = input;

		/**
		 * the result of combining the constants which are required to produce a
		 * typical application top level shell
		 */
		setShellStyle(SWT.RESIZE|SWT.MAX|SWT.CLOSE);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select Datasource...");
		newShell.addShellListener(new ShellAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ShellAdapter#shellClosed(org.eclipse.swt.events.ShellEvent)
			 */
			@Override
			public void shellClosed(ShellEvent e) {
				selectedDataSet= null;
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

		addButton = new Button(container, SWT.NONE);
		final FormData fd_addButton = new FormData();
		fd_addButton.right = new FormAttachment(100, -5);
		fd_addButton.bottom = new FormAttachment(0, 31);
		fd_addButton.top = new FormAttachment(0, 5);
		addButton.setLayoutData(fd_addButton);
		addButton.setText("Add..");
		
		removeButton = new Button(container, SWT.NONE);
		final FormData fd_removeButton = new FormData();
		fd_removeButton.right = new FormAttachment(100, -5);
		fd_removeButton.bottom = new FormAttachment(0, 61);
		fd_removeButton.top = new FormAttachment(0, 35);
		removeButton.setLayoutData(fd_removeButton);
		removeButton.setText("Remove");

		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		final FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(100, 2);
		fd_label.right = new FormAttachment(100, 2);
		fd_label.left = new FormAttachment(0, -6);
		separator.setLayoutData(fd_label);
		separator.setText("Label");

		Table list = new Table(container, SWT.BORDER);
		fd_label.top = new FormAttachment(list, 28, SWT.DEFAULT);
		fd_removeButton.left = new FormAttachment(list, 6, SWT.DEFAULT);
		fd_addButton.left = new FormAttachment(list, 6, SWT.DEFAULT);
		final FormData fd_list = new FormData();
		fd_list.bottom = new FormAttachment(100, -32);
		fd_list.right = new FormAttachment(100, -89);
		fd_list.top = new FormAttachment(0, 4);
		fd_list.left = new FormAttachment(0, 5);
		list.setLayoutData(fd_list);

		/** create a ListViewer */
		viewer = new TableViewer(list);
		viewer.setContentProvider(new DataSetContentProvider());
		viewer.setLabelProvider(new DataSetLabelProvider());
		viewer.addSelectionChangedListener(new ISelectionChangedListener(){

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection sel = (IStructuredSelection) selection;
					Object object = sel.getFirstElement();
					selectedDataSet = (IDAOFactory) object;
					validationOKButton(selectedDataSet);
				}
				
			}
		});
		viewer.setInput(input);
		//
		return container;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		validationOKButton(selectedDataSet);
	}
	
	private void validationOKButton(Object selection) {
		setErrorMessage(null);
		okButton.setEnabled(true);

		if (selection == null) {
			okButton.setEnabled(false);
			setErrorMessage("No Datasource selected!");
		}
		
		if (selection instanceof MemoryDAOFactory) {
			MemoryDAOFactory memoryDAO = (MemoryDAOFactory) selection;
			setTitle("Description:");
			setMessage(memoryDAO.getDescription());
		}
		
		if (selection instanceof DB4ODAOFactory) {
			DB4ODAOFactory dbDAO = (DB4ODAOFactory) selection;
			String file = dbDAO.getFileName();
			setTitle("Description:");
			setMessage(dbDAO.getDescription() + ". Object Database (.."
					+ file.substring(file.length() - 40, file.length()) + ").");
		}
	}
	
	protected void setAddButtonAction(SelectionListener listener){
		addButton.addSelectionListener(listener);
	}
	
	protected void setRemoveButtonAction(SelectionListener listener){
		removeButton.addSelectionListener(listener);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(400, 350);
	}

	public Object getResult(){
		return selectedDataSet;
	}
	
	protected void refresh(){
		viewer.refresh();
	}
}

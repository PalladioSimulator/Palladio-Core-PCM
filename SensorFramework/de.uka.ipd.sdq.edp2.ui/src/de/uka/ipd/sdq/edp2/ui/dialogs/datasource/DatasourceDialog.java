package de.uka.ipd.sdq.edp2.ui.dialogs.datasource;

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

import de.uka.ipd.sdq.edp2.models.Repository.Repository;

/**
 * Dialog to manage EDP2 repositories used as data sources.
 * 
 * @author Sebastian Lehrig
 */
public class DatasourceDialog extends TitleAreaDialog {

	private static String DIALOG_TITLE = "Create/Load the data source.";
	
	private Button addButton, removeButton, okButton, openButton;
	private Object input;
	private Repository selectedRepository;
	private TableViewer viewer;
	private boolean buttonValidation;
	private String dialogTitle;
	
	/**
	 * Create the dialog.
	 * 
	 * @param input Initial set of EDP2 repositories to show
	 * */
	public DatasourceDialog(Shell parentShell, String dialogTitle,
			Object input, boolean makeButtonValidation) {
		super(parentShell);
		this.dialogTitle = dialogTitle;
		this.input = input;
		this.buttonValidation = makeButtonValidation;

		/**
		 * the result of combining the constants which are required to produce a
		 * typical application top level shell
		 */
		setShellStyle(SWT.RESIZE | SWT.MAX | SWT.CLOSE);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(dialogTitle);
		newShell.addShellListener(new ShellAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ShellAdapter#shellClosed(org.eclipse.swt.events.ShellEvent)
			 */
			@Override
			public void shellClosed(ShellEvent e) {
			    selectedRepository = null;
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

		/** 'Add..' button */
		addButton = new Button(container, SWT.NONE);
		final FormData fd_addButton = new FormData();
		fd_addButton.right = new FormAttachment(100, -5);
		fd_addButton.bottom = new FormAttachment(0, 31);
		fd_addButton.top = new FormAttachment(0, 5);
		addButton.setLayoutData(fd_addButton);
		addButton.setText("Add..");
		
		/** 'Remove' button */
		removeButton = new Button(container, SWT.NONE);
		final FormData fd_removeButton = new FormData();
		fd_removeButton.right = new FormAttachment(100, -5);
		fd_removeButton.bottom = new FormAttachment(0, 61);
		fd_removeButton.top = new FormAttachment(0, 35);
		removeButton.setLayoutData(fd_removeButton);
		removeButton.setText("Remove");

		/** 'Open..' button */
		openButton = new Button(container, SWT.NONE);
		final FormData fd_openButton = new FormData();
		fd_openButton.left = new FormAttachment(100, -84);
		fd_openButton.right = new FormAttachment(100, -5);
		fd_openButton.bottom = new FormAttachment(0, 91);
		fd_openButton.top = new FormAttachment(0, 65);
		openButton.setLayoutData(fd_openButton);
		openButton.setText("Open..");

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
		viewer.setContentProvider(new DatasourceListContentProvider());
		viewer.setLabelProvider(new DatasourceListLabelProvider());
		viewer.addSelectionChangedListener(new ISelectionChangedListener(){

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection sel = (IStructuredSelection) selection;
					Object object = sel.getFirstElement();
					selectedRepository = (Repository) object;
					validationOKButton(selectedRepository);
				}
				
			}
		});
		viewer.setInput(input);
		
		setTitle(DIALOG_TITLE);

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
		validationOKButton(selectedRepository);
	}
	
	private void validationOKButton(Object selection) {
		setErrorMessage(null);
		okButton.setEnabled(true);

		if (buttonValidation && selection == null) {
			okButton.setEnabled(false);
			setErrorMessage("No Datasource selected!");
		}
		
		// TODO check whether this code is needed
//		if (selection instanceof MemoryDAOFactory) {
//			MemoryDAOFactory memoryDAO = (MemoryDAOFactory) selection;
//			setTitle("Description:");
//			setMessage(memoryDAO.getDescription());
//		}
	}
	
	protected void setAddButtonAction(SelectionListener listener){
		addButton.addSelectionListener(listener);
	}
	
	protected void setRemoveButtonAction(SelectionListener listener){
		removeButton.addSelectionListener(listener);
	}
	
	protected void setOpenButtonAction(SelectionListener listener){
		openButton.addSelectionListener(listener);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(400, 350);
	}

	public Object getResult(){
		return selectedRepository;
	}
	
	protected void refresh(){
		viewer.refresh();
	}
}

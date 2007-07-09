package de.uka.ipd.sdq.dialogs.selection;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

import de.uka.ipd.sdq.dialogs.DialogsImages;

/** @author admin roman */
public abstract class SelectEObjectDialog extends TitleAreaDialog {

	/** input dialog resource name (Repository,System,..) */
	protected String resourceName = "";
	
	/** string values */
	private String DIALOG_TITLE = "Select Object...";
	private String DIALOG_WARNUNG_MSG = "Eventuell müssen weitere Modelle erst nachgeladen werden!";
	
	// inner elements
	private ToolBar toolBar;
	private ToolItem addItem, editItem, deleteItem;
	private TreeViewer viewer;
	private EObject selection;
	private Class<?> providedService;
	private Label label;
	private Button OKbutton,CANCELbutton;
	private Button loadResourceButton;
	
	/** Create the dialog */
	public SelectEObjectDialog(Shell parentShell) {
		super(parentShell);
		this.setShellStyle(SWT.RESIZE|SWT.MAX|SWT.CLOSE);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(DIALOG_TITLE);
		newShell.addShellListener(new ShellAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ShellAdapter#shellClosed(org.eclipse.swt.events.ShellEvent)
			 */
			@Override
			public void shellClosed(ShellEvent e) {
				selection = null;
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

		/** create a treeviewer */
		viewer = new TreeViewer(container, SWT.BORDER);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				selection = (EObject) sel.getFirstElement();
				
				label.setText(((AdapterFactoryLabelProvider) viewer
						.getLabelProvider()).getText(selection));
				
				if (selection != null && isInstanceOfProvidedService(selection))
					setOkButtonEnabled(true);
				else  {
					setOkButtonEnabled(false);
				}
			}

		});
		final Tree tree = viewer.getTree();
		final FormData fd_tree = new FormData();
		fd_tree.bottom = new FormAttachment(100, -61);
		fd_tree.top = new FormAttachment(0, 5);
		fd_tree.left = new FormAttachment(0, 5);
		tree.setLayoutData(fd_tree);
		
		/** Select Object label */
		final Label selectedObjectLabel = new Label(container, SWT.NONE);
		final FormData fd_selectedObjectLabel = new FormData();
		fd_selectedObjectLabel.bottom = new FormAttachment(100, -35);
		fd_selectedObjectLabel.top = new FormAttachment(tree, 9, SWT.DEFAULT);
		fd_selectedObjectLabel.left = new FormAttachment(0, 7);
		fd_selectedObjectLabel.right = new FormAttachment(0, 85);
		selectedObjectLabel.setLayoutData(fd_selectedObjectLabel);
		selectedObjectLabel.setText("Selected object:");
		selectedObjectLabel.setBounds(10, 260, 97, 13);

		/** feld for selected object */
		label = new Label(container, SWT.NONE);
		final FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(100, -35);
		fd_label.top = new FormAttachment(tree, 9, SWT.DEFAULT);
		fd_label.right = new FormAttachment(0, 457);
		fd_label.left = new FormAttachment(0, 100);
		label.setLayoutData(fd_label);
		label.setText("...");
		label.setBounds(113, 260, 188, 13);
		
		/** create actions toolbar with items */
		toolBar = new ToolBar(container,  SWT.VERTICAL);
		fd_tree.right = new FormAttachment(toolBar, -5, SWT.LEFT);
		final FormData fd_toolBar = new FormData();
		fd_toolBar.left = new FormAttachment(100, -29);
		fd_toolBar.right = new FormAttachment(100, -5);
		fd_toolBar.bottom = new FormAttachment(0, 210);
		fd_toolBar.top = new FormAttachment(0, 5);
		toolBar.setLayoutData(fd_toolBar);

		addItem = new ToolItem(toolBar, SWT.PUSH);
		addItem.setImage(DialogsImages.imageRegistry.get(DialogsImages.ADD));
		addItem.setEnabled(false);

		editItem = new ToolItem(toolBar, SWT.PUSH);
		editItem.setImage(DialogsImages.imageRegistry.get(DialogsImages.EDIT));
		editItem.setEnabled(false);

		deleteItem = new ToolItem(toolBar, SWT.PUSH);
		deleteItem.setImage(DialogsImages.imageRegistry
				.get(DialogsImages.DELETE));
		deleteItem.setEnabled(false);
		
		/** Separator */
		Label separator;
		separator = new Label(container, SWT.SEPARATOR|SWT.HORIZONTAL);
		final FormData fd_separator = new FormData();
		fd_separator.left = new FormAttachment(0, -2);
		fd_separator.right = new FormAttachment(100, 4);
		fd_separator.top = new FormAttachment(100, -7);
		fd_separator.bottom = new FormAttachment(100, 1);
		separator.setLayoutData(fd_separator);
		
		
		
		/** Load resource button */
		loadResourceButton = new Button(container, SWT.NONE);
		final FormData fd_loadResourceButton = new FormData();
		fd_loadResourceButton.left = new FormAttachment(100, -130);
		fd_loadResourceButton.top = new FormAttachment(100, -33);
		fd_loadResourceButton.bottom = new FormAttachment(separator, -3, SWT.DEFAULT);
		fd_loadResourceButton.right = new FormAttachment(100, -9);
		loadResourceButton.setLayoutData(fd_loadResourceButton);
		loadResourceButton.setText("Load Resource...");
		loadResourceButton.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = e.display.getActiveShell();
				LoadResourceDialog dialog = new LoadResourceDialog(shell);
				dialog.open();
				String uri = dialog.getURIText();
				if (uri != null){
					addModelToResourceSet(shell, uri);
					viewer.refresh();
					viewer.expandAll();
				}
			}
			
		});
		
		//
		return area;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		CANCELbutton = createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		CANCELbutton.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				selection = null;
			}
		});
		
		OKbutton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		setOkButtonEnabled(false);
		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		super.cancelPressed();
		this.selection = null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#open()
	 */
	@Override
	public int open() {
		if (resourceName.equals("")) {
			setMessage(DIALOG_WARNUNG_MSG, IMessageProvider.WARNING);
		} else {
			setMessage(DIALOG_WARNUNG_MSG + " (*." + resourceName.toLowerCase()
					+ ")", IMessageProvider.WARNING);
			loadResourceButton.setText("Load " + resourceName + "...");
		}
		return super.open();
	}

	private void setOkButtonEnabled(boolean enabled) {
		OKbutton.setEnabled(enabled);

		if (providedService == null)
			OKbutton.setEnabled(true);

		if (!enabled && providedService != null) {
			setErrorMessage("No " + providedService.getSimpleName()
					+ " selected!");
		} else {
			setErrorMessage(null);
			setMessage(null, IMessageProvider.WARNING);
		}
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(500, 400);
	}
	
	public void setViewerContentProvider(IContentProvider provider){
		viewer.setContentProvider(provider);
	}
	
	public void setViewerLabelProvider(IBaseLabelProvider labelProvider){
		viewer.setLabelProvider(labelProvider);
	}
	
	public void setViewerInput(Object input){
		viewer.setInput(input);
		viewer.expandAll();
	}
	
	
	/**
	 * Activated an action border with that actions: Insert, an editing,
	 * deletion.
	 * 
	 * @param addEnabled -
	 *            the new enabled state of insert action deleteEnabled - the new
	 *            enabled state of delete actio editedEnabled - the new enabled
	 *            state of edited action If a Action is activated, one must set
	 *            additionally a SelectionListener
	 * @see de.uka.ipd.sdq.dialogs#setAddSelectionListener(SelectionListener)
	 */
	public void enableToolBar(Boolean addEnabled, Boolean deleteEnabled,
			Boolean editedEnabled) {
		toolBar.setEnabled(true);
		addItem.setEnabled(addEnabled);
		deleteItem.setEnabled(deleteEnabled);
		editItem.setEnabled(editedEnabled);
	}

	protected void setAddSelectionListener(SelectionListener listener) {
		addItem.addSelectionListener(listener);
	}

	protected void setDeleteSelectionListener(SelectionListener listener) {
		deleteItem.addSelectionListener(listener);
	}

	protected void setEditeSelectionListener(SelectionListener listener) {
		editItem.addSelectionListener(listener);
	}

	/**
	 * The function makes possible for validation a selected type element in in the
	 * dialogue. If provided service is set, OK button activated only if selected
	 * element agrees with entered type.
	 * 
	 * The function must be called forwards open() function!
	 * 
	 * @param providedService - return type of dialog
	 */
	public void setProvidedService(Class<?> providedService) {
		this.providedService = providedService;
		setTitle("Select " + providedService.getSimpleName() + "...");
	}
	
	/**
	 * @param object -
	 *            is a candidate for return value
	 */
	private boolean isInstanceOfProvidedService(Object object) {
		if (providedService == null)
			return true;
		return providedService.isAssignableFrom(object.getClass());
	}
	
	/**
	 * Gives back a resource, which is necessary for this dialog. Delegetad on
	 * the subclass
	 * 
	 * @return - class name of the first elemnt in the filterList
	 */
	protected abstract void setInputDialogResourceName(Collection<Object> filterList);
	
	/** add new resource to ResourceSet - delegetad on the subclass */
	protected abstract void addModelToResourceSet(Shell shell, String uri);
	

	public TreeViewer getTreeViewer() {
		return viewer;
	}
	
	public EObject getResult() {
		return selection;
	}

	protected void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}

package de.uka.ipd.sdq.dialogs.selection;

import java.util.ArrayList;
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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

import de.uka.ipd.sdq.dialogs.DialogsImages;

public class SelectEObjectDialog extends Dialog {

	private Tree list;
	protected Object result;
	protected Shell shell;
	private Collection<Object> filterList;
	private Object input;
	private TreeViewer listViewer;
	protected AdapterFactory adapterFactory;
	private Class providedService;
	private EObject selection = null;
	private Label label;
	private Collection<Object> childReferences = new ArrayList<Object>();
	protected Composite composite;
	protected Group sharetGroup;
	private ToolBar toolBar;
	private ToolItem addItem, editItem, deleteItem;
	private Button okButton;
	private boolean okAssert = false;

	/**
	 * Create the dialog
	 * 
	 * @param parent
	 */
	public SelectEObjectDialog(Shell parent, AdapterFactory adapterFactory,
			Collection<Object> filterList, Object input) {
		super(parent, SWT.NONE);
		this.filterList = filterList;
		this.input = input;
		this.adapterFactory = adapterFactory;
	}
	
	/**
	 * Create the dialog
	 * 
	 * @param parent
	 */
	public SelectEObjectDialog(Shell parent, AdapterFactory adapterFactory,
			Collection<Object> filterList,
			Collection<Object> additionalChildReferences, Object input) {
		super(parent, SWT.NONE);
		this.filterList = filterList;
		this.input = input;
		this.adapterFactory = adapterFactory;
		this.childReferences = additionalChildReferences;
	}

	/**
	 * The function makes possible for validation a selected type element in in the
	 * dialogue. If provided service is set, OK button activated only if selected
	 * element agrees with entered type.
	 * 
	 * @param providedService - return type of dialog
	 */
	public void setProvidedService(Class providedService) {
		this.providedService = providedService;
	}

	/**
	 * Open the dialog
	 * 
	 * @return the result
	 */
	public Object open() {
		createContents();
		listViewer.setContentProvider(new AdapterFactoryContentProvider(
				new FilteredItemsAdapterFactory(adapterFactory, filterList,
						childReferences)));
		listViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		listViewer.setInput(input);
		listViewer.expandAll();
		shell.open();
		shell.layout();
		/**
		 * Listener is needed for examination, which only if an OK button is pressed,
		 * which does not empty selection value.
		 */
		shell.addDisposeListener(new DisposeListener(){
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
			 */
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if(!okAssert)
					selection = null;
			}
		});
		
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
		shell.setSize(500, 375);
		shell.setText("Select Object...");

		final Group selectObjectGroup = new Group(shell, SWT.NONE);
		selectObjectGroup.setLayoutData(new GridData(476, 279));
		selectObjectGroup.setText("Select object");

		listViewer = new TreeViewer(selectObjectGroup, SWT.BORDER);
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				selection = (EObject) sel.getFirstElement();
				label.setText(new AdapterFactoryLabelProvider(adapterFactory)
						.getText(selection));
				
				if (isInstanceOfProvidedService(selection))
					setOkButtonEnabled(true);
				else 
					setOkButtonEnabled(false);
			}

		});
		list = listViewer.getTree();
		list.setBounds(10, 20, 435, 232);

		final Label selectedObjectLabel = new Label(selectObjectGroup, SWT.NONE);
		selectedObjectLabel.setText("Selected object:");
		selectedObjectLabel.setBounds(10, 260, 97, 13);
		sharetGroup = selectObjectGroup;

		label = new Label(selectObjectGroup, SWT.NONE);
		label.setText("...");
		label.setBounds(113, 260, 188, 13);

		toolBar = new ToolBar(sharetGroup, SWT.VERTICAL);
		toolBar.setBounds(448, 22, 24, 230);
		toolBar.setEnabled(false);

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

		composite = new Composite(shell, SWT.RIGHT_TO_LEFT);
		composite.setLayout(new RowLayout());
		final GridData gridData = new GridData(SWT.LEFT, SWT.TOP, true, false);
		gridData.heightHint = 30;
		gridData.widthHint = 508;
		composite.setLayoutData(gridData);

		okButton = new Button(composite, SWT.NONE);
		okButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				okAssert = true;
				shell.close();
			}
		});
		final RowData rdOkButton = new RowData();
		rdOkButton.width = 86;
		okButton.setLayoutData(rdOkButton);
		okButton.setSelection(true);
		okButton.setText("OK");
		setOkButtonEnabled(false);

		final Button cancelButton = new Button(composite, SWT.NONE);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selection = null;
				shell.close();
			}
		});
		final RowData rdCancelButton = new RowData();
		rdCancelButton.width = 84;
		cancelButton.setLayoutData(rdCancelButton);
		cancelButton.setText("Cancel");
		//
		
	}
	
	/**
	 * @param object - a candidate for return value
	 */
	private boolean isInstanceOfProvidedService(Object object) {
		
		if (providedService == null)
			return true;
		String selectedType = object.getClass().getSimpleName();
		String type = providedService.getSimpleName();
		return (selectedType.contains(type));
	}

	private void setOkButtonEnabled(boolean enabled) {
		okButton.setEnabled(enabled);
		
		if (providedService == null)
			okButton.setEnabled(true);
	}

	public EObject getResult() {
		return selection;
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
	 * @return the TreeViewer
	 */
	protected TreeViewer getListViewer() {
		return listViewer;
	}
}
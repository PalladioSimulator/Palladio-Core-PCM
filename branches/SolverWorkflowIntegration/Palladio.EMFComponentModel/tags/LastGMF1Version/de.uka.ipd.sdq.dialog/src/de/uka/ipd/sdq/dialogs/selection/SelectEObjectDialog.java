package de.uka.ipd.sdq.dialogs.selection;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.ui.plugin.AbstractUIPlugin;


public class SelectEObjectDialog extends Dialog {

	private Tree list;
	protected Object result;
	protected Shell shell;
	private Collection filterList;
	private Object input;
	private TreeViewer listViewer;
	protected AdapterFactory adapterFactory;
	private EObject selection = null;
	private Label label;
	private Collection childReferences = new ArrayList();
	protected Composite composite;
	protected Group sharetGroup;
	private ToolBar toolBar;
	private ToolItem addItem, editItem, deleteItem;
	
	public final static String PLUGIN_ID = "de.uka.ipd.sdq.dialog";
	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String ADD 	= "add";
	public static final String DELETE  = "delete";
	public static final String EDIT  = "edit";
	
	// For the toolbar images
	public static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 

	static {
		String iconPath = "icons/";
		
		imageRegistry.put(ADD,
				 getImageDescriptor(iconPath + ADD + ".gif")
		);
		
		imageRegistry.put(DELETE,
				 getImageDescriptor(iconPath + DELETE + ".gif")
				);
		imageRegistry.put(EDIT,
				 getImageDescriptor(iconPath + EDIT + ".gif")
				);
	}
	
	/**
	 *@param imageFilePath the relative to the root of the plug-in; the path must be legal
     *@return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);
	}


	/**
	 * Create the dialog
	 * 
	 * @param parent
	 */
	public SelectEObjectDialog(Shell parent, AdapterFactory adapterFactory,
			Collection filterList, Object input) {
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
			Collection filterList, Collection additionalChildReferences,
			Object input) {
		super(parent, SWT.NONE);
		this.filterList = filterList;
		this.input = input;
		this.adapterFactory = adapterFactory;
		this.childReferences = additionalChildReferences;
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
		
		/**
		 * defined Images for actions buttons
		 */
		Image addIcon = imageRegistry.get(ADD);
		Image deleteIcon = imageRegistry.get(DELETE);
		Image editIcon = imageRegistry.get(EDIT);

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
		addItem.setImage(addIcon);
		addItem.setEnabled(false);
		
		editItem = new ToolItem(toolBar, SWT.PUSH);
		editItem.setImage(editIcon);
		editItem.setEnabled(false);

		deleteItem = new ToolItem(toolBar, SWT.PUSH);
		deleteItem.setImage(deleteIcon);
		deleteItem.setEnabled(false);

		composite = new Composite(shell, SWT.RIGHT_TO_LEFT);
		composite.setLayout(new RowLayout());
		final GridData gridData = new GridData(SWT.LEFT, SWT.TOP, true, false);
		gridData.heightHint = 30;
		gridData.widthHint = 508;
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

	public EObject getResult() {
		return selection;
	}
	
	/**
	 * Activated an action border with that actions: Insert, an editing, deletion.
	 * @param addEnabled - the new enabled state of insert action
	 * 			deleteEnabled - the new enabled state of delete actio
	 * 				editedEnabled - the new enabled state of edited action
	 * If a Action is activated, one must set additionally a SelectionListener
	 * @see de.uka.ipd.sdq.dialog#setAddSelectionListener(SelectionListener)
	 */
	public void enableToolBar(Boolean addEnabled, Boolean deleteEnabled, Boolean editedEnabled){
		toolBar.setEnabled(true);
		addItem.setEnabled(addEnabled);
		deleteItem.setEnabled(deleteEnabled);
		editItem.setEnabled(editedEnabled);
	}
	
	protected void setAddSelectionListener(SelectionListener listener){
		addItem.addSelectionListener(listener);
	}
	
	protected void setDeleteSelectionListener(SelectionListener listener){
		deleteItem.addSelectionListener(listener);
	}
	
	protected void setEditeSelectionListener(SelectionListener listener){
		editItem.addSelectionListener(listener);
	}

	/**
	 * @return the TreeViewer
	 */
	protected TreeViewer getListViewer() {
		return listViewer;
	}
}
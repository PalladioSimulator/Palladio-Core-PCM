package de.uka.ipd.sdq.sensorframework.dialogs.dataset;


import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.dialogs.CreateLinkedResourceGroup;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.DrillDownComposite;

/**
 * Load the existing data source wizard page. If the initial resource selection
 * contains exactly one file or directory resource then it will be used as the
 * default data source.
 * 
 * @param pageName
 *            the name of the page
 * @param type
 *            specifies the type of resource to link to. IResource.FILE or
 *            IResource.FOLDER
 * 
 * @author Roman Andrej
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class WizardDatasourceLoadPage extends WizardPage implements Listener {

	/** string constants */
	private static final String WIZARD_TITEL_FOLDER = "Choose the data directory";
	private static final String WIZARD_MSG_FOLDER = "Choose the folder resource.";
	private static final String WIZARD_TITEL_FILE = "Choose the data file";
	private static final String WIZARD_MSG_FILE = "Choose the file resource.";
	
	private static final int SIZING_CONTAINER_GROUP_HEIGHT = 300;
	private static final int SIZING_CONTAINER_GROUP_WIDTH = 250;
	
	private int type;
	
	private Button advancedButton;

	private CreateLinkedResourceGroup linkedResourceGroup;

	private Composite linkedResourceParent;

	private Composite linkedResourceComposite;
	
	
	/**
	 * Creates a wizard of load data source
	 */
	protected WizardDatasourceLoadPage(String pageName, int type) {
		super(pageName);
		this.type = type;
	}
	
	/**
	 * Height of the "advanced" linked resource group. Set when the advanced
	 * group is first made visible.
	 */
	private int linkedResourceGroupHeight = -1;
	
	// handle on parts
	private Text containerNameField;

	// Last selection made by user
	//private String selectedResourcePath = "";
	
	// Last selection made by user
	private IResource selectedResource;
	
	private IFileStore fileStore = null;
	
	private TreeViewer treeViewer;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		// top level group
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setFont(parent.getFont());
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
				| GridData.HORIZONTAL_ALIGN_FILL));

		Label label = new Label(composite, SWT.WRAP);
		label.setText("Enter or select the " + getResourceType() + ":");
		label.setFont(this.getFont());

		containerNameField = new Text(composite, SWT.SINGLE | SWT.BORDER);
		containerNameField
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//containerNameField.addListener(SWT.Modify, this);
		containerNameField.setFont(this.getFont());

		createTreeViewer(composite);
		createAdvancedControls(composite);
		// Show description on opening
		setErrorMessage(null);
		setDialogStrings();
		setControl(composite);

		this.setPageComplete(false);
	}
	
	
	/** The method set a wizard title and message */
	private void setDialogStrings() {
		setMessage(null);
		if (type == IResource.FILE) {
			setMessage(WIZARD_MSG_FILE);
			setTitle(WIZARD_TITEL_FILE);
		}

		if (type == IResource.FOLDER) {
			setMessage(WIZARD_MSG_FOLDER);
			setTitle(WIZARD_TITEL_FOLDER);
		}
	}
	
	/**
	 * Creates the widget for advanced options.
	 * 
	 * @param parent
	 *            the parent composite
	 */
	protected void createAdvancedControls(Composite parent) {
		Preferences preferences = ResourcesPlugin.getPlugin()
				.getPluginPreferences();

		if (preferences.getBoolean(ResourcesPlugin.PREF_DISABLE_LINKING) == false) {
			linkedResourceParent = new Composite(parent, SWT.NONE);
			linkedResourceParent.setFont(parent.getFont());
			linkedResourceParent.setLayoutData(new GridData(
					GridData.FILL_HORIZONTAL));
			GridLayout layout = new GridLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			linkedResourceParent.setLayout(layout);

			advancedButton = new Button(linkedResourceParent, SWT.PUSH);
			advancedButton.setFont(linkedResourceParent.getFont());
			
			advancedButton.setText(IDEWorkbenchMessages.showAdvanced);
			GridData data = setButtonLayoutData(advancedButton);
			data.horizontalAlignment = GridData.BEGINNING;
			advancedButton.setLayoutData(data);
			advancedButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					handleAdvancedButtonSelect();
				}
			});
		}

		linkedResourceGroup = new CreateLinkedResourceGroup(type,
				this, new CreateLinkedResourceGroup.IStringValue() {

					public String getValue() {
						return containerNameField.getText();
					}

					public void setValue(String string) {
						containerNameField.setText(string);
					}
				});
	}
	
	/**
	 * Returns a new drill down viewer for this dialog.
	 * 
	 * @param heightHint
	 *            height hint for the drill down composite
	 */
	protected void createTreeViewer(Composite parent) {
		// Create drill down.
		DrillDownComposite drillDown = new DrillDownComposite(parent,
				SWT.BORDER);
		GridData spec = new GridData(SWT.FILL, SWT.FILL, true, true);
		spec.heightHint = SIZING_CONTAINER_GROUP_HEIGHT;
		spec.widthHint = SIZING_CONTAINER_GROUP_WIDTH;
		drillDown.setLayoutData(spec);

		// Create tree viewer inside drill down.
		treeViewer = new TreeViewer(drillDown, SWT.NONE);
		drillDown.setChildTree(treeViewer);
		treeViewer.setContentProvider(new WorkbenchContentProvider());
		treeViewer.setLabelProvider(WorkbenchLabelProvider
				.getDecoratingWorkbenchLabelProvider());
		treeViewer.setComparator(new ViewerComparator());
		treeViewer.setUseHashlookup(true);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				Object object = selection.getFirstElement();
				
				if (object instanceof IResource) {
					selectedResource = (IResource) object;
					setPageComplete(validitaResource(selectedResource));
				}
			}
		});
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object item = ((IStructuredSelection) selection)
							.getFirstElement();
					if (item == null) {
						return;
					}
					if (treeViewer.getExpandedState(item)) {
						treeViewer.collapseToLevel(item, 1);
					} else {
						treeViewer.expandToLevel(item, 1);
					}
				}
			}
		});

		// This has to be done after the viewer has been laid out
		treeViewer.setInput(ResourcesPlugin.getWorkspace());
	}
	
	/**
	 * The container selection has changed in the tree view. Update the
	 * container name field value and notify all listeners.
	 * 
	 * @param text
	 *            The container that changed
	 */
	public void containerSelectionChanged(String text) {

		if (text.startsWith("/")) {
			text = text.replaceFirst("/", "");
		}

		containerNameField.setText(text);
		containerNameField.setToolTipText(text);
	}
	
	/**
	 * Validate in LinkedResourceGroup selected file
	 */
	private boolean validitaLinkedResource() {
		if ((linkedResourceGroup != null)
				&& (linkedResourceGroup.getLinkTargetURI() != null)) {
			URI uri = linkedResourceGroup.getLinkTargetURI();

			/**
			 * This variable represents a value. That is back supplied, if
			 * linkedResourceGroup.getLinkTargetURI() is empty.
			 */
			URI defaultURI = URIUtil.toURI("");

			if (!uri.toString().equals(defaultURI.toString())) {

				try {
					fileStore = EFS.getStore(uri);
				} catch (CoreException e) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Validate in viewer selected resource
	 * 
	 * @param resource -
	 *            viewer selection
	 */
	private boolean validitaResource(IResource resource) {

		if (resource == null) {
			return false;
		}

		IFileInfo fileInfo = null;

		try {
			fileStore = EFS.getStore(resource.getLocationURI());
		} catch (CoreException e1) {
			return false;
		}

		fileInfo = fileStore.fetchInfo();

		if (type == IResource.FILE) {
			return !fileInfo.isDirectory();
		}

		if (type == IResource.FOLDER) {
			return fileInfo.isDirectory();
		}

		return false;
	}
	
	/**
	 * Shows/hides the advanced option widgets.
	 */
	protected void handleAdvancedButtonSelect() {
		Shell shell = getShell();
		Point shellSize = shell.getSize();
		Composite composite = (Composite) getControl();

		if (linkedResourceComposite != null) {
			linkedResourceComposite.dispose();
			linkedResourceComposite = null;
			composite.layout();
			shell.setSize(shellSize.x, shellSize.y - linkedResourceGroupHeight);
			advancedButton.setText(IDEWorkbenchMessages.showAdvanced);
		} else {
			linkedResourceComposite = linkedResourceGroup
					.createContents(linkedResourceParent);
			if (linkedResourceGroupHeight == -1) {
				Point groupSize = linkedResourceComposite.computeSize(
						SWT.DEFAULT, SWT.DEFAULT, true);
				linkedResourceGroupHeight = groupSize.y;
			}
			shell.setSize(shellSize.x, shellSize.y + linkedResourceGroupHeight);
			composite.layout();
			advancedButton.setText(IDEWorkbenchMessages.hideAdvanced);
		}
	}
	
	/**
	 * Returns the currently selected file name. Null if the field is empty.
	 * 
	 * @return IPath
	 */
	public IPath getFileFullPath() {
		if (fileStore == null) {
			return null;
		}

		IPath path = new Path(fileStore.toString());
		// The user may not have made this absolute so do it for them
		path.makeAbsolute();

		// TODO: StB: Commented out as this is not working under linux and I have doubts that it works correctly under windows!!
//		if (false && path.getDevice() == null) { //dead code
//			IPath rootPath = ResourcesPlugin.getWorkspace().getRoot()
//					.getLocation();
//			return rootPath.append(path);
//		}

		return path;
	}

	/**
	 * The WizardDatasourceFileLoadPage implementation of this Listener method
	 * handles all events and enablements for controls on this page. Subclasses
	 * may extend.
	 */
	public void handleEvent(Event event) {
		if (linkedResourceComposite != null
				&& !linkedResourceComposite.isDisposed()) {
			setPageComplete(validitaLinkedResource());
		}else {
			setPageComplete(validitaResource(selectedResource));
		}
	}
	
	private String getResourceType(){
		if (type == IResource.FILE )
			return "file";
		if (type == IResource.FOLDER )
			return "folder";
		return "<undefined>";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage#setPageComplete(boolean)
	 */
	@Override
	public void setPageComplete(boolean complete) {
		super.setPageComplete(complete);
		setErrorMessage("No resource selected!");

		if (complete) {
			setErrorMessage(null);
			containerSelectionChanged(fileStore.toString());
		}
	}
}

/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.wizards;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

import de.uka.ipd.sdq.edp2.visualization.AbstractAdapter;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;

/**
 * {@link WizardPage}, which provides a list of all available adapters
 * {@link AbstractAdapter}, that are registered as extensions.
 * 
 * @author Dominik Ernst
 */
public class SelectAdapterPage extends WizardPage implements
		ISelectionChangedListener {

	private final static Logger logger = Logger
			.getLogger(SelectAdapterPage.class.getCanonicalName());

	private final static String ADAPTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.adapter";

	private final static String ADAPTER_CLASS_ATTRIBUTE = "class";
	private final static String ADAPTER_WIZARD_ATTRIBUTE = "wizard";

	AbstractDataSource selectedSource;
	ArrayList<IAdapterWizard> availableAdapters;

	List adapterList;
	IStatus selectionStatus;
	Status statusOK;
	IAdapterWizard selectedAdapterWizard;
	TableViewer adapterViewer;
	AbstractAdapter createdAdapter;

	protected SelectAdapterPage(String pageName, AbstractDataSource selectedSource) {
		super(pageName);
		this.selectedSource = selectedSource;
		setDescription("Select the Adapter you wish to add.");
		statusOK = new Status(IStatus.OK, "not_used", 0, "", null);
		selectionStatus = statusOK;
	}

	@Override
	public boolean canFlipToNextPage() {
		return updatePageStatus().isOK();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// create the composite to hold the widgets
		GridData gd;
		Composite composite = new Composite(parent, SWT.NONE);

		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		composite.setLayout(gl);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Available Adapters:");

		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 200;
		sashForm.setLayoutData(gd);

		adapterViewer = new TableViewer(sashForm, SWT.BORDER);
		adapterViewer.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public Object[] getElements(Object inputElement) {
				return getApplicableAdapters(selectedSource).toArray();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// TODO Auto-generated method stub

			}
		});
		adapterViewer.setLabelProvider(new ILabelProvider() {

			@Override
			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getText(Object element) {
				if (element != null) {
					return ((IWizard) element).getWindowTitle();
				}
				return null;
			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub

			}
		});

		adapterViewer.setInput(getApplicableAdapters(selectedSource));
		adapterViewer.addSelectionChangedListener(this);

		// set the composite as the control for this page
		setControl(composite);
		updatePageStatus();
	}

	protected ArrayList<IAdapterWizard> getApplicableAdapters(
			AbstractDataSource forSource) {
		availableAdapters = new ArrayList<IAdapterWizard>();
		// checks the extension registry for all registered adapters and adds
		// them to the list
		final IConfigurationElement[] adapterExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						ADAPTER_EXTENSION_POINT_ID);
		for (IConfigurationElement e : adapterExtensions) {
			Object w, o = null;
			try {
				w = e.createExecutableExtension(ADAPTER_WIZARD_ATTRIBUTE);
				o = e.createExecutableExtension(ADAPTER_CLASS_ATTRIBUTE);
				if (((AbstractAdapter) o).canAccept(forSource)) {
					availableAdapters.add((IAdapterWizard) w);
				}
			} catch (CoreException ex) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
			logger.log(Level.INFO, o.toString());
		}
		return availableAdapters;
	}

	/**
	 * Method which is called when the "Next" Button in the Wizard is clicked.
	 * Must call
	 * {@link IAdapterWizard#setSourceFromCaller(AbstractDataSource, SelectAdapterPage)}
	 * , where the {@link AbstractDataSource} is the source handed from the
	 * RawMeasurements object, which was selected in the first place and
	 * <code>this</code> a reference on this {@link SelectAdapterPage}.
	 */
	@Override
	public IWizardPage getNextPage() {
		selectedAdapterWizard.setSourceFromCaller(selectedSource, this);
		selectedAdapterWizard.addPages();
		return selectedAdapterWizard.getStartingPage();
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		selectionStatus = statusOK;
		IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		selectedAdapterWizard = null;
		if (selection == null) {
			selectionStatus = new Status(IStatus.ERROR, "", 0,
					"Must select an adapter to proceed.", null);
		} else {
			selectedAdapterWizard = (IAdapterWizard) selection
					.getFirstElement();
			logger.log(Level.INFO, selectedAdapterWizard.getWindowTitle());
		}

		updatePageStatus();
		getContainer().updateButtons();

	}

	public IStatus updatePageStatus() {
		IStatus pageStatus = statusOK;
		switch (selectionStatus.getSeverity()) {
		case IStatus.OK:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage());
			pageStatus = statusOK;
			break;
		case IStatus.WARNING:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage(), WizardPage.WARNING);
			pageStatus = selectionStatus;
			break;
		case IStatus.INFO:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage(), WizardPage.INFORMATION);
			pageStatus = selectionStatus;
			break;
		default:
			setErrorMessage(selectionStatus.getMessage());
			setMessage(null);
			pageStatus = selectionStatus;
			break;
		}
		return pageStatus;
	}

	public void setAdapter(AbstractAdapter adapter) {
		logger.log(Level.INFO, "adapter of AdapterWizard set");
		this.createdAdapter = adapter;
		AdapterWizard wizard = (AdapterWizard) getWizard();
		wizard.setAdapter(adapter);
	}

}

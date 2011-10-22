/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.wizards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
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

import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;

/**
 * @author Dominik Ernst TODO change such that it allows to select from a list
 *         of wizards see {@link WizardListSelectionPage}
 */
public class SelectDefaultCombinationsPage extends WizardPage implements
		ISelectionChangedListener {

	private final static Logger logger = Logger
			.getLogger(SelectDefaultCombinationsPage.class.getCanonicalName());

	private final static String FILTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.filter";
	private final static String ADAPTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.adapter";
	private final static String JFREECHART_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.jfreechart";

	private final static String CLASS_ATTRIBUTE = "class";
	private final static String ID_ATTRIBUTE = "id";
	private final static String WIZARD_ATTRIBUTE = "wizard";
	private final static String INPUT_CLASS_ATTRIBUTE = "inputClass";
	private final static String INPUT_FACTORY_ATTRIBUTE = "inputFactory";

	Object currentSelection;
	IDataSource selectedSource;
	IStatus selectionStatus;
	Status statusOK;
	TableViewer choiceViewer;

	protected SelectDefaultCombinationsPage(String pageName,
			IDataSource selectedSource) {
		super(pageName);
		this.selectedSource = selectedSource;
		setDescription("Choose a combination of Filters/Adapters + Editor to display"
				+ "the selected Data.");
		statusOK = new Status(IStatus.OK, "not_used", 0, "", null);
		selectionStatus = new Status(IStatus.INFO, "not_used", 0,
				"Please select a Visualization to proceed.", null);
	}

	@Override
	public boolean canFlipToNextPage() {
		((DefaultViewsWizard) getWizard()).setFinishable(updatePageStatus()
				.isOK());
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
		label.setText("Available Choices:");

		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 200;
		sashForm.setLayoutData(gd);

		choiceViewer = new TableViewer(sashForm, SWT.BORDER);
		choiceViewer.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public Object[] getElements(Object inputElement) {
				return getApplicableChoices(selectedSource).toArray();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// TODO Auto-generated method stub

			}
		});
		choiceViewer.setLabelProvider(new ILabelProvider() {

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
					ArrayList<Object> arrayListElement = (ArrayList<Object>)element;
					StringBuffer shownString = new StringBuffer();
					int length = arrayListElement.size();
					shownString.append("[ ");
					for (Object ele : arrayListElement){
						shownString.append(ele.getClass().getSimpleName());
						length--;
						if (length > 0) shownString.append(" + ");
					}
					shownString.append(" ]");
					return shownString.toString();
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

		choiceViewer.setInput(getApplicableChoices(selectedSource));
		choiceViewer.addSelectionChangedListener(this);

		// set the composite as the control for this page
		setControl(composite);
		updatePageStatus();
	}

	/**
	 * Checks the registered plugins for filters {@link IFilter}, adapters
	 * {@link IAdapter} and JFreeCharts {@link JFreeChartEditorInput}. Then
	 * creates the basic combinations ("defaults") of these and returns those
	 * combinations, which work for the selected {@link IDataSource}.
	 * 
	 * @param forSource
	 *            the selected {@link IDataSource}
	 * @return the possible visualizations for the selected source
	 */
	protected ArrayList<ArrayList<IDataSink>> getApplicableChoices(
			IDataSource forSource) {
		Object o = null;
		String id;
		// get list of registered filters - assume that the basic filters exist
		final IConfigurationElement[] filterExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						FILTER_EXTENSION_POINT_ID);
		HashMap<String, IFilter> filters = new HashMap<String, IFilter>();
		for (IConfigurationElement e : filterExtensions) {

			try {
				o = e.createExecutableExtension(CLASS_ATTRIBUTE);
				id = e.getAttribute(ID_ATTRIBUTE);
				filters.put(id, (IFilter) o);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		// get list of registered adapters - assume that the basic adapters
		// exist
		final IConfigurationElement[] adapterExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						ADAPTER_EXTENSION_POINT_ID);
		HashMap<String, IAdapter> adapters = new HashMap<String, IAdapter>();
		for (IConfigurationElement e : adapterExtensions) {
			try {
				o = e.createExecutableExtension(CLASS_ATTRIBUTE);
				id = e.getAttribute(ID_ATTRIBUTE);
				adapters.put(id, (IAdapter) o);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		// get the list of registered visualizations - again, assume that the
		// typical visualizations are registered plugins
		final IConfigurationElement[] chartExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						JFREECHART_EXTENSION_POINT_ID);
		HashMap<String, JFreeChartEditorInput> charts = new HashMap<String, JFreeChartEditorInput>();
		for (IConfigurationElement e : chartExtensions) {
			try {
				o = e.createExecutableExtension(INPUT_CLASS_ATTRIBUTE);
				id = e.getAttribute(ID_ATTRIBUTE);
				charts.put(id, (JFreeChartEditorInput) o);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		ArrayList<ArrayList<IDataSink>> defaultVariants = new ArrayList<ArrayList<IDataSink>>();
		ArrayList<IDataSink> default1, default2, default3, default4;
		default1 = new ArrayList<IDataSink>();
		default2 = new ArrayList<IDataSink>();
		default3 = new ArrayList<IDataSink>();
		default4 = new ArrayList<IDataSink>();

		default1.add(charts
				.get("de.uka.ipd.sdq.edp2.visualization.Scatterplot"));
		
		default2
				.add(adapters
						.get("de.uka.ipd.sdq.edp2.transformation.HistogramFrequencyAdapter"));
		default2.add(charts.get("de.uka.ipd.sdq.edp2.visualization.Histogram"));

		default3.add(filters
				.get("de.uka.ipd.sdq.edp2.transformation.WarmupFilter"));
		default3.add(charts
				.get("de.uka.ipd.sdq.edp2.visualization.Scatterplot"));

		default4
				.add(adapters
						.get("de.uka.ipd.sdq.edp2.transformation.HistogramFrequencyAdapter"));
		default4.add(filters
				.get("de.uka.ipd.sdq.edp2.transformation.WarmupFilter"));
		default4.add(charts.get("de.uka.ipd.sdq.edp2.visualization.Histogram"));

		defaultVariants.add(default1);
		defaultVariants.add(default2);
		defaultVariants.add(default3);
		defaultVariants.add(default4);

		// remove those variants, which don't work for the selected source
		// TODO only checks first element in default combination so far, should it check the following ones, too?
		for (ArrayList<IDataSink> variant : defaultVariants) {
			if (!variant.get(0).canAccept(forSource)) {
				defaultVariants.remove(variant);
			}
		}

		return defaultVariants;
	}

	/**
	 * Method which is called when the "Next" Button in the Wizard is clicked.
	 */
	@Override
	public IWizardPage getNextPage() {
		return null;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		selectionStatus = statusOK;
		IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		if (selection.isEmpty()) {
			selectionStatus = new Status(IStatus.ERROR, "not_used", 0,
					"Please select a Visualization to proceed.", null);
		} else {
			int index = choiceViewer.getTable().getSelectionIndex();
			setSelectedDefault(getApplicableChoices(selectedSource).get(index));
		}

		updatePageStatus();
	}

	public IStatus updatePageStatus() {
		IStatus pageStatus = statusOK;
		((DefaultViewsWizard)getWizard()).setFinishable(false);
		switch (selectionStatus.getSeverity()) {
		case IStatus.OK:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage());
			pageStatus = statusOK;
			((DefaultViewsWizard)getWizard()).setFinishable(true);
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
		getContainer().updateButtons();
		return pageStatus;
	}

	public void setSelectedDefault(ArrayList<IDataSink> selection) {
		((DefaultViewsWizard)getWizard()).setSelectedDefault(selection);
	}

}

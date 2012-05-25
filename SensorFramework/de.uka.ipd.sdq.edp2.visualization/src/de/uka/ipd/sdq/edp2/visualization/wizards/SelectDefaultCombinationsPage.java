package de.uka.ipd.sdq.edp2.visualization.wizards;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.uka.ipd.sdq.edp2.visualization.AbstractAdapter;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.AbstractFilter;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;

/**
 * Implementation of a {@link WizardPage} that contains a list of visualizations
 * which are able to display the selected data. The list contains both the basic defaults, 
 * i.e. registered visualizations only, and defaults as described by extensions to the extension point
 * <code>de.uka.ipd.sdq.edp2.visualization.defaultSequences</code>.
 * @author Dominik Ernst
 */
public class SelectDefaultCombinationsPage extends WizardPage implements
		ISelectionChangedListener {

	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(SelectDefaultCombinationsPage.class.getCanonicalName());

	/**
	 * Extension points for registered {@link AbstractFilter}, {@link AbstractAdapter} and
	 * {@link JFreeChartEditorInput}-elements
	 */
	private final static String FILTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.filter";
	private final static String ADAPTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.adapter";
	private final static String SINK_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.datasink";
	private final static String DEFAULT_COMBOS_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.defaultSequences";

	/**
	 * Attribute names and element IDs as used in extension points.
	 */
	private final static String ELEMENT_ID_ADAPTER = "adapter";
	private final static String ELEMENT_ID_FILTER = "filter";
	private final static String ELEMENT_ID_DATASINK = "datasink";
	private final static String ELEMENT_ID_PROPERTY = "property";
	private final static String ELEMENT_ID_INPUT_METRIC = "inputMetric";
	private final static String INPUT_METRIC_UUID_ATTRIBUTE = "UUID";
	private final static String INPUT_METRIC_DESCRIPTION_ATTRIBUTE = "description";
	private final static String PROPERTY_KEY_ATTRIBUTE = "key";
	private final static String PROPERTY_VALUE_ATTRIBUTE = "value";
	private final static String ADAPTER_ID_ATTRIBUTE = "adapterID";
	private final static String FILTER_ID_ATTRIBUTE = "filterID";
	private final static String DATASINK_ID_ATTRIBUTE = "sinkID";

	private final static String CLASS_ATTRIBUTE = "class";
	private final static String ID_ATTRIBUTE = "id";
	private final static String NAME_ATTRIBUTE = "name";

	/**
	 * The source which was selected when the wizard was started.
	 */
	private AbstractDataSource selectedSource;
	/**
	 * The current {@link IStatus} based on the selection in the <choiceViewer>
	 */
	private IStatus selectionStatus;
	/**
	 * The 'OK'-Status, which signalizes everything is fine.
	 */
	private Status statusOK;
	/**
	 * Viewer for the possible choices of Filter/Adapter/Chart combinations.
	 */
	private TableViewer choiceViewer;

	/**
	 * The default sequences to display experiment data;
	 */
	private ArrayList<DefaultSequence> defaultSequences;

	/**
	 * Constructor
	 * 
	 * @param pageName
	 *            the name of this {@link WizardPage}
	 * @param selectedSource
	 *            the source which was selected to invoke the wizard.
	 */
	protected SelectDefaultCombinationsPage(String pageName,
			AbstractDataSource selectedSource) {
		super(pageName);
		this.selectedSource = selectedSource;
		setDescription("Choose a combination of Filters/Adapters + Editor to display"
				+ "the selected Data.");
		statusOK = new Status(IStatus.OK, "not_used", 0, "", null);
		selectionStatus = new Status(IStatus.INFO, "not_used", 0,
				"Please select a Visualization to proceed.", null);

		createDefaultCombinations();
	}

	/**
	 * Checks the registered plugins for filters {@link AbstractFilter}, adapters
	 * {@link AbstractAdapter} and JFreeCharts {@link JFreeChartEditorInput}. Then
	 * creates the basic combinations, objects of the type
	 * {@link DefaultSequence} from these.
	 */
	private void createDefaultCombinations() {
		Object o = null;
		String id;
		// get list of registered filters - assume that the basic filters exist
		final IConfigurationElement[] filterExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						FILTER_EXTENSION_POINT_ID);
		HashMap<String, AbstractFilter> filters = new HashMap<String, AbstractFilter>();
		for (IConfigurationElement e : filterExtensions) {

			try {
				o = e.createExecutableExtension(CLASS_ATTRIBUTE);
				id = e.getAttribute(ID_ATTRIBUTE);
				filters.put(id, (AbstractFilter) o);
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
		HashMap<String, AbstractAdapter> adapters = new HashMap<String, AbstractAdapter>();
		for (IConfigurationElement e : adapterExtensions) {
			try {
				o = e.createExecutableExtension(CLASS_ATTRIBUTE);
				id = e.getAttribute(ID_ATTRIBUTE);
				adapters.put(id, (AbstractAdapter) o);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		// get the list of registered visualizations
		final IConfigurationElement[] visualizationExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						SINK_EXTENSION_POINT_ID);
		HashMap<String, IVisualizationInput> charts = new HashMap<String, IVisualizationInput>();
		for (IConfigurationElement e : visualizationExtensions) {
			try {
				id = e.getAttribute(ID_ATTRIBUTE);
				o = e.createExecutableExtension(CLASS_ATTRIBUTE);
				charts.put(id, (JFreeChartEditorInput) o);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				logger.log(Level.SEVERE, e1.getMessage());
				throw new RuntimeException();
			}
		}

		defaultSequences = new ArrayList<DefaultSequence>();

		final IConfigurationElement[] defaultSequencesExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						DEFAULT_COMBOS_EXTENSION_POINT_ID);

		for (IConfigurationElement e : defaultSequencesExtensions) {

			DefaultSequence tempDefault = new DefaultSequence();

			tempDefault.setSequenceID(e.getAttribute(ID_ATTRIBUTE));
			tempDefault.setSequenceName(e.getAttribute(NAME_ATTRIBUTE));

			final IConfigurationElement[] sequence = e.getChildren();

			// use if-then-else to keep the order of transformations the same as
			// in the extension

			for (IConfigurationElement element : sequence) {
				if (element.getName().equals(ELEMENT_ID_ADAPTER)) {
					tempDefault.addSequenceElement(adapters.get(element
							.getAttribute(ADAPTER_ID_ATTRIBUTE)));
					final IConfigurationElement[] properties = element
							.getChildren(ELEMENT_ID_PROPERTY);
					for (IConfigurationElement property : properties) {
						HashMap<String, Object> elementProperties = new HashMap<String, Object>();
						elementProperties.put(property
								.getAttribute(PROPERTY_KEY_ATTRIBUTE), property
								.getAttribute(PROPERTY_VALUE_ATTRIBUTE));
						tempDefault.addSequenceProperty(elementProperties);
					}
				} else if (element.getName().equals(ELEMENT_ID_FILTER)) {
					tempDefault.addSequenceElement(filters.get(element
							.getAttribute(FILTER_ID_ATTRIBUTE)));
					final IConfigurationElement[] properties = element
							.getChildren(ELEMENT_ID_PROPERTY);
					for (IConfigurationElement property : properties) {
						HashMap<String, Object> elementProperties = new HashMap<String, Object>();
						elementProperties.put(property
								.getAttribute(PROPERTY_KEY_ATTRIBUTE), property
								.getAttribute(PROPERTY_VALUE_ATTRIBUTE));
						tempDefault.addSequenceProperty(elementProperties);
					}

				} else if (element.getName().equals(ELEMENT_ID_DATASINK)) {
					// the visualization is handled separately by the
					// DefaultSequence class
					tempDefault.setVisualization(charts.get(element
							.getAttribute(DATASINK_ID_ATTRIBUTE)));
					final IConfigurationElement[] properties = element
							.getChildren(ELEMENT_ID_PROPERTY);
					for (IConfigurationElement property : properties) {
						HashMap<String, Object> elementProperties = new HashMap<String, Object>();
						elementProperties.put(property
								.getAttribute(PROPERTY_KEY_ATTRIBUTE), property
								.getAttribute(PROPERTY_VALUE_ATTRIBUTE));
						tempDefault
								.setVisualizationProperties(elementProperties);
					}
				}
			}

			// there is exactly 1 element of the type inputMetric
			IConfigurationElement inputMetricElement = e
					.getChildren(ELEMENT_ID_INPUT_METRIC)[0];
			tempDefault.setInputMetricUUID(inputMetricElement
					.getAttribute(INPUT_METRIC_UUID_ATTRIBUTE));
			tempDefault.setInputDescription(inputMetricElement
					.getAttribute(INPUT_METRIC_DESCRIPTION_ATTRIBUTE));

			defaultSequences.add(tempDefault);

		}

		// HistogramAdapter+Histogram are added independently of Default
		// Combinations in extension points
		DefaultSequence basicSequence1 = new DefaultSequence();
		basicSequence1.setSequenceID("histogramAdapterDefault");
		basicSequence1.setSequenceName("Histogram + Adapter");
		basicSequence1.setInputMetricUUID("no_UUID");
		basicSequence1
				.addSequenceElement(adapters
						.get("de.uka.ipd.sdq.edp2.transformation.HistogramFrequencyAdapter"));
		basicSequence1.setVisualization(charts
				.get("de.uka.ipd.sdq.edp2.visualization.inputs.HistogramEditorInput"));
		// The scatterplot is added independently of Default Combinations in
		// extension points
		DefaultSequence basicSequence2 = new DefaultSequence();
		basicSequence2.setSequenceID("scatterplotDefault");
		basicSequence2.setSequenceName("Scatterplot");
		basicSequence2.setInputMetricUUID("no_UUID");
		basicSequence2.setVisualization(charts
				.get("de.uka.ipd.sdq.edp2.visualization.inputs.ScatterPlotInput"));
		
		// experimental sequence with histogram only (for multiple dataseries)
		DefaultSequence basicSequence3 = new DefaultSequence();
		basicSequence3.setSequenceID("histogramDefault");
		basicSequence3.setSequenceName("Histogram (EXPERIMENTAL)");
		basicSequence3.setInputMetricUUID("no_UUID");
		basicSequence3.setVisualization(charts
				.get("de.uka.ipd.sdq.edp2.visualization.inputs.HistogramEditorInput"));

		defaultSequences.add(basicSequence1);
		defaultSequences.add(basicSequence2);
		defaultSequences.add(basicSequence3);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
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
				//do nothing here
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return getApplicableSequences(selectedSource).toArray();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				//do nothing here
			}
		});
		choiceViewer.setLabelProvider(new ILabelProvider() {

			@Override
			public void addListener(ILabelProviderListener listener) {
				//do nothing here
			}

			@Override
			public void dispose() {
				//do nothing here
			}

			@Override
			public Image getImage(Object element) {
				//do nothing here
				return null;
			}

			@Override
			public String getText(Object element) {
				if (element != null) {
					// the elements in the list are of type DefaultSequence
					DefaultSequence sequenceElement = (DefaultSequence) element;
					StringBuilder shownString = new StringBuilder(
							sequenceElement.getSequenceName());
					// return the sequenceName as labels
					return shownString.toString();
				}
				return null;
			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				//not used
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {
				//not used
			}
		});

		choiceViewer.setInput(getApplicableSequences(selectedSource));
		choiceViewer.addSelectionChangedListener(this);

		// set the composite as the control for this page
		setControl(composite);
		updatePageStatus();
	}

	/**
	 * Method that checks if a given {@link AbstractDataSource} can be processed by any registered {@link DefaultSequence}-objects and returns
	 * the possible results as a list.
	 * @param forSource the {@link AbstractDataSource} for which sequences are returned
	 * @return list of {@link DefaultSequence}-objects that can process the given source.
	 */
	private ArrayList<DefaultSequence> getApplicableSequences(
			AbstractDataSource forSource) {
		ArrayList<DefaultSequence> applicableSequences = new ArrayList<DefaultSequence>();

		for (DefaultSequence seq : defaultSequences) {
			if (seq.getInputMetricUUID().equals(
					forSource.getOriginalMeasurementsRange().getMeasurements()
							.getMeasure().getMetric().getUuid())) {
				applicableSequences.add(seq);
			}
			else if (seq.getInputMetricUUID().equals("no_UUID")) {
				if (seq.getSize() > 0) {
					if (seq.getFirstSequenceElement().canAccept(forSource)) {
						applicableSequences.add(seq);
					}
				} else {
					if (seq.getVisualization().canAccept(forSource)) {
						applicableSequences.add(seq);
					}
				}
			}
		}

		return applicableSequences;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(
	 * org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
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
			setSelectedDefault(getApplicableSequences(selectedSource)
					.get(index));
		}

		updatePageStatus();
	}

	/**
	 * Method which handles the status of the whole {@link WizardPage} based on
	 * the different states resulting from inputs.
	 * 
	 * @return the page Status
	 */
	public IStatus updatePageStatus() {
		IStatus pageStatus = statusOK;
		((DefaultViewsWizard) getWizard()).setFinishable(false);
		switch (selectionStatus.getSeverity()) {
		case IStatus.OK:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage());
			pageStatus = statusOK;
			((DefaultViewsWizard) getWizard()).setFinishable(true);
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

	/**
	 * Forwards the chosen variant to the wizard.
	 * 
	 * @param selection
	 */
	public void setSelectedDefault(DefaultSequence selection) {
		((DefaultViewsWizard) getWizard()).setSelectedDefault(selection);
	}

}

package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.DataAdapter;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.views.ViewDropTargetListener;

public abstract class AbstractReportView extends EditorPart implements
		ITabbedPropertySheetPageContributor, Observer {

	/** Contributor identifier. */
	public static String ABSTRACT_EDITOR_ID = "de.uka.ipd.sdq.sensorframework.visualisation.AbstractReportView";

	/** Editor input. */
	protected ConfigEditorInput myInput;
	
	/** List of all data adapters used by this report. */
	private ArrayList<DataAdapter> dataAdapters = null;

	/**Marks if the SettingsChanged event from DataAdapters are ignored. */
	private boolean ignoreDataSettingsChanged;

	public AbstractReportView() {
		super();
		ignoreDataSettingsChanged = false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		getSite().setSelectionProvider(new ISelectionProvider() {

			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public ISelection getSelection() {
				return new StructuredSelection(this);
			}

			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public void setSelection(ISelection selection) {
			}
		});

		addDropSupport(parent);

		createReportControls(parent);
		changedInputData();
	}

	/** The method define a 'Template method' pattern. */
	protected abstract void createReportControls(Composite parent);

	private void addDropSupport(Control control) {

		int operations = DND.DROP_COPY | DND.DROP_DEFAULT;
		DropTarget target = new DropTarget(control, operations);

		Transfer[] transferTypes = new Transfer[] { 
				LocalSelectionTransfer.getTransfer()
		};
		target.setTransfer(transferTypes);
		target.addDropListener(new ViewDropTargetListener(
				this.getEditorInput()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	/** The method return the contributor identifier for 'ConfigEditorInput'. */
	public String getContributorId() {
		return ABSTRACT_EDITOR_ID;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		myInput = (ConfigEditorInput) input;
		myInput.addObserver(this);
	}

	/** {@inheritDoc}
	 */
	public void update(Observable o, Object arg) {
		getSite().getPage().activate(this);
		if (arg != null) {
			if (arg == DataAdapter.SETTINGS_CHANGED)
				if (!ignoreDataSettingsChanged)
					generateVisualization(dataAdapters);
			if (ConfigEditorInput.class.isInstance(arg))
				changedInputData();
		}
	}

	private void changedInputData() {
		ArrayList<SensorAndMeasurements> list = new ArrayList<SensorAndMeasurements>();

		for (ConfigEntry re : myInput.getConfigEntrys()) {
			for (Sensor s : re.getSensors()) {
				try {
					list.add(re.getExperimentRun().getMeasurementsOfSensor(s));
				} catch (Exception e1) {
					showMessage(s.getSensorName(),
							"Missing the Measurements of sensor!");
				}
			}
		}
		// get the adapter factory for input
		IAdapterFactory adapterFactory = AdapterRegistry.singleton()
				.getFactoryByID(myInput.getAdapterFactoryID());

		/* Add the data sources to this report an observe changes at
		 * the adapters and their settings.
		 */
		ArrayList<DataAdapter> newDataAdapters = new ArrayList<DataAdapter>();
		DataAdapter usedAdapter = null;
		for (SensorAndMeasurements sam : list) {
			usedAdapter = adapterFactory.getAdapter(myInput
					// set the empty filter of the measurements 
					.getFiltersManager().getFilteredMeasurements(sam));
			usedAdapter.addObserver(this);
			newDataAdapters.add(usedAdapter);
		}
		generateVisualization(newDataAdapters);
		for (DataAdapter adapter : newDataAdapters) {
			adapter.addObserver(this);
		}
		dataAdapters = newDataAdapters;
	}

	protected abstract void generateVisualization(List<DataAdapter> list);
	
	/** Show exception message. */
	private void showMessage(String title, String message) {
		MessageDialog.openInformation(this.getEditorSite().getShell(), title,
				message);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		// The implementation is not necessary.
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		// The implementation is not necessary.
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#isDirty()
	 */
	@Override
	public boolean isDirty() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	public boolean isIgnoreDataSettingsChanged() {
		return ignoreDataSettingsChanged;
	}

	public void setIgnoreDataSettingsChanged(boolean ignoreDataSettingsChanged) {
		this.ignoreDataSettingsChanged = ignoreDataSettingsChanged;
	}
}
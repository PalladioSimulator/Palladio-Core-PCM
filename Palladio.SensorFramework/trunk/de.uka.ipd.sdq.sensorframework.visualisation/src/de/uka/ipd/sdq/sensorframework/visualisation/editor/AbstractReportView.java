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
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.views.ViewDropTargetListener;

public abstract class AbstractReportView extends EditorPart implements
		ITabbedPropertySheetPageContributor, Observer {

	public static String ABSTRACT_EDITOR_ID = "de.uka.ipd.sdq.codegen.simudatavisualization.views.ReportView";
	private ConfigEditorInput myInput;
	
	public AbstractReportView() {
		super();
	}

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
		setViewerInput();
	}

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

	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	public String getContributorId() {
		return ABSTRACT_EDITOR_ID;
	}

	@Override
	public void setFocus() {
		// TODO !!
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
	}

	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		myInput = (ConfigEditorInput) input;
		myInput.addObserver(this);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	public void update(Observable o, Object arg) {
		getSite().getPage().activate(this);
		setViewerInput();
	}

	private void setViewerInput() {
		ArrayList<SensorAndMeasurements> list = new ArrayList<SensorAndMeasurements>();
		
		for (ConfigEntry re : myInput.getConfigEntrys()) {
			for (Sensor s : re.getSensors()) {
				try {
					list.add(re.getExperimentRun()
							.getMeasurementsOfSensor(s));
				} catch (Exception e1) {
					showMessage(s.getSensorName(),
							"Missing the Measurements of sensor!");
				}
			}
		}
		IAdapterFactory myFactory = AdapterRegistry.singleton().getFactoryByID(myInput.getAdapterFactoryID());
		ArrayList<IAdapter> input = new ArrayList<IAdapter>();
		for (SensorAndMeasurements sam : list)
			input.add(myFactory.getAdapter(sam));
		this.setInput(input);
	}

	protected abstract void setInput(List<IAdapter> list);
	
	/** show exception message */
	private void showMessage(String title, String message) {
		MessageDialog.openInformation(this.getEditorSite().getShell(), title,
				message);
	}
}
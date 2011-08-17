package de.uka.ipd.sdq.edp2.models.ExperimentData.presentation;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;
import de.uka.ipd.sdq.edp2.visualization.dialogs.SelectVisualizationDialog;
import de.uka.ipd.sdq.edp2.visualization.dialogs.SelectVisualizationLabelProvider;
import de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInput;
import de.uka.ipd.sdq.edp2.visualization.wizards.AdapterWizard;

/**
 * Listener for selections in the TreeViewer of {@link ExperimentDataEditor}.
 * Upon Doubleklick on a {@link RawMeasurements}-object it opens a Dialog and
 * offers possible Editors to display the data encapsulated by the object. Also
 * creates a new {@link EDP2Source}, which is associated with the selected
 * {@link RawMeasurements}.
 * 
 * @author ernst
 * 
 */
public class DoubleClickListener implements IDoubleClickListener {

	private final static Logger logger = Logger
			.getLogger(DoubleClickListener.class.getCanonicalName());

	@Override
	public void doubleClick(DoubleClickEvent event) {
		Object selectedObject = null;
		if (event.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) event
					.getSelection();
			selectedObject = selection.getFirstElement();
		}
		RawMeasurements measurement = null;
		if (selectedObject instanceof RawMeasurements) {
			measurement = (RawMeasurements) selectedObject;

			if (measurement != null && !measurement.getDataSeries().isEmpty()) {

				EDP2Source source = new EDP2Source(measurement);

				SelectVisualizationDialog dialog = new SelectVisualizationDialog(
						event.getViewer().getControl().getShell(),
						new SelectVisualizationLabelProvider());
				dialog.setElements(getPossibleVisualizations(measurement));
				dialog.open();
				Object[] results = dialog.getResult();

				Object result = results[0];
				IEditorInput input = null;
				if (result instanceof ScatterPlotEditor) {
					input = new ScatterPlotInput(source);
					try {
						IWorkbenchPage page = EDP2EditorPlugin
								.getPlugin()
								.getWorkbench()
								.getActiveWorkbenchWindow()
								.getActivePage();
						IEditorPart editor = page
								.openEditor(input,
										"de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlot");
						page.addPartListener(new PartEventListener());
					} catch (PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (result instanceof HistogramEditor) {
						// HistogramFrequencyAdapter adapter = new
						// HistogramFrequencyAdapter(source);
						// input = new HistogramEditorInput(adapter);
						AdapterWizard wizard = new AdapterWizard(source);
						IAdapter adapter = null;
						WizardDialog wdialog = new WizardDialog(
								EDP2EditorPlugin.getPlugin().getWorkbench()
										.getActiveWorkbenchWindow().getShell(),
								wizard);
						wdialog.open();
						if (wdialog.getReturnCode() == Window.OK) {
							adapter = wizard.getAdapter();
							input = new HistogramEditorInput(adapter);
							try {
								EDP2EditorPlugin
										.getPlugin()
										.getWorkbench()
										.getActiveWorkbenchWindow()
										.getActivePage()
										.openEditor(input,
												"de.uka.ipd.sdq.edp2.visualization.editors.Histogram");
							} catch (PartInitException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				}

			} else {
				throw new RuntimeException("Empty Measurements!");
			}
		}

	}

	private Object[] getPossibleVisualizations(RawMeasurements measurement) {
		ArrayList<Object> list = getRegisteredVisualizations();
		list.clear();
		list.add(new ScatterPlotEditor());
		list.add(new HistogramEditor());
		return (list.toArray());
	}

	public ArrayList<Object> getRegisteredVisualizations() {
		ArrayList<Object> list = new ArrayList<Object>();
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						"de.uka.ipd.sdq.edp2.editor.visualizations");
		for (IConfigurationElement element : configurationElements) {

			logger.log(Level.INFO, "found class:"
					+ element.getAttribute("class"));
			/*
			 * try { Class<?> someClass =
			 * Class.forName(element.getAttribute("class")); Object someObject =
			 * someClass.newInstance(); list.add(someObject); } catch
			 * (InvalidRegistryObjectException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } catch (ClassNotFoundException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); } catch
			 * (InstantiationException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (IllegalAccessException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */

		}
		return list;
	}

	public static IConfigurationElement[] getConfigurationElements() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						"de.uka.ipd.sdq.edp2.visualization");

		return configurationElements;
	}

}

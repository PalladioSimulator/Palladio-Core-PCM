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
import de.uka.ipd.sdq.edp2.visualization.AbstractTransformation;
import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;
import de.uka.ipd.sdq.edp2.visualization.dialogs.SelectVisualizationDialog;
import de.uka.ipd.sdq.edp2.visualization.dialogs.SelectVisualizationLabelProvider;
import de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInput;
import de.uka.ipd.sdq.edp2.visualization.wizards.AdapterWizard;
import de.uka.ipd.sdq.edp2.visualization.wizards.DefaultSequence;
import de.uka.ipd.sdq.edp2.visualization.wizards.DefaultViewsWizard;

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

				DefaultViewsWizard wizard = new DefaultViewsWizard(source);
				WizardDialog wdialog = new WizardDialog(EDP2EditorPlugin
						.getPlugin().getWorkbench().getActiveWorkbenchWindow()
						.getShell(), wizard);
				wdialog.open();

				if (wdialog.getReturnCode() == Window.OK) {
					DefaultSequence selection = wizard.getSelectedDefault();

					selection.getFirstSequenceElement().setProperties(
							selection.getSequenceProperties().get(0));
					selection.getFirstSequenceElement().setSource(source);

					for (int i = 1; i < selection.getSize(); i++) {
						selection.getSequenceElements().get(i).setProperties(
								selection.getSequenceProperties().get(i));
						selection.getSequenceElements().get(i).setSource(
								selection.getSequenceElements().get(i - 1));
					}

					IDataSink visualization = selection.getVisualization();
					visualization.setProperties(selection
							.getVisualizationProperties());
					visualization.setSource(selection.getLastSequenceElement());
					IEditorInput input = selection.getVisualization();

					try {
						IWorkbenchPage page = EDP2EditorPlugin.getPlugin()
								.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage();
						IEditorPart editor = page
								.openEditor(input,
										"de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor");
						page.addPartListener(new PartEventListener());
					} catch (PartInitException e) { // TODO Auto-generated
						// catchblock
						e.printStackTrace();
					}

					/*
					 * SelectVisualizationDialog dialog = new
					 * SelectVisualizationDialog(
					 * event.getViewer().getControl().getShell(), new
					 * SelectVisualizationLabelProvider());
					 * dialog.setElements(getPossibleVisualizations
					 * (measurement)); dialog.open(); Object[] results =
					 * dialog.getResult();
					 * 
					 * Object result = results[0]; IEditorInput input = null; if
					 * (result instanceof ScatterPlotInput) { input = new
					 * ScatterPlotInput(source); try { IWorkbenchPage page =
					 * EDP2EditorPlugin .getPlugin() .getWorkbench()
					 * .getActiveWorkbenchWindow() .getActivePage(); IEditorPart
					 * editor = page .openEditor(input,
					 * "de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor"
					 * ); page.addPartListener(new PartEventListener()); } catch
					 * (PartInitException e) { // TODO Auto-generated catch
					 * block e.printStackTrace(); } } else { if (result
					 * instanceof HistogramEditorInput) { //
					 * HistogramFrequencyAdapter adapter = new //
					 * HistogramFrequencyAdapter(source); // input = new
					 * HistogramEditorInput(adapter); AdapterWizard wizard = new
					 * AdapterWizard(source); IAdapter adapter = null;
					 * WizardDialog wdialog = new WizardDialog(
					 * EDP2EditorPlugin.getPlugin().getWorkbench()
					 * .getActiveWorkbenchWindow().getShell(), wizard);
					 * wdialog.open(); if (wdialog.getReturnCode() == Window.OK)
					 * { adapter = wizard.getAdapter(); input = new
					 * HistogramEditorInput(adapter); try { EDP2EditorPlugin
					 * .getPlugin() .getWorkbench() .getActiveWorkbenchWindow()
					 * .getActivePage() .openEditor(input,
					 * "de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor"
					 * ); } catch (PartInitException e) { // TODO Auto-generated
					 * catch block e.printStackTrace(); } }
					 * 
					 * } }
					 */

				}
			} else {
				throw new RuntimeException("Empty Measurements!");
			}
		}

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

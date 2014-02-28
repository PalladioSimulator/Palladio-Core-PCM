package de.uka.ipd.sdq.edp2.ui.views.navigator;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.ui.EDP2UIPlugin;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInputHandle;
import de.uka.ipd.sdq.edp2.visualization.wizards.DefaultSequence;
import de.uka.ipd.sdq.edp2.visualization.wizards.DefaultViewsWizard;

/**
 * Listener for selections in the {@link Navigator}.
 * Creates a new {@link EDP2Source}, which is associated with the selected
 * {@link RawMeasurements}. Upon Double-click on a {@link RawMeasurements}
 * -object, it opens a Dialog and offers possible combinations of visualizations
 * and transformations to display the data encapsulated by the object. All
 * combinations are objects of the Type {@link DefaultSequence} and displayed in
 * the {@link DefaultViewsWizard}.
 * 
 * TODO This is a copied version of /de.uka.ipd.sdq.edp2.editor/src-man/de/uka
 *      /ipd/sdq/edp2/models/ExperimentData/presentation/NavigatorDoubleClickListener.java.
 *      Get rid of redundancies.
 * 
 * @author Sebastian Lehrig
 * 
 */
public class NavigatorDoubleClickListener implements IDoubleClickListener {

	private final static Logger logger = Logger
			.getLogger(NavigatorDoubleClickListener.class.getCanonicalName());

	@Override
	public void doubleClick(DoubleClickEvent event) {
		Object selectedObject = null;
		if (event.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) event
					.getSelection();
			selectedObject = selection.getFirstElement();
		}
		RawMeasurements measurement = null;
		// check for the object to contain actual data
		if (selectedObject instanceof RawMeasurements) {
			measurement = (RawMeasurements) selectedObject;

			if (measurement != null && !measurement.getDataSeries().isEmpty()) {

				EDP2Source source = new EDP2Source(measurement);

				// open the wizard with reference to the selected source
				// it shows possible visualizations, which are instances of
				// DefaultSequence
				DefaultViewsWizard wizard = new DefaultViewsWizard(source);
				WizardDialog wdialog = new WizardDialog(EDP2UIPlugin.INSTANCE.getWorkbench().getActiveWorkbenchWindow()
						.getShell(), wizard);
				wdialog.open();

				if (wdialog.getReturnCode() == Window.OK) {
					DefaultSequence selection = wizard.getSelectedDefault();

					// check if something has been selected (should be always
					// the case)
					if (selection.getSize() > 0) {
						// check if there are properties for the first element
						// in the selected combination
						if (selection.getSequenceProperties().size() > 0) {
							logger.log(Level.INFO,
									"Setting properties of element "
											+ selection.getSequenceElements()
													.get(0).getName()
											+ " with "
											+ selection.getSequenceProperties()
													.get(0));
							selection.getFirstSequenceElement().setProperties(
									selection.getSequenceProperties().get(0));
						}
						selection.getFirstSequenceElement().setSource(source);
					}

					// for all other IDataFlow elements in the DefaultSequence,
					// set their properties to provided values
					for (int i = 1; i < selection.getSize(); i++) {
						selection
								.getSequenceElements()
								.get(i)
								.setProperties(
										selection.getSequenceProperties()
												.get(i));
						logger.log(Level.INFO, "Setting properties of element "
								+ selection.getSequenceElements().get(i)
										.getName() + " with "
								+ selection.getSequenceProperties().get(i));
						selection
								.getSequenceElements()
								.get(i)
								.setSource(
										selection.getSequenceElements().get(
												i - 1));
					}
					logger.log(Level.INFO, selection
							.getVisualizationProperties().toString());
					IVisualizationInput visualization = selection
							.getVisualization();
					visualization.setProperties(selection
							.getVisualizationProperties());
					if (selection.getSize() > 0) {
						visualization.setSource(selection
								.getLastSequenceElement());
					} else {
						visualization.setSource(source);
					}
					JFreeChartEditorInputHandle input = new JFreeChartEditorInputHandle(
							(JFreeChartEditorInput) visualization);
					logger.log(Level.INFO,
							input.getInputProperties()[0].toString());

					try {
						IWorkbenchPage page = EDP2UIPlugin.INSTANCE.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage();
						page.openEditor(input,
								"de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor");
					} catch (PartInitException e) {
						logger.log(Level.SEVERE, "Could not initialize editor!");
						e.printStackTrace();
					}

				}
			} else {
				throw new RuntimeException("Empty Measurements!");
			}
		}

	}

}

package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.logging.Logger;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInputHandle;

/**
 * GUI controls for displaying options of {@link AbstractEditor}s. Shows and
 * allows to edit visual settings of the current Editor in the Eclipse
 * Properties View if an {@link AbstractEditor} is the currently active editor.
 * 
 * @author Roland Richter, Dominik Ernst
 * 
 */
public class DisplayPropertySection extends AbstractPropertySection {
	/** Logger */
	private static Logger logger = Logger
			.getLogger(DisplayPropertySection.class.getCanonicalName());

	/**
	 * Key, which must be the same as the key under which the ID's / names of
	 * {@link IDataSink}s are stored.
	 */
	private final static String NAME_KEY = "elementName";
	private InputSelectionComposite selectionComposite;
	/**
	 * Composite for all properties of all JFreeCharts
	 */
	private CommonChartPropertiesComposite commonComposite;
	/**
	 * Composite for the properties of the currently displayed chart.
	 */
	private Composite specificComposite;
	/**
	 * The last active editor;
	 */
	private JFreeChartEditor editor;
	/**
	 * The parent composite.
	 */
	private Composite parent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		this.parent = parent;
		if (getInput() != null) {
			selectionComposite = new InputSelectionComposite(parent,
					SWT.EMBEDDED, getInput());
			if (selectionComposite.getInputSelection() != null) {
				createPropertyComposites();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput
	 * (org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
	}

	/**
	 * Retrieves the input of the currently active editor.
	 * 
	 * @return the current {@link IDataSink}
	 */
	public JFreeChartEditorInputHandle getInput() {
		if (Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
				.getActivePage() == null) {
			return null;
		}
		editor = (JFreeChartEditor) Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		return (JFreeChartEditorInputHandle) editor.getEditorInput();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		updateInput();
	}

	private void updateInput() {
		if (specificComposite != null) {
			specificComposite.dispose();
		}
		if (selectionComposite != null) {
			selectionComposite.dispose();
		}
		if (commonComposite != null) {
			commonComposite.dispose();
		}
		selectionComposite = new InputSelectionComposite(parent, SWT.EMBEDDED,
				getInput());
		selectionComposite.getComboBox().addSelectionListener(
				new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						createPropertyComposites();

					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						createPropertyComposites();
					}
				});
		if (selectionComposite.getInputSelection() != null) {
			createPropertyComposites();
		}
	}

	private void createPropertyComposites() {

		commonComposite = selectionComposite.getInputSelection()
				.getCommonChartProperties().retrieveComposite(parent);
		specificComposite = selectionComposite.getInputSelection()
				.getChartProperties().retrieveComposite(parent);
	}

}

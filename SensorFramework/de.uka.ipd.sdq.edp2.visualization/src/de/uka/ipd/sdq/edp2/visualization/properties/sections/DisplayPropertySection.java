package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;

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
	 * Key which must be the same as the key under which the ID's / names of
	 * {@link IDataSink}s are stored.
	 */
	private final static String NAME_KEY = "elementName";
	/**
	 * The current input of the
	 */
	private JFreeChartEditorInput editorInput;
	/**
	 * The table to show all modifiable attributes.
	 */
	private Table propertyTable;
	/**
	 * The last active editor;
	 */
	private AbstractEditor editor;

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

		try {
			// properties view is only visible for abstract editors, so no type
			// check is necessary
			editor = (AbstractEditor) Activator.getDefault().getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			// NPE may happen if the properties view is restored or opened while
			// the editor is still or already closed
		} catch (NullPointerException npe) {
			logger.log(Level.SEVERE,
					"Tried to open properties view without an active editor!");
			throw new RuntimeException();
		}
		new CommonChartPropertiesComposite(parent, SWT.EMBEDDED, new CommonChartProperties(getInput().getChart()));
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
	public JFreeChartEditorInput getInput() {
		editor = (AbstractEditor) Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		editorInput = (JFreeChartEditorInput) editor.getEditorInput();
		return editorInput;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
	}

}

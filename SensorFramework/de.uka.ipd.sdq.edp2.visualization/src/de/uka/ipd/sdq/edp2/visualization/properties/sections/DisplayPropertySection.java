package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInput;

/**
 * only Testting TAB
 * @author Roland Richter, Dominik Ernst
 * 
 */
public class DisplayPropertySection extends AbstractPropertySection {
	/** Logger */
	private static Logger logger = Logger.getLogger(DisplayPropertySection.class.getCanonicalName());
	
	private Text labelText;
	private ScatterPlotInput configObject;
	

	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		labelText = getWidgetFactory().createText(composite, "fdh"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelText.setLayoutData(data);
		// labelText.addModifyListener(listener);

		CLabel labelLabel = getWidgetFactory()
				.createCLabel(composite, "Label:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(labelText,
				-ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(labelText, 0, SWT.CENTER);
		labelLabel.setLayoutData(data);
		
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
		logger.log(Level.INFO, "setinput");
		super.setInput(part, selection);

		if (part instanceof ScatterPlotEditor) {
			ScatterPlotEditor editor = (ScatterPlotEditor) part;
			configObject = (ScatterPlotInput) editor.getEditorInput();
		}
	}
	
	public IDataSource getSource() {
		return configObject.getSource();
	}
	
	public void refresh() {
		super.refresh();
	}
	
}

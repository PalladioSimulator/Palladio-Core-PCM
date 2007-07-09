/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.perspectives;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author johann
 *
 */
public class DomainExpertPerspective implements IPerspectiveFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		// TODO Auto-generated method stub
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
				
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.componentdeveloper_perspective");
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.softwarearchitect_perspective");
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.deployer_perspective");
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.domainexpert_perspective");
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.qosanalyst_perspective");
		
		layout.addView("org.eclipse.ui.examples.navigator.view", IPageLayout.LEFT, 0.25f, editorArea);
	}

}

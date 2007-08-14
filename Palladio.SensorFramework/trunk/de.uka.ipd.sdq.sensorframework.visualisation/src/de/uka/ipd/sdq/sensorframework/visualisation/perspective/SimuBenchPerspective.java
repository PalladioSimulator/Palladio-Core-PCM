/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.perspective;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author admin
 *
 */
public class SimuBenchPerspective implements IPerspectiveFactory {
	
	private static final String EXPERIMENTS_VIEW = "de.uka.ipd.sdq.codegen.simudatavisualization.ExperimentsView";
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		//layout.addActionSet(MAIN_ACTION_SET);
		
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.25f, editorArea);
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.75f, editorArea);

		topLeft.addView(EXPERIMENTS_VIEW);
		
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		
		layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);		
	}
}

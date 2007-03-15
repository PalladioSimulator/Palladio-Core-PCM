/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author admin
 *
 */
public class SimuBenchPerspective implements IPerspectiveFactory {
	
	private static final String EXPERIMENTS_VIEW = "de.uka.ipd.sdq.codegen.simudatavisualization.ExperimentsView";
	private static final String REPORT_VIEW = "de.uka.ipd.sdq.codegen.simudatavisualization.ReportView";

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(false);
		
		//layout.addActionSet(MAIN_ACTION_SET);
		
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.25f, editorArea);
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.75f, editorArea);
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, 2.0f, editorArea);

		topLeft.addView(EXPERIMENTS_VIEW);
		right.addView(REPORT_VIEW);
		
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
	}

}

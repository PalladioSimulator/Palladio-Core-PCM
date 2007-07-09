/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.perspectives;


import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


/**
 * @author steffen, johann
 *
 */
public class ComponentDeveloperPerspective implements IPerspectiveFactory {

	private static final String MAIN_ACTION_SET = "de.uka.ipd.sdq.PCMBench.mainActionSet";

	private static final String NAVIGATOR_VIEW = "de.uka.ipd.sdq.pcmbench.projectview";

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {		
				
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.componentdeveloper_perspective");
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.softwarearchitect_perspective");
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.deployer_perspective");
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.domainexpert_perspective");
		layout.addPerspectiveShortcut("de.uka.ipd.sdq.pcmbench.qosanalyst_perspective");		
		
		layout.addActionSet(MAIN_ACTION_SET);
		
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.25f, editorArea);
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.75f, editorArea);
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, 0.66f, editorArea);
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.5f, "topLeft");

		topLeft.addView(NAVIGATOR_VIEW);
		topLeft.addView("org.eclipse.ui.navigator.ProjectExplorer");

		right.addView(IPageLayout.ID_OUTLINE);

		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView("org.eclipse.pde.runtime.LogView");
		
		
	}	

}

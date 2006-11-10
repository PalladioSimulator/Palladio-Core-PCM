package de.uka.ipd.sdq.pcmbench.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import de.uka.ipd.sdq.pcmbench.views.ResourceView;

public class PCMBenchPerspective implements IPerspectiveFactory {

	private static final String MAIN_ACTION_SET = "de.uka.ipd.sdq.PCMBench.mainActionSet";

	private static final String NAVIGATOR_VIEW = "de.uka.ipd.sdq.pcmbench.projectview";
	
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		
		layout.addActionSet(MAIN_ACTION_SET);
		
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.25f, editorArea);
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.75f, editorArea);
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, 0.66f, editorArea);
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.5f, "topLeft");

		topLeft.addView(NAVIGATOR_VIEW);
		bottomLeft.addView(ResourceView.ID);

		right.addView(IPageLayout.ID_OUTLINE);

		bottom.addView(IPageLayout.ID_PROP_SHEET);
	}
}

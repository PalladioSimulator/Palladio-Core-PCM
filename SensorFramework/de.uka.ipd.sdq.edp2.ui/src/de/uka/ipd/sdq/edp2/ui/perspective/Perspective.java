package de.uka.ipd.sdq.edp2.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * The EDP2 perspective.
 * 
 * @author Sebastian Lehrig
 */
public class Perspective implements IPerspectiveFactory {
	private final String NAVIGATOR_ID = "de.uka.ipd.sdq.edp2.ui.views.navigator";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);

		IFolderLayout navFolder = layout.createFolder("experiments",
				IPageLayout.LEFT, 0.33f, editorArea);
		navFolder.addView(NAVIGATOR_ID);
		layout.getViewLayout(NAVIGATOR_ID).setCloseable(false);
	}

}

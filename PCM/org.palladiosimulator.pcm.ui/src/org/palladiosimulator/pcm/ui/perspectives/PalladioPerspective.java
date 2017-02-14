package org.palladiosimulator.pcm.ui.perspectives;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.sirius.ui.tools.api.views.modelexplorerview.IModelExplorerView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

/**
 * Provides the Palladio UI perspective.
 * 
 * @author Priti Chaudhari
 * @author Philipp Merkle
 * @author Amine Kechaou
 * 
 */
public class PalladioPerspective implements IPerspectiveFactory {

    private final String SIMULATION_VIEW_ID = "de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusViewPart";
    private final String EXPERIMENTS_VIEW = "org.palladiosimulator.edp2.ui.views.navigator";

    @Override
    public void createInitialLayout(final IPageLayout layout) {
        defineActions(layout);
        defineLayout(layout);
    }

    private void defineLayout(final IPageLayout layout) {
        layout.setEditorAreaVisible(true);
        layout.setFixed(false);

        final String editorAreaId = layout.getEditorArea();

        // Top left: Project view and Experiments view
        final IFolderLayout topLeftFolder = layout
                .createFolder("topLeft", IPageLayout.LEFT, (float) 0.25, editorAreaId);
        topLeftFolder.addView(IModelExplorerView.ID);
        topLeftFolder.addView(this.EXPERIMENTS_VIEW);

        // Bottom left: Outline view.
        final IFolderLayout bottomLeftFolder = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.618f, "topLeft");
        bottomLeftFolder.addView(IPageLayout.ID_OUTLINE);

        // Place properties and console view to bottom of the editor area.
        final IFolderLayout bottomFolder = layout
                .createFolder("bottom", IPageLayout.BOTTOM, (float) 0.75, editorAreaId);
        bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
        bottomFolder.addView(IConsoleConstants.ID_CONSOLE_VIEW);

        // Place Simulation Dock Status next to properties.
        final IFolderLayout bottomRightFolder = layout.createFolder("bottomRight", IPageLayout.RIGHT, (float) 0.618,
                "bottom");
        bottomRightFolder.addView(this.SIMULATION_VIEW_ID);
    }

    private void defineActions(final IPageLayout layout) {
        // add "Run <configuration>"-button (along with additional buttons residing in the same
        // action set)
        layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
    }

}

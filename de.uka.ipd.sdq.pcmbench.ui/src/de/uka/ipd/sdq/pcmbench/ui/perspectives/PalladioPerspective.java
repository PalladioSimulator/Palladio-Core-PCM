package de.uka.ipd.sdq.pcmbench.ui.perspectives;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

/**
 * Provides the Palladio UI perspective.
 * 
 * @author Priti Chaudhari
 * @author Philipp Merkle
 * 
 */
public class PalladioPerspective implements IPerspectiveFactory {

    private final String SIMULATION_VIEW_ID = "de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusViewPart";
    private final String EXPERIMENTS_VIEW = "de.uka.ipd.sdq.codegen.simudatavisualization.ExperimentsView";

    @Override
    public void createInitialLayout(IPageLayout layout) {
        defineActions(layout);
        defineLayout(layout);
    }

    private void defineLayout(IPageLayout layout) {
        layout.setEditorAreaVisible(true);
        layout.setFixed(false);

        String editorAreaId = layout.getEditorArea();

        // Top left: Project view and Experiments view
        IFolderLayout topLeftFolder = layout.createFolder("topLeft", IPageLayout.LEFT, (float) 0.25, editorAreaId);
        topLeftFolder.addView(IPageLayout.ID_PROJECT_EXPLORER);
        topLeftFolder.addView(EXPERIMENTS_VIEW);

        // Bottom left: Outline view.
        IFolderLayout bottomLeftFolder = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.618f, "topLeft");
        bottomLeftFolder.addView(IPageLayout.ID_OUTLINE);

        // Place properties and console view to bottom of the editor area.
        IFolderLayout bottomFolder = layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.75, editorAreaId);
        bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
        bottomFolder.addView(IConsoleConstants.ID_CONSOLE_VIEW);

        // Place Simulation Dock Status next to properties.
        IFolderLayout bottomRightFolder = layout
                .createFolder("bottomRight", IPageLayout.RIGHT, (float) 0.618, "bottom");
        bottomRightFolder.addView(SIMULATION_VIEW_ID);
    }

    private void defineActions(IPageLayout layout) {
        // add "Run <configuration>"-button (along with additional buttons residing in the same
        // action set)
        layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
    }
    
}

package de.uka.ipd.sdq.codegen.simucontroller.gui;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DocksModel;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockAddedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockDeletedEvent;

public class DockStatusViewPart extends ViewPart implements Observer {

    public static final String ID = "de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusViewPart"; //$NON-NLS-1$
    private HashMap<String, DockStatusViewer> viewers = new HashMap<String, DockStatusViewer>();
    private DocksModel model;
    private Composite container;

    /**
     * Create contents of the view part
     * 
     * @param parent
     */
    @Override
    public void createPartControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new FillLayout());
        model = SimuControllerPlugin.getDockModel();

        for (DockModel dock : model.getAllDocks()) {
            update(model, new DockAddedEvent(dock));
        }
        model.addObserver(this);

        createActions();
    }

    @Override
    public void dispose() {
        model.deleteObserver(this);
        super.dispose();
    }

    /**
     * Create the actions
     */
    private void createActions() {
        // Create the actions
    }

    @Override
    public void setFocus() {
        // Set the focus
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof DockAddedEvent) {
            final DockAddedEvent addedEvent = (DockAddedEvent) arg;
            PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

                public void run() {
                    DockStatusViewPart.this.viewers.put(addedEvent.getDock().getID(),
                            new DockStatusViewer(addedEvent.getDock(), container, SWT.NONE));
                    container.layout();
                    container.redraw();
                }

            });
        }
        if (arg instanceof DockDeletedEvent) {
            final DockDeletedEvent deleteEvent = (DockDeletedEvent) arg;
            PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

                public void run() {
                    DockStatusViewer viewer = DockStatusViewPart.this.viewers.get(deleteEvent.getDock().getID());
                    DockStatusViewPart.this.viewers.remove(deleteEvent.getDock().getID());
                    viewer.dispose();
                    container.layout();
                    container.redraw();
                }

            });
        }
    }

}

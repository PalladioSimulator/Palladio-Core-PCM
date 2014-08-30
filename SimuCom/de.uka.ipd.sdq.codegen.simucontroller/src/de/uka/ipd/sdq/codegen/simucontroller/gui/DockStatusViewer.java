package de.uka.ipd.sdq.codegen.simucontroller.gui;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import swing2swt.layout.BorderLayout;
import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerImages;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;

public class DockStatusViewer extends Composite implements Observer {
    /** Logger for this class. */
    private static final Logger LOGGER = Logger.getLogger(DockStatusViewer.class);

    private Image idleImage;
    private DockModel model;
    private Label simTimeLabel;
    private Label measurementsLabel;
    private ProgressBar progressBar;
    private Label remoteLocationLabel;
    private Label dockIdLabel;
    private Image runningImage;
    private Image pauseImage;
    private Canvas iconCanvas;
    private int lastUIUpdate = -1;

    private ToolItem stop;

    /**
     * Create the composite
     * 
     * @param parent
     * @param style
     */
    public DockStatusViewer(final DockModel model, Composite parent, int style) {
        super(parent, style);
        this.model = model;
        model.addObserver(this);

        setLayout(new BorderLayout(0, 0));

        final Composite composite = new Composite(this, SWT.NONE);
        composite.setLayoutData(BorderLayout.SOUTH);
        composite.setLayout(new FillLayout());

        final Group statusGroup = new Group(composite, SWT.NONE);
        statusGroup.setLayout(new GridLayout(5, false));
        statusGroup.setText("Status");

        final Label idLabel = new Label(statusGroup, SWT.NONE);
        idLabel.setText("ID:");

        dockIdLabel = new Label(statusGroup, SWT.NONE);
        dockIdLabel.setText("Label");
        dockIdLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

        iconCanvas = new Canvas(statusGroup, SWT.NONE);
        iconCanvas.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 4));
        iconCanvas.addPaintListener(new PaintListener() {

            public void paintControl(PaintEvent e) {
                Image image = null;

                if (DockStatusViewer.this.model.isIdle())
                    image = idleImage;
                else if (DockStatusViewer.this.model.isSuspended() && !DockStatusViewer.this.model.isStepping())
                    image = pauseImage;
                else
                    image = runningImage;
                if (!image.isDisposed())
                    e.gc.drawImage(image, 0, 0);
            }

        });

        final Label locationLabel = new Label(statusGroup, SWT.NONE);
        locationLabel.setText("Location:");

        remoteLocationLabel = new Label(statusGroup, SWT.NONE);
        remoteLocationLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        remoteLocationLabel.setText("Label");

        final Label simulationTimeLabel = new Label(statusGroup, SWT.NONE);
        simulationTimeLabel.setText("Simulation Time:");

        simTimeLabel = new Label(statusGroup, SWT.NONE);
        simTimeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        simTimeLabel.setText("Label");

        final Label measurementsLabelLabel = new Label(statusGroup, SWT.NONE);
        measurementsLabelLabel.setText("Measurements:");

        measurementsLabel = new Label(statusGroup, SWT.NONE);
        measurementsLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        measurementsLabel.setText("Label");

        Composite compositeProgress = new Composite(statusGroup, SWT.NONE);
        GridLayout gl_compositeProgress = new GridLayout(2, false);
        gl_compositeProgress.verticalSpacing = 0;
        gl_compositeProgress.marginHeight = 0;
        gl_compositeProgress.marginWidth = 0;
        compositeProgress.setLayout(gl_compositeProgress);
        compositeProgress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));

        progressBar = new ProgressBar(compositeProgress, SWT.NONE);
        progressBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        ToolBar toolBar = new ToolBar(compositeProgress, SWT.FLAT | SWT.RIGHT);

        stop = new ToolItem(toolBar, SWT.NONE);
        stop.setEnabled(false);
        stop.setDisabledImage(SimuControllerImages.imageRegistry.get(SimuControllerImages.SIMU_STOP_BLK));
        stop.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                model.getService().stopSimulation();
            }
        });
        stop.setImage(SimuControllerImages.imageRegistry.get(SimuControllerImages.SIMU_STOP));

        idleImage = SimuControllerImages.imageRegistry.get(SimuControllerImages.MASCHINE);
        runningImage = SimuControllerImages.imageRegistry.get(SimuControllerImages.MASCHINE_BUSY);
        pauseImage = SimuControllerImages.imageRegistry.get(SimuControllerImages.MASCHINE_PAUSE);

        update(model, null);
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }

    public void update(Observable o, Object arg) {
        if (model.getPercentDone() != lastUIUpdate || model.isStepping() || model.isSuspended() || model.isIdle()) {
            PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

                public void run() {
                    showSimuDockView();
                    if (!dockIdLabel.isDisposed())
                        dockIdLabel.setText(model.getID());
                    if (!remoteLocationLabel.isDisposed())
                        remoteLocationLabel.setText(model.getRemoteMaschineURI() == null ? "<local>" : model
                                .getRemoteMaschineURI());
                    if (!measurementsLabel.isDisposed())
                        measurementsLabel.setText(model.getMeasurementCount() + "");
                    if (!simTimeLabel.isDisposed())
                        simTimeLabel.setText(new DecimalFormat("0.#").format(model.getSimTime()));
                    if (!progressBar.isDisposed())
                        progressBar.setSelection(model.getPercentDone());
                    if (!iconCanvas.isDisposed())
                        iconCanvas.redraw();
                    // change stop-button state, depending on the model state
                    stop.setEnabled(!model.isIdle());
                }

            });
        }
        lastUIUpdate = model.getPercentDone();
    }

    public static void showSimuDockView() {
        // if Eclipse is running headless, accessing the workbench would raise an exception
        if (!PlatformUI.isWorkbenchRunning()) {
            return;
        }

        PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

            public void run() {
                // the code is performed asynchronously, so the workbench state needs
                // to be check right before the execution
                if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null) {
                    return;
                }
                IViewPart viewer;
                try {
                    viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                            .showView(DockStatusViewPart.ID);
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(viewer);
                    viewer.setFocus();
                } catch (PartInitException e) {
                    LOGGER.warn("Could not show SimuDockView and set focus to it.", e);
                }
            }

        });
    }

}

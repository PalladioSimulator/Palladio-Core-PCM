package de.uka.ipd.sdq.codegen.simucontroller.gui;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import swing2swt.layout.BorderLayout;
import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerImages;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;

public class DockStatusViewer extends Composite implements Observer {

	private Image idle_image;
	private DockModel model;
	private Label simTimeLabel;
	private Label measurementsLabel;
	private ProgressBar progressBar;
	private Label remoteLocationLabel;
	private Label dockIdLabel;
	private Image running_image;
	private Image pause_image;
	private Canvas iconCanvas;
	private int lastUIUpdate = -1;

	/**
	 * Create the composite
	 * @param parent
	 * @param style
	 */
	public DockStatusViewer(final DockModel model, Composite parent, int style) {
		super(parent, style);
		this.model = model;
		model.addObserver(this);
		
		setLayout(new BorderLayout(0, 0));

		final Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout());

		iconCanvas = new Canvas(composite, SWT.NONE);

		final Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLayoutData(BorderLayout.SOUTH);
		composite_1.setLayout(new FillLayout());

		final Group statusGroup = new Group(composite_1, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginRight = 100;
		gridLayout.numColumns = 4;
		statusGroup.setLayout(gridLayout);
		statusGroup.setText("Status");

		final Label idLabel = new Label(statusGroup, SWT.NONE);
		idLabel.setText("ID:");

		dockIdLabel = new Label(statusGroup, SWT.NONE);
		final GridData gd_dockIdLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
		dockIdLabel.setLayoutData(gd_dockIdLabel);
		dockIdLabel.setText("Label");

		final Label locationLabel = new Label(statusGroup, SWT.NONE);
		locationLabel.setLayoutData(new GridData());
		locationLabel.setText("Location:");

		remoteLocationLabel = new Label(statusGroup, SWT.NONE);
		remoteLocationLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		remoteLocationLabel.setText("Label");

		final Label simulationTimeLabel = new Label(statusGroup, SWT.NONE);
		simulationTimeLabel.setText("Simulation Time:");

		simTimeLabel = new Label(statusGroup, SWT.NONE);
		simTimeLabel.setLayoutData(new GridData(83, SWT.DEFAULT));
		simTimeLabel.setText("Label");

		final Label measurementsLabelLabel = new Label(statusGroup, SWT.NONE);
		measurementsLabelLabel.setLayoutData(new GridData());
		measurementsLabelLabel.setText("Measurements:");

		measurementsLabel = new Label(statusGroup, SWT.NONE);
		final GridData gd_measurementsLabel = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		gd_measurementsLabel.widthHint = 93;
		measurementsLabel.setLayoutData(gd_measurementsLabel);
		measurementsLabel.setText("Label");

		progressBar = new ProgressBar(statusGroup, SWT.NONE);
		final GridData gd_progressBar = new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1);
		progressBar.setLayoutData(gd_progressBar);
		//
		
		idle_image = SimuControllerImages.imageRegistry.get(SimuControllerImages.MASCHINE);
		running_image = SimuControllerImages.imageRegistry.get(SimuControllerImages.MASCHINE_BUSY);
		pause_image = SimuControllerImages.imageRegistry.get(SimuControllerImages.MASCHINE_PAUSE);
		iconCanvas.addPaintListener(new PaintListener(){

			public void paintControl(PaintEvent e) {
				Image image = null;
				
				if (DockStatusViewer.this.model.isIdle())
					image = idle_image;
				else if (DockStatusViewer.this.model.isSuspended() && !DockStatusViewer.this.model.isStepping())
					image = pause_image;
				else
					image = running_image;
				if (!image.isDisposed())
					e.gc.drawImage(image, 0, 0);
			}
			
		});

		final Button stopButton = new Button(composite, SWT.NONE);
		stopButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				model.getService().stopSimulation();
			}
		});
		stopButton.setText("Stop!");
		
		update(model,null);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void update(Observable o, Object arg) {
		if (model.getPercentDone() != lastUIUpdate  || model.isStepping() || model.isSuspended() || model.isIdle()) {
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable(){
	
				public void run() {
					showSimuDockView();
					if (!dockIdLabel.isDisposed())
						dockIdLabel.setText(model.getID());
					if (!remoteLocationLabel.isDisposed())
						remoteLocationLabel.setText(model.getRemoteMaschineURI() == null ? "<local>" : model.getRemoteMaschineURI());
					if (!measurementsLabel.isDisposed())
						measurementsLabel.setText(model.getMeasurementCount()+"");
					if (!simTimeLabel.isDisposed())
						simTimeLabel.setText(new DecimalFormat("0.#").format(model.getSimTime()));
					if (!progressBar.isDisposed())
						progressBar.setSelection(model.getPercentDone());
					if (!iconCanvas.isDisposed())
						iconCanvas.redraw();
					
				}
				
			});
		}
		lastUIUpdate = model.getPercentDone();
	}
	
	public static void showSimuDockView() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable(){

			public void run() {
				IViewPart viewer;
				try {
					viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(DockStatusViewPart.ID);
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(viewer);
					viewer.setFocus();
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
	}
	
}

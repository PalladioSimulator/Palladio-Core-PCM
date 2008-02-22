package de.uka.ipd.sdq.codegen.simucontroller.gui;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerImages;
import swing2swt.layout.BorderLayout;

public class DockStatusViewer extends Composite implements Observer {

	private Image image;
	private DockStatusModel model;
	private Label simTimeLabel;
	private Label measurementsLabel;
	private ProgressBar progressBar;
	private Label remoteLocationLabel;
	private Label dockIdLabel;
	private Image image_busy;
	private Canvas c;

	/**
	 * Create the composite
	 * @param parent
	 * @param style
	 */
	public DockStatusViewer(DockStatusModel model, Composite parent, int style) {
		super(parent, style);
		this.model = model;
		model.addObserver(this);
		
		setLayout(new BorderLayout(0, 0));

		final Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout());

		c = new Canvas(composite, SWT.NONE);

		final Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLayoutData(BorderLayout.SOUTH);
		composite_1.setLayout(new FillLayout());

		final Group statusGroup = new Group(composite_1, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginRight = 10;
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
		
		image = SimuControllerImages.imageRegistry.get(SimuControllerImages.MASCHINE);
		image_busy = SimuControllerImages.imageRegistry.get(SimuControllerImages.MASCHINE_BUSY);
		c.addPaintListener(new PaintListener(){

			public void paintControl(PaintEvent e) {
				if (!image.isDisposed())
					e.gc.drawImage(DockStatusViewer.this.model.isIdle() ? image : image_busy, 0, 0);
			}
			
		});
		
		update(model,null);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void update(Observable o, Object arg) {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable(){

			public void run() {
				dockIdLabel.setText(model.getID());
				remoteLocationLabel.setText(model.getRemoteMaschineURI() == null ? "<local>" : model.getRemoteMaschineURI());
				measurementsLabel.setText(model.getMeasurementCount()+"");
				simTimeLabel.setText(new DecimalFormat("0.#").format(model.getSimTime()));
				progressBar.setSelection(model.getPercentDone());
				c.redraw();
			}
			
		});
	}
}

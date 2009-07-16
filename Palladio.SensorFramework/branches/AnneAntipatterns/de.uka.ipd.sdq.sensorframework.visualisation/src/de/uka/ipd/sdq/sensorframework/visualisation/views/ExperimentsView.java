package de.uka.ipd.sdq.sensorframework.visualisation.views;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.action.Action;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.EditorInputTransfer;
import org.eclipse.ui.part.ViewPart;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.AddNewDatasourceWizard;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.ConfigureDatasourceDialog;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.OpenDatasourceWizard;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.CSVSettingsDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.DialogType;

/**
 * The view shows data obtained from the 'SensorFactory' model. The view is connected to the model
 * using a content provider.
 * 
 * @author Roman Andrej
 */
public class ExperimentsView extends ViewPart {
	private TreeViewer viewer;

	/** Define elements, which can be deleted. */
	private IDAOFactory selectedFactory = null;
	private Experiment selectedExperiment = null;

	/** Define the actions for menu manager. */
	private Action reloadView;
	private Action saveAsCSV;
	private Action collapseAll;
	private Action expandAll;
	private Action newDataSet;
	private Action openDataSet;
	private Action deleteDataSet;
	private Action properties;
	
	//Anne addition
	private Action saveSummaryToCSV;

	private static Logger logger = Logger
			.getLogger("de.uka.ipd.sdq.sensorframework.visualisation.views.ExperimentsView.log");

	public ExperimentsView() {
	}

	class NameSorter extends ViewerSorter {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets .Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		int ops = DND.DROP_COPY | DND.DROP_MOVE;

		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setLabelProvider(new TreeLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		Transfer[] transfers = new Transfer[] { EditorInputTransfer.getInstance(),
				LocalSelectionTransfer.getTransfer() };
		viewer.addDragSupport(ops, transfers, new TreeDragSourceListener(viewer));
		viewer.addDoubleClickListener(new DoubleClickListener());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged
			 * (org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				Object selectedObject = selection.getFirstElement();
				setSelectedElement(selectedObject);
			}
		});

		makeActions();
		hookContextMenu();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ExperimentsView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/**
	 * Contributes actions to the action bars.
	 */
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	/**
	 * Fills the action bar menu with the list of resolvers to be selected
	 * 
	 * @param manager
	 *            - The menu manager to add the actions to.
	 */
	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(newDataSet);
		manager.add(openDataSet);
		manager.add(deleteDataSet);
		manager.add(new Separator());
		manager.add(reloadView);
	}

	/**
	 * Fill context for the tree view pop-up menu.
	 * 
	 * @param menu
	 *            - the menu manager.
	 */
	private void fillContextMenu(IMenuManager manager) {
		manager.add(deleteDataSet);
		manager.add(new Separator());
		manager.add(reloadView);
		manager.add(new Separator());
		manager.add(properties);
		manager.add(new Separator());
		manager.add(saveAsCSV);
		
		//Anne
		manager.add(saveSummaryToCSV);
		
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));

	}

	/**
	 * Adds actions to the local toolbar.
	 * 
	 * @param manager
	 *            - the local toolbar manager.
	 */
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(newDataSet);
		manager.add(openDataSet);
		manager.add(deleteDataSet);
		manager.add(new Separator());
		manager.add(reloadView);
		manager.add(new Separator());
		manager.add(collapseAll);
		manager.add(expandAll);
		manager.add(new Separator());
	}

	private void makeActions() {

		/** Reload viewer action */
		reloadView = new Action() {
			@Override
			public void run() {
				try {
					SensorFrameworkDataset.singleton().reload();
				} catch (Exception ex) {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getShell(), "Reloading the Sensor Dataset Failed",
							"Reloading the Sensor Dataset Failed. Error Message given: "
									+ ex.getMessage());
				}
				viewer.refresh();
			}
		};
		reloadView.setText("Reload View");
		reloadView.setToolTipText("Reload View");
		reloadView.setImageDescriptor(VisualisationPlugin
				.getImageDescriptor("/icons/db_reload_obj.gif"));

		/** Collapse all action */
		collapseAll = new Action() {
			@Override
			public void run() {
				viewer.collapseAll();
			}
		};
		collapseAll.setText("Collapse All");
		collapseAll.setToolTipText("Collapse All");
		collapseAll.setImageDescriptor(VisualisationPlugin
				.getImageDescriptor("/icons/collapseall.gif"));

		/** Expand all action */
		expandAll = new Action() {
			@Override
			public void run() {
				viewer.expandAll();
			}
		};
		expandAll.setText("Expand All");
		expandAll.setToolTipText("Expand All");
		expandAll
				.setImageDescriptor(VisualisationPlugin.getImageDescriptor("/icons/expandall.gif"));

		/** New DataSet action. */
		newDataSet = new Action() {
			@Override
			public void run() {
				AddNewDatasourceWizard wizard = new AddNewDatasourceWizard();
				// Instantiates the wizard container with the wizard and opens
				// it
				WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
				dialog.create();
				dialog.setTitle(ConfigureDatasourceDialog.ADD_WIZARD_TITLE);
				dialog.open();
				viewer.refresh();
			}
		};
		newDataSet.setText("New Data Source");
		newDataSet.setToolTipText("New Data Source");
		newDataSet.setImageDescriptor(VisualisationPlugin.getImageDescriptor("/icons/add_obj.gif"));

		/** Open DataSet action */
		openDataSet = new Action() {
			@Override
			public void run() {

				OpenDatasourceWizard wizard = new OpenDatasourceWizard();

				// Instantiates the wizard container with the wizard and opens
				// it
				WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
				dialog.create();

				dialog.setTitle(ConfigureDatasourceDialog.OPEN_WISARD_TITLE);
				dialog.open();
				viewer.refresh();
			}
		};
		openDataSet.setText("Open");
		openDataSet.setToolTipText("Open a Data Source");
		openDataSet.setImageDescriptor(VisualisationPlugin
				.getImageDescriptor("/icons/data_source_folder.gif"));

		/** Delete DataSet/Experiment action. */
		deleteDataSet = new Action() {
			@Override
			public void run() {

				// selected element in 'ExperimentView' DAOFactory
				if (selectedFactory != null) {
					SensorFrameworkDataset.singleton().removeDataSource(selectedFactory);
					viewer.refresh();
				}
				// selected element in 'ExperimentView' is Experiment
				if (selectedExperiment != null && selectedFactory != null) {
					selectedFactory.createExperimentDAO()
							.removeExperiment(selectedExperiment, true);
					viewer.refresh();
				}
			}
		};
		deleteDataSet.setText("Delete");
		deleteDataSet.setToolTipText("Delete a Data Source/Experiment");
		deleteDataSet.setImageDescriptor(VisualisationPlugin
				.getImageDescriptor("/icons/remove_obj.gif"));
		deleteDataSet.setEnabled(false);

		/** Properties action. */
		properties = new Action() {
			@Override
			public void run() {

				IPreferencePage page = new DAOFactoryPreferencePage(
						selectedFactory);
				page.setTitle("General Information");
				PreferenceManager mgr = new PreferenceManager();
				IPreferenceNode node = new PreferenceNode("1", page);
				mgr.addToRoot(node);
				PreferenceDialog dialog = new PreferenceDialog(getSite().getShell(), mgr);
				dialog.create();
				dialog.setMessage(page.getTitle());
				dialog.open();

			}
		};
		properties.setText("Properties");
		properties.setEnabled(false);

		/** Save As CSV action */
		saveAsCSV = new Action() {
			@Override
			public void run() {
				exportSelectedDataToCSV();
			}
		};
		saveAsCSV.setText("Save as CSV");
		
		/** Save As CSV action */
		saveSummaryToCSV = new Action() {
			@Override
			public void run() {
				writeSummaryReport();
			}
		};
		saveSummaryToCSV.setText("Save experiment summary to CSV");
	}

	/**
	 * Transform and export the data in the CSV format.
	 * 
	 * @author David Scherr
	 * @param fileName
	 *            Name of the CSV file.
	 * @param measurement
	 *            The collection of measurements of the selected sensor.
	 * @param isHeader
	 *            If the value is true, then the CSV file will integrate a superscription.
	 * @param separator
	 *            At the moment there are 3 possibilities to separate the CSV data: (1) Semicolon
	 *            (2) Comma (3) Tabulator. One of these is stored in this parameter as the
	 *            corresponding character, but still in String format (maybe in the future someone
	 *            will add a separator with more than one character).
	 */
	private void exportSensorMeasurementToCSV(String fileName, Collection<Measurement> measurement,
			boolean isHeader, String separator) {

		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try {
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			if (measurement.iterator().next() instanceof StateMeasurement) {
				// If you have activated the header in the dialog (CSVSettingsDialog), then you get
				// a superscription of the measurement types.
				if (isHeader) {
					bufferedWriter.append("Event Time" + separator + "State" + "\n");
				}
				// Get each element of Event Time and Sensor State as a pair which will be save as
				// one CSV line into the buffer.
				for (Iterator<Measurement> iterator = measurement.iterator(); iterator.hasNext();) {
					// The instance of the Measurement is known as StateMeasurement and through the
					// casting you get the special data of this type of Measurement.
					StateMeasurement data = ((StateMeasurement) iterator.next());
					// Write one pair of data per line with the separator, which you can choose in
					// the dialog (CSVSettingsDialog).
					bufferedWriter.append(data.getEventTime() + separator
							+ data.getSensorState().getStateLiteral() + "\n");
				}
			} else if (measurement.iterator().next() instanceof TimeSpanMeasurement) {
				// If you have activated the header in the dialog (CSVSettingsDialog), then you get
				// a superscription of the measurement types.
				if (isHeader) {
					bufferedWriter.append("Event Time" + separator + "Time Span" + "\n");
				}
				// Get each element of Event Time and Time Span as a pair which will be save as one
				// CSV line into the buffer.
				for (Iterator<Measurement> iterator = measurement.iterator(); iterator.hasNext();) {
					// The instance of the Measurement is known as TimeSpanMeasurement and through
					// the casting you get the special data of this type of Measurement.
					TimeSpanMeasurement data = ((TimeSpanMeasurement) iterator.next());
					// Write one pair of data per line with the separator, which you can choose in
					// the dialog (CSVSettingsDialog).
					bufferedWriter.append(data.getEventTime() + separator + data.getTimeSpan()
							+ "\n");
				}
			} else {
				// The type of measurement is unknown.
				logger.log(Level.SEVERE, "It is not possible to export this type of measurement "
						+ "to the CSV format. At the moment only instances of StateMeasurement "
						+ "and TimeSpanMeasurement are suitable.");
				throw new IllegalArgumentException();
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author David Scherr
	 * 
	 * @param pathDir
	 *            Path in which you find the <code>ExperimentRun</code> directory.
	 * @param sensors
	 *            Sensors of Measurement.
	 * @param run
	 *            <code>ExperimentRun</code> with all measurements.
	 * @param isHeader
	 *            If the value is true, then the CSV file will integrate a superscription.
	 * @param separator
	 *            At the moment there are 3 possibilities to separate the CSV data: (1) Semicolon
	 *            (2) Comma (3) Tabulator. One of these is stored in this parameter as the
	 *            corresponding character, but still in String format (maybe in the future someone
	 *            will add a separator with more than one character).
	 */
	private void exportExperimentRunToCSV(String pathDir, Collection<Sensor> sensors,
			ExperimentRun run, boolean isHeader, String separator) {
		SensorAndMeasurements sensorAndMeasurements;
		String fileName;
		String pathFile;
		for (Iterator<Sensor> iterator = sensors.iterator(); iterator.hasNext();) {
			Sensor sensor = iterator.next();
			sensorAndMeasurements = run.getMeasurementsOfSensor(sensor);
			fileName = sanitizeFileName(sensor.getSensorName().toString() + ".csv");
			pathFile = pathDir + File.separatorChar + fileName;
			exportSensorMeasurementToCSV(pathFile, sensorAndMeasurements.getMeasurements(),
					isHeader, separator);
		}
	}

	/**
	 * Get the Data which are associated with the selected TreeView element and open a save dialog
	 * with settings for the CSV export.
	 * 
	 * @author David Scherr
	 */
	private void exportSelectedDataToCSV() {

		ISelection selection = viewer.getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object object = structuredSelection.getFirstElement();

		if (object instanceof FileDAOFactory) {

		} else if (object instanceof ExperimentAndDAO) {

		} else if (object instanceof TreeContainer) {
			TreeContainer treeContainer = (TreeContainer) object;
			String dirAllExperimentRuns = treeContainer.getName();
			CSVSettingsDialog dialog = new CSVSettingsDialog("", dirAllExperimentRuns, "",
					DialogType.DIRECTORY);

			// If the returned path of the dialog is valid, then continue the export.
			if (dialog.getValidPath()) {
				exportAllExperimentRunsToCSV(dialog.getPath(), treeContainer
						.getElements(), dialog.isHeader(), dialog.getSeparator());
			}

		} else if (object instanceof TreeObject) {
			TreeObject treeObject = (TreeObject) object;
			Object innerObject = treeObject.getObject();

			if (innerObject instanceof Sensor) {
				// Get the measurement of a special selected sensor of the TreeObject.
				Sensor sensor = (Sensor) innerObject;
				SensorAndMeasurements sensorAndMeasurements = treeObject.getRun()
						.getMeasurementsOfSensor(sensor);
				String fileName = sanitizeFileName(sensorAndMeasurements.getSensor()
						.getSensorName().toString()
						+ ".csv");
				// Please note that the dialog type is a FileDialog.
				CSVSettingsDialog dialog = new CSVSettingsDialog("", fileName, "*.csv",
						DialogType.FILE);

				if (dialog.getValidPath()) {
					exportSensorMeasurementToCSV(dialog.getPath(), sensorAndMeasurements
							.getMeasurements(), dialog.isHeader(), dialog.getSeparator());
				}
			} else if (innerObject instanceof ExperimentRun) {
				// Get the measurements of all sensors of the selected TreeObject.
				ExperimentRun run = (ExperimentRun) innerObject;
				String dirExperiment = sanitizeFileName(run.getExperimentDateTime());
				// Please note that the dialog type is a DirectoryDialog.
				CSVSettingsDialog dialog = new CSVSettingsDialog("", dirExperiment, "",
						DialogType.DIRECTORY);

				if (dialog.getValidPath()) {
					exportExperimentRunToCSV(dialog.getPath(), treeObject.getExperiment()
							.getSensors(), run, dialog.isHeader(), dialog.getSeparator());
				}
			}
		}
	}

	private void exportAllExperimentRunsToCSV(String pathDir,
			Collection<TreeObject> allExperimentRuns, boolean isHeader, String separator) {
		// Save all Experiments
		for (Iterator<TreeObject> iterator = allExperimentRuns.iterator(); iterator.hasNext();) {
			TreeObject treeObject = (TreeObject) iterator.next();
			Object innerObject = treeObject.getObject();

			// Save all ExperimentRuns
			if (innerObject instanceof ExperimentRun) {
				// Get the measurements of all sensors of the selected TreeObject.
				ExperimentRun run = (ExperimentRun) innerObject;
				String dirExperiment = sanitizeFileName(run.getExperimentDateTime());
				String pathAllExperimentRuns = pathDir + File.separatorChar + dirExperiment;
				new File(pathAllExperimentRuns).mkdirs();
				exportExperimentRunToCSV(pathAllExperimentRuns, treeObject.getExperiment()
						.getSensors(), run, isHeader, separator);
			}
		}
	}

	/**
	 * Some characters are not allowed for file names, e.g. : , ", *, etc. which will be replaced by
	 * sanitizeFileName().
	 * 
	 * @author David Scherr
	 * @param fileName
	 *            The name of the file.
	 * @return The sanitized file name, which is free of not allowed characters.
	 */
	private String sanitizeFileName(String fileName) {

		// Replace all chars, which can't be a part of a valid windows filename.
		fileName = fileName.replace('\\', '-');
		fileName = fileName.replace('/', '-');
		fileName = fileName.replace(':', '-');
		fileName = fileName.replace('*', '+');
		fileName = fileName.replace('?', '!');
		fileName = fileName.replace('"', ' ');
		fileName = fileName.replace('<', '(');
		fileName = fileName.replace('>', ')');
		fileName = fileName.replace('|', ',');

		return fileName;
	}

	/** Set a instance of, in viewer selected element. */
	private void setSelectedElement(Object selected) {

		selectedFactory = null;
		selectedExperiment = null;
		
		//Anne
		saveSummaryToCSV.setEnabled(true);
		

		if (selected instanceof IDAOFactory) {
			selectedFactory = (IDAOFactory) selected;
			deleteDataSet.setEnabled(true);
			properties.setEnabled(true);
			saveAsCSV.setEnabled(true);
		} else if (selected instanceof ExperimentAndDAO) {
			ExperimentAndDAO experimentAndDAO = (ExperimentAndDAO) selected;
			selectedExperiment = (Experiment) experimentAndDAO.getExperiment();
			selectedFactory = experimentAndDAO.getDatasource();
			deleteDataSet.setEnabled(true);
			properties.setEnabled(false);
			saveAsCSV.setEnabled(true);
		} else {
			deleteDataSet.setEnabled(false);
			properties.setEnabled(false);
			saveAsCSV.setEnabled(true);

			if ((selected instanceof TreeContainer)) {
				if (((TreeContainer) selected).getName().equals("Sensors")) {
					saveAsCSV.setEnabled(false);
				}
			} else if (selected instanceof TreeObject) {
				if (((TreeObject) selected).getObject() instanceof ExperimentRun) {

				} else {
					if (((TreeObject) selected).getRun() == null) {
						saveAsCSV.setEnabled(false);
					}
				}
			}
		}
	}
	
	/** FIXME: copied from exportSelectedDataToCSV()
	 * 
	 */
	private void writeSummaryReport(){
		
		ISelection selection = viewer.getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object object = structuredSelection.getFirstElement();

		if (object instanceof FileDAOFactory) {

		} else if (object instanceof ExperimentAndDAO) {

		} else if (object instanceof TreeContainer) {
			/*TreeContainer treeContainer = (TreeContainer) object;
			String dirAllExperimentRuns = treeContainer.getName();
			CSVSettingsDialog dialog = new CSVSettingsDialog("", dirAllExperimentRuns, "",
					DialogType.DIRECTORY);

			// If the returned path of the dialog is valid, then continue the export.
			if (dialog.getValidPath()) {
				exportAllExperimentRunsToCSV(dialog.getPath(), treeContainer
						.getElements(), dialog.isHeader(), dialog.getSeparator());
			}*/

		} else if (object instanceof TreeObject) {
			TreeObject treeObject = (TreeObject) object;
			Object innerObject = treeObject.getObject();

			/*if (innerObject instanceof Sensor) {
				// Get the measurement of a special selected sensor of the TreeObject.
				Sensor sensor = (Sensor) innerObject;
				SensorAndMeasurements sensorAndMeasurements = treeObject.getRun()
						.getMeasurementsOfSensor(sensor);
				String fileName = sanitizeFileName(sensorAndMeasurements.getSensor()
						.getSensorName().toString()
						+ ".csv");
				// Please note that the dialog type is a FileDialog.
				CSVSettingsDialog dialog = new CSVSettingsDialog("", fileName, "*.csv",
						DialogType.FILE);

				if (dialog.getValidPath()) {
					exportSensorMeasurementToCSV(dialog.getPath(), sensorAndMeasurements
							.getMeasurements(), dialog.isHeader(), dialog.getSeparator());
				}
			} else*/ if (innerObject instanceof ExperimentRun) {
				// Get the measurements of all sensors of the selected TreeObject.
				ExperimentRun run = (ExperimentRun) innerObject;
				String dirExperiment = sanitizeFileName(run.getExperimentDateTime());
				// Please note that the dialog type is a DirectoryDialog.
				CSVSettingsDialog dialog = new CSVSettingsDialog("", dirExperiment, "",
						DialogType.DIRECTORY);

				if (dialog.getValidPath()) {
					writeTimeSummaryReportForExperimentToCSV(dialog.getPath(), treeObject.getExperiment()
							.getSensors(), run, dialog.isHeader(), dialog.getSeparator());
				}
			}
		}
		
	}

	private void writeTimeSummaryReportForExperimentToCSV(String pathDir,
			Collection<Sensor> sensors, ExperimentRun run, boolean header,
			String separator) {
		
		//For each sensor, output sensor name;mean resp time;no of meas
		
		//copied from exportExperimentRunToCSV(String, Collection<Sensor>, ExperimentRun, boolean, String)
		String fileName = sanitizeFileName(run.getExperimentDateTime() + ".csv");
		String fileNameState = sanitizeFileName(run.getExperimentDateTime() + "_state.csv");
		String pathFile = pathDir + File.separatorChar + fileName;
		String pathFileState = pathDir + File.separatorChar + fileNameState;
		
		FileWriter fileWriterForTime;
		BufferedWriter bufferedWriterForTime;
		
		FileWriter fileWriterForState;
		BufferedWriter bufferedWriterForState;
		try {
			fileWriterForState = new FileWriter(pathFileState);
			bufferedWriterForState = new BufferedWriter(fileWriterForState);
			
			fileWriterForTime = new FileWriter(pathFile);
			bufferedWriterForTime = new BufferedWriter(fileWriterForTime);
			
			if (header){
				bufferedWriterForTime.write("name"+separator+"respTime"+separator+"noOfMeas"+"\n");
				bufferedWriterForState.write("name"+separator+"util\n");
			}
			
			for (Sensor sensor : sensors) {
				//TODO distinguish between utilisation sensors and response time sensors
				if (TimeSpanSensor.class.isInstance(sensor)){
					bufferedWriterForTime.write(getResultLineForTime((TimeSpanSensor)sensor, run, separator)+"\n");
				} else if (StateSensor.class.isInstance(sensor)){
					bufferedWriterForState.write(getResultLineForState((StateSensor)sensor, run, separator)+"\n");
				}
			}
			
			bufferedWriterForTime.flush();

			bufferedWriterForTime.close();
			fileWriterForTime.close();
			
			bufferedWriterForState.flush();

			bufferedWriterForState.close();
			fileWriterForState.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String getResultLineForState(StateSensor sensor, ExperimentRun run,
			String separator) {
		
		String name = sensor.getSensorName();
		
		Collection<Measurement> measurements = run.getMeasurementsOfSensor(sensor).getMeasurements();
		
		Map<State, Double> timeSums = new HashMap<State, Double>();
		
		//partly copied from StateSensorToPieAdapter
		for (State state : sensor.getSensorStates()) {
			timeSums.put(state, 0.0);
		}
		
		double lastChangeTime = 0.0; 
		State lastState = sensor.getInitialState();
		double sum = 0;

		//XXX: currently gets the utilization of all busy states, too. 
		for (Measurement measurement : measurements) {
			StateMeasurement sm = (StateMeasurement)measurement;
	
			Double oldValue = timeSums.get(lastState);
			double diff = sm.getEventTime() - lastChangeTime;
			double newValue = oldValue + diff;
			sum += diff;
			timeSums.put(lastState, newValue);

			lastChangeTime = sm.getEventTime();
			lastState = sm.getSensorState();
		}

		//XXX: Assuming here that the initial state was the idle state
		State idleState = sensor.getInitialState();
		
		double utilisation = 1-timeSums.get(idleState);
	
		return name+separator+utilisation;
	}

	private String getResultLineForTime(TimeSpanSensor sensor, ExperimentRun run, String seperator) {
		SensorAndMeasurements sensorAndMeasurements = run.getMeasurementsOfSensor(sensor);
		
		String name = sensor.getSensorName();
		
		double meanValue = getMeanValue(sensorAndMeasurements.getMeasurements());
		
		int noOfMeasurements = sensorAndMeasurements.getMeasurements().size();
		
		String resultLine = name+seperator+meanValue+seperator+noOfMeasurements;
		
		return resultLine;
	}

	private double getMeanValue(Collection<Measurement> measurements) {
		
		double sum = 0.0;
		for (Measurement measurement : measurements) {
			if (TimeSpanMeasurement.class.isInstance(measurement)){
				TimeSpanMeasurement timeMeas = (TimeSpanMeasurement)measurement; 
				sum += timeMeas.getTimeSpan();
			} else {
				logger.severe("Found a non time span measurement in sensor, ignoring it.");
			}
		}
		return sum / measurements.size();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
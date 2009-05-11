package de.uka.ipd.sdq.sensorframework.visualisation.views;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.action.Action;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
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
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.CSVSettingsDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.DialogType;

/**
 * The view shows data obtained from the 'SensorFactory' model. The view is
 * connected to the model using a content provider.
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

	private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.sensorframework.visualisation.views.ExperimentsView.log");
	
	public ExperimentsView() {
	}

	class NameSorter extends ViewerSorter {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		int ops = DND.DROP_COPY | DND.DROP_MOVE;

		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setLabelProvider(new TreeLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		Transfer[] transfers = new Transfer[] {
				EditorInputTransfer.getInstance(),
				LocalSelectionTransfer.getTransfer() };
		viewer.addDragSupport(ops, transfers,
				new TreeDragSourceListener(viewer));
		viewer.addDoubleClickListener(new DoubleClickListener());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged
			 * (org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
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
					MessageDialog.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(),
							"Reloading the Sensor Dataset Failed",
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
		expandAll.setImageDescriptor(VisualisationPlugin
				.getImageDescriptor("/icons/expandall.gif"));

		/** New DataSet action. */
		newDataSet = new Action() {
			@Override
			public void run() {
				AddNewDatasourceWizard wizard = new AddNewDatasourceWizard();
				// Instantiates the wizard container with the wizard and opens
				// it
				WizardDialog dialog = new WizardDialog(getSite().getShell(),
						wizard);
				dialog.create();
				dialog.setTitle(ConfigureDatasourceDialog.ADD_WIZARD_TITLE);
				dialog.open();
				viewer.refresh();
			}
		};
		newDataSet.setText("New Data Source");
		newDataSet.setToolTipText("New Data Source");
		newDataSet.setImageDescriptor(VisualisationPlugin
				.getImageDescriptor("/icons/add_obj.gif"));

		/** Open DataSet action */
		openDataSet = new Action() {
			@Override
			public void run() {

				OpenDatasourceWizard wizard = new OpenDatasourceWizard();

				// Instantiates the wizard container with the wizard and opens
				// it
				WizardDialog dialog = new WizardDialog(getSite().getShell(),
						wizard);
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
					SensorFrameworkDataset.singleton().removeDataSource(
							selectedFactory);
					viewer.refresh();
				}
				// selected element in 'ExperimentView' is Experiment
				if (selectedExperiment != null && selectedFactory != null) {
					selectedFactory.createExperimentDAO().removeExperiment(
							selectedExperiment, true);
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
				PreferenceDialog dialog = new PreferenceDialog(getSite()
						.getShell(), mgr);
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
				saveDataAsCSV();
			}
		};
		saveAsCSV.setText("Save as CSV");
	}

	/**
	 * Transform and export the data in the CSV format.
	 * 
	 * @author David Scherr
	 * @param filename
	 *            Name of the CSV file.
	 * @param measurement
	 *            The collection of measurements of the selected sensor.
	 * @param isHeader
	 *            If the value is true, then the CSV file will integrate a
	 *            superscription.
	 * @param separator
	 *            At the moment there are 3 possibilities to separate the CSV
	 *            data: (1) Semicolon (2) Comma (3) Tabulator. One of these is
	 *            stored in this parameter as the corresponding character, but
	 *            still in String format (maybe in the future someone will add a
	 *            separator with more than one character).
	 */
	private void exportSensorDataToCSV(String filename,
			Collection<Measurement> measurement, boolean isHeader,
			String separator) {

		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try {
			fileWriter = new FileWriter(filename);
			bufferedWriter = new BufferedWriter(fileWriter);
			if (measurement.iterator().next() instanceof StateMeasurement) {
				// If you have activated the header in the dialog (CSVSettingsDialog),
				// then you get a superscription of the measurement types.
				if (isHeader) {
					bufferedWriter.append("Event Time" + separator + "State"
							+ "\n");
				}
				// Get each element of Event Time and Sensor State as a pair which will be
				// save as one CSV line into the buffer.
				for (Iterator<Measurement> iterator = measurement.iterator(); iterator
						.hasNext();) {
					// The instance of the Measurement is known as StateMeasurement and
					// through the casting you get the special data of this type of Measurement.
					StateMeasurement data = ((StateMeasurement) iterator.next());
					// Write one pair of data per line with the separator, which
					// you can choose in the dialog (CSVSettingsDialog).
					bufferedWriter.append(data.getEventTime() + separator
							+ data.getSensorState().getStateLiteral() + "\n");
				}
			} else if (measurement.iterator().next() instanceof TimeSpanMeasurement) {
				// If you have activated the header in the dialog (CSVSettingsDialog),
				// then you get a superscription of the measurement types.
				if (isHeader) {
					bufferedWriter.append("Event Time" + separator
							+ "Time Span" + "\n");
				}
				// Get each element of Event Time and Time Span as a pair which will be
				// save as one CSV line into the buffer.
				for (Iterator<Measurement> iterator = measurement.iterator(); iterator
						.hasNext();) {
					// The instance of the Measurement is known as TimeSpanMeasurement and
					// through the casting you get the special data of this type of Measurement.
					TimeSpanMeasurement data = ((TimeSpanMeasurement) iterator
							.next());
					// Write one pair of data per line with the separator, which
					// you can choose in the dialog (CSVSettingsDialog).
					bufferedWriter.append(data.getEventTime() + separator
							+ data.getTimeSpan() + "\n");
				}
			} else {
				// The type of measurement is unknown.				
				logger.log(Level.SEVERE, "It is not possible to export this type of measurement to the CSV format."
						+ "At the moment only instances of StateMeasurement and TimeSpanMeasurement are suitable.");
				throw new IllegalArgumentException();
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the Data which are associated with the selected TreeView element and
	 * open a save dialog which settings for the CSV export.
	 * 
	 * @author David Scherr
	 */
	private void saveDataAsCSV() {
		
		ISelection selection = viewer.getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;	
		Object object = structuredSelection.getFirstElement();

		if (object instanceof FileDAOFactory) {
			
		} else if (object instanceof ExperimentAndDAO) {
			
		} else if (object instanceof TreeContainer) {
			System.out.println(((TreeContainer) object).getName());
			
		} else if (object instanceof TreeObject) {
			TreeObject treeObject = (TreeObject) object;
			Object innerObject = treeObject.getObject();
			
			if (innerObject instanceof Sensor) {
				// Get the measurement of a special selected sensor of the TreeObject.
				Sensor sensor = (Sensor) innerObject;
				SensorAndMeasurements sensorAndMeasurements = treeObject.getRun().getMeasurementsOfSensor(sensor);			
				String fileName = senatiseFileName(sensorAndMeasurements.getSensor().getSensorName().toString()+ ".csv");

				CSVSettingsDialog dialog = new CSVSettingsDialog("", fileName, "*.csv", DialogType.FILE);
				dialog.open();		
				
				if (!(dialog.getFilePath().equals(""))) {
					// new File(dialog.getFilePath()).mkdirs();
					exportSensorDataToCSV(dialog.getFilePath(), sensorAndMeasurements
							.getMeasurements(), dialog.isHeader(), dialog
							.getSeparator());
				} else {
					// The Save Dialog is canceled.
				}
				dialog.dispose();	

			} else if (innerObject instanceof ExperimentRun) {
				// Get the measurements of all sensors of the selected TreeObject.
				ExperimentRun run = (ExperimentRun) innerObject;				
				SensorAndMeasurements sensorAndMeasurements;
				String fileName = "";
				String filePath = "";
				String experimentDir = senatiseFileName(run.getExperimentDateTime());
				
				CSVSettingsDialog dialog = new CSVSettingsDialog("", "", "*.csv", DialogType.PATH);
				dialog.open();
				filePath = dialog.getFilePath() + File.separatorChar + experimentDir;
				
				if (!(filePath.equals(""))) {
					new File(filePath).mkdirs();
					for (Iterator<Sensor> iterator = treeObject.getExperiment().getSensors().iterator(); iterator.hasNext();) {
						Sensor sensor = iterator.next();
						sensorAndMeasurements = run.getMeasurementsOfSensor(sensor);
						fileName = senatiseFileName(sensor.getSensorName().toString() + ".csv");
						
						exportSensorDataToCSV(filePath + File.separatorChar + fileName,
								sensorAndMeasurements.getMeasurements(),
								dialog.isHeader(), dialog.getSeparator());	
					}
					
				} else {
					// The Save Dialog is canceled.
				}
				dialog.dispose();				
			}
		}
	}
	
	private String senatiseFileName(String fileName) {
		
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

		if (selected instanceof IDAOFactory) {
			selectedFactory = (IDAOFactory) selected;
			deleteDataSet.setEnabled(true);
			properties.setEnabled(true);
		} else if (selected instanceof ExperimentAndDAO) {
			ExperimentAndDAO experimentAndDAO = (ExperimentAndDAO) selected;
			selectedExperiment = (Experiment) experimentAndDAO.getExperiment();
			selectedFactory = experimentAndDAO.getDatasource();
			deleteDataSet.setEnabled(true);
			properties.setEnabled(false);
		} else {
			deleteDataSet.setEnabled(false);
			properties.setEnabled(false);
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
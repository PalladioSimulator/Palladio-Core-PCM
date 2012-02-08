/**
 *
 */
package de.fzi.se.validation.effort.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import de.fzi.se.validation.effort.IEstimator;

/**Dialog to display all estimations provided by a list of {@link IEstimator}s to the user.
 *
 * @see de.uka.ipd.sdq.errorhandling.dialogs.issues.IssuesDialog
 *
 * @author groenda
 *
 */
public class EstimationsDialog extends Dialog  {
	/** Label for the column containing the criterion name. */
	public static final String COLUMN_LABEL_CRITERION_NAME = "Criterion";
	/** Label for the column containing the number of test cases. */
	public static final String COLUMN_LABEL_NUMBER_TESTCASES = "Estimated number of test cases";
	/** Label for the column containing the confidence level. */
	public static final String COLUMN_LABEL_CONFIDENCE_LEVEL = "Confidence level";
	/** Label for the column containing the target UUID. */
	public static final String COLUMN_LABEL_TARGET_ID = "Target Behaviour ID";
	/** Label for the column containing the URI. */
	public static final String COLUMN_LABEL_URI = "URI containing the target";
	/** Label for information which is not available. */
	public static final String LABEL_INFO_NOT_AVAILABLE = "N/A";

	/** Estimators with results to display. */
	private final List<IEstimator> estimators;

	/** Table containing the estimations. */
	private Table table;

	/**Constructor.
	 * @param parentShell Shell for the dialog.
	 * @param estimators List of estimations to display.
	 */
	public EstimationsDialog(Shell parentShell, List<IEstimator> estimators) {
		super(parentShell);
		setShellStyle(SWT.RESIZE | SWT.MAX);
		this.estimators = estimators;
	}

	/**
	 * Create contents of the dialog
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		table = new Table(container, SWT.FULL_SELECTION | SWT.BORDER);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final TableColumn columnCriterionName = new TableColumn(table, SWT.NONE);
		columnCriterionName.setWidth(140);
		columnCriterionName.setText(EstimationsDialog.COLUMN_LABEL_CRITERION_NAME);

		final TableColumn columnNumberTestcases = new TableColumn(table, SWT.NONE);
		columnNumberTestcases.setWidth(180);
		columnNumberTestcases.setText(EstimationsDialog.COLUMN_LABEL_NUMBER_TESTCASES);

		final TableColumn confidenceLevelTestcases = new TableColumn(table, SWT.NONE);
		confidenceLevelTestcases.setWidth(95);
		confidenceLevelTestcases.setText(EstimationsDialog.COLUMN_LABEL_CONFIDENCE_LEVEL);

		final TableColumn targetIdTestcases = new TableColumn(table, SWT.NONE);
		targetIdTestcases.setWidth(165);
		targetIdTestcases.setText(EstimationsDialog.COLUMN_LABEL_TARGET_ID);

		final TableColumn uriTestcases = new TableColumn(table, SWT.NONE);
		uriTestcases.setWidth(150);
		uriTestcases.setText(EstimationsDialog.COLUMN_LABEL_URI);

		fillTable(table);

		return container;
	}

	/**Fills the table with estimations.
	 * @param table Table to fill.
	 */
	private void fillTable(Table table) {
		TableViewer tableViewer = new TableViewer(table);
		tableViewer.setContentProvider(new IStructuredContentProvider() {
			public void dispose() {
				// nothing to do
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				viewer.refresh();
			}

			public Object[] getElements(Object inputElement) {
				return estimators.toArray();
			}
		});
		tableViewer.setLabelProvider(new ITableLabelProvider() {
			private ArrayList<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();

			public Image getColumnImage(Object element, int columnIndex) {
				// no image to display
				return null;
			}

			public String getColumnText(Object element, int columnIndex) {
				IEstimator estimator = (IEstimator) element;
				switch(columnIndex){
				case 0:
					if (estimator.getCriterionName() == null) {
						return EstimationsDialog.LABEL_INFO_NOT_AVAILABLE;
					} else {
						return estimator.getCriterionName();
					}
				case 1:
					if (estimator.getEstimation() == null) {
						return EstimationsDialog.LABEL_INFO_NOT_AVAILABLE;
					} else {
						return Long.toString(estimator.getEstimation().getNumberTestcases());
					}
				case 2:
					if (estimator.getEstimation() == null) {
						return EstimationsDialog.LABEL_INFO_NOT_AVAILABLE;
					} else {
						return Double.toString(estimator.getEstimation().getAlpha());
					}
				case 3:
					if (estimator.getEstimation() == null) {
						return EstimationsDialog.LABEL_INFO_NOT_AVAILABLE;
					} else {
						return estimator.getEstimation().getTargetId();
					}
				case 4:
					if (estimator.getEstimation() == null) {
						return EstimationsDialog.LABEL_INFO_NOT_AVAILABLE;
					} else {
						return estimator.getEstimation().getTargetUri();
					}
				default :
					throw new IllegalArgumentException("Only five columns are supported.");
				}
			}

			public void addListener(ILabelProviderListener listener) {
				listeners.add(listener);
			}

			public void dispose() {
				listeners = null;
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
				listeners.remove(listener);
			}

		});
		tableViewer.setInput(estimators);
	}

	/**
	 * Create contents of the button bar
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		parent.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(620, 500);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Validation effort estimations");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 */
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
	}

}

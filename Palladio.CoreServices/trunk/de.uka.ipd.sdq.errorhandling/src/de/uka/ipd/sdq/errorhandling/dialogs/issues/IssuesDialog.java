package de.uka.ipd.sdq.errorhandling.dialogs.issues;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.SeverityEnum;

public class IssuesDialog extends Dialog {

	public static final int IGNORE_BUTTON = 2;
	private List<SeverityAndIssue> issues;
	private Text detailsText;
	private Table table;
	/**
	 * Create the dialog
	 * @param parentShell
	 */
	public IssuesDialog(Shell parentShell, List<SeverityAndIssue> issues) {
		super(parentShell);
		setShellStyle(SWT.RESIZE|SWT.MAX);
		this.issues = issues;
		Collections.sort(this.issues);
	}

	/**
	 * Create contents of the dialog
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		table = new Table(container, SWT.FULL_SELECTION | SWT.BORDER);
		table.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateDetails();
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final TableColumn newColumnTableColumn = new TableColumn(table, SWT.NONE);
		newColumnTableColumn.setWidth(81);
		newColumnTableColumn.setText("Severity");

		final TableColumn newColumnTableColumn_1 = new TableColumn(table, SWT.NONE);
		newColumnTableColumn_1.setWidth(317);
		newColumnTableColumn_1.setText("Message");

		final TableColumn newColumnTableColumn_2 = new TableColumn(table, SWT.NONE);
		newColumnTableColumn_2.setWidth(100);
		newColumnTableColumn_2.setText("Element");

		final TableColumn newColumnTableColumn_3 = new TableColumn(table, SWT.NONE);
		newColumnTableColumn_3.setWidth(150);
		newColumnTableColumn_3.setText("Resource");
		//
		fillTable(table);

		final Group detailsGroup = new Group(container, SWT.NONE);
		final GridData gd_detailsGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_detailsGroup.heightHint = 92;
		detailsGroup.setLayoutData(gd_detailsGroup);
		detailsGroup.setText("Details");
		detailsGroup.setLayout(new GridLayout());

		detailsText = new Text(detailsGroup, SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY | SWT.H_SCROLL | SWT.BORDER);
		detailsText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		return container;
	}

	protected void updateDetails() {
		if (table.getSelectionIndex() > -1) {
			SeverityAndIssue sai = issues.get(table.getSelectionIndex());
			String text = "Severity: " + (sai.getError() == SeverityEnum.ERROR ? "ERROR" : "WARNING")+"\n\n";
			text+="Message: "+sai.getMessage()+"\n\n";
			text+="Element: "+sai.getElement()+"\n\n";
			text+="Resource: "+sai.getResourceName()+"\n";
			detailsText.setText(text);
		}
	}

	private void fillTable(Table table) {
		TableViewer tableViewer = new TableViewer(table);
		tableViewer.setContentProvider(new IStructuredContentProvider(){

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				viewer.refresh();
			}

			public Object[] getElements(Object inputElement) {
				return issues.toArray();
			}
			
		});
		tableViewer.setLabelProvider(new ITableLabelProvider() {

			public Image getColumnImage(Object element, int columnIndex) {
				SeverityAndIssue sai = (SeverityAndIssue) element;
				switch(columnIndex){
				case 0:
					if (sai.getError() == SeverityEnum.ERROR)
						return ErrorhandlingDialogImages.imageRegistry.get(ErrorhandlingDialogImages.ERROR);
					else
						return ErrorhandlingDialogImages.imageRegistry.get(ErrorhandlingDialogImages.WARNING);
				default:
					return null;
				}
			}

			public String getColumnText(Object element, int columnIndex) {
				SeverityAndIssue sai = (SeverityAndIssue) element;
				switch(columnIndex){
				case 0:
					if (sai.getError() == SeverityEnum.ERROR)
						return "ERROR";
					else
						return "WARNING";
				case 1:
					return sai.getMessage();
				case 2:
					return sai.getElement().toString();
				case 3:
					return sai.getResourceName();
				}
				return null;
			}

			public void addListener(ILabelProviderListener listener) {
				
			}

			public void dispose() {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
			}
		
		});
		tableViewer.setInput(issues);
	}

	private void disableIgnoreButton() {
		this.getButton(IGNORE_BUTTON).setEnabled(false);
	}

	/**
	 * Create contents of the button bar
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IGNORE_BUTTON, "Ignore",
				false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL,
				true);
		for (SeverityAndIssue sai : issues)
			if (sai.getError() == SeverityEnum.ERROR) {
				disableIgnoreButton();
				break;
			}
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(661, 463);
	}
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Validation Errors have been reported");
	}
	
	protected void buttonPressed(int buttonId) {
		if (buttonId == IGNORE_BUTTON) {
			setReturnCode(IGNORE_BUTTON);
			close();
			return;
		}
		super.buttonPressed(buttonId);
	}

}

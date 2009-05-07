package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.dialogs.parameters.CreateEditorContents;
import de.uka.ipd.sdq.sensorframework.filter.AbstractMeasurementsCollection;

/**
 * @author Roman Andrej
 */
public class ParametersDialog extends TitleAreaDialog {

	private AbstractMeasurementsCollection filter;

	/**
	 * Creates a dialog with the given parent and edited properties name
	 * 
	 * @param parentShell
	 *            -object that returns the current parent shell columnName -
	 *            edited properties
	 */
	public ParametersDialog(Shell parentShell, AbstractMeasurementsCollection filter) {
		super(parentShell);
		this.filter = filter;

		/**
		 * the result of combining the constants which are required
		 * to produce a typical application top level shell
		 */
		setShellStyle(SWT.RESIZE|SWT.TITLE|SWT.CLOSE |SWT.MIN|SWT.MAX);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Filter parameters");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Edit a Parameter...");

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		CreateEditorContents editorContents = CreateEditorContents
				.create(container);

//		editorContents
//				.setViewerContentProvider(new IStructuredContentProvider(){
//
//					/* (non-Javadoc)
//					 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
//					 */
//					public Object[] getElements(Object inputElement) {
//						if (inputElement instanceof AbstractMeasurementsFilter) {
//							AbstractMeasurementsFilter filter = (AbstractMeasurementsFilter) inputElement;
//							return new Object[] { filter.getParameter() };
//						}
//						return null;
//					}
//
//					/* (non-Javadoc)
//					 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
//					 */
//					public void dispose() {
//						// The implementation is not necessary.
//					}
//
//					/* (non-Javadoc)
//					 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
//					 */
//					public void inputChanged(Viewer viewer, Object oldInput,
//							Object newInput) {
//						// The implementation is not necessary.
//					}
//				});
//		editorContents
//				.setViewerLabelProvider(new ParametersDialogLabelProvider(
//						filter.getClass().getSimpleName()));
//		editorContents.setViewerCellModifier(new ...);
//		editorContents.setAddButtonActionListener(new AddParameterAction(
//				signature));
//
//		DeleteParameterAction deleteParameterAction = new DeleteParameterAction(
//				signature);
//		UpParameterAction upParameterAction = new UpParameterAction(signature);
//		DownParameterAction downParameterAction = new DownParameterAction(
//				signature);
//
//		editorContents.setDeleteButtonActionListener(deleteParameterAction);
//		editorContents.setUpButtonActionListener(upParameterAction);
//		editorContents.setDownButtonActionListener(downParameterAction);
//
//		editorContents.setViewerSelectionChangedListener(deleteParameterAction);
//		editorContents.setViewerSelectionChangedListener(upParameterAction);
//		editorContents.setViewerSelectionChangedListener(downParameterAction);
//
		editorContents.setViewerInput(filter);
//
//		/** create separatot to button area */
//		((CreateEditorContents) editorContents).createSeparator(parent);

		return area;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				false);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(500, 375);
	}
}

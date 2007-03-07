	package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * @author roman
 * 
 * The dialogue serves the input of parameter names and types in table cells. It
 * a simple editor implemented for providing and deletion of types.
 */
public class ParametersDialogViewer extends TitleAreaDialog {

	private ParametersDialogResources dialogResources;

	private ComposedAdapterFactory adapterFactory;

	private String properties;

	/**
	 * Creates a dialog with the given parent and edited properties name
	 * 
	 * @param parentShell
	 *            -object that returns the current parent shell columnName -
	 *            edited properties
	 */
	public ParametersDialogViewer(Shell parentShell, String columnName) {
		super(parentShell);
		this.properties = columnName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(properties);

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		dialogResources = new ParametersDialogResources();

		adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());

		dialogResources.createToolBarWithTableViewer(container,
				new AdapterFactoryContentProvider(adapterFactory),
				new AdapterFactoryLabelProvider(
						new ParametersItemProviderAdapterFactory(
								new PalladioItemProviderAdapterFactory(
										adapterFactory))),
				new ParametersCellModifier(), new AddParameterActionListener(),
				new DeleteParameterActionListener(),
				OperationsTabResources.getEditedSignature());

		dialogResources.createSeparator(container);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(500, 375);
	}
}

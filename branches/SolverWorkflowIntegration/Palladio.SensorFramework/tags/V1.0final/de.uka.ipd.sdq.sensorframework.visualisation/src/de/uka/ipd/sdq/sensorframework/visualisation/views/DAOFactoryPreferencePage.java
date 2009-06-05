/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * DAO Factory preference page implementation.
 * 
 * @author Roman Andrej
 */
public class DAOFactoryPreferencePage extends PreferencePage {


	IDAOFactory factory;
	
	/**
	 * @param factory
	 */
	public DAOFactoryPreferencePage(IDAOFactory factory) {
		this.factory = factory;
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		
		final int width = 70;
		final int heigth = 16;
		
		Composite container = new Composite(parent, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);

		// Name
		final Label nameLabel = new Label(container, SWT.NONE);
		final GridData gd_nameLabel = new GridData(width, heigth);
		nameLabel.setLayoutData(gd_nameLabel);
		nameLabel.setText("Name:");

		final Label namevalueLabel = new Label(container, SWT.NONE);
		final GridData gd_namevalueLabel = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gd_namevalueLabel.heightHint = heigth;
		namevalueLabel.setLayoutData(gd_namevalueLabel);
		namevalueLabel.setText(factory.getName());

//		// Description
//		final Label descriptionLabel = new Label(container, SWT.NONE);
//		final GridData gd_descriptionLabel = new GridData(width, heigth);
//		descriptionLabel.setLayoutData(gd_descriptionLabel);
//		descriptionLabel.setText("Description:");
//
//		final Label descriptionvalueLabel = new Label(container, SWT.NONE);
//		final GridData gd_descriptionvalueLabel = new GridData(SWT.FILL, SWT.CENTER, false, false);
//		gd_descriptionLabel.heightHint = heigth;
//		descriptionvalueLabel.setLayoutData(gd_descriptionvalueLabel);
//		descriptionvalueLabel.setText(factory.getDescription());

		// Persistent Info
		final Label locationPathLabel = new Label(container, SWT.NONE);
		final GridData gd_locationPathLabel = new GridData(width, heigth);
		locationPathLabel.setLayoutData(gd_locationPathLabel);
		locationPathLabel.setText("Location path:");

		final Label pathValueLabel = new Label(container, SWT.NONE);
		final GridData gd_pathValueLabel = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gd_pathValueLabel.heightHint = heigth;
		pathValueLabel.setLayoutData(gd_pathValueLabel);
		pathValueLabel.setText(factory.getPersistendInfo());

		return container;
	}
}

package org.somox.ui.runconfig.tabs;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.somox.configuration.ConfigurationDefinition;
import org.somox.ui.Activator;
import org.somox.ui.SoMoXUILogger;

/**
 * The class defines a tab, which is responsible for the input for a model
 * extraction
 * 
 * @author Michael Hauck
 */
public class ModelExtractionInputTab extends AbstractLaunchConfigurationTab {


	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		//configuration.setAttribute("test1", (String) testTextField.getText());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				ModelExtractionInputTab.this.setDirty(true);
				ModelExtractionInputTab.this.updateLaunchConfigurationDialog();
			}
		};

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		LinkedList<ConfigurationDefinition> configs = Activator.getDefault()
				.getGuiSoMoXCoreController().getConfigurationDefinitions();

		SoMoXUILogger.logInfo("Number of configs to be build: "
				+ configs.size());

		Iterator<ConfigurationDefinition> configIterator = configs.iterator();
		while (configIterator.hasNext()) {
			ConfigurationDefinition config = configIterator.next();

			if (ConfigurationDefinition.Type.DIRECTORY.equals(config.getType())) {

				final Group directoryTypeGroup = new Group(container, SWT.NONE);
				final GridLayout glDirectoryTypeGroup = new GridLayout();
				glDirectoryTypeGroup.numColumns = 3;
				directoryTypeGroup.setLayout(glDirectoryTypeGroup);
				directoryTypeGroup.setText(config.getName());
				directoryTypeGroup.setLayoutData(new GridData(SWT.FILL,
						SWT.CENTER, true, false));

				final Text textDirectory = new Text(directoryTypeGroup,
						SWT.SINGLE | SWT.BORDER);
				final GridData gd_textResourceTypeRepository = new GridData(
						SWT.FILL, SWT.CENTER, true, false);
				gd_textResourceTypeRepository.widthHint = 200;
				textDirectory.setLayoutData(gd_textResourceTypeRepository);
				textDirectory.addModifyListener(modifyListener);

				final Button workspaceButton = new Button(directoryTypeGroup,
						SWT.NONE);
				workspaceButton.setText("Workspace...");
				workspaceButton
						.addSelectionListener(new WorkspaceButtonSelectionListener(
								textDirectory));

				final Button buttonResourceTypeRepository = new Button(
						directoryTypeGroup, SWT.NONE);
				buttonResourceTypeRepository.setLayoutData(new GridData());
				buttonResourceTypeRepository.setText("File System...");
				buttonResourceTypeRepository
						.addSelectionListener(new SelectionAdapter() {

							/*
							 * (non-Javadoc)
							 * 
							 * @seeorg.eclipse.swt.events.SelectionAdapter#
							 * widgetSelected
							 * (org.eclipse.swt.events.SelectionEvent)
							 */
							public void widgetSelected(SelectionEvent e) {
								String resultOpenFileDialog = "";
								
								DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.OPEN);
								dialog.setText("Select a folder.");
								
								if (dialog.open() != null) {
									resultOpenFileDialog = dialog.getFilterPath();	
								}	
								
								if (!resultOpenFileDialog.equals(new String(""))) {
									textDirectory.setText(resultOpenFileDialog);			
								}
							}
						});

			} else if (ConfigurationDefinition.Type.STRING.equals(config
					.getType())) {
				
				final Group stringTypeGroup = new Group(container, SWT.NONE);
				final GridData gd_stringTypeGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
				stringTypeGroup.setLayoutData(gd_stringTypeGroup);
				final GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 2;
				stringTypeGroup.setLayout(gridLayout);
				
				final Label stringLabel = new Label(stringTypeGroup, SWT.NONE);
				stringLabel.setText(config.getName());
				final Text stringField = new Text(stringTypeGroup, SWT.BORDER);
				stringField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				
			} else if (ConfigurationDefinition.Type.BOOLEAN.equals(config
					.getType())) {
				
				final Group booleanTypeGroup = new Group(container, SWT.NONE);
				booleanTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
				booleanTypeGroup.setLayout(new GridLayout());
				final Button booleanButton = new Button(booleanTypeGroup, SWT.CHECK);
				booleanButton.setText(config.getName());
			}
		}

	}

	/** Button SelectionListener - call a WorkspaceResourceDialog */
	class WorkspaceButtonSelectionListener extends SelectionAdapter {

		private Text field;

		public WorkspaceButtonSelectionListener(Text field) {
			this.field = field;

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
		 * .swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			String resultOpenFileDialog = "";
			/** create the dialog message */
			String msg = "Select a folder.";

			IResource dir = null;
			List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
			IContainer[] dirs = WorkspaceResourceDialog.openFolderSelection(
					getShell(), null, msg, false, null, filters);
			try {
				if (dirs.length != 0) {
					dir = dirs[0];
				}
				if (dir != null) {
					resultOpenFileDialog = dir.getLocation().toOSString();
				}
			} catch (Exception ce) {
				ce.printStackTrace();
			}
			if (!resultOpenFileDialog.equals(new String(""))) {
				field.setText(resultOpenFileDialog);
			}
		}
	}

	public void initializeFrom(ILaunchConfiguration config) {

	}

	/*public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		try {
			Integer.parseInt(testTextField.getText().trim());
		} catch (NumberFormatException nfe) {
			setErrorMessage("testTextField is not an integer");
			return false;
		}
		return true;
	}*/

	@Override
	public String getName() {
		return "Model Extraction";
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		//configuration.setAttribute("test1", "200");

	}

}

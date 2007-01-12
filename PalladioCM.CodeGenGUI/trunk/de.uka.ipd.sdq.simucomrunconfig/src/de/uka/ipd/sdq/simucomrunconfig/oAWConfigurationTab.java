package de.uka.ipd.sdq.simucomrunconfig;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author admin
 * 
 */
public class oAWConfigurationTab extends AbstractLaunchConfigurationTab {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return ResourceManagerTab.getConfigurationImage();
	}

	/**
	 * The default value for the 'height' Layout attribute.
	 */
	private final int LAYOUT_WIDTH = 554;

	private Text outputPath;

	private Label locationLabel;

	private Button workspaceButton;

	private Button fileSystemButton;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		// Create outPath section
		final Group outputPathGroup = new Group(container, SWT.NONE);
		outputPathGroup.setText("Output Path");
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		outputPathGroup.setLayout(gridLayout);
		outputPathGroup.setLayoutData(new GridData(LAYOUT_WIDTH, 80));

		final Button defaultLocationButton = new Button(outputPathGroup,
				SWT.CHECK);
		final GridData gridData_1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1);
		defaultLocationButton.setLayoutData(gridData_1);
		defaultLocationButton.setText("Use default location");
		defaultLocationButton.setSelection(true);
		defaultLocationButton.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				setEnabled(false);
				outputPath
						.setText(ResourceManagerTab.getGeneretePluginPath());

				if (!defaultLocationButton.getSelection())
					setEnabled(true);
			}
		});
		new Label(outputPathGroup, SWT.NONE);

		locationLabel = new Label(outputPathGroup, SWT.NONE);
		locationLabel.setLayoutData(new GridData(48, SWT.DEFAULT));
		locationLabel.setText("Location:");

		outputPath = new Text(outputPathGroup, SWT.BORDER);
		final GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1);
		gridData.widthHint = 456;
		outputPath.setLayoutData(gridData);
		outputPath.setText(ResourceManagerTab.getGeneretePluginPath());
		new Label(outputPathGroup, SWT.NONE);

		workspaceButton = new Button(outputPathGroup, SWT.NONE);
		workspaceButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false));
		workspaceButton.setText("Workspace...");

		fileSystemButton = new Button(outputPathGroup, SWT.NONE);
		fileSystemButton.setLayoutData(new GridData());
		fileSystemButton.setText("File System...");
		fileSystemButton.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				String pluginPath = openDirectoryDialog(e);
				outputPath.setText(pluginPath);
				ResourceManagerTab.setGeneretePluginPath(pluginPath);
			}
		});

		// --- setEnabled(false) ---
		setEnabled(false);

	}

	/**
	 * TODO
	 * 
	 * @param enable
	 */
	private void setEnabled(Boolean enable) {
		locationLabel.setEnabled(enable);
		outputPath.setEnabled(enable);
		workspaceButton.setEnabled(enable);
		fileSystemButton.setEnabled(enable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return "Configuration";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	/**
	 * The function calls the DirectoryDialog and give back absolute path to the
	 * directory as String
	 * 
	 * @param shell
	 *            which will be the parent of the new instance
	 * @return absolute path to ordner
	 */
	private String openDirectoryDialog(SelectionEvent e) {

		String directoryname = "";
		Shell shell = e.display.getActiveShell();

		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN | SWT.SAVE);
		dialog.setText("Select Directoryn");

		if (dialog.open() != null) {
			directoryname = dialog.getFilterPath(); // + File.separatorChar;
		}

		return directoryname;
	}

}

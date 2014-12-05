package de.uka.ipd.sdq.simucom.rerunSimulation.runconfig;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.simucom.rerunSimulation.listener.GeneratedProjectSelectionListener;

public class GeneratedProjectChooseSimulationTab extends AbstractLaunchConfigurationTab {

    private Composite container;

    private Text generatedProject;
    private Button fileSystemChooser;

    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout());
        setControl(container);

        ModifyListener modify = new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
            }

        };
        final Group generatedProjectInputGroup = new Group(container, SWT.BORDER);
        final GridLayout glGeneratedProjectInputGroup = new GridLayout();
        glGeneratedProjectInputGroup.numColumns = 2;

        generatedProjectInputGroup.setLayout(glGeneratedProjectInputGroup);
        generatedProjectInputGroup.setText("Choose existing generated project");
        generatedProjectInputGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        generatedProject = new Text(generatedProjectInputGroup, SWT.SINGLE | SWT.BORDER);
        final GridData gridDataTextFileName = new GridData(SWT.FILL, SWT.CENTER, true, false);
        gridDataTextFileName.widthHint = 200;
        generatedProject.setLayoutData(gridDataTextFileName);
        generatedProject.addModifyListener(modify);

        fileSystemChooser = new Button(generatedProjectInputGroup, SWT.NONE);
        fileSystemChooser.setText("File system...");
        fileSystemChooser.addSelectionListener(new GeneratedProjectSelectionListener());
    }

    @Override
    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
        // No defaults needed currently
    }

    @Override
    public void initializeFrom(ILaunchConfiguration configuration) {
        generatedProject.setText("");
    }

    @Override
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {

    }

    @Override
    public String getName() {
        return "File Configuration";
    }

}

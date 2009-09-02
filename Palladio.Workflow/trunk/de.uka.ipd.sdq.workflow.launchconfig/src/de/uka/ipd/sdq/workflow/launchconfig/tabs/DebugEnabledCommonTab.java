package de.uka.ipd.sdq.workflow.launchconfig.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class DebugEnabledCommonTab extends CommonTab {

	public static final String WORKFLOW_ENGINE_DEBUG_LEVEL = "de.uka.ipd.sdq.workflowengine.debuglevel";
	private Combo debuglvl;

	@Override
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		};
		Composite myComposite = new Composite(parent,SWT.NONE);
		GridLayout myCompositeLayout = new GridLayout();
		myCompositeLayout.numColumns = 1;
		myComposite.setLayout(myCompositeLayout);
		
		Group debugLevelGrp = new Group(myComposite, SWT.NONE);
		debugLevelGrp.setText("Output details");
		debugLevelGrp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		GridLayout grdLayout = new GridLayout();
		debugLevelGrp.setLayout(grdLayout);
		grdLayout.numColumns = 2;
		
		Label lblDebugLevel = new Label(debugLevelGrp, SWT.NONE);
		lblDebugLevel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1, 1));
		lblDebugLevel.setText("Output verboseness level");
		
		debuglvl = new Combo(debugLevelGrp, SWT.NONE);
		debuglvl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		debuglvl.add("TRACE", 0);
		debuglvl.add("DEBUG", 1);
		debuglvl.add("INFO", 2);
		debuglvl.add("WARNING", 3);
		debuglvl.add("ERROR", 4);
		debuglvl.add("ALL", 5);
		debuglvl.select(2);
		debuglvl.addModifyListener(modifyListener);
		
		super.createControl(myComposite);
		Control oldControl = getControl();
		oldControl.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		
		setControl(myComposite);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		try {
			debuglvl.select(configuration.getAttribute(WORKFLOW_ENGINE_DEBUG_LEVEL, 2));
		} catch (CoreException e) {
			debuglvl.select(2);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(WORKFLOW_ENGINE_DEBUG_LEVEL,
				debuglvl.getSelectionIndex());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		super.setDefaults(config);
		config.setAttribute(WORKFLOW_ENGINE_DEBUG_LEVEL,
				2);
	}
}

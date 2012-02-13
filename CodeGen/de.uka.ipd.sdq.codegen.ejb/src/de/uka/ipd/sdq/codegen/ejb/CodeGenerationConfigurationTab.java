package de.uka.ipd.sdq.codegen.ejb;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuConfigurationTab;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;


public class CodeGenerationConfigurationTab extends SimuConfigurationTab {
	
	protected Combo comboModelToTextTarget;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);		
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		
		try{
			String solverStr = configuration.getAttribute(ConstantsContainer.MODEL_TO_TEXT_CHOICE, 
					ConstantsContainer.MODEL_TO_TEXT_TARGET_EJB);
			String[] items = comboModelToTextTarget.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(solverStr)){
					comboModelToTextTarget.select(i);
				}
			}
		} catch(CoreException e){
			comboModelToTextTarget.select(0);
		}
		
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		
		configuration.setAttribute(ConstantsContainer.MODEL_TO_TEXT_CHOICE,
				comboModelToTextTarget.getText());
		
	}

	@Override
	protected void createFurtherSections(Composite container) {
		super.createFurtherSections(container);
		
		final Group modelTarget = new Group(container, SWT.NONE);
		modelTarget.setText("Transformation Target");
		
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				CodeGenerationConfigurationTab.this.setDirty(true);
				CodeGenerationConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};

		comboModelToTextTarget = new Combo (modelTarget, SWT.READ_ONLY);
		comboModelToTextTarget.setItems (new String [] {
				ConstantsContainer.MODEL_TO_TEXT_TARGET_EJB,
				ConstantsContainer.MODEL_TO_TEXT_TARGET_STUBS,
				ConstantsContainer.MODEL_TO_TEXT_TARGET_PROTO
				});
		comboModelToTextTarget.setSize (350, 50);
		comboModelToTextTarget.addModifyListener(modifyListener);
	}

	
	
	
}

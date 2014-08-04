package org.palladiosimulator.protocom.workflow;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import de.uka.ipd.sdq.workflow.pcm.runconfig.AbstractConfigurationTab;

public class ProtoComGenerationConfigurationTab extends AbstractConfigurationTab {

    protected Combo comboModelToTextTarget;

    // Sensitivity Analysis
    private Text variableText;
    private Text minimumText;
    private Text maximumText;
    private Text stepWidthText;
    private ArrayList<String> modelFiles = new ArrayList<String>();

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
    }

    @Override
    public void initializeFrom(ILaunchConfiguration configuration) {
        super.initializeFrom(configuration);

        try {
            variableText.setText(configuration.getAttribute(ConstantsContainer.VARIABLE_TEXT, ""));
        } catch (CoreException e) {
            variableText.setText("");
        }

        try {
            minimumText.setText(configuration.getAttribute(ConstantsContainer.MINIMUM_TEXT, ""));
        } catch (CoreException e) {
            minimumText.setText("");
        }

        try {
            maximumText.setText(configuration.getAttribute(ConstantsContainer.MAXIMUM_TEXT, ""));
        } catch (CoreException e) {
            maximumText.setText("");
        }

        try {
            stepWidthText.setText(configuration.getAttribute(ConstantsContainer.STEP_WIDTH_TEXT, ""));
        } catch (CoreException e) {
            stepWidthText.setText("");
        }

        try {
            modelFiles.clear();
            modelFiles.add(configuration.getAttribute(ConstantsContainer.REPOSITORY_FILE, ""));
            modelFiles.add(configuration.getAttribute(ConstantsContainer.SYSTEM_FILE, ""));
            modelFiles.add(configuration.getAttribute(ConstantsContainer.ALLOCATION_FILE, ""));
            modelFiles.add(configuration.getAttribute(ConstantsContainer.USAGE_FILE, ""));
        } catch (CoreException e) {
            stepWidthText.setText("");
        }

        try {
            String solverStr = configuration.getAttribute(ConstantsContainer.MODEL_TO_TEXT_CHOICE,
                    ConstantsContainer.MODEL_TO_TEXT_TARGET_JAVA_SE_RMI);
            String[] items = comboModelToTextTarget.getItems();
            for (int i = 0; i < items.length; i++) {
                String str = items[i];
                if (str.equals(solverStr)) {
                    comboModelToTextTarget.select(i);
                }
            }
        } catch (CoreException e) {
            comboModelToTextTarget.select(0);
        }

    }

    @Override
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
        super.performApply(configuration);

        configuration.setAttribute(ConstantsContainer.VARIABLE_TEXT, variableText.getText());
        configuration.setAttribute(ConstantsContainer.MINIMUM_TEXT, minimumText.getText());
        configuration.setAttribute(ConstantsContainer.MAXIMUM_TEXT, maximumText.getText());
        configuration.setAttribute(ConstantsContainer.STEP_WIDTH_TEXT, stepWidthText.getText());

        configuration.setAttribute(ConstantsContainer.MODEL_TO_TEXT_CHOICE, comboModelToTextTarget.getText());
    }

    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
        super.setDefaults(configuration);
        configuration.setAttribute(ConstantsContainer.DELETE_TEMPORARY_DATA_AFTER_ANALYSIS, false);
    }

    @Override
    protected void createFurtherSections(Composite container) {
        final Group sensitivityAnalysisParametersGroup = new Group(container, SWT.NONE);
        sensitivityAnalysisParametersGroup.setText("Sensitivity Analysis Parameters");
        final GridData gridDataSensitivityAnalysisParametersGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
        sensitivityAnalysisParametersGroup.setLayoutData(gridDataSensitivityAnalysisParametersGroup);
        final GridLayout gridLayout1 = new GridLayout();
        gridLayout1.numColumns = 3;
        sensitivityAnalysisParametersGroup.setLayout(gridLayout1);

        final Label variableToAdaptLabel = new Label(sensitivityAnalysisParametersGroup, SWT.NONE);
        final GridData gridDataVariableToAdaptLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
        variableToAdaptLabel.setLayoutData(gridDataVariableToAdaptLabel);
        variableToAdaptLabel.setText("Variable:");

        variableText = new Text(sensitivityAnalysisParametersGroup, SWT.BORDER);
        variableText.setEnabled(true);
        variableText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        variableText.addModifyListener(modifyListener);

        final Button selectVariableButton = new Button(sensitivityAnalysisParametersGroup, SWT.NONE);
        selectVariableButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(final SelectionEvent e) {
                selectVariable();
            }
        });
        selectVariableButton.setText("Select Variable...");

        final Composite composite = new Composite(sensitivityAnalysisParametersGroup, SWT.NONE);
        final GridData gdComposite = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
        composite.setLayoutData(gdComposite);
        final GridLayout gridLayout2 = new GridLayout();
        gridLayout2.numColumns = 6;
        composite.setLayout(gridLayout2);

        final Label minimumLabel = new Label(composite, SWT.NONE);
        minimumLabel.setText("Minimum:");

        minimumText = new Text(composite, SWT.BORDER);
        minimumText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        minimumText.addModifyListener(modifyListener);

        final Label maximumLabel = new Label(composite, SWT.NONE);
        maximumLabel.setText("Maximum:");

        maximumText = new Text(composite, SWT.BORDER);
        maximumText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        maximumText.addModifyListener(modifyListener);

        final Label stepWidthLabel = new Label(composite, SWT.NONE);
        stepWidthLabel.setText("Step Width:");

        stepWidthText = new Text(composite, SWT.BORDER);
        stepWidthText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        stepWidthText.addModifyListener(modifyListener);

        final Group modelTargetGroup = new Group(container, SWT.NONE);
        modelTargetGroup.setText("Transformation Target");
        final GridData gridDataModelTarget = new GridData(SWT.FILL, SWT.CENTER, true, false);
        modelTargetGroup.setLayoutData(gridDataModelTarget);
        final GridLayout gridLayoutModelTarget = new GridLayout();
        gridLayoutModelTarget.numColumns = 1;
        modelTargetGroup.setLayout(gridLayoutModelTarget);

        final ModifyListener modifyListener = new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                ProtoComGenerationConfigurationTab.this.setDirty(true);
                ProtoComGenerationConfigurationTab.this.updateLaunchConfigurationDialog();
            }
        };

        comboModelToTextTarget = new Combo(modelTargetGroup, SWT.READ_ONLY);
        comboModelToTextTarget.setItems(new String[] {
                ConstantsContainer.MODEL_TO_TEXT_TARGET_JAVA_SE_RMI,
                ConstantsContainer.MODEL_TO_TEXT_TARGET_JAVA_SE_RMI_STUBS,
                ConstantsContainer.MODEL_TO_TEXT_TARGET_JAVA_EE_EJB
        });
        comboModelToTextTarget.setSize(350, 50);
        comboModelToTextTarget.addModifyListener(modifyListener);
    }

    protected void selectVariable() {
        ResourceSet rs = new ResourceSetImpl();
        ArrayList<Object> filter = new ArrayList<Object>();
        filter.add(EObject.class);
        for (String file : modelFiles) {
            try {
                rs.getResource(URI.createURI(file), true);
            } catch (Exception ex) {
                rs.getResource(URI.createFileURI(file), true);
            }
        }
        EcoreUtil.resolveAll(rs);
        PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(this.getShell(), filter, rs);
        if (dialog.open() == org.eclipse.jface.dialogs.Dialog.OK) {
            variableText.setText(EcoreUtil.getURI(dialog.getResult()).toString());
        }
    }
}

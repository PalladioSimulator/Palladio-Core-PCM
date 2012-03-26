package edu.kit.ipd.sdq.pcm.codegen.m2m.reliability.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class ReliabilityExtensionTab extends AbstractLaunchConfigurationTab {
	

	// Default values
	private static final Boolean DEFAULT_SIMULATE_FAILURES = false;
	
	// UI elements
	private Button simulateFailuresButton;
	
	// Configuration attribute IDs
	public static final String SIMULATE_FAILURES = "simulateFailures";

	public void createControl(Composite parent) {

		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				ReliabilityExtensionTab.this.setDirty(true);
				ReliabilityExtensionTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				ReliabilityExtensionTab.this.setDirty(true);
				ReliabilityExtensionTab.this.updateLaunchConfigurationDialog();
			}
		};
		// Create the top-level container:
				Composite container = new Composite(parent, SWT.NONE);

				setControl(container);
				container.setLayout(new GridLayout());

				// Create reliability section:
				final Group reliabilityGroup = new Group(container, SWT.NONE);
				reliabilityGroup.setText("Reliability");
				final GridData gd_reliabilityGroup = new GridData(SWT.FILL, SWT.CENTER,
						true, false);
				reliabilityGroup.setLayoutData(gd_reliabilityGroup);
				reliabilityGroup.setLayout(new GridLayout());
				simulateFailuresButton = new Button(reliabilityGroup, SWT.CHECK);
				final GridData gd_simulateFailuresButton = new GridData(
						SWT.FILL, SWT.CENTER, true, false);
				simulateFailuresButton
						.setLayoutData(gd_simulateFailuresButton);
				simulateFailuresButton.setText("Simulate failures");
				simulateFailuresButton.addSelectionListener(selectionListener);

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				SIMULATE_FAILURES, DEFAULT_SIMULATE_FAILURES);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			simulateFailuresButton.setSelection(configuration.getAttribute(
					SIMULATE_FAILURES, true));
		} catch (CoreException e) {
			simulateFailuresButton.setSelection(false);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				SIMULATE_FAILURES,
				this.simulateFailuresButton.getSelection());
	}

	@Override
	public String getName() {
		return "Reliability Extension";
	}

}

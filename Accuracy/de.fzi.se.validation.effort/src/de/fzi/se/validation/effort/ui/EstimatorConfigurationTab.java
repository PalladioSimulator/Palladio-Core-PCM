/**
 *
 */
package de.fzi.se.validation.effort.ui;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.fzi.se.validation.effort.workflow.EstimatorConstantsContainer;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab;

/**Launch configuration dialog tab for validation effort estimation.
 *
 * @author groenda
 *
 */
public class EstimatorConfigurationTab extends AbstractEstimatorConfigurationTab {
	/** Label of the estimator group. */
	private static final String ESTIMATOR_GROUP_LABEL = "Validation Effort Estimation";
	/** Label of the repository file label. */
	private static final String ESTIMATOR_REPOSITORY_FILE_LABEL = "Repository File";
	/** Label of the behaviour URI. */
	private static final String ESTIMATOR_BEHAVIOUR_URI_LABEL = "Behaviour: ";
	/** Label of the behaviour URI selection button. */
	private static final String ESTIMATOR_BEHAVIOUR_URI_SELECTION_BUTTON_LABEL = "Select";
	/** Label of the behaviour URI selection button. */
	private static final String ESTIMATOR_CONFIDENCE_LABEL = "Confidence Level: ";
	/** Name of this tab. */
	private static final String NAME = "Estimation Configuration";

	/** Repository file uri text field. */
	private Text repositoryFile;
	/** Behaviour URI text field. */
	private Text behaviourURI;
	/** Confidence level text field. */
	private Text confidenceText;
	/** Button for behaviour URI selection. */
	private Button selectBehaviourURIButton;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		Composite container = (Composite) getControl();

		final Group estimatorGroup = new Group(container, SWT.NONE);
		estimatorGroup.setText(ESTIMATOR_GROUP_LABEL);
		final GridData gd_estimatorGroup = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		estimatorGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		estimatorGroup.setLayout(gridLayout);

		// repository file
		repositoryFile = new Text(estimatorGroup, SWT.SINGLE | SWT.BORDER);
		repositoryFile.addModifyListener(modifyListener);
		repositoryFile.setLayoutData(gd_estimatorGroup);
		repositoryFile.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (! repositoryFile.getText().equals(EstimatorConstantsContainer.DEFAULT_REPOSITORY_FILE)) {
					selectBehaviourURIButton.setEnabled(true);
				}
			}
		});
		TabHelper.createFileInputSection(estimatorGroup, modifyListener,
				ESTIMATOR_REPOSITORY_FILE_LABEL,
				ConstantsContainer.REPOSITORY_EXTENSION,
				repositoryFile, getShell(), EstimatorConstantsContainer.DEFAULT_REPOSITORY_FILE);
		repositoryFile.getParent().setLayoutData(gd_estimatorGroup);

		// behaviour URI
		final Label behaviourURILabel = new Label(estimatorGroup, SWT.NONE);
		behaviourURILabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		behaviourURILabel.setText(ESTIMATOR_BEHAVIOUR_URI_LABEL);

		behaviourURI = new Text(estimatorGroup, SWT.SINGLE | SWT.BORDER);
		behaviourURI.setEnabled(true);
		behaviourURI.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		behaviourURI.addModifyListener(modifyListener);

		selectBehaviourURIButton = new Button(estimatorGroup, SWT.NONE);
		selectBehaviourURIButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				selectBehaviourURI();
			}
		});
		selectBehaviourURIButton.setText(ESTIMATOR_BEHAVIOUR_URI_SELECTION_BUTTON_LABEL);
		selectBehaviourURIButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		selectBehaviourURIButton.setEnabled(false);

		// confidence level
		final Label confidenceLabel = new Label(estimatorGroup, SWT.NONE);
		confidenceLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		confidenceLabel.setText(ESTIMATOR_CONFIDENCE_LABEL);

		confidenceText = new Text(estimatorGroup, SWT.SINGLE | SWT.BORDER);
		confidenceText.setEnabled(true);
		confidenceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		confidenceText.addModifyListener(modifyListener);

	}

	/**Code for selecting the behaviour URI.
	 * The value of {@link #behaviourURI} is used to load the resource and provide a selection.
	 */
	protected void selectBehaviourURI() {
		ResourceSet rs = new ResourceSetImpl();
		ArrayList<Object> filter = new ArrayList<Object>();
		filter.add(Repository.class);
		filter.add(RepositoryComponent.class);
		filter.add(ResourceDemandingBehaviour.class);
		try {
			rs.getResource(URI.createURI(repositoryFile.getText()), true);
		} catch (Exception ex) {
			rs.getResource(URI.createFileURI(repositoryFile.getText()), true);
		}
		EcoreUtil.resolveAll(rs);
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog
			(this.getShell(),
			 filter,
			 rs);
		dialog.setTitle("Select Behaviour");
		if (dialog.open() == org.eclipse.jface.dialogs.Dialog.OK) {
			if (dialog.getResult() instanceof ResourceDemandingBehaviour) {
				behaviourURI.setText(EcoreUtil.getURI(dialog.getResult()).toString());
			} else {
				behaviourURI.setText(EstimatorConstantsContainer.DEFAULT_BEHAVIOUR_URI);
			}
		}
	}

	@Override
	public String getName() {
		return EstimatorConfigurationTab.NAME;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			repositoryFile.setText(configuration.getAttribute(EstimatorConstantsContainer.REPOSITORY_FILE, EstimatorConstantsContainer.DEFAULT_REPOSITORY_FILE));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Validation effort estimation repository file.", e.getMessage());
		}
		try {
			behaviourURI.setText(configuration.getAttribute(EstimatorConstantsContainer.BEHAVIOUR_URI, EstimatorConstantsContainer.DEFAULT_BEHAVIOUR_URI));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Validation effort estimation behaviour URI.", e.getMessage());
		}
		if (! repositoryFile.getText().equals(EstimatorConstantsContainer.DEFAULT_REPOSITORY_FILE)) {
			selectBehaviourURIButton.setEnabled(true);
		}
		try {
			confidenceText.setText(configuration.getAttribute(EstimatorConstantsContainer.CONFIDENCE, EstimatorConstantsContainer.DEFAULT_CONFIDENCE.toString()));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Validation effort estimation behaviour URI.", e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(EstimatorConstantsContainer.REPOSITORY_FILE, this.repositoryFile.getText());
		configuration.setAttribute(EstimatorConstantsContainer.BEHAVIOUR_URI, this.behaviourURI.getText());
		configuration.setAttribute(EstimatorConstantsContainer.CONFIDENCE, this.confidenceText.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(EstimatorConstantsContainer.REPOSITORY_FILE, EstimatorConstantsContainer.DEFAULT_REPOSITORY_FILE);
		configuration.setAttribute(EstimatorConstantsContainer.BEHAVIOUR_URI, EstimatorConstantsContainer.DEFAULT_BEHAVIOUR_URI);
		configuration.setAttribute(EstimatorConstantsContainer.CONFIDENCE, EstimatorConstantsContainer.DEFAULT_CONFIDENCE.toString());
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (repositoryFile.getText().equals(EstimatorConstantsContainer.DEFAULT_REPOSITORY_FILE)) {
			setErrorMessage("The location for the repository is missing.");
			return false;
		}
		if (behaviourURI.getText().equals(EstimatorConstantsContainer.DEFAULT_BEHAVIOUR_URI)) {
			setErrorMessage("A (resource demanding) behaviour must be selected.");
			return false;
		}
		try {
			double confidence = Double.parseDouble(confidenceText.getText());
			if (confidence < 0 || confidence > 1) {
				setErrorMessage("Confidence must be in the interval [0,1].");
				return false;
			}
		} catch (NumberFormatException e) {
			setErrorMessage("You must enter a number for the confidence level, e.g. 0.95.");
		}
		return true;
	}

	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
		// intentionally left blank
	}

	@Override
	public Image getImage() {
		return RunConfigImages.getTabImage(ConfigurationTab.PLUGIN_ID,ConfigurationTab.CONFIGURATION_TAB_IMAGE_PATH);
	}
}

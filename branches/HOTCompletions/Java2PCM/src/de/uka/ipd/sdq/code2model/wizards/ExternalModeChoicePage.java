package de.uka.ipd.sdq.code2model.wizards;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;

/**
 * The wizard page where the user can choose how packages are classified as
 * external: by own selection, as last time, or by the default strategy.
 * 
 * @author thomas
 */
public class ExternalModeChoicePage extends WizardPage implements Listener {

	private int numColumns = 2;
	private Button chooseButton;
	private Button reuseButton;
	private Button defaultButton;

	public ExternalModeChoicePage() {
		super(Code2ModelWizard.modeChoicePageName);
		setTitle("External Packages Classification");
		setDescription("Choose how external packages are determined");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		// layout for this wizard page
		GridLayout gl = new GridLayout();
		gl.numColumns = numColumns;
		composite.setLayout(gl);

		GridData gd = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		gd.horizontalSpan = numColumns;

		chooseButton = createRadioButton(composite, gd,
				"Choose from methods invoked in selection");
		chooseButton.setSelection(false);
		reuseButton = createRadioButton(composite, gd,
				"Reuse last selection");
		reuseButton.setSelection(false);
		defaultButton = createRadioButton(composite, gd,
				"Default: everything outside own package is external");
		defaultButton.setSelection(false);

		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		int lastUserSelection = prefs
				.getInt(Code2ModelPreferences.externalClassificationMode);
		if (lastUserSelection == Code2ModelPreferences.EXT_CLASSIFICATION_USER) {
			chooseButton.setSelection(true);
		} else if (lastUserSelection == Code2ModelPreferences.EXT_CLASSIFICATION_REUSE) {
			reuseButton.setSelection(true);
		} else if (lastUserSelection == Code2ModelPreferences.EXT_CLASSIFICATION_DEFAULT) {
			defaultButton.setSelection(true);
		}

		setControl(composite);
	}

	/**
	 * Create a new radio button.
	 * 
	 * @param composite the {@link Composite} to add it to
	 * @param gd the {@link GridData} to put it in
	 * @param description the text
	 * @return the radio button
	 */
	private Button createRadioButton(Composite composite, GridData gd,
			String description) {
		Button button = new Button(composite, SWT.RADIO);
		button.setText(description);
		button.setLayoutData(gd);
		button.setSelection(true);
		button.addListener(SWT.Selection, this);
		return button;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		if (event.widget == chooseButton) {
			prefs.setValue(Code2ModelPreferences.externalClassificationMode,
					Code2ModelPreferences.EXT_CLASSIFICATION_USER);
		} else if (event.widget == reuseButton) {
			prefs.setValue(Code2ModelPreferences.externalClassificationMode,
					Code2ModelPreferences.EXT_CLASSIFICATION_REUSE);
		} else if (event.widget == defaultButton) {
			prefs.setValue(Code2ModelPreferences.externalClassificationMode,
					Code2ModelPreferences.EXT_CLASSIFICATION_DEFAULT);
		}

		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		if (chooseButton.getSelection()) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		if (chooseButton.getSelection()) {
			return ((Code2ModelWizard)getWizard()).pkgsPage;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		return true;
	}

}

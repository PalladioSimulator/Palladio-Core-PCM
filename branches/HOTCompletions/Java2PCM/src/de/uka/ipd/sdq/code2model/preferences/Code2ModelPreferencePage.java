package de.uka.ipd.sdq.code2model.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.uka.ipd.sdq.code2model.Activator;

/**
 * The visual part of the preferences page appearing in the Eclipse preferences.
 * 
 * @author thomas
 */
public class Code2ModelPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	private IWorkbench workbench;

	public Code2ModelPreferencePage() {
		super(GRID);
		setPreferenceStore(doGetPreferenceStore());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	protected void createFieldEditors() {
		Composite composite = getFieldEditorParent();
		addField(new BooleanFieldEditor(
				Code2ModelPreferences.treatRelatedPackageAsSelf,
				"Treat related packages like the own package when using the default strategy",
				composite));
		addField(new BooleanFieldEditor(
				Code2ModelPreferences.alwaysInternalAction,
				"Create InternalActions for anything between service calls",
				composite));
		addField(new BooleanFieldEditor(
				Code2ModelPreferences.separateInternalActionsforAPI,
				"Create separate InternalActions for Java API calls",
				composite));
		addField(new BooleanFieldEditor(
				Code2ModelPreferences.methodsMustBeInIFace,
				"Create RDSEFFs only for methods declared in an implemented interface",
				composite));
		addField(new DirectoryFieldEditor(
				Code2ModelPreferences.repositoryOutputDir,
				"Output directory for serializing the repository", composite));
		addField(new DirectoryFieldEditor(
				Code2ModelPreferences.log4jConfigDir,
				"log4j configuration directory", composite));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		this.workbench = workbench;
	}

	/* (non-Javadoc) 
	 * @see org.eclipse.jface.preference.PreferencePage#doGetPreferenceStore()
	 */
	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

}


package de.uka.ipd.sdq.code2model.analysis.callclassification;

import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;

/**
 * The default {@link ServiceCallClassifier}: calls to related packages (common
 * root) depend on the user configuration, "others" are external.
 * 
 * @author thomas
 */
public class DefaultServiceCallClassifier extends ServiceCallClassifier {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier#classifyOtherCall()
	 */
	@Override
	protected int classifyOtherCall(String declaringClassFQN, String methodName) {
		// The default is simple: everything that isn't one of the cases handled
		// by packageDistance is external.
		return EXTERNAL_PACKAGE;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier#classifyRelatedCall(java.lang.String)
	 */
	@Override
	protected int classifyRelatedCall(String declaringClassFQN,
			String methodName) {
		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		boolean relatedAreInternal = prefs
				.getBoolean(Code2ModelPreferences.treatRelatedPackageAsSelf);
		if (relatedAreInternal) {
			return SAME_PACKAGE;
		}
		return EXTERNAL_PACKAGE;
	}

}

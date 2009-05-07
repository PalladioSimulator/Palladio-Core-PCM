/**
 * 
 */
package de.uka.ipd.sdq.code2model.analysis.callclassification;

import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;

/**
 * @author thomas
 */
public class PreferencesServiceCallClassifier extends ServiceCallClassifier {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier#classifyOtherCall(java.lang.String)
	 */
	@Override
	protected int classifyOtherCall(String declaringClassFQN, String methodName) {
		String qualifiedMethodName = declaringClassFQN + "." + methodName;
		logger.debug("Checking " + qualifiedMethodName);
		
		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		String extPackages = prefs
				.getString(Code2ModelPreferences.externalMethods);
		String[] userChosenMethods = extPackages.split(";");
		
		// TODO: we should also compare the parameter types, i.e., the complete
		// signature.
		for (String chosenMethod : userChosenMethods) {
			if (qualifiedMethodName.equals(chosenMethod)) {
				logger.debug(qualifiedMethodName + " is external.");
				return EXTERNAL_PACKAGE;
			}
		}
		return IGNORE;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier#classifyRelatedCall()
	 */
	@Override
	protected int classifyRelatedCall(String FQN, String methodName) {
		// We don't care about relatedness: if the user has chosen it, it is in,
		// otherwise not.
		return classifyOtherCall(FQN, methodName);
	}
}

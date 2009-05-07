package de.uka.ipd.sdq.code2model.preferences;

import de.uka.ipd.sdq.code2model.analysis.callclassification.DefaultServiceCallClassifier;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

/**
 * The central preferences class.
 * 
 * @author thomas
 */
public class Code2ModelPreferences {

	/**
	 * Where to save the XMI serialization of the repository containing the
	 * RDSEFFs.
	 */
	public static final String repositoryOutputDir = "repositoryOutputDir";

	/**
	 * Should the actions between two service calls be represented as an
	 * InternalAction even if deemed not performance relevant?
	 */
	public static final String alwaysInternalAction = "alwaysInternalAction";
	
	public static final String separateInternalActionsforAPI = 
			"separateInternalActionsforAPI";

	/**
	 * Should RDSEFFs only be declared for methods that are declared in an
	 * implemented interface?
	 */
	public static final String methodsMustBeInIFace = "methodsMustBeInIFace";

	/**
	 * Which packages of the Java API should result in InternalActions, and
	 * which should be ignored?
	 */
	public static final String wantedApiParts = "relevantApiParts";

	/**
	 * The list of user-selected methods to result in {@link ExternalCallAction}s.
	 */
	public static final String externalMethods = "externalMethods";

	/**
	 * How to determine ExternalCallActions: let the user select packages,
	 * re-use the user's last selection, or use a default strategy (defined in
	 * {@link DefaultServiceCallClassifier}).
	 */
	public static final String externalClassificationMode = "externalClassificationMode";
	public static final int EXT_CLASSIFICATION_USER = 0;
	public static final int EXT_CLASSIFICATION_REUSE = 1;
	public static final int EXT_CLASSIFICATION_DEFAULT = 2;

	/**
	 * Should invocations of methods in related packages, i.e., having a common
	 * package fragment root, be treated as internal when using the default
	 * strategy?  Otherwise, they are treated as external calls.
	 */
	public static final String treatRelatedPackageAsSelf = "treatRelatedPackageAsSelf";
	
	public static final String log4jConfigDir = "log4jConfigDir";
	public static final String LOG4J_CONFIGFILE_NAME = "log4j.properties";
}

package de.uka.ipd.sdq.code2model.analysis.callclassification;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Name;

/**
 * <p>
 * Determines the distance (package-wise) of a method call and recognizes some
 * special cases.
 * </p>
 * <p>
 * During the code analysis, some information is given to the
 * {@link ServiceCallClassifier}. First, the own package has to be known to
 * determine the distance of method calls to the own package and is set by
 * {@link #setOurPackage(Name)}. Then, Thread classes (implementing
 * {@link Runnable} or extending {@link Thread}) have to be known to handle
 * thread invocations, they are set when encountered by
 * {@link #addThreadClass(ITypeBinding)}.
 * </p>
 * <p>
 * This class is abstract, as the classification of calls that are neither
 * internal, nor from the same package, nor related is left open. Either in this
 * case the user-set preferences are consulted ({@link PreferencesServiceCallClassifier})
 * or a default strategy is applied ({@link DefaultServiceCallClassifier}).
 * </p>
 * 
 * @author thomas
 */
public abstract class ServiceCallClassifier {

	/**
	 * This method should be ignored.
	 */
	public static final int IGNORE = -1;
	/**
	 * The called method is in the same package as the class currently analysed.
	 */
	public static final int SAME_PACKAGE = 0;
	/**
	 * The called method is in another package as the class currently analysed.
	 */
	public static final int EXTERNAL_PACKAGE = 2;
	/**
	 * The called method is a Java API call, belonging to a package we consider
	 * relevant for the RDSEFF.
	 */
	public static final int JAVA_WANTED = 3;
	/**
	 * The called method is a Java API call, belonging to a package we do not
	 * consider relevant for the RDSEFF.
	 */
	public static final int JAVA_UNWANTED = IGNORE;
	/**
	 * The called method is the start of a thread.
	 */
	public static final int THREAD_INVOCATION = 5;

	protected Name ourPackage;
	protected String ourFQN = "";
	protected Set<ITypeBinding> threadClasses;
	// TODO Should not be initialized here, but in constructor from preferences
	protected String[] wantedApiPkgs = { "java.io", "java.net", "java.sql", 
			"java.util.logging", "java.util.zip", "javax.imageio", 
			"javax.net", "javax.sql"};

	Logger logger;

	public ServiceCallClassifier() {
		logger = Logger.getLogger(this.getClass());
		this.threadClasses = new HashSet<ITypeBinding>();
	}

	/**
	 * Make a found Thread class known to the Classifier.
	 * 
	 * @param threadClass
	 *            the {@link ITypeBinding} of the thread class
	 */
	public void addThreadClass(ITypeBinding threadClass) {
		this.threadClasses.add(threadClass);
	}

	/**
	 * Set the package of the currently analysed class.
	 * 
	 * @param p
	 *            our package's {@link Name}
	 */
	public void setOurPackage(Name p) {
		this.ourPackage = p;
		this.ourFQN = p.getFullyQualifiedName();
	}

	/**
	 * @return the {@link Name} of the package of the currently analysed class
	 */
	public Name getOurPackage() {
		return this.ourPackage;
	}

	/**
	 * Given an invoked method's name, determines its distance to our package.
	 * 
	 * @param declaringClassFQN
	 *            the fully qualified name of the invoked method
	 * @param methodName
	 *            the method's name to recognize some special cases
	 * @return the classification as int as set by the class' static fields
	 */
	public int classifyMethod(String declaringClassFQN, String methodName) {
		if (declaringClassFQN == null || declaringClassFQN.length() == 0) {
			logger.warn("No package name given for classifying method "
					+ methodName + ". Classifying as same package.");
			return SAME_PACKAGE;
		}

		String givenFqnPackage = declaringClassFQN.substring(0,
				declaringClassFQN.lastIndexOf("."));

		String fqn = declaringClassFQN + "." + methodName;
		int classification;
		if (givenFqnPackage.equals(ourFQN)) {
			classification = SAME_PACKAGE;
		} else if (methodIsFromRelatedPackage(givenFqnPackage)) {
			classification = classifyRelatedCall(declaringClassFQN, methodName);
		} else if (methodIsThreadInvocation(declaringClassFQN, methodName)) {
			classification = THREAD_INVOCATION;
		} else if (classIsFromJavaAPI(declaringClassFQN)) {
			classification = apiCallClassification(declaringClassFQN);
		} else {
			classification = classifyOtherCall(declaringClassFQN, methodName);
		}
		logger.debug(fqn + " classified as " + classification + " in " + ourFQN);
		return classification;
	}

	/**
	 * Check if this class is part of the Java API.
	 * 
	 * @param declaringClassFQN
	 *            the fully qualified name of the declaring class
	 * @return true if member of the API, false otherwise
	 */
	private boolean classIsFromJavaAPI(String declaringClassFQN) {
		return (declaringClassFQN.startsWith("java.") || declaringClassFQN
				.startsWith("javax."));
	}

	/**
	 * Classify a call to a related package, i.e., sharing a common package
	 * fragment root, as external or ignore.
	 * 
	 * @return {@link #EXTERNAL_PACKAGE} or {@link #IGNORE}
	 */
	protected abstract int classifyRelatedCall(String declaringClassFQN,
			String methodName);

	/**
	 * Classify a method call that is not internal, in a related package, or to
	 * the Java API.
	 * 
	 * @param declaringClassFQN
	 *            the fully qualified name of the method's declaring class
	 * @param methodName
	 *            the name of the method
	 * @return the classification as defined in the constants of
	 *         {@link ServiceCallClassifier}
	 */
	protected abstract int classifyOtherCall(String declaringClassFQN,
			String methodName);

	/**
	 * Check if the given package is "related" (but not equal) to our package,
	 * i.e., if they have a common first part.
	 * 
	 * @param givenFqnPackage
	 *            the package name to check
	 * @return whether the given and the recorded package are related
	 */
	protected boolean methodIsFromRelatedPackage(String givenFqnPackage) {
		return (ourFQN.startsWith(givenFqnPackage) || givenFqnPackage
				.startsWith(ourFQN));
	}

	/**
	 * Check if the given method is the invocation of a thread as defined by the
	 * Java API.
	 * 
	 * @param givenFQN
	 *            the fully qualified name of the given method's package
	 * @param methodName
	 *            the name of the method
	 * @return whether it is a thread invocation
	 */
	protected boolean methodIsThreadInvocation(String givenFQN,
			String methodName) {
		return (givenFQN.equals("java.lang.Thread") && methodName
				.equals("start"));
	}

	/**
	 * Classifies Java API calls as either {@link #JAVA_WANTED} or
	 * {@link #JAVA_UNWANTED}.
	 * 
	 * @param calleeFQN
	 *            the fully qualified name of the invoked API call
	 * @return the classification as defined in {@link ServiceCallClassifier}
	 */
	protected int apiCallClassification(String calleeFQN) {
		for (String curWanted : this.wantedApiPkgs) {
			if (calleeFQN.startsWith(curWanted)) {
				return JAVA_WANTED;
			}
		}
		return JAVA_UNWANTED;
	}

}

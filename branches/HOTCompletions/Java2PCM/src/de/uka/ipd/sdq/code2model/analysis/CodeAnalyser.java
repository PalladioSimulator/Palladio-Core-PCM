package de.uka.ipd.sdq.code2model.analysis;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.analysis.callclassification.DefaultServiceCallClassifier;
import de.uka.ipd.sdq.code2model.analysis.callclassification.PreferencesServiceCallClassifier;
import de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier;
import de.uka.ipd.sdq.code2model.astvisitors.AnalysingASTVisitor;
import de.uka.ipd.sdq.code2model.pcm.SeffBuilder;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;
import de.uka.ipd.sdq.code2model.wrappers.Method;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**
 * Manages and starts the analysis of one {@link CompilationUnit}.
 * 
 * It selects an appropriate {@link ServiceCallClassifier}, parses the
 * compilation unit, and starts the analysis by letting the correct visitor
 * visit the AST.
 * 
 * @author thomas
 */
public class CodeAnalyser {

	private String workspacePath;
	private String projectName;

	private SeffBuilder builder;
	private AST2SeffTranslator translator;
	private Logger logger;
	private ServiceCallClassifier classifier;

	/**
	 * The constructor, sets up Eclipse workspace related data.
	 * 
	 * @param monitor
	 *            an {@link IProgressMonitor} to report analysis progress
	 */
	public CodeAnalyser(IProgressMonitor monitor) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		this.workspacePath = root.getLocationURI().getPath();

		this.builder = new SeffBuilder();
		this.translator = new AST2SeffTranslator(builder);
		this.classifier = createClassifier();
		
		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * Get some necessary information about the current compilation unit.
	 * 
	 * @param compUnit
	 *            the current compilation unit
	 * @throws JavaModelException
	 *             if no package declaration could be found
	 */
	private void getDataFromCompilationUnit(ICompilationUnit compUnit)
			throws JavaModelException {
		this.projectName = compUnit.getJavaProject().getElementName();
	}

	/**
	 * Start the whole analysis process for the given compilation unit.
	 * <p>
	 * The given list records which methods the user has selected from the unit.
	 * If null, all methods are interesting.
	 * </p>
	 * 
	 * @param parsedCompUnit
	 *            the compilation unit to analyse
	 * @param selectedMethodsForUnit
	 *            the methods the user has selected, or null if all
	 * @throws Exception
	 */
	public void analyse(CompilationUnit parsedCompUnit, 
			Set<Method> selectedMethodsForUnit) throws Exception {
		IJavaElement elem = parsedCompUnit.getJavaElement();
		if (elem instanceof ICompilationUnit) {
			ICompilationUnit iCompUnit = (ICompilationUnit) elem;
			getDataFromCompilationUnit(iCompUnit);			
		} else {
			logger.error("IJavaElement of CompilationUnit is not an ICompilationUnit.");
		}

		AnalysingASTVisitor visitor = new AnalysingASTVisitor(
				this.translator, this.classifier, selectedMethodsForUnit);
		parsedCompUnit.accept(visitor);
	}

	/**
	 * Decide on whether to use a {@link DefaultServiceCallClassifier} or a
	 * {@link PreferencesServiceCallClassifier} according to the user
	 * preferences, and return an appropriate classifier.
	 * 
	 * @return a {@link ServiceCallClassifier}
	 */
	private ServiceCallClassifier createClassifier() {
		ServiceCallClassifier classifier;
		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		int classificationMode = prefs
				.getInt(Code2ModelPreferences.externalClassificationMode);
		if (classificationMode == Code2ModelPreferences.EXT_CLASSIFICATION_DEFAULT) {
			classifier = new DefaultServiceCallClassifier();
		} else {
			classifier = new PreferencesServiceCallClassifier();
		}
		return classifier;
	}

	/**
	 * Saves the created {@link ResourceDemandingSEFF}s as XMI.
	 * 
	 * @throws IOException
	 */
	public String serializeRepository() throws IOException {
		URI fullPath = getSerializationPath();
		this.builder.saveRDSEFF(fullPath, this.projectName);
		return fullPath.path();
	}

	/**
	 * Helper method to find the output location where the repository should be
	 * written.
	 * <p>
	 * The user set preferences are consulted first. If they are not set, the
	 * file is written to the project's root in the workspace directory.
	 * </p>
	 * 
	 * @return the path, including the file name, where to save the repository
	 */
	private URI getSerializationPath() {
		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		String baseDir = prefs
				.getString(Code2ModelPreferences.repositoryOutputDir);
		boolean pathNotSet = baseDir.equals(""); 
		if (pathNotSet) {
			baseDir = this.workspacePath;
		}
		URI uri = URI.createFileURI(baseDir);
		
		if (this.projectName != null) {
			// Once for directory, twice for file name
			uri = uri.appendSegment(this.projectName);
			uri = uri.appendSegment(this.projectName);
		} else {
			uri = uri.appendSegment("default");
		}
//
//		uri = uri.appendFileExtension("repository");
		return uri;
	}

}

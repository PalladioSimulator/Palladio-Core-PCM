package de.uka.ipd.sdq.code2model.analysis;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.operation.IRunnableWithProgress;

import de.uka.ipd.sdq.code2model.wrappers.Method;

/**
 * Encapsulates the actual analysis process.
 * <p>
 * Is supposed to be used with a prograss dialog or similar as it implements
 * {@link IRunnableWithProgress}.
 * </p>
 * 
 * @author thomas
 */
public class RDSEFFBuildingAnalysisDirector implements IRunnableWithProgress {
	protected UserSelection selection;
	protected String savedRepositoryLocation;
	
	/**
	 * @param selection
	 * @throws Exception
	 */
	public RDSEFFBuildingAnalysisDirector(UserSelection selection) throws Exception {
		this.selection = selection;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void run(IProgressMonitor monitor) throws InvocationTargetException {
		CodeAnalyser analyser = new CodeAnalyser(monitor);

		monitor.beginTask("Generating the model", selection.size());
		for (CompilationUnit unit : selection) {
			if (monitor.isCanceled()) {
				return;
			}
			monitor.subTask("Analysing " + unit.getJavaElement().getElementName());
			try {
				Set<Method> selectedMethodsForUnit = selection.getMethodsForUnit(unit);
				analyser.analyse(unit, selectedMethodsForUnit);
			} catch (Exception e) {
				throw (new InvocationTargetException(e));
			}
			monitor.worked(1);
		}
		monitor.done();

		try {
			this.savedRepositoryLocation = analyser.serializeRepository();
		} catch (IOException e) {
			throw (new InvocationTargetException(e));
		}
	}

	/**
	 * Return the path to the savd repository. Used for user feedback.
	 * 
	 * @return the path as String
	 */
	public String getSavedRepositoryLocation() {
		return this.savedRepositoryLocation;
	}

}

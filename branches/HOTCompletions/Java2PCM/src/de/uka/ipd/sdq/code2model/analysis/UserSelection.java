/**
 * 
 */
package de.uka.ipd.sdq.code2model.analysis;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.viewers.TreeSelection;

import de.uka.ipd.sdq.code2model.wrappers.Method;

/**
 * Encapsulates the user's selection in the Eclipse UI. It handles grouping the
 * selection and parsing the selected compilation units, and keeps track of
 * which methods were selected for which compilation unit.
 * 
 * @author thomas
 */
public class UserSelection implements Iterable<CompilationUnit> {
	Logger logger;
	Iterator<CompilationUnit> parsedUnitsIterator;
	HashMap<CompilationUnit, Set<Method>> parsedCompilationUnits; 
	
	public UserSelection(TreeSelection selection) throws InvocationTargetException {
		logger = Logger.getLogger(this.getClass());
		parsedCompilationUnits = new HashMap<CompilationUnit, Set<Method>>();
		
		queueAndParse(selection);
		
		parsedUnitsIterator = parsedCompilationUnits.keySet().iterator();
	}

	/**
	 * Queue all objects the user has selected using
	 * {@link #queueSelectedObjects(List)}, and parse them.
	 * 
	 * @param selection
	 *            the user selection
	 * @throws InvocationTargetException
	 */
	private void queueAndParse(TreeSelection selection) throws InvocationTargetException {
		List<Object> selectedObjects = selection.toList();
		HashMap<ICompilationUnit, Set<Method>> compUnitsAndMethods = 
			queueSelectedObjects(selectedObjects);

		for (ICompilationUnit iUnit : compUnitsAndMethods.keySet()) {
			CompilationUnit unit = parse(iUnit);
			Set<Method> methods = compUnitsAndMethods.get(iUnit);
			this.parsedCompilationUnits.put(unit, methods);
		}
	}

	/**
	 * Get all methods the user has selected in a given compilation unit.
	 * 
	 * @param unit
	 *            the compilation unit
	 * @return the set of {@link Method}s the user selected
	 */
	public Set<Method> getMethodsForUnit(CompilationUnit unit) {
		return this.parsedCompilationUnits.get(unit);
	}

	/**
	 * Queue the objects the user selected, grouped by compilation unit.
	 * 
	 * @param selectedObjects
	 *            the selected UI objects
	 * @return a hash map mapping compilation units to a list of their methods
	 *         which were selected, or an empty list if the whole unit was
	 *         selected
	 * @throws InvocationTargetException 
	 */
	protected HashMap<ICompilationUnit, Set<Method>> queueSelectedObjects(List<Object> selectedObjects) throws InvocationTargetException
			{
		HashMap<ICompilationUnit, Set<Method>> compUnitsAndMethods = 
			new HashMap<ICompilationUnit, Set<Method>>();
		for (Object selected : selectedObjects) {
			logger.info("Got " + selected.getClass() + " in selection.");
			ICompilationUnit compUnit;
			/*
			 * Check what the user has selected.
			 * 
			 * A strange thing can occur: SourceType is from jdt.internal.core
			 * and should not appear anywhere in the plugin code, but when the
			 * user selects a class in Eclipse (the class itself, not the .java
			 * file), it is a SourceType. We abort then, although from a user
			 * perspective it seems perfectly valid to select a class.
			 */
			if (selected instanceof IMethod) {
				IMethod selMethod = (IMethod) selected;
				ICompilationUnit thisCompUnit = selMethod.getCompilationUnit();
				if (!compUnitsAndMethods.containsKey(thisCompUnit)) {
					compUnitsAndMethods.put(thisCompUnit, new HashSet<Method>());
				}
				Method method = new Method(selMethod);
				Set<Method> thisMethods = compUnitsAndMethods.get(thisCompUnit);
				thisMethods.add(method);
				compUnitsAndMethods.put(thisCompUnit, thisMethods);
			} else if (selected instanceof ICompilationUnit) {
				compUnit = (ICompilationUnit) selected;
				compUnitsAndMethods.put(compUnit, new HashSet<Method>());
			/* Not working due to restriction described above.
			} else if (selected instanceof SourceType) {
				SourceType st = (SourceType) selected;
				compUnit = st.getCompilationUnit();
				compUnitsAndMethods.put(compUnit, new HashSet<Method>()); 
			*/
			} else if (selected instanceof IPackageFragment) {
				// DO NOTHING
				logger.info("Skipping package.");
			}
			else {
				logger.error("Selected object is a " + selected.getClass() + 
						", should be IMethod or ICompilationUnit.");
				Exception e = new Exception(
						"Something is wrong with the selection.  "
						+ "Please select a java file or a method.");
				throw (new InvocationTargetException(e));
			}
		}
		return compUnitsAndMethods;
	}
	
	/**
	 * Lets the {@link ASTParser} create the AST.
	 * <p>
	 * Bindings are created.
	 * </p>
	 */
	protected CompilationUnit parse(ICompilationUnit compUnit) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT); // i.e. one class
		parser.setSource(compUnit);
		parser.setResolveBindings(true);
		return (CompilationUnit) parser.createAST(null /* IProgressMonitor */);
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<CompilationUnit> iterator() {
		return this.parsedCompilationUnits.keySet().iterator();
	}

	/**
	 * Give the number of elements the user has selected in the Eclipse UI.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return this.parsedCompilationUnits.size();
	}

}

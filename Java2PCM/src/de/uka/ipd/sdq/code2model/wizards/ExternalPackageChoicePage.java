/**
 * 
 */
package de.uka.ipd.sdq.code2model.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.analysis.UserSelection;
import de.uka.ipd.sdq.code2model.analysis.callclassification.DefaultServiceCallClassifier;
import de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier;
import de.uka.ipd.sdq.code2model.astvisitors.MethodInvocationCollectingASTVisitor;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;
import de.uka.ipd.sdq.code2model.ui.UserMessage;
import de.uka.ipd.sdq.code2model.wrappers.Method;
import de.uka.ipd.sdq.code2model.wrappers.Package;

/**
 * @author thomas
 * 
 */
public class ExternalPackageChoicePage extends WizardPage implements Listener {

	private UserSelection userSelection;
	private Logger logger;

	/**
	 * Listener for checking/unchecking elements in the package/methods tree
	 * where the user selects he external services.
	 * <p>
	 * For each user click, all checked elements are iterated over and written
	 * to the preferences. Not very clever, but simple, and the trees will never
	 * be that large.
	 * </p>
	 * 
	 * @author thomas
	 */
	private final class CheckStateListener implements ICheckStateListener {
		private final CheckboxTreeViewer tv;

		private CheckStateListener(CheckboxTreeViewer tv) {
			this.tv = tv;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ICheckStateListener#checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent)
		 */
		public void checkStateChanged(CheckStateChangedEvent event) {
			// If an element was (un)checked, (un)check all its children.
			if (event.getChecked()) {
				this.tv.setSubtreeChecked(event.getElement(), true);
			} else {
				this.tv.setSubtreeChecked(event.getElement(), false);
			}
			
			Object[] checkedElements = this.tv.getCheckedElements();
			updatePreferences(checkedElements);
		}

		/**
		 * Updates the preferences when the tree selection was modified by
		 * the user.
		 * 
		 * @param checkedElements
		 *            an array containing all checked elements of the tree
		 */
		private void updatePreferences(Object[] checkedElements) {
			String selectedMethods = "";
			for (Object o : checkedElements) {
				if (o instanceof Method) {
					Method checkedMethod = (Method) o;
					selectedMethods += 
							checkedMethod.getQualifiedDeclaringClassName() + "."
							+ checkedMethod.getMethodName() + ";";
				}
			}
			IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
			prefs.setValue(Code2ModelPreferences.externalMethods, selectedMethods);
		}
	}

	public ExternalPackageChoicePage(UserSelection userSelection) {
		super(Code2ModelWizard.extPkgsChoicePageName);
		logger = Logger.getLogger(this.getClass());
		
		this.userSelection = userSelection;
		setTitle("External Methods Classification");
		setDescription("Please choose the methods representing external services.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(1, false));

		final CheckboxTreeViewer tv = new CheckboxTreeViewer(composite);
		tv.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

		tv.setContentProvider(new InvokedMethodsContentProvider());
		tv.setLabelProvider(new InvokedMethodsLabelProvider());
		tv.setSorter(new ViewerSorter());

		Package rootPackage = getRootPackageWithInvokedMethods();
		tv.setInput(rootPackage);
		
		tv.addCheckStateListener(new CheckStateListener(tv));

		setControl(composite);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		return true;
	}

	/**
	 * Get the root package for the tree showing the invoked methods, grouped by
	 * package, to the user. It contains all "real" packages with their methods
	 * as children, in the correct tree structure.
	 * <p>
	 * The root package itself is not displayed, it serves as container for the
	 * displayed content.
	 * </p>
	 * 
	 * @return the root {@link Package}
	 */
	private Package getRootPackageWithInvokedMethods() {
		Package rootPackage = new Package("root");
		HashMap<String, Package> createdPackages = new HashMap<String, Package>();
		try {
			Set<IMethodBinding> invokedMethods = collectInvokedMethods();

			for (IMethodBinding m : invokedMethods) {
				String pkgName = getPackageNameFromMethod(m);
				Package p = createdPackages.get(pkgName);
				if (p == null) {
					p = new Package(pkgName);
					logger.debug("Created new package " + p);
					createdPackages.put(pkgName, p);
				}
				logger.debug("Creating Method from binding");
				p.addMethod(new Method(m));
				rootPackage.addPackage(p);
			}
		} catch (Exception e) {
			UserMessage.displayException(e);
		}
		return rootPackage;
	}

	/**
	 * Get the fully qualified name of the package of the class the given method
	 * is declared in.
	 * <p>
	 * There is also <code>m.getDeclaringClass().getPackage().getName()</code>,
	 * making this method seemingly obsolete, but it didn't work reliably for
	 * me.
	 * </p>
	 * 
	 * @param m the binding of the method whose package to find out
	 * @return the fully qualified name of the package
	 */
	private String getPackageNameFromMethod(IMethodBinding m) {
		String pkgName = m.getDeclaringClass().getQualifiedName();
		int lastDot = pkgName.lastIndexOf(".");
		if (lastDot > -1) {
			pkgName = pkgName.substring(0, lastDot);
		}
		return pkgName;
	}

	/**
	 * Collect all methods invoked in the user selection.
	 * 
	 * @return the list of invoked methods
	 * @throws InvocationTargetException
	 */
	private Set<IMethodBinding> collectInvokedMethods()
			throws InvocationTargetException {
		ServiceCallClassifier classifier = new DefaultServiceCallClassifier();
		Set<IMethodBinding> invokedMethods = new HashSet<IMethodBinding>();
		for (CompilationUnit unit : this.userSelection) {
			try {
				MethodInvocationCollectingASTVisitor collector = new MethodInvocationCollectingASTVisitor(
						this.userSelection.getMethodsForUnit(unit), classifier);
				unit.accept(collector);
				invokedMethods.addAll(collector.getCollectedMethods());
			} catch (Exception e) {
				e.printStackTrace();
				throw (new InvocationTargetException(e));
			}
		}
		logger.info("Collected:");
		for (IMethodBinding b : invokedMethods) {
			logger.info("    " + b.getDeclaringClass().getQualifiedName() + "." + b.getName());
		}
		return invokedMethods;
	}

}

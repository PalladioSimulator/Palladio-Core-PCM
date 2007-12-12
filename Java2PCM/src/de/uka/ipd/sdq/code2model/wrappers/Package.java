package de.uka.ipd.sdq.code2model.wrappers;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.code2model.wizards.Code2ModelWizard;

/**
 * Encapsulates a package with enough information to use it in the
 * {@link Code2ModelWizard} to list the methods to be classified grouped by
 * package.
 * 
 * @author thomas
 */
public class Package {
	private String name;
	private Set<Method> methods = new HashSet<Method>();
	private Set<Package> subPackages = new HashSet<Package>();
	private Logger logger;

	public Package(String name) {
		logger = Logger.getLogger(this.getClass());
		this.name = name;
	}

	/**
	 * @return the name of the package
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Add a method to this package.
	 * 
	 * @param method the method to add
	 */
	public void addMethod(Method method) {
		if (! method.getQualifiedDeclaringClassName().startsWith(this.getName()) ) {
			logger.warn("Method " + method + " is added to package " + this
					+ ", but its package does not match.");			
		}
		method.setPackage(this);
		
		int methodCount = this.methods.size();
		this.methods.add(method);
		if (methodCount == this.methods.size()) {
			logger.info("Method " + method + " has not been added.");
		} else {
			logger.info("Method " + method + " has been added.");
		}
	}
	
	/**
	 * Add a subpackage, e.g., <code>foo.bar.baz</code> for
	 * <code>foo.bar</code>.
	 * <p>
	 * No check is done whether it is actually a subpackage!
	 * </p>
	 * 
	 * @param pkg
	 *            the subpackage
	 */
	public void addPackage(Package pkg) {
		this.subPackages.add(pkg);
	}
	
	/**
	 * Get the methods this package contains.
	 * 
	 * @return an array with the methods as {@link Method}
	 */
	public Method[] getMethods() {
		Method[] m = new Method[this.methods.size()];
		m = this.methods.toArray(m);
		return m;
	}
	
	/**
	 * Get the subpackages of this package, e.g., <code>foo.bar.baz</code> for
	 * <code>foo.bar</code>.
	 * 
	 * @return an array with the subpackages, as {@link Package}
	 */
	public Package[] getSubPackages() {
		Package[] p = new Package[this.subPackages.size()];
		p = this.subPackages.toArray(p);
		return p;
	}
	
	/**
	 * Get the subpackages and the methods this package contains in one array.
	 * 
	 * @return an array containing first the subpackages, then the methods
	 */
	public Object[] getChildren() {
		Method[] methods = getMethods();
		Package[] pkgs = getSubPackages();
		return concat(pkgs, methods);
	}
	
	/**
	 * Concatenate two arrays.
	 * 
	 * @param arrayOne
	 *            the first array
	 * @param arrayTwo
	 *            the second array
	 * @return an array containing first arrayOne, then arrayTwo
	 */
	private Object[] concat(Object[] arrayOne, Object[] arrayTwo) {
		Object[] both = new Object[arrayOne.length + arrayTwo.length];
		System.arraycopy(arrayOne, 0, both, 0, arrayOne.length);
		System.arraycopy(arrayTwo, 0, both, arrayOne.length, arrayTwo.length);
		return both;
	}

	/**
	 * Two packages are equal if their names are equal.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Package otherPkg = (Package) obj;
		return this.name.equals(otherPkg.getName());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public String toString() {
		return this.getName();
	}	
}

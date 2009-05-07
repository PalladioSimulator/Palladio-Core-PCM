package de.uka.ipd.sdq.code2model;

public class Helpers {

	/**
	 * Get the simple name from a qualified name, e.g., Foo from foo.bar.Foo.
	 * 
	 * @param qualifiedName a possibly qualified name
	 * @return the simple name
	 */
	public static String getSimpleNameFromQualified(String qualifiedName) {
		String simpleName = qualifiedName;
		int lastDot = qualifiedName.lastIndexOf(".");
		if ( (lastDot > 0) && ((lastDot + 1) < qualifiedName.length()) ) {
			simpleName = qualifiedName.substring(lastDot + 1);
		}
		return simpleName;
	}
	
}

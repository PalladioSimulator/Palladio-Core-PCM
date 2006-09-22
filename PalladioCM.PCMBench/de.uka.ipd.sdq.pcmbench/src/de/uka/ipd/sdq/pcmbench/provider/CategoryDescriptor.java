package de.uka.ipd.sdq.pcmbench.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class CategoryDescriptor {
	private EReference eReference = null;
	private String label;
	private Class childClass;
	private Class parentClass;

	/**
	 * @return the childClass
	 */
	public Class getChildClass() {
		return childClass;
	}

	/**
	 * @return the eReference
	 */
	public EReference getEReference() {
		return eReference;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the parentClass
	 */
	public Class getParentClass() {
		return parentClass;
	}

	public CategoryDescriptor(Class parentClass, // parent Object 
			Class childClass,    		// Class of the children of the category
			EReference eReference, 	// eReference of the category
			String label)   		// Label to display for the category
	{
		this.eReference = eReference; 
		this.label = label;
		this.parentClass = parentClass;
		this.childClass = childClass;
	}
}

package de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware;


import org.eclipse.emf.ecore.EReference;

/**
 * @author Snowball
 * A class used to configure a single category of the category aware item provider
 */
public class CategoryDescriptor {
	private EReference eReference = null;
	private String label;
	private Class childClass;
	private Class parentClass;

	/**
	 * See constructor for description
	 * @return the childClass
	 */
	public Class getChildClass() {
		return childClass;
	}

	/**
	 * See constructor for description
	 * @return the eReference
	 */
	public EReference getEReference() {
		return eReference;
	}

	/**
	 * See constructor for description
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * See constructor for description
	 * @return the parentClass
	 */
	public Class getParentClass() {
		return parentClass;
	}

	/**
	 * @param parentClass Reflective class of the parent node of this category, e.g., Repository.class
	 * @param childClass Reflective class of the child nodes which should belong to this category, e.g., ProvidesComponentType.class
	 * This is used to filter the children accordingly
	 * @param eReference The eReference of the parent node which is searched to find matching children
	 * @param label The label which is displayed for the category
	 */
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

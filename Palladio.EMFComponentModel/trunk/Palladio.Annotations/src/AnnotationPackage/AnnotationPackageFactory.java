/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see AnnotationPackage.AnnotationPackagePackage
 * @generated
 */
public interface AnnotationPackageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnnotationPackageFactory eINSTANCE = AnnotationPackage.impl.AnnotationPackageFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnnotationPackagePackage getAnnotationPackagePackage();

} //AnnotationPackageFactory

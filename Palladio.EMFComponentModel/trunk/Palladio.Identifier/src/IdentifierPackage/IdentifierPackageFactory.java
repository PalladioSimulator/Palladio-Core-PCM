/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package IdentifierPackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see IdentifierPackage.IdentifierPackagePackage
 * @generated
 */
public interface IdentifierPackageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IdentifierPackageFactory eINSTANCE = IdentifierPackage.impl.IdentifierPackageFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IdentifierPackagePackage getIdentifierPackagePackage();

} //IdentifierPackageFactory

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.impl;

import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QMLDeclarationsFactoryImpl extends EFactoryImpl implements QMLDeclarationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QMLDeclarationsFactory init() {
		try {
			QMLDeclarationsFactory theQMLDeclarationsFactory = (QMLDeclarationsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///QMLDeclarations.ecore"); 
			if (theQMLDeclarationsFactory != null) {
				return theQMLDeclarationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QMLDeclarationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLDeclarationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QMLDeclarationsPackage.QML_DECLARATIONS: return createQMLDeclarations();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLDeclarations createQMLDeclarations() {
		QMLDeclarationsImpl qmlDeclarations = new QMLDeclarationsImpl();
		return qmlDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLDeclarationsPackage getQMLDeclarationsPackage() {
		return (QMLDeclarationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QMLDeclarationsPackage getPackage() {
		return QMLDeclarationsPackage.eINSTANCE;
	}

} //QMLDeclarationsFactoryImpl

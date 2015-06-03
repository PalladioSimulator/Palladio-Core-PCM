/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fzi.se.quality.QualityFactory;
import de.fzi.se.quality.QualityPackage;
import de.fzi.se.quality.QualityRepository;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class QualityFactoryImpl extends EFactoryImpl implements QualityFactory {

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static QualityFactory init() {
        try {
            final QualityFactory theQualityFactory = (QualityFactory) EPackage.Registry.INSTANCE
                    .getEFactory(QualityPackage.eNS_URI);
            if (theQualityFactory != null) {
                return theQualityFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new QualityFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public QualityFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case QualityPackage.QUALITY_REPOSITORY:
            return this.createQualityRepository();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public QualityRepository createQualityRepository() {
        final QualityRepositoryImpl qualityRepository = new QualityRepositoryImpl();
        return qualityRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public QualityPackage getQualityPackage() {
        return (QualityPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static QualityPackage getPackage() {
        return QualityPackage.eINSTANCE;
    }

} // QualityFactoryImpl

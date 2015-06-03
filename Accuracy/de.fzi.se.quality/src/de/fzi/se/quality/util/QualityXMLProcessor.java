/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.fzi.se.quality.QualityPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class QualityXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public QualityXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        QualityPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the QualityResourceFactoryImpl factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null) {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new QualityResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new QualityResourceFactoryImpl());
        }
        return this.registrations;
    }

} // QualityXMLProcessor

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class QualityAnnotationXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public QualityAnnotationXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        QualityAnnotationPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the QualityAnnotationResourceFactoryImpl factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null) {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new QualityAnnotationResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new QualityAnnotationResourceFactoryImpl());
        }
        return this.registrations;
    }

} // QualityAnnotationXMLProcessor

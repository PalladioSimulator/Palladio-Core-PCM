/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.fzi.se.quality.parameters.ParametersPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ParametersXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ParametersXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        ParametersPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the ParametersResourceFactoryImpl factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null) {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new ParametersResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new ParametersResourceFactoryImpl());
        }
        return this.registrations;
    }

} // ParametersXMLProcessor
